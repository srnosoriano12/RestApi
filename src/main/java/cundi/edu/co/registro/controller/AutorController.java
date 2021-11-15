package cundi.edu.co.registro.controller;

import java.net.http.HttpResponse.ResponseInfo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.IAutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private IAutorService services;
	
	@GetMapping(value="/obtenerPaginado/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable  Integer page, @PathVariable  Integer size){		
		Page<Autor> autores = services.retornarPaginado(page,size);
		return new ResponseEntity<Page<Autor>>(autores,HttpStatus.OK);		
	}		
	
	@GetMapping(value="buscar/{id}")	
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ModelNotFoundException{
		
		return new ResponseEntity<Object>(services.retornarPorId(id),HttpStatus.OK);
		
	}
	
	@PutMapping(value ="editar",consumes = "application/json")
	public ResponseEntity<?> editar(@RequestBody  @Valid Autor autor) throws IntegridadException, ModelNotFoundException{
		services.editar(autor);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@PostMapping(value="/agregar",consumes = "application/json")
	public ResponseEntity<?> agregar(@RequestBody  @Valid Autor autor) throws IntegridadException{
		services.guardar(autor);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
		
	@DeleteMapping(value="/eliminar/{id}",produces  = "application/json")
	public ResponseEntity<?>eliminaar(@PathVariable Integer id) throws ModelNotFoundException{
		
		services.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
}
