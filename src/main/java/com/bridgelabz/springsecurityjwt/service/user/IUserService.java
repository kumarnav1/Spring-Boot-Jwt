package com.bridgelabz.springsecurityjwt.service.user;

import com.bridgelabz.springsecurityjwt.entity.LoginUser;
import com.bridgelabz.springsecurityjwt.entity.User;

import java.util.List;

public interface IUserService {
    public User addUser(LoginUser user);
    public List<User> getUsers();
}
