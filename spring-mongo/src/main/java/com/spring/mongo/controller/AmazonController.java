package com.spring.mongo.controller;

import com.spring.mongo.exception.CityNotFoundException;
import com.spring.mongo.exception.UserNotFoundException;
import com.spring.mongo.model.User;
import com.spring.mongo.repo.AmazonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orderService")
@RestController
@Slf4j
public class AmazonController {
    @Autowired
    private AmazonRepo amazonRepo;

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody User user) {
        amazonRepo.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) throws UserNotFoundException {
        User userbyName = amazonRepo.findByName(name);
        if (userbyName != null) {
            return userbyName;
        } else {
            throw new UserNotFoundException("User with name : " + name+ " is not found");
        }
    }

    @GetMapping("/getUserByAddress/{city}")
    public User getUserByAddress(@PathVariable String city) throws CityNotFoundException {
        User user = amazonRepo.findByAddress(city);
        if (user!= null){
            return user;
        }else
            throw new CityNotFoundException("City : "+ city+ " is not available, Please try another city");
    }
}
