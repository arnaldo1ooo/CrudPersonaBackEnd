package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pais;
import com.example.demo.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return paisRepository.findAll();
	}

	public List<Pais> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return paisRepository.findAll(sort);
	}

}
