package org.likelion.tm8.user.domain;

import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String email;
    private String name;
    private String gender;
    private int height;
    private int age;
}