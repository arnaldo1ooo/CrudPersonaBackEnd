package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estado;
import com.example.demo.service.EstadoService;

@RestController
@RequestMapping("/estados/")
public class EstadoController {
	
	@Autowired
	private EstadoService estadosService;  
	
	
	//Leer por PAIS
	@GetMapping ("{idPais}")
	private ResponseEntity<List<Estado>> getEstadosByPais(@PathVariable("idPais") Long idPais){
		return ResponseEntity.ok(estadosService.findByPaisId(idPais));
	}
	
	
}
