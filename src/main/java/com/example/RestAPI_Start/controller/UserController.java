package com.example.RestAPI_Start.controller;

import com.example.RestAPI_Start.entity.UserEntity;
import com.example.RestAPI_Start.exception.UserAlreadyExistsException;
import com.example.RestAPI_Start.exception.UserNotFoundException;
import com.example.RestAPI_Start.repository.UserRepo;
import com.example.RestAPI_Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity){
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok().body("Added user");
        } catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Mistake...");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Mistake...");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(userService.deleteUser(id));
        }  catch (Exception e){
            return ResponseEntity.badRequest().body("Mistake...");
        }
    }
}
