package com.tech.pro.controller;

import com.tech.pro.entity.Users;
import com.tech.pro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Long id){
        Optional<Users> users = userService.getUser(id);
        return users.orElse(null);
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public Users addOrUpdateUser(@RequestBody Users users){
       return userService.addOrUpdateUser(users);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/user")
    public Users getUserByUserName(@RequestParam("userName") String userName){
        return userService.getUserByUserName(userName);
    }
}
