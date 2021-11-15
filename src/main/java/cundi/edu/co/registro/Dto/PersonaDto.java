package cundi.edu.co.registro.Dto;




import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value = "Objeto persona",description = "Objeto encargado de recibir los datos de la persona")

public class PersonaDto  extends RepresentationModel<PersonaDto> {	
	
	@NotNull
	@ApiModelProperty(required = true,dataType = "Integer",example = "10")
	private int id;	
	@ApiModelProperty(required = true,dataType = "String",example = "Raul" ,allowableValues =" range[3, 20]")
	@NotBlank(message = "Nombre obligatorio") @Size(max = 20 , min = 3)
		
	private String nombre;
	@Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+$",message = "Formato correo incorrecto") @NotBlank(message = "Correo obligatorio") @Size(max = 50 , min = 6)
	@ApiModelProperty(required = true,dataType = "String",example = "Raul@gmail.com" ,allowableValues =" range[6, 50]")
	private String correo;
	@NotBlank(message = "Correo obligatorio") @Size(max = 50 , min = 6)	
	@ApiModelProperty(required = true,dataType = "String",example = "bogota-colombia" ,allowableValues =" range[6, 50]")
	private String direccion;
	@NotNull
	@ApiModelProperty(required = true,dataType = "Boolean",example = "true")
	private boolean sexo;
	@ApiModelProperty(required = true,dataType = "Integer",example = "19",allowableValues =" range[18, 100]")
	@NotNull @Min(18) @Max(100)	
	private int edad;
	
	public PersonaDto() {
		
	}

	public PersonaDto(int id,String nombre, String correo, String direccion, boolean sexo, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.sexo = sexo;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id= id;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	
}
