package hw35.spring_security.controller;


import hw35.spring_security.dto.AuthDTO;
import hw35.spring_security.dto.LoginDTO;
import hw35.spring_security.dto.RegisterDTO;
import hw35.spring_security.dto.UserDTO;
import hw35.spring_security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody LoginDTO loginDTO){

        return new ResponseEntity<>(authService.login(loginDTO), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterDTO registerDTO){

        UserDTO userDTO = authService.register(registerDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }


}
