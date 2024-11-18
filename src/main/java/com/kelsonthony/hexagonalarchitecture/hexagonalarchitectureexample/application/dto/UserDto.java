package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Object id;
    @Email
    private String email;
    @NotBlank
    private String name;
}
