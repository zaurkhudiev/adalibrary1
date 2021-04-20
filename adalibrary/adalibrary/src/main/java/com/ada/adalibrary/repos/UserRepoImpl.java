package com.ada.adalibrary.repos;

import com.ada.adalibrary.domain.User;
import com.ada.adalibrary.exception.UsAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepoImpl implements UserRepo{
    private static final String SQL_CREATE = "INSERT INTO LIBRARY_USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('LIBRARY_USERS_SEQ'),?, ?, ?, ?)";
   private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM LIBRARY_USERS WHERE EMAIL = ?";
   private static final String SQL_FIND_BY_ID = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD " + "FROM LIBRARY_USERS WHERE USER_ID = ?";

   private static final String SQL_FIND_BY_EMAIL = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD " + "FROM LIBRARY_USERS WHERE EMAIL = ?";
    @Autowired
   JdbcTemplate jdbcTemplate;
    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws UsAuthException {
        String hash = BCrypt.hashpw(password,BCrypt.gensalt(10));
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,firstName);
                preparedStatement.setString(2,lastName);
                preparedStatement.setString(3,email);
                preparedStatement.setString(4,hash);
                return preparedStatement;
            } ,keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");

        }catch (Exception e){
            throw new UsAuthException("Invalid details. Failed to create account");


        }
    }

    @Override
    public User findEmailAndPassword(String email, String password) throws UsAuthException {
       try{
           User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email}, userRowMapper);
           if (!BCrypt.checkpw(password,user.getPassword()))
               throw new UsAuthException("Invalid Email");
return user;

       }catch (EmptyResultDataAccessException e){
           throw  new UsAuthException("Invalid email/password");
       }
    }

    @Override
    public Integer getByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL,Integer.class, email);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, userId);
    }
    private RowMapper<User> userRowMapper = ((rs,rowNum) -> {
return new User(rs.getInt("USER_ID"),
        rs.getString("FIRST_NAME"),
        rs.getString("LAST_NAME"),
        rs.getString("EMAIL"),
        rs.getString("PASSWORD"));

    });
}
