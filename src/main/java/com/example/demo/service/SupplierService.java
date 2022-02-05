package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.SupplierRepository;

import com.example.demo.entity.Supplier;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	public Iterable<Supplier> getSupplierDetails() {

		return supplierRepository.findAll();
	}

	@Transactional
	public Optional<Supplier> getSupplier(Integer supplierId) {

		return supplierRepository.findById(supplierId);
	}

	public void saveSupplier(@Valid Supplier supplier) {
		supplierRepository.save(supplier);

	}

	@Transactional
	public void deleteSupplier(Integer supplierId) {
		supplierRepository.deleteById(supplierId);

	}


}
