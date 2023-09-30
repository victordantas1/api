package com.vct.api.domain.model.service.impl;

import com.vct.api.domain.model.User;
import com.vct.api.domain.model.repository.UserRepository;
import com.vct.api.domain.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found, id don't exist"));
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This number account already exists");
        }
        return userRepository.save(userToCreate);
    }
}
