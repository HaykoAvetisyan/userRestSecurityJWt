package com.example.userrestsecurityjwt.dto;

import com.example.userrestsecurityjwt.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;




@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private String name;
    private String surName;
    private String email;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surName);
        user.setEmail(email);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setSurName(user.getSurname());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
