package cundi.edu.co.registro.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.registro.Dto.PersonaDto;
import cundi.edu.co.registro.entity.Estudiante;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.imp.IEstudianteServiceImp;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private IEstudianteServiceImp service;
	
	
	@GetMapping(value="/buscar/{id}",produces = "application/json")
	public ResponseEntity<Estudiante> obtenerPersona(@ApiParam(value = "id de la persona",name = "id",required = true,type = "Integer") @PathVariable ("id") @NotNull @Min(1) int id) throws ModelNotFoundException {		
		
		Estudiante estudiante = service.obtenerId(id);
		return  new  ResponseEntity<Estudiante> (estudiante,HttpStatus.OK);
	}
		
	@GetMapping(value="/obtenerPaginado/{page}/{size}",produces = "application/json")
	public ResponseEntity<?> obtenerTodos( @PathVariable int page , @PathVariable int size ) throws ModelNotFoundException  {		
		Page<Estudiante> estudiantes = service.obtenerPaginado(page,size);
		return  new  ResponseEntity<Page<Estudiante>> (estudiantes,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/obtenerPaginadoPql/{page}/{size}",produces = "application/json")
	public ResponseEntity<?> obtenerTodosPaginado( @PathVariable int page , @PathVariable int size ) throws ModelNotFoundException  {		
		Page<Estudiante> estudiantes = service.obtenerPaginadoJpql(page,size);
		return  new  ResponseEntity<Page<Estudiante>> (estudiantes,HttpStatus.OK);
	}
	
		
	@PostMapping(value="/agregar",consumes="application/json")	
	public ResponseEntity<?> agregarPersona(@RequestBody Estudiante estudiante) throws ModelNotFoundException, IntegridadException{
		service.agregar(estudiante);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping(value="/editar")
	public ResponseEntity<?> editarPersona(@RequestBody Estudiante estudiante) throws ModelNotFoundException, IntegridadException{
		
		service.editar(estudiante);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
