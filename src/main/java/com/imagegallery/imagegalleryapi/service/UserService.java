package com.imagegallery.imagegalleryapi.service;

import com.imagegallery.imagegalleryapi.dto.request.UserRequestDTO;
import com.imagegallery.imagegalleryapi.dto.response.CommonResponseDTO;
import com.imagegallery.imagegalleryapi.dto.response.UserResponseDTO;

public interface UserService {
    CommonResponseDTO saveUser(UserRequestDTO userRequestDTO);

    CommonResponseDTO getUserDetails(String email, String password);
}
