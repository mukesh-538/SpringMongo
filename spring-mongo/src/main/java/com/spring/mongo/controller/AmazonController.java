package com.spring.mongo.controller;

import com.spring.mongo.exception.CityNotFoundException;
import com.spring.mongo.exception.UserNotFoundException;
import com.spring.mongo.model.User;
import com.spring.mongo.repo.AmazonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orderService")
@RestController
public class AmazonController {
    @Autowired
    private AmazonRepo amazonRepo;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody User user) {
        amazonRepo.save(user);
        return "Order placed successfully";
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
