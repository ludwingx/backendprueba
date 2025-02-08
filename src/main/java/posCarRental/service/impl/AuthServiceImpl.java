package posCarRental.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import posCarRental.dto.SignupRequestDto;
import posCarRental.dto.UserDto;
import posCarRental.entity.Rol;
import posCarRental.entity.User;
import posCarRental.entity.enums.UserStatus;
import posCarRental.repository.IRolRepository;
import posCarRental.repository.IUserRepository;
import posCarRental.service.IAuthService;

import java.util.Set;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRolRepository rolRepository;

    //CREA AUTOMÁTICAMENTE EL USUARIO ADMIN CON SU ROL

    //@PostConstruct
    public void createAdmin() {
        User user = new User();
        user.setName("Admin");
        user.setEmail("admin@gmail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setStatus(UserStatus.ACTIVO);

        Rol adminRol = rolRepository.findByName("ADMIN");
        if (adminRol == null) {
            adminRol = new Rol();
            adminRol.setName("ADMIN");
            rolRepository.save(adminRol);
        }

        user.setRol(adminRol);
        userRepository.save(user);
    }

    @Override
    public UserDto createCustomer(SignupRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(requestDto.getPassword()));
        user.setStatus(UserStatus.ACTIVO);

        // Obtener el rol "customer" de la base de datos
        Rol customerRole = rolRepository.findByName("CUSTOMER");
        if (customerRole == null) {
            // Si no existe el rol "customer", lo creamos (solo si es necesario)
            customerRole = new Rol();
            customerRole.setName("CUSTOMER");
            rolRepository.save(customerRole);
        }

        user.setRol(customerRole);

        User createUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createUser.getId());
        return userDto;
    }

    @Override
    public boolean verificationEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
