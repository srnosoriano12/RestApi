package cundi.edu.co.registro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.entity.Usuario;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	
	@GetMapping(value="/obtenerPaginado/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable  Integer page, @PathVariable  Integer size){		
		Page<Usuario> usuarios = service.retornarPaginado(page,size);
		return new ResponseEntity<Page<Usuario>>(usuarios,HttpStatus.OK);		
	}		
	
	
	@GetMapping(value="/buscarPorId/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ModelNotFoundException{
		Usuario usuario = service.retornarPorId(id); 
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	
	@PutMapping(value ="editar",consumes = "application/json")
	public ResponseEntity<?> editar(@RequestBody  @Valid Usuario usuario) throws IntegridadException, ModelNotFoundException{
		service.editar(usuario);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@PostMapping(value="/agregar",consumes = "application/json")
	public ResponseEntity<?> agregar(@RequestBody  @Valid Usuario usuario) throws IntegridadException{
		service.guardar(usuario);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
		
	@DeleteMapping(value="/eliminar/{id}",produces  = "application/json")
	public ResponseEntity<?>eliminaar(@PathVariable Integer id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
