package cundi.edu.co.registro.service;

import org.springframework.data.domain.Page;

import cundi.edu.co.registro.Dto.AutorEditorialDto;
import cundi.edu.co.registro.Dto.EditorialAutorDto;
import cundi.edu.co.registro.Dto.EditorialDto;
import cundi.edu.co.registro.Dto.IAutorDto;
import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.entity.Editorial;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IAutorRepo;


public interface IAutorEditorialService {

	
	public void agregarAutorEditorial(AutorEditorialDto object) throws IntegridadException;
	
	
	public void eliminarAutoriEditorial(Integer idAutor,Integer idEditorial) throws ModelNotFoundException;
	
	
	public Page<IAutorDto> retornarPaginadoAutoresPorEditorial(Integer idEditorial,Integer page, Integer size) throws ModelNotFoundException;
	
	
	public Page<EditorialAutorDto> retornarPaginanoEditorialesPorAutores(Integer idAutor,Integer page, Integer size) throws ModelNotFoundException;
	
	
	
}
