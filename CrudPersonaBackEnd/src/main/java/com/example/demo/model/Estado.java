package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado")
@Data //Agrega los getters y setters
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	private Long id;
	
	@Column(name = "est_nombre")
	private String nombre;
	
	@ManyToOne	//Muchos ESTADOS para un PAIS
	@JoinColumn (name="est_pais")
	private Pais pais;
	
}
