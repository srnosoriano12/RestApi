package cundi.edu.co.registro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.registro.Dto.AutorEditorialDto;
import cundi.edu.co.registro.Dto.EditorialAutorDto;
import cundi.edu.co.registro.Dto.IAutorDto;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.IAutorEditorialService;

@RestController
@RequestMapping("/autorEditorial")
public class AutorEditorialController {

	
	@Autowired
	private IAutorEditorialService services;
	
	
	@PostMapping(value="/agregar",consumes = "application/json")
	public ResponseEntity<?> agregar(@RequestBody  AutorEditorialDto autorEditorial) throws IntegridadException{
		services.agregarAutorEditorial(autorEditorial);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
		
	@DeleteMapping(value="eliminar/{idAutor}/{idEditorial}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idAutor, @PathVariable Integer idEditorial) throws ModelNotFoundException{
		services.eliminarAutoriEditorial(idAutor, idEditorial);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value="/obtenerPaginadoEditorialesPorAutor/{idAutor}/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable  Integer idAutor,@PathVariable  Integer page, @PathVariable  Integer size) throws ModelNotFoundException{		
		Page<EditorialAutorDto> autores = services.retornarPaginanoEditorialesPorAutores(idAutor,page,size);
		return new ResponseEntity<Page<EditorialAutorDto>>(autores,HttpStatus.OK);		
	}		
	
	
	@GetMapping(value="/obtenerPaginadoAutoresPorEditorial/{idEditorial}/{page}/{size}")
	public ResponseEntity<?> retornarPaginadoAutor(@PathVariable  Integer idEditorial,@PathVariable  Integer page, @PathVariable  Integer size) throws ModelNotFoundException{		
		Page<IAutorDto> autores = services.retornarPaginadoAutoresPorEditorial(idEditorial,page,size);
		return new ResponseEntity<Page<IAutorDto>>(autores,HttpStatus.OK);		
	}
	
}
