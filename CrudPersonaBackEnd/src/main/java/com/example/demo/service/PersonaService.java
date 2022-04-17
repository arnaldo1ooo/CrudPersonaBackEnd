package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	public List<Persona> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return personaRepository.findAll(sort);
	}

	public <S extends Persona> S save(S entity) {
		return personaRepository.save(entity);
	}

	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return personaRepository.findAll(pageable);
	}
	
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.existsById(id);
	}

	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}

	public void delete(Persona entity) {
		personaRepository.delete(entity);
	}
	
}
