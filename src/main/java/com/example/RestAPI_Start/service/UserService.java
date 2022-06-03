package com.example.RestAPI_Start.service;

import com.example.RestAPI_Start.entity.UserEntity;
import com.example.RestAPI_Start.exception.UserAlreadyExistsException;
import com.example.RestAPI_Start.exception.UserNotFoundException;
import com.example.RestAPI_Start.model.UserModel;
import com.example.RestAPI_Start.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(userEntity.getUsername()) != null){
            throw new UserAlreadyExistsException("User already exists!");
        }
        return userRepo.save(userEntity);
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("User not found(");
        }
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
