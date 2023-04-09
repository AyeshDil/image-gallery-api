package com.imagegallery.imagegalleryapi.service.impl;

import com.imagegallery.imagegalleryapi.dto.request.UserRequestDTO;
import com.imagegallery.imagegalleryapi.dto.response.UserResponseDTO;
import com.imagegallery.imagegalleryapi.entity.User;
import com.imagegallery.imagegalleryapi.repo.UserRepo;
import com.imagegallery.imagegalleryapi.service.UserService;
import com.imagegallery.imagegalleryapi.util.Generate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceIMPL(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String saveUser(UserRequestDTO userRequestDTO) {
        User user = new User(
                new Generate().generateId(3, 6),
                userRequestDTO.getFirstName(),
                userRequestDTO.getLastName(),
                userRequestDTO.getUserName(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPassword()
        );
        userRepo.save(user);
        return "Saved";
    }

    @Override
    public UserResponseDTO getUserDetails(String email, String password) {
        Optional<User> user = userRepo.findByEmailEquals(email);
        if (user.isPresent() && user.get().getPassword().equals(password)){
//            user entity -> userResponseDTO
            UserResponseDTO userResponseDTO = new UserResponseDTO(
                    user.get().getUserId(),
                    user.get().getFirstName(),
                    user.get().getLastName(),
                    user.get().getUserName(),
                    user.get().getEmail(),
                    user.get().getPassword()
            );
            return userResponseDTO;

        } else {
            return null;
        }

    }
}
