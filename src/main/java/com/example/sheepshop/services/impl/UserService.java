package com.example.sheepshop.services.impl;

import com.example.sheepshop.entitys.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findByUsername(String username);

}
