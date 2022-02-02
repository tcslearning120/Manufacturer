package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
