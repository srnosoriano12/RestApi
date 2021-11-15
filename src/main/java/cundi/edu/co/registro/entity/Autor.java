package cundi.edu.co.registro.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "El nombre debe ser obligatorio")
	@Size(min  = 3,max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
	@Column(name="nombre",  nullable = false, columnDefinition = "TEXT")	
	private String nombre;
	
	@NotNull(message = "El apellido debe ser obligatorio")
	@Size(min  = 3,max = 20, message = "El apellido debe tener entre 3 y 20 caracteres")
	@Column(name="apellido" , nullable = false ,columnDefinition = "TEXT")
	
	private String apellido;
	@NotNull(message = "El correo debe ser obligatorio")
	@Size(min  = 6,max = 50, message = "El correo debe tener entre 6 y 50 caracteres")
	@Column(name="correo", nullable = false,columnDefinition = "TEXT")	
	private String correo;
	
	@NotNull(message = "La cedula debe ser cedula")
	@Size(min  = 7,max = 15, message = "la cedula debe tener entre 6 y 15 caracteres")
	@Column(name="cedula", nullable = false, columnDefinition = "TEXT")
	private String cedula;		
	
	@OneToMany(mappedBy = "autor",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	 @JsonManagedReference
	List<Libro> listaLibros;	
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre, String apellido, String correo, String cedula) {
		super();
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

	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}

}
