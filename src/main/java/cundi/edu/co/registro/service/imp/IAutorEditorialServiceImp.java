package cundi.edu.co.registro.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.Dto.AutorEditorialDto;
import cundi.edu.co.registro.Dto.EditorialAutorDto;
import cundi.edu.co.registro.Dto.EditorialDto;
import cundi.edu.co.registro.Dto.IAutorDto;
import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.entity.Editorial;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IAutorEditorialRepo;
import cundi.edu.co.registro.repository.IAutorRepo;
import cundi.edu.co.registro.repository.IEditorialRepo;
import cundi.edu.co.registro.service.IAutorEditorialService;


@Service
public class IAutorEditorialServiceImp implements IAutorEditorialService{

	@Autowired
	private IAutorEditorialRepo repo;
	
	@Autowired 
	private IEditorialRepo repoEditorial;
	
	@Autowired 
	private IAutorRepo repoAutor;
	
	
	@Override
	public void agregarAutorEditorial(AutorEditorialDto object) throws IntegridadException {
		
		if(!repoAutor.existsById(object.getIdAutor())) {
			throw new IntegridadException("Autor no encontrado");			
		}else if(!repoEditorial.existsById(object.getIdEditorial())){
			throw new IntegridadException("Editorial no encontrada");
		}if(repo.countByIdAutorAndIdEditorial(object.getIdAutor(),object.getIdEditorial())>0) {			
			throw new IntegridadException("Relacion ya existente");
		}else {
			repo.guardarAutorEditorial(object.getIdAutor(), object.getIdEditorial(), object.getFecha());
		}		
	}

	@Override
	public void eliminarAutoriEditorial(Integer idAutor, Integer idEditorial) throws ModelNotFoundException {

		if(repo.countByIdAutorAndIdEditorial(idAutor,idEditorial)>0) {	
			repo.eliminarAutorEditorial(idAutor, idEditorial);
		}else {
			throw new ModelNotFoundException("Relacion no encontrada");
		}
		
	}
	
	
	@Override
	public Page<EditorialAutorDto> retornarPaginanoEditorialesPorAutores(Integer idAutor, Integer page, Integer size) throws ModelNotFoundException {

		if(repoAutor.existsById(idAutor)) {
			return repo.findEditorialesPorAutor(idAutor,PageRequest.of(page, size));
			
		}else {
			throw new ModelNotFoundException("Autor no existente");
		}
		
		
	}

	@Override
	public Page<IAutorDto> retornarPaginadoAutoresPorEditorial(Integer idEditorial, Integer page, Integer size) throws ModelNotFoundException {
		if(repoEditorial.existsById(idEditorial)) {
			
			return repo.findAutoresPorEditorial(idEditorial,PageRequest.of(page, size));
		}else {
			throw new ModelNotFoundException("Editorial no existente");
		}
					
	}

	
}
