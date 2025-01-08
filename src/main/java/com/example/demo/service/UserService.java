package com.example.demo.service;

import com.example.demo.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    void getAllUsers();

    ResponseEntity<String> addUser(UserEntity user);

    ResponseEntity<String> updateUser(UserEntity user);

    ResponseEntity<String> deleteUser(Long id);
}