package com.imagegallery.imagegalleryapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
