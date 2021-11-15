package cundi.edu.co.registro.Dto;

import java.util.Date;

public class AutorEditorialDto {

	
	
	private Integer idEditorial;
	
	private Integer idAutor; 
	
	private Date fecha;

	
	public AutorEditorialDto() {
		
		
	}
	
	
	public AutorEditorialDto(Integer idEditorial, Integer idAutor, Date fecha) {
		super();
		this.idEditorial = idEditorial;
		this.idAutor = idAutor;
		this.fecha = fecha;
	}

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
}
