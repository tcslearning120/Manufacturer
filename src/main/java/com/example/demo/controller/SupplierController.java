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

import com.example.demo.Repository.ComponentRepository;
import com.example.demo.Repository.SupplierRepository;
import com.example.demo.entity.Supplier;

import com.example.demo.service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	@Autowired
	ComponentRepository componentRepository;
	@Autowired
	SupplierRepository supplierRepository;

	@GetMapping("/supplier")
	public Iterable<Supplier> getDetails() {
		return supplierService.getSupplierDetails();

	}

	@GetMapping("/supplier/{supplierId}")
	Optional<Supplier> getSuppliers(@PathVariable("supplierId") Integer supplierId) {
		return supplierService.getSupplier(supplierId);
	}

	@PostMapping("/supplier")
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	void creatSupplier(@RequestBody @Valid Supplier supplier) {
		supplierService.saveSupplier(supplier);
	}

	@DeleteMapping("/supplier/{supplierid}")
	void deleteSupplier(@PathVariable("supplierId") Integer supplierId) {
		supplierService.deleteSupplier(supplierId);
	}

}