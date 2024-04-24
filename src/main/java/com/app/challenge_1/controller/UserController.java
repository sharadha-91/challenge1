package com.app.challenge_1.controller;


import com.app.challenge_1.dto.UserRequestDto;
import com.app.challenge_1.dto.UserResponseDto;
import com.app.challenge_1.model.User;
import com.app.challenge_1.response.Response;
import com.app.challenge_1.response.ResponseStatus;
import com.app.challenge_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
  public UserResponseDto createUser(@RequestBody UserRequestDto userdto){

                String firstname = userdto.getFirstName();
                String lastname = userdto.getLastName();
                String email =  userdto.getEmail();
                String password = userdto.getPassword();

      UserResponseDto userResponse = new UserResponseDto();
      try {
          User use = this.userService.saveUser(firstname, lastname, email, password);
          userResponse.setUser(use);
          //userResponse.setResponse(Response.getSuccessResponse());
          userResponse.setResponseStatus(ResponseStatus.SUCCESS);
      }catch(Exception e){
          System.out.println(e.getMessage());
          //userResponse.setResponse(Response.getFailureResponse("FAILURE"));
             userResponse.setResponseStatus(ResponseStatus.FAILURE);
      }
        return userResponse;
    }

    @GetMapping("/userslist")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    //public UserResponseDto getUserById(@PathVariable("id") int id){
    public User getUserById(@PathVariable("id") int id){
        UserResponseDto userResponse = new UserResponseDto();
        User user1 = null;

        try{
            //User user=  this.userService.getUserById(id);
            user1=  this.userService.getUserById(id);
//             userResponse.setUser(user);
//             userResponse.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            System.out.println(e.getMessage());
            userResponse.setResponseStatus(ResponseStatus.FAILURE);
        }
        return user1;
        // return userResponse;
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUserById(@RequestBody UserRequestDto userRequest, @PathVariable("id")int id){
        UserResponseDto userResponse = new UserResponseDto();
                String firstname = userRequest.getFirstName();
                String lastname = userRequest.getLastName();
                String email = userRequest.getEmail();
                String password = userRequest.getPassword();
        try{
               User user = this.userService.updateUserById(id,firstname,lastname,email,password);
               userResponse.setUser(user);
               userResponse.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            System.out.println(e.getMessage());
            userResponse.setResponseStatus(ResponseStatus.FAILURE);
        }
        return userResponse;
    }


    @DeleteMapping("/{id}")
    public ResponseStatus deleteUserById(@PathVariable("id") int id){
        ResponseStatus responseStatus;
        try {
            this.userService.deleteUserById(id);
            responseStatus = ResponseStatus.SUCCESS;
        }catch(Exception e){
            System.out.println(e.getMessage());
            responseStatus = ResponseStatus.FAILURE;
        }
        return responseStatus;
    }






}
