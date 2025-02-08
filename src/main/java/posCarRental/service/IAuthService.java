package posCarRental.service;

import posCarRental.dto.SignupRequestDto;
import posCarRental.dto.UserDto;

public interface IAuthService {

    void createAdmin();

    UserDto createCustomer(SignupRequestDto requestDto);

    boolean verificationEmail(String email);

}
