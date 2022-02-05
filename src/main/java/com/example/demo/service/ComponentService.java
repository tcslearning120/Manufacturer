package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ComponentRepository;

import com.example.demo.entity.Component;

@Service
public class ComponentService {
	@Autowired
	ComponentRepository componentRepository;

	public Optional<Component> getcomponent(Integer id) {

		return componentRepository.findById(id);
	}

	public void saveComponent(@Valid Component component) {

		componentRepository.save(component);
	}

	@Transactional
	public void deleteComponent(Integer id) {

		componentRepository.deleteById(id);
	}

	
	
}
