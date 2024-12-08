package com.security.demo.entity;


import com.security.demo.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SqlResultSetMapping(
        name = "UserDTOMapping",
        classes = @ConstructorResult(
                targetClass = UserDTO.class,
                columns = {
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "email", type = String.class)
                }
        )
)
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  username;

    private String password;

    private String email;


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
