package cundi.edu.co.registro.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editorial")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id; 
	
	@Column(name = "nit", length = 12, nullable = false , unique = true)
	private String nit;
	
	@Column(name="nombre", length =  15 , nullable =  false)
	private String nombre;
	
	@Column(name = "correo", length = 25, unique =  true, nullable = true)
	private String correo;

	
	public Editorial() {
		
		
	}
	
	public Editorial(int id, String nit, String nombre, String correo) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
		Editorial other = (Editorial) obj;
		return id == other.id;
	}
		
		
	
	
	
	
}
