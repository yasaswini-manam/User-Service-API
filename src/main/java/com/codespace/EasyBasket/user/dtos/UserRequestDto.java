package com.codespace.EasyBasket.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor   // ✅ REQUIRED
@AllArgsConstructor  // ✅ GOOD
public class UserRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 6)
    private String password;
}