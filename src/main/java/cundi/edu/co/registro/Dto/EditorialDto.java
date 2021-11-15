package cundi.edu.co.registro.Dto;




public class EditorialDto {

	
	private Integer id;
	
	private String correo;
	
	private String nit;
	
	private String nombre;

	
	
	public EditorialDto() {
		
	}
	
	
	public EditorialDto(Integer id, String correo, String nit, String nombre) {
		super();
		this.id = id;
		this.correo = correo;
		this.nit = nit;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
	
	
	
	
	
}
