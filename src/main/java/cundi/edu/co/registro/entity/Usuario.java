package cundi.edu.co.registro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotNull(message = "Documento obligatorio")
	@Size(min = 6, max = 30, message = "Longitud de documento incorrecta")
	@Column(name= "documento",unique = true,length = 30,nullable = false)
	private String documento;
	
	@NotNull(message = "Nombre obligatorio")
	@Size(min = 3, max = 25, message = "Longitud de nombre incorrecta")	
	@Column(name = "nombre",nullable = false,length = 25)
	private String nombre;

	@NotNull(message = "Apellido obligatorio")
	@Size(min = 3, max = 25, message = "Longitud de apellido incorrecta")	
	@Column(name = "apellido",nullable = false,length = 25)
	private String apellido;
	
	@NotNull(message = "Nick obligatorio")
	@Size(min = 6, max = 25, message = "Longitud de Nick incorrecta")	
	@Column(name = "nick",nullable = false,length = 25)
	private String nick;
	
	@NotNull(message = "Clave obligatorio")
	
	@Column(columnDefinition = "TEXT", name = "clave",nullable = false,length = 25)
	private String clave;
	
	
	@ManyToOne
	@JoinColumn(name="idRol",foreignKey = @ForeignKey(name="FK_rol"))
	private Rol rol;


	public Usuario() {
		
		
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
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


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
}


