package com.codespace.EasyBasket.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.codespace.EasyBasket.user.mappers.UserMapper;
import com.codespace.EasyBasket.user.dtos.UserRequestDto;
import com.codespace.EasyBasket.user.dtos.UserResponseDto;
import com.codespace.EasyBasket.user.repository.UserRepository;
import com.codespace.EasyBasket.user.entity.User;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    @Override
public UserResponseDto create(UserRequestDto dto) {
    try {
        User user = UserMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    } catch (Exception e) {
        e.printStackTrace();   // 🔥 shows real error
        throw e;
    }
}

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
       return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);

    }

}
