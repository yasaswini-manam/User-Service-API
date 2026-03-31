package com.codespace.EasyBasket.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.codespace.EasyBasket.user.dtos.UserRequestDto;
import com.codespace.EasyBasket.user.dtos.UserResponseDto;
import com.codespace.EasyBasket.user.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "basicAuth")  
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
    
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto dto){
        return userService.create(dto);
    }

    @GetMapping("{id}")
    public UserResponseDto getUser(@PathVariable Long id)
    {
            return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "user with id " + id + " has been deleted successfully";
    }

}
