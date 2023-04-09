package com.imagegallery.imagegalleryapi.controller;

import com.imagegallery.imagegalleryapi.dto.request.UserRequestDTO;
import com.imagegallery.imagegalleryapi.dto.response.UserResponseDTO;
import com.imagegallery.imagegalleryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/save")
    public String RegUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.saveUser(userRequestDTO);
    }

    @GetMapping(path = "/get", params = {"email", "password"})
    public UserResponseDTO getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ){
        UserResponseDTO userResponseDTO = userService.getUserDetails(email, password);
        return userResponseDTO;
    }
}
