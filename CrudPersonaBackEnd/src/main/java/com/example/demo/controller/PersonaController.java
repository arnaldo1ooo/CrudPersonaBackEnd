package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/personas/")
public class PersonaController {

	@Autowired
	private PersonaService personaService;  
	
	
	//Leer todo
	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas(){
		return ResponseEntity.ok(personaService.findAll());
	}
	
}
