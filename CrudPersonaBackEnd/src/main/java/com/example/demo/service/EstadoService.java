package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estado;
import com.example.demo.repository.EstadoRepository;

@Service
public class EstadoService{

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		// TODO Auto-generated method stub
		return estadoRepository.findAll();
	}
	
	public List<Estado> findByPaisId(Long idPais) {
		
		return estadoRepository.findByPaisId(idPais);
	}

	public List<Estado> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return estadoRepository.findAll(sort);
	}
}
