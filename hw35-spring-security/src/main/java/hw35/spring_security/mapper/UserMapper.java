package hw35.spring_security.mapper;

import hw35.spring_security.dto.UserDTO;
import hw35.spring_security.entity.User;
import hw35.spring_security.enums.UserRole;

public class UserMapper {

    public static UserDTO userToUserDto(User user){
        return new UserDTO(user.getId(), user.getName(), UserRole.valueOf(user.getRole()));
    }
}
