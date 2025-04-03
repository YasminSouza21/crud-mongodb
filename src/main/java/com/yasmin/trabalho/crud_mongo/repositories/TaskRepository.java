package com.yasmin.trabalho.crud_mongo.repositories;

import com.yasmin.trabalho.crud_mongo.domain.tasks.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {

    Task findTopByOrderByIdDesc();

    void deleteById(Long id);

    Optional<Task> findById(Long id);
}
