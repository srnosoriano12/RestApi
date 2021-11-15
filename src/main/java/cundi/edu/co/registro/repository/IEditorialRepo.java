package cundi.edu.co.registro.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cundi.edu.co.registro.entity.Editorial;

@Repository
public interface IEditorialRepo extends JpaRepository<Editorial,Integer>{
	
	
	public Boolean existsByNit(String nit);
	
	public Boolean existsByCorreo(String correo);
		
	@Query(
			value = "SELECT COUNT(*) FROM editorial WHERE correo = ?2 AND NOT id = ?1 ",
			nativeQuery = true)
	public long countByCorreoYIdExceptOwn(int id,String correo);
	
	
	@Query(
			value = "SELECT COUNT(*) FROM editorial WHERE nit = ?2 AND NOT id = ?1 ",
			nativeQuery = true)
	public long countByNitYIdExceptOwn(int id,String nit);
	
	
	
	
	
	
	
}

