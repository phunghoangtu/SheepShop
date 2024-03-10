package com.example.sheepshop.services;

import com.example.sheepshop.entitys.User;
import com.example.sheepshop.repositorys.UserRepository;
import com.example.sheepshop.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
