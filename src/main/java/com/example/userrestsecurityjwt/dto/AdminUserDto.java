package com.example.userrestsecurityjwt.dto;

import com.example.userrestsecurityjwt.model.Status;
import com.example.userrestsecurityjwt.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;




@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String name;
    private String surName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setSurname(surName);
        user.setName(name);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setName(user.getName());
        adminUserDto.setSurName(user.getSurname());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}
