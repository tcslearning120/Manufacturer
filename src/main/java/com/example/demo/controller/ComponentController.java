package com.example.demo.controller;

import java.util.Optional;

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

import com.example.demo.entity.Component;

import com.example.demo.service.ComponentService;


@RestController
public class ComponentController {
	@Autowired
	ComponentService componentService;
	@GetMapping("/component/{id}")
	Optional<Component>getComponents(@PathVariable("id") Integer id){
	   return componentService.getcomponent(id);
	}
	@PostMapping("/component")
	@ResponseStatus(code = HttpStatus.CREATED)
	void creatComponent(@RequestBody @Valid Component component) {
		componentService.saveComponent(component);
	}

	@DeleteMapping("/component/{id}")
	void deleteComponent(@PathVariable("id") Integer id) {
		componentService.deleteComponent(id);
	}
}
