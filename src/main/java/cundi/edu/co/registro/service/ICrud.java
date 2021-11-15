package cundi.edu.co.registro.service;

import org.springframework.data.domain.Page;

import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;

public interface ICrud <T,K>{

	public Page<T> retornarPaginado(int page,int size);
	
	public T retornarPorId(K id) throws ModelNotFoundException ;
	
	public void guardar(T object) throws IntegridadException;
	
	public void editar(T object) throws IntegridadException,ModelNotFoundException;
		
	public void eliminar(K id) throws ModelNotFoundException;

	
	
}
