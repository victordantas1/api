package com.vct.api.domain.model.service;
import com.vct.api.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}
