package com.spring.mongo.repo;

import com.spring.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmazonRepo extends MongoRepository<User, Integer> {
    User findByName(String name);

    @Query("{'Address.city':?0}")
    User findByAddress(String city);
}
