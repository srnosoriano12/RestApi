package cundi.edu.co.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cundi.edu.co.registro.entity.Libro;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Integer>{

	
}
