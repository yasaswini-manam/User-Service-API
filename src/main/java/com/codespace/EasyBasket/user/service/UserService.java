package com.codespace.EasyBasket.user.service;

import java.util.List;
import com.codespace.EasyBasket.user.dtos.UserRequestDto;
import com.codespace.EasyBasket.user.dtos.UserResponseDto;
//import com.codespace.EasyBasket.user.entity.User;

public interface UserService {
  UserResponseDto create(UserRequestDto dto);
  UserResponseDto getUserById(Long id);
  List<UserResponseDto>  getAllUsers();
  void delete (long id);

}
