package com.ada.adalibrary.impl;

import com.ada.adalibrary.domain.User;
import com.ada.adalibrary.exception.UsAuthException;
import com.ada.adalibrary.repos.UserRepo;
import com.ada.adalibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public User validate(String email, String password) throws UsAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepo.findEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws UsAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new UsAuthException("Invalid Email");
        Integer count = userRepo.getByEmail(email);
        if (count > 0)
            throw new UsAuthException("Email already in use");
        Integer userId = userRepo.create(firstName, lastName, email, password);
        return userRepo.findById(userId);
    }
}
