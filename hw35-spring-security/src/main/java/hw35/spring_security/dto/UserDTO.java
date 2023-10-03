package hw35.spring_security.dto;

import hw35.spring_security.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private UserRole role;
}
