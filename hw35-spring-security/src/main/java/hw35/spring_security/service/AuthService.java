package hw35.spring_security.service;

import hw35.spring_security.dto.AuthDTO;
import hw35.spring_security.dto.LoginDTO;
import hw35.spring_security.dto.RegisterDTO;
import hw35.spring_security.dto.UserDTO;

public interface AuthService {

    AuthDTO login(LoginDTO loginDTO);
    UserDTO register(RegisterDTO registerDTO);
}
