package hw35.spring_security.dto;

import hw35.spring_security.enums.UserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthDTO {

    private UserDTO userDTO;
    private boolean authorized;
}
