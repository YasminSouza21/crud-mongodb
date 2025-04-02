package com.yasmin.trabalho.crud_mongo.services;

import com.yasmin.trabalho.crud_mongo.domain.products.Product;
import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductRequestDTO productRequestDTO){
        productRepository.save(new Product(productRequestDTO));
    }

    public void updateProduct(ProductRequestUpdateDTO productRequestUpdateDTO){

        Optional<Product> product = productRepository.findById(productRequestUpdateDTO.id());

        if(product.isPresent()){
            Product existingProduct = product.get();
            existingProduct.setId(productRequestUpdateDTO.id());
            existingProduct.setPrice(productRequestUpdateDTO.price());
            existingProduct.setQuantity(productRequestUpdateDTO.quantity());
            existingProduct.setName(productRequestUpdateDTO.name());

            productRepository.save(existingProduct);
        }
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product findTopProduct(){ return productRepository.findTopByOrderByIdDesc();}
}
