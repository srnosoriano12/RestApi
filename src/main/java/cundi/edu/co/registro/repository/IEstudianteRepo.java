package cundi.edu.co.registro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import cundi.edu.co.registro.entity.Estudiante;

@Repository
public interface IEstudianteRepo extends JpaRepository<Estudiante,Integer>{

	public Estudiante findByCedula(String cedula);
	
	public Estudiante findByCorreo(String correo);
	
	public long countByCedula(String cedula);
	
	public Boolean existsByCedula(String cedula);
	
	public long countByCorreo(String correo);

	public Boolean existsByCorreo(String correo);
	
		 
	// findBy dos campos
	
	public Estudiante findByIdAndCedula(int id, String cedula); 
	
	public Estudiante findByIdAndCorreo(int id, String correo);
		
	public Boolean  existsByIdAndCedula(int id,String cedula);
	
	public Boolean existsByIdAndCorreo(int id, String correo);
	
	
	// correo existe sin tener en cuenta el propio sql 
	
	@Query(
		value = "SELECT COUNT(*) FROM estudiante WHERE correo = ?2 AND NOT id = ?1 ",
		nativeQuery = true)
	public long countByCorreoYIdExceptOwn(int id,String correo);
	
	// jpql	
	
	@Query(value = "SELECT e FROM Estudiante e ORDER BY id")
	Page <Estudiante> findAllEstudianteWithPagination(Pageable pageable);
	
}


