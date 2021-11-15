package cundi.edu.co.registro.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.entity.Libro;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IAutorRepo;
import cundi.edu.co.registro.repository.ILibroRepo;
import cundi.edu.co.registro.service.ILibroService;


@Service
public class ILibroServiceImp implements ILibroService{

	
	@Autowired
	private ILibroRepo repo;
	
	@Autowired
	private IAutorRepo repoAutor;
	
	@Override
	public Page<Libro> retornarPaginado(int page, int size) {

		return repo.findAll(PageRequest.of(page, size));
		
	}

	@Override
	public Libro retornarPorId(Integer id) throws ModelNotFoundException {
		return repo.findById(id).orElseThrow(()-> new ModelNotFoundException("Libro no encontrado"));
	}

	@Override
	public void guardar(Libro object) throws IntegridadException {
	
		repo.save(object);
		
	}

	@Override
	public void guardarL(Libro libro) throws ModelNotFoundException {
		if(!existsAutor(libro.getAutor().getId())) {
			throw new ModelNotFoundException("Autor no encontrado");
		}
		repo.save(libro);
	}
	
	
	@Override
	public void editar(Libro object) throws IntegridadException, ModelNotFoundException {
		
		if(existsAutor(object.getAutor().getId())) {
			if(!repo.existsById(object.getId())) {
				throw new ModelNotFoundException("Libro no encontrado");
			}
			repo.save(object);
		}else {
			throw new ModelNotFoundException("Autor no encontrado");
		}
		

	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		if(!repo.existsById(id)) {
			throw new ModelNotFoundException("Libro no encontrado");
		}
		repo.deleteById(id);
	}

	
	private Boolean existsAutor(Integer id) {
		
		return repoAutor.existsById(id);
		
	}


	
	
	
}
