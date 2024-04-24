package com.app.challenge_1.service;

import com.app.challenge_1.exceptions.NoUserFoundException;
import com.app.challenge_1.model.User;

import java.util.List;

public interface UserService {

  //  public User saveUser(int userId,String firstName, String lastName, String email, String password);
    public User saveUser(String firstName, String lastName, String email, String password);
    public void deleteUserById(int id);
    public User getUserById(int id);
    public List<User> getAllUsers();
    public User updateUserById(int id,String firstName,String lastName,String email,String password) throws NoUserFoundException;

}
