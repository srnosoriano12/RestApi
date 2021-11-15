package cundi.edu.co.registro.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IAutorRepo;
import cundi.edu.co.registro.service.IAutorService;


@Service
public class IAutorServiceImp implements IAutorService{

	
	@Autowired 
	private  IAutorRepo repo;

	@Override
	public Page<Autor> retornarPaginado(int page, int size) {
				
		return repo.findAllAutorWithPagination(PageRequest.of(page, size));
	}

	@Override
	public Autor retornarPorId(Integer id) throws ModelNotFoundException {

		return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));
		
	}

	@Override
	public void guardar(Autor object) throws IntegridadException {
		// TODO Auto-generated method stub		
		
		if(repo.countByCorreo(object.getCorreo())> 0 || repo.countByCedula(object.getCedula())> 0 ) {
			if(repo.countByCorreo(object.getCorreo())> 0 ) {
				throw new IntegridadException("Error al agregar, correo ya existente");
			}else {
				throw new IntegridadException("Error al agregar, cedula ya existente");
			}
		}
		repo.save(object);
	}

	@Override
	public void editar(Autor object) throws IntegridadException, ModelNotFoundException {

		if(repo.existsById(object.getId())) {
			if(repo.existsByIdAndCedula(object.getId(), object.getCedula())) {
				// valid CORREO
				if(repo.countByCorreoYIdExceptOwn(object.getId(), object.getCorreo()) > 0 ) {
					throw new IntegridadException("Correo ya existente");
				}
				//edit
				repo.save(object);
			}else {
				throw new IntegridadException("No es posible editar la cedula");
			}
		}else {
			throw new ModelNotFoundException("Autor no encontrado");
		}				
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {

		if(!repo.existsById(id)) {
			throw new ModelNotFoundException("Autor no encontrado");
		}
		repo.deleteById(id);
	}
	
	
	
	
}
