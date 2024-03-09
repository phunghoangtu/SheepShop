package com.example.sheepshop.services;

import com.example.sheepshop.models.Users;
import com.example.sheepshop.repositorys.UserRepository;
import com.example.sheepshop.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
