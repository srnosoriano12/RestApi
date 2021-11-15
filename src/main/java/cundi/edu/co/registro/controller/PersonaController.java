package cundi.edu.co.registro.controller;

import javax.validation.Valid;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cundi.edu.co.registro.Dto.PersonaDto;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.IPersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;





@RestController
@Api(value = "Servicios persona",description =  " Controlador encargado de recibir todas las peticiones relacionadas con la persona")
@RequestMapping("/persona")
@Validated

public class PersonaController {
	
	@Autowired
	
	private IPersonaService servicios ;
	
	@ApiOperation(value = "Buscar una persona por id",notes = "retorna a la persona de ser encontrada")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "objeto persona",response = PersonaDto.class), @ApiResponse(code = 404, message = "Not found")})
		
	@GetMapping(value="/buscar/{id}",produces = "application/json")
	public ResponseEntity<PersonaDto> obtenerPersona(@ApiParam(value = "id de la persona",name = "id",required = true,type = "Integer") @PathVariable ("id") @NotNull @Min(1) int id) throws ModelNotFoundException {		
		PersonaDto personas = servicios.obtener(id);
		
		personas.add(linkTo(methodOn(PersonaController.class).eliminarPersona(id)).withSelfRel().withType("DELETE"));
		personas.add(linkTo(methodOn(PersonaController.class).editarPersona(personas)).withSelfRel().withType("PUT"));
		personas.add(linkTo(methodOn(PersonaController.class).agregarPersona(personas)).withSelfRel().withType("POST"));
		return  new ResponseEntity<PersonaDto>(personas,HttpStatus.OK);
	}
		
	
	@ApiOperation(value = "obtener las personas",notes = "retorna a las personas del sistema")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "objeto persona",response = PersonaDto.class), @ApiResponse(code = 404, message = "Not found")})
		
	@GetMapping(value="/obtener",produces = "application/json")
	public ResponseEntity<List<PersonaDto>> obtenerPersonas() throws ModelNotFoundException {		
		
		
		List<PersonaDto> listaPersonas = servicios.listaPersonas();
		
		for (PersonaDto personaDto : listaPersonas) {
			personaDto.add(linkTo(methodOn(PersonaController.class).eliminarPersona(personaDto.getId())).withSelfRel().withType("DELETE"));
			personaDto.add(linkTo(methodOn(PersonaController.class).obtenerPersona(personaDto.getId())).withSelfRel().withType("GET"));
		}
		
		return  new  ResponseEntity<List<PersonaDto>> (listaPersonas,HttpStatus.OK);
	}
	
	
	
	
	@ApiOperation(value = "Agrega una persona")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Persona agregada"),@ApiResponse(code = 404,message = "Not Found")})
	@PostMapping(value="/agregar",consumes="application/json")
		
	public ResponseEntity<?> agregarPersona(@RequestBody @Valid PersonaDto persona) throws ModelNotFoundException{
		
		persona.add(linkTo(methodOn(PersonaController.class).eliminarPersona(persona.getId())).withSelfRel().withType("DELETE"));
		persona.add(linkTo(methodOn(PersonaController.class).editarPersona(persona)).withSelfRel().withType("PUT"));
		persona.add(linkTo(methodOn(PersonaController.class).obtenerPersona(persona.getId())).withSelfRel().withType("GET"));
		return new ResponseEntity<Object>(persona,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Editar una persona")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Persona editada"),@ApiResponse(code = 404,message = "Not Found")})
	@PutMapping(value="/editar",consumes="application/json")
	public ResponseEntity<?> editarPersona(@RequestBody @Valid PersonaDto persona) throws ModelNotFoundException {
		
		persona.add(linkTo(methodOn(PersonaController.class).eliminarPersona(persona.getId())).withSelfRel().withType("DELETE"));
		persona.add(linkTo(methodOn(PersonaController.class).obtenerPersona(persona.getId())).withSelfRel().withType("GET"));
		persona.add(linkTo(methodOn(PersonaController.class).agregarPersona(persona)).withSelfRel().withType("POST"));
		return new ResponseEntity<Object>(persona,HttpStatus.OK);	
	}
	
	
	
	
	
	@ApiOperation(value = "Eliminar una persona")
	@ApiResponses(value = {@ApiResponse(code = 204,message = "Persona eliminada"),@ApiResponse(code = 404,message = "Not Found")})
	@DeleteMapping(value="/eliminar/{i}",produces = "application/json")
	public ResponseEntity<?> eliminarPersona(@ApiParam(value = "id de la persona",name = "id",required = true,type = "Integer") @PathVariable int i) throws ModelNotFoundException {
		 	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);			
	}
	
}
