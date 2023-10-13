package com.melih.task.response;


import com.melih.task.model.User;
import lombok.Data;

@Data
public class UserResponse {
    Long id;
    Long userId;
    String userName;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userId = user.getUserId();

    }
}