package com.codespace.EasyBasket.user.mappers;

import com.codespace.EasyBasket.user.dtos.UserRequestDto;
import com.codespace.EasyBasket.user.dtos.UserResponseDto;
import com.codespace.EasyBasket.user.entity.User;

public class UserMapper {
    // toEntity
    // toDto
    public static User toEntity(UserRequestDto dto){
        return User.builder()
        .email(dto.getEmail())
        .name(dto.getName())
        .password(dto.getPassword())
        .build();
       // User user = new User();
       // user.setEmail(dto.getEmail());
       // user.setName(dto.getName());
       // user.setPassword(dto.getPassword());
    }

    public static UserResponseDto toDto(User user){
        return UserResponseDto.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .build();
    }
}
