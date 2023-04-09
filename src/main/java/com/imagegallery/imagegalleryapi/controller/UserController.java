package com.imagegallery.imagegalleryapi.controller;

import com.imagegallery.imagegalleryapi.dto.request.UserRequestDTO;
import com.imagegallery.imagegalleryapi.dto.response.CommonResponseDTO;
import com.imagegallery.imagegalleryapi.dto.response.UserResponseDTO;
import com.imagegallery.imagegalleryapi.service.UserService;
import com.imagegallery.imagegalleryapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StandardResponse> RegUser(@RequestBody UserRequestDTO userRequestDTO) {
        CommonResponseDTO commonResponseDTO = userService.saveUser(userRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(
                        commonResponseDTO.getCode(),
                        commonResponseDTO.getMessage(),
                        commonResponseDTO.getData()
                ), HttpStatus.CREATED
        );

    }

    @GetMapping(path = "/get", params = {"email", "password"})
    public ResponseEntity<StandardResponse> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ) {
        CommonResponseDTO commonResponseDTO = userService.getUserDetails(email, password);
        return new ResponseEntity<>(
                new StandardResponse(
                        commonResponseDTO.getCode(),
                        commonResponseDTO.getMessage(),
                        commonResponseDTO.getData()
                ), HttpStatus.OK
        );
    }
}
