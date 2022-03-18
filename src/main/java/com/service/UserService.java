package com.service;

import com.model.UserModel;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public HashMap<String,Object> saveUser(String username, String password){
        //check if user exists
        UserModel searchResult = this.getUser(username);
        UserModel dbResult = null;
        HashMap<String,Object> response = new HashMap<>();

        if(searchResult == null){

            UserModel user = new UserModel();
            user.setUsername(username);
            user.setPassword(password);
            user.setCreated_at(new Timestamp(System.currentTimeMillis()));
            dbResult = this.userRepository.save(user);
            response.put("new_user",true);
            response.put("data",dbResult);
            return response;
        }
        response.put("new_user",false);
        response.put("data",null);
        return response;
    }

    public UserModel getUser(String username){
        UserModel user = this.userRepository.findByUsername(username);
        if(user != null) return user;
        return null;
    }

    public HashMap<String,Object> checkUser(String username,String password){
        UserModel searchResult = this.getUser(username);
        HashMap<String,Object> response = new HashMap<>();


        if(searchResult == null) {
            response.put("new_user",true);
            response.put("data",searchResult);
            return response;
        }
        response.put("new_user",false);
        response.put("data",null);
        return response;
    }
}
