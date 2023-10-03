package hw35.spring_security.service;

import hw35.spring_security.dto.AuthDTO;
import hw35.spring_security.dto.LoginDTO;
import hw35.spring_security.dto.RegisterDTO;
import hw35.spring_security.dto.UserDTO;
import hw35.spring_security.entity.User;
import hw35.spring_security.enums.UserRole;
import hw35.spring_security.mapper.UserMapper;
import hw35.spring_security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceDefault implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthDTO login(LoginDTO loginDTO) {

        System.out.println(loginDTO.getName());
        User u = userRepository.findByName(loginDTO.getName());
        String encodedPassword = passwordEncoder.encode(loginDTO.getPassword());
        System.out.println(u);

        if (u != null) {

            if (passwordEncoder.matches(loginDTO.getPassword(), u.getPassword())) {

                UserDTO loggedInUser =  UserMapper.userToUserDto(u);
                AuthDTO authDTO = new AuthDTO();
                authDTO.setUserDTO(loggedInUser);
                authDTO.setAuthorized(true);
                return authDTO;
            }
        }
        return null;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        User user = new User();
        User foundUser = userRepository.findByName(registerDTO.getName());
        if(foundUser != null)
            throw new RuntimeException("User with name: "+registerDTO.getName()+" already exists! ");
        String role = registerDTO.getRole().toUpperCase();

        if(!checkRole(role))
            throw new RuntimeException("Pointed out role : "+ role+" is not permitted!" +
                    " Please, choose ADMIN or USER! ");

        user.setName(registerDTO.getName());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(UserRole.valueOf(role).toString());
        User savedUser = userRepository.save(user);
        return UserMapper.userToUserDto(savedUser);
    }

    private boolean checkRole(String role){

        Set<String> roles = new HashSet<>();
        for(UserRole ur: UserRole.values())
            roles.add(ur.toString());
        return roles.contains(role);
    }
}
