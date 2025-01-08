package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;
}