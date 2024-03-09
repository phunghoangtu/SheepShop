package com.example.sheepshop.services.impl;

import com.example.sheepshop.models.Users;

public interface UserService {

    Users findByUsername(String username);

}
