package com.app.challenge_1.serviceImpl;

import com.app.challenge_1.exceptions.NoUserFoundException;
import com.app.challenge_1.model.User;
import com.app.challenge_1.repository.UserRepository;
import com.app.challenge_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(String firstName, String lastName, String email, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            try {
                throw new NoUserFoundException("NO user with ID "+id);
            } catch (NoUserFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
      return  this.userRepository.findAll();
    }

    @Override
    public User updateUserById(int id,String firstName,String lastName,String email,String password) throws NoUserFoundException {
           Optional<User> optUser = this.userRepository.findById(id);
           if(optUser.isEmpty()){
               throw new NoUserFoundException("No user present");
           }else {
               User use = optUser.get();
               use.setId(id);
               use.setFirstName(firstName);
               use.setLastName(lastName);
               use.setEmail(email);
               use.setPassword(password);

               return this.userRepository.save(use);
           }
    }


}
