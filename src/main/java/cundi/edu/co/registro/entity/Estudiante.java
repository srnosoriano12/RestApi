package cundi.edu.co.registro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "El nombre debe ser obligatorio")
	@Size(min  = 3,max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
	@Column(name="nombre", length = 20 , nullable = false)	
	private String nombre;
	@NotNull(message = "El apellido debe ser obligatorio")
	@Size(min  = 3,max = 20, message = "El apellido debe tener entre 3 y 20 caracteres")
	@Column(name="apellido", length = 20 , nullable = false)
	
	private String apellido;
	@NotNull(message = "El correo debe ser obligatorio")
	@Size(min  = 6,max = 50, message = "El correo debe tener entre 6 y 50 caracteres")
	@Column(name="correo", length = 50 , nullable = false)
	private String correo;

	@NotNull(message = "La cedula debe ser cedula")
	@Size(min  = 7,max = 15, message = "la cedula debe tener entre 6 y 15 caracteres")
	@Column(name="cedula", length = 15 , nullable = false)
	private String cedula;
	
	
	public Estudiante() {}
	
	public Estudiante(Integer id, String nombre, String apellido, String correo,String cedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cedula = cedula;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	} 
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
}
