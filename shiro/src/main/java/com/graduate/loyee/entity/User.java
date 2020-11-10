package com.graduate.loyee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String tel;
    private String sex;
    private String email;
    private String scope;
    private String password;
    private String perms;
}
