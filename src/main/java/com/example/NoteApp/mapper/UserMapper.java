package com.example.NoteApp.mapper;

import com.example.NoteApp.dto.NoteRequest;
import com.example.NoteApp.dto.NoteResponse;
import com.example.NoteApp.dto.UserRequest;
import com.example.NoteApp.dto.UserResponse;
import com.example.NoteApp.model.Note;
import com.example.NoteApp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
    List<UserResponse> listUserToUserResponse(List<User> users);
}
