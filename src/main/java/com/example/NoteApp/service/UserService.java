package com.example.NoteApp.service;

import com.example.NoteApp.dto.UserRequest;
import com.example.NoteApp.model.User;

public interface UserService {
    void addUser(UserRequest userRequest);
    boolean existsByUsername(String username);
}
