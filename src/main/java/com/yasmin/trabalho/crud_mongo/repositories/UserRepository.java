package com.yasmin.trabalho.crud_mongo.repositories;

import com.yasmin.trabalho.crud_mongo.domain.users.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findTopByOrderByIdDesc();

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
