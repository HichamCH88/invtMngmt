package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Enums.Role;
import com.hicham.stockmanagment.model.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Integer id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private AddressDTO address;

    private String email;

    private String phoneNum;

    private Role role;

    private boolean isEnable=true;

    public static User toEntity(UserDTO dto){
        User user=User.builder().username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .build();
        user.setId(dto.getId());
        return user;
    }
    public static UserDTO fromEntity(User user){
        return UserDTO.builder().id(user.getId())
                .username(user.getUsername())
                .password("Hidden")
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .email(user.getEmail())
                .phoneNum(user.getPhoneNum())
                .build();

    }
}
