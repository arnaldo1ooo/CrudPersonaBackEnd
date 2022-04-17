package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	List<Estado> findByPaisId(Long idPais);
}
