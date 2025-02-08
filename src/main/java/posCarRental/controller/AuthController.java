package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import posCarRental.dto.AuthRequestDto;
import posCarRental.dto.AuthResponseDto;
import posCarRental.dto.SignupRequestDto;
import posCarRental.dto.UserDto;
import posCarRental.entity.User;
import posCarRental.repository.IUserRepository;
import posCarRental.security.JWTUtil;
import posCarRental.security.UserDetailsServiceImpl;
import posCarRental.service.IAuthService;

import java.util.Optional;
import static posCarRental.constants.GeneralConstants.*;

@RestController
@RequestMapping(AUTH)
public class AuthController {

    @Autowired
    private IAuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private IUserRepository userRepository;

    //REGISTER USER
    @PostMapping(SIGNUP)
    public ResponseEntity<?> createCustomer(@RequestBody SignupRequestDto requestDto){
        if (authService.verificationEmail(requestDto.getEmail())) {
            return new ResponseEntity<>("Customer already exist with this email", HttpStatus.NOT_ACCEPTABLE); 
        }
        UserDto createUserDto = authService.createCustomer(requestDto);
        if (createUserDto == null) {
            return new ResponseEntity<>("Customer not create user", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(createUserDto);
    }

    //LOGIN
    @PostMapping(LOGIN)
    public AuthResponseDto createAuthentication(@RequestBody AuthRequestDto requestDto) throws BadCredentialsException, DisabledException, UsernameNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username o password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(requestDto.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        AuthResponseDto authResponseDto = new AuthResponseDto();
        if (optionalUser.isPresent()) {
            authResponseDto.setUserId(optionalUser.get().getId());
            authResponseDto.setRol(optionalUser.get().getRol().getName());
            authResponseDto.setToken(jwt);
        }
        return authResponseDto;
    }
}
