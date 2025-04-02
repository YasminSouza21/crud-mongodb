package com.yasmin.trabalho.crud_mongo.repositories;

import com.yasmin.trabalho.crud_mongo.domain.products.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Optional<Product> findById(Long id);

    void deleteById(Long id);

    Product findTopByOrderByIdDesc();
}
