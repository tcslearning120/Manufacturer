package com.example.demo.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;


@RestController
public class ProductController {
@Autowired
ProductService productService;

@GetMapping("/product/{productId}")
Optional<Product>getProducts(@PathVariable("productId") Integer productId){
   return productService.getproduct(productId);
}

@PostMapping("/product")
@Transactional
@ResponseStatus(code = HttpStatus.CREATED)
void creatProduct(@RequestBody  Product product) {
	productService.saveProduct(product);
}

@DeleteMapping("/product/{productid}")
void deleteProduct(@PathVariable("productId") Integer productId) {
	productService.deleteProduct(productId);
}
}
