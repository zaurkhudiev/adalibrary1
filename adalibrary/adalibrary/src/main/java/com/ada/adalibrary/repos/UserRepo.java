package com.ada.adalibrary.repos;

import com.ada.adalibrary.domain.User;
import com.ada.adalibrary.exception.UsAuthException;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    Integer create(String firstName, String lastName, String email, String password) throws UsAuthException;
    User findEmailAndPassword(String email, String password) throws UsAuthException;
    Integer getByEmail(String email);

    User findById(Integer userId);

}
