package hw35.spring_security.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    private String name;
    private String password;
    private String role;
}
