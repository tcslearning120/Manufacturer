package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

}
