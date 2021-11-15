package cundi.edu.co.registro.service.imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.entity.Estudiante;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IEstudianteRepo;
import cundi.edu.co.registro.service.IEstudianteService;


@Service
public class IEstudianteServiceImp implements IEstudianteService{

	
	@Autowired
	private IEstudianteRepo repo;
	
	
	
	@Override
	public Estudiante obtenerId(int id) throws ModelNotFoundException {

		return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Estudiante no encontrado"));
		
	}

	@Override
	public List<Estudiante> obtener() throws ModelNotFoundException {

		return repo.findAll();
	}

	@Override
	public void editar(Estudiante estudiante) throws ModelNotFoundException, IntegridadException {
		
		
		if(repo.existsById(estudiante.getId())) {
			if(repo.existsByIdAndCedula(estudiante.getId(), estudiante.getCedula())) {

				
				if(repo.countByCorreoYIdExceptOwn(estudiante.getId(), estudiante.getCorreo())>0) {
					throw new IntegridadException("No es posible editar el correo ya existe");
				}
				//editar
				this.repo.save(estudiante);		
			}else {
				throw new IntegridadException("No es posible editar el campo cedula");
			}
		}else {
			throw new ModelNotFoundException("Estudiante no encontrado");
		}
		
		
		
	}
	
	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		if(repo.existsById(id)) {
			this.repo.deleteById(id);
		}else {
			throw new ModelNotFoundException("Estudiante no encontrado");
		}
	}

	@Override
	public Page<Estudiante> obtenerPaginado(int page, int size) throws ModelNotFoundException {
		
		return repo.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public Page<Estudiante> obtenerPaginadoJpql(int page, int size) throws ModelNotFoundException {

		return repo.findAllEstudianteWithPagination(PageRequest.of(page, size));
	}
	
	

	@Override
	public void agregar(Estudiante estudiante) throws IntegridadException {
		
		
		
		if(repo.countByCedula(estudiante.getCedula())> 0 || repo.countByCorreo(estudiante.getCorreo()) > 0 ) {
			if(repo.countByCedula(estudiante.getCedula())> 0) {
				throw new IntegridadException("Cedula ya existente");
			}else {
				throw new IntegridadException("Correo ya existe");
			}
		}
		this.repo.save(estudiante);
	}

	

}
