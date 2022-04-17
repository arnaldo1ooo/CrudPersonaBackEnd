package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Data //Agrega los getters y setters
public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "per_id")
	private Long id;
	
	@Column(name = "per_nombre")
	private String nombre;
	
	@Column(name = "per_apellido")
	private String apellido;
	
	@Column(name = "per_edad")
	private int edad;
	
	@ManyToOne	//Muchas PERSONAS para un PAIS
	@JoinColumn (name="per_pais")
	private Pais pais;
	
	
	@ManyToOne	//Muchas PERSONAS para un Estado
	@JoinColumn (name="per_estado")
	private Estado estado;
	
	
	
}
