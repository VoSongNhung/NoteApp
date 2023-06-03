package com.example.NoteApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String uuid;
    private String fullname;
    @Email
    private String email;
}
