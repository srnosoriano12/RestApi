package cundi.edu.co.registro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cundi.edu.co.registro.entity.Autor;

@Repository
public interface IAutorRepo extends JpaRepository<Autor,Integer>{

		
	public Boolean existsByCedula(String cedula);
	
	public Boolean existsByCorreo(String correo);
	
	public long countByCedula(String cedula);
	
	public long countByCorreo(String correo);
	
	
	public Autor findByCedula(String cedula);
	
	public Autor findByCorreo(String correo);
	
	// find and exists by two columns
	
	public Autor findByIdAndCedula(Integer id, String cedula);
	
	public Autor findByIdAndCorreo(Integer id, String correo);
	
	public Boolean existsByIdAndCedula(Integer id,String cedula);
	
	public Boolean existsByIdAndCorreo(Integer id, String correo);
	
	// JPQL consult pagination 
	
	@Query(value = "SELECT a FROM Autor a ORDER BY id")
	Page <Autor> findAllAutorWithPagination(Pageable pageable);
	
	// native query POSTGRES sin tener en cuenta el propio correo
	
	@Query(
		value = "SELECT COUNT(*) FROM autor WHERE correo = ?2 AND NOT id = ?1 ",
		nativeQuery = true)
	public long countByCorreoYIdExceptOwn(int id,String correo);
	
	
}
