package com.imagegallery.imagegalleryapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
