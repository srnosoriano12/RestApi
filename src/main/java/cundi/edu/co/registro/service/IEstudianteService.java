package cundi.edu.co.registro.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.registro.entity.Estudiante;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;

public interface IEstudianteService {
	
	
	public Estudiante obtenerId(int id) throws ModelNotFoundException;
	
	public List<Estudiante> obtener() throws ModelNotFoundException;
	
	public Page<Estudiante> obtenerPaginado(int page, int size) throws ModelNotFoundException;
	
	
	public Page<Estudiante> obtenerPaginadoJpql(int page,int size) throws ModelNotFoundException;
	
	public void editar(Estudiante estudiante) throws ModelNotFoundException, IntegridadException;
	
	public void agregar(Estudiante estudiante) throws IntegridadException;
	
	public void eliminar(int id) throws ModelNotFoundException; 
	
	
	
	
}

