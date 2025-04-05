package com.yasmin.trabalho.crud_mongo.domain.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "products")
public class Product {
    @Id
    private ObjectId objectId;
    private Long id;
    private String name;
    private int quantity;
    private double price;

    public Product(ProductRequestDTO productRequestDTO) {
        this.id = productRequestDTO.id();
        this.name = productRequestDTO.name();
        this.quantity = productRequestDTO.quantity();
        this.price = productRequestDTO.price();
    }

    public Product(ProductRequestUpdateDTO productRequestUpdateDTO) {
        this.id = productRequestUpdateDTO.id();
        this.name = productRequestUpdateDTO.name();
        this.quantity = productRequestUpdateDTO.quantity();
        this.price = productRequestUpdateDTO.price();
    }


}
