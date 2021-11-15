package cundi.edu.co.registro.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.entity.Editorial;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IEditorialRepo;
import cundi.edu.co.registro.service.IEditorialService;

@Service
public class IEditorialServiceImp implements IEditorialService{

	@Autowired
	private IEditorialRepo repo;
	
	@Override
	public Page<Editorial> retornarPaginado(int page, int size) {
		
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Editorial retornarPorId(Integer id) throws ModelNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Editorial no encontrado"));
	}

	@Override
	public void guardar(Editorial object) throws IntegridadException {
		
		if(repo.existsByNit(object.getNit()) || repo.existsByCorreo(object.getCorreo())) {
			if(repo.existsByCorreo(object.getCorreo())){
				throw new IntegridadException("Correo ya existente");
			}else{
				throw new IntegridadException("Nit ya existente");
			}
		}else {
			repo.save(object);
		}
	}

	@Override
	public void editar(Editorial object) throws IntegridadException, ModelNotFoundException {
		// que no sea el mismo con nit y correo. 
		
		if(repo.countByCorreoYIdExceptOwn(object.getId(), object.getCorreo())> 0 ) {
			throw new IntegridadException("Correo ya existe");
		}else if(repo.countByNitYIdExceptOwn(object.getId(), object.getNit())> 0 ) {
			throw new IntegridadException("Nit ya existe");
		}else {
			repo.save(object);
		}
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		if(repo.existsById(id)) {
			repo.delete(repo.getById(id));
		}else {
			throw new ModelNotFoundException("Editorial no encontrada");
		}
	}
	
	
	
	
}
