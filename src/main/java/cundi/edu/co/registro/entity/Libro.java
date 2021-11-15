package cundi.edu.co.registro.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference; 

@Entity
@Table(name="libro")
public class Libro {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@NotNull(message = "El nombre es obligario")
	@Size(min  = 3,max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")
	@Column(name = "nombre",nullable = false,columnDefinition = "TEXT")
	private String nombre;
	
	@NotNull(message = "La descripcion es obligaria")
	@Size(min  = 5,max = 60, message = "la descripcion debe tener entre 5 y 60 caracteres")
	@Column(name = "descripcion",nullable = false,columnDefinition = "TEXT")
	private String descripcion;
	
	
	@NotNull(message = "El numero de paginas es obligatorio")
	@Column(name ="numero_paginas", nullable = false)
	private Integer numeroPaginas;

	
	@NotNull(message = "La fecha debe ser obligatoria")
	@Column(name = "fecha_publicacion",nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaPublicacion;

	@ManyToOne
	@JoinColumn(name = "id_autor",nullable = false,foreignKey = @ForeignKey(name = "FK_Autor_Libro"))
	@JsonBackReference
	private Autor autor;
	
	public Libro() {
		super();
	}
	
	public Libro(String nombre, String descripcion, Integer numeroPaginas,Calendar fechaPublicacion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroPaginas = numeroPaginas;
		this.fechaPublicacion = fechaPublicacion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}


	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}


	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Autor getAutor() {
		return autor;
	} 
	
}
