package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pais;
import com.example.demo.service.PaisService;

@RestController
@RequestMapping("/paises/")
public class PaisController {
	
	@Autowired
	private PaisService paisService;  
	
	//Leer todo
	@GetMapping
	private ResponseEntity<List<Pais>> getAllPaises(){
		return ResponseEntity.ok(paisService.findAll());
	}
	
}
