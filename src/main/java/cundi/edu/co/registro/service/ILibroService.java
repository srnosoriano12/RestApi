package cundi.edu.co.registro.service;

import cundi.edu.co.registro.entity.Libro;
import cundi.edu.co.registro.exception.ModelNotFoundException;


public interface ILibroService extends ICrud<Libro, Integer>{
	
	
	public void guardarL(Libro libro) throws ModelNotFoundException;
	
}
