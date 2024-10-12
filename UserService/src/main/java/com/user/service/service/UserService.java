package com.user.service.service;

import com.user.service.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUserById(String userId);
}
