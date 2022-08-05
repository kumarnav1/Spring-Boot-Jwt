package com.bridgelabz.springsecurityjwt.service.user;

import com.bridgelabz.springsecurityjwt.entity.LoginUser;
import com.bridgelabz.springsecurityjwt.entity.User;
import com.bridgelabz.springsecurityjwt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(LoginUser loginUser) {
        User user = modelMapper.map(loginUser, User.class);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
