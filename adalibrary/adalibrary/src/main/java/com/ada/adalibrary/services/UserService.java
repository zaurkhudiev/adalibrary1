package com.ada.adalibrary.services;

import com.ada.adalibrary.domain.User;
import com.ada.adalibrary.exception.UsAuthException;

public interface UserService {

        User validate(String email, String password) throws UsAuthException;
        User registerUser(String firstName, String lastName, String email, String password) throws UsAuthException;


    }


