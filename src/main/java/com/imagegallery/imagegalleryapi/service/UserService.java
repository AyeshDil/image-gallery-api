package com.imagegallery.imagegalleryapi.service;

import com.imagegallery.imagegalleryapi.dto.request.UserRequestDTO;
import com.imagegallery.imagegalleryapi.dto.response.UserResponseDTO;

public interface UserService {
    String saveUser(UserRequestDTO userRequestDTO);

    UserResponseDTO getUserDetails(String email, String password);
}
