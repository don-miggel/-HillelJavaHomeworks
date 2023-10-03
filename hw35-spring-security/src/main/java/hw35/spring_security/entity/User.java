package hw35.spring_security.entity;

import hw35.spring_security.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_users")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_role")
    private String role;


}
