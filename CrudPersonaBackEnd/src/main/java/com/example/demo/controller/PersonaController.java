package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/personas/")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	// Leer todo
	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas() {
		return ResponseEntity.ok(personaService.findAll());
	}

	// Crear
	@PostMapping // Tambien se puede usar @RequestMapping(POST)
	public ResponseEntity<?> crear(@RequestBody Persona Persona) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(Persona));
		} catch (Exception e) {	//Si salvar falla
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	// Leer
	@GetMapping("/{personaId}")
	public ResponseEntity<?> leer(@PathVariable() Long personaId) {
		Optional<Persona> oPersona = personaService.findById(personaId); // Se utiliza Optional para evitar error cuando
																			// es null

		if (!oPersona.isPresent()) { // Si trae null
			return ResponseEntity.notFound().build(); // Retorna el codigo 404
		}

		return ResponseEntity.ok(oPersona);
	}

	//Actualizar
	@PutMapping("/{personaId}")
	public ResponseEntity<?> actualizar(@RequestBody Persona personaDetails, @PathVariable() Long departamentoId){
		Optional<Persona> oPersona = personaService.findById(departamentoId);
		
		if (!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		//BeanUtils.copyProperties(personaDetails, oDepartamento);	Sirve para copiar directamente todo el objeto personaDetails a oDepartamento
		
		oPersona.get().setNombre(personaDetails.getNombre());
		oPersona.get().setPais(personaDetails.getPais());
		oPersona.get().setEstado(personaDetails.getEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(oPersona.get()));
	}
	
	// Borrar
	@DeleteMapping("/{personaId}")
	public ResponseEntity<?> borrar(@PathVariable() Long personaId) {

		if (!personaService.findById(personaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		personaService.deleteById(personaId);

		return ResponseEntity.ok().build();
	}

}
