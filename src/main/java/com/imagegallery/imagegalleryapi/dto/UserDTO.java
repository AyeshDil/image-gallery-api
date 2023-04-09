package com.imagegallery.imagegalleryapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
