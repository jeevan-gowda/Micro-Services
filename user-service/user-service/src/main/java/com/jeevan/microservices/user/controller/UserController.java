package com.jeevan.microservices.user.controller;

import com.jeevan.microservices.user.VO.ResponseTemplateVO;
import com.jeevan.microservices.user.entity.Users;
import com.jeevan.microservices.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public Users saveUser(@RequestBody Users users){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(users);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserById method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
