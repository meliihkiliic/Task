package com.melih.task.service;

import com.melih.task.model.User;
import com.melih.task.repository.UserRepository;
import com.melih.task.request.UserRequest;
import com.melih.task.response.UserResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }
    public User getOneUserById(Long userId) {
        return userRepository.findByUserId(userId);
    }



    public UserResponse updateUser(Long userId, UserRequest userRequest) throws IOException {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            return null;
        }
        user.setUserName(userRequest.getUserName());
        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            return new UserResponse(savedUser);
        }
        return null;
    }


}