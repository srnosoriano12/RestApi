package cundi.edu.co.registro.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cundi.edu.co.registro.Dto.EditorialAutorDto;
import cundi.edu.co.registro.Dto.EditorialDto;
import cundi.edu.co.registro.Dto.IAutorDto;
import cundi.edu.co.registro.entity.Autor;
import cundi.edu.co.registro.entity.AutorEditorial;
import cundi.edu.co.registro.entity.Editorial;

@Repository
public interface IAutorEditorialRepo extends JpaRepository<AutorEditorial,Integer>{

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO autor_editorial(id_autor,id_editorial,fecha) values (:idAutor,:idEditorial,:fecha)",
			nativeQuery = true)	
	public void guardarAutorEditorial(@Param("idAutor") Integer idAutor,@Param("idEditorial") Integer idEditorial,@Param("fecha") Date fecha);


	@Transactional
	@Modifying
	@Query(
			value = "DELETE FROM autor_editorial WHERE id_autor = ?1 AND id_editorial =?2",
			nativeQuery =  true )
	public void eliminarAutorEditorial(int idAutor,int idEditorial);
	
	@Query(
			value = "SELECT COUNT(*) FROM autor_editorial WHERE id_autor =?1 AND id_editorial =?2",
			nativeQuery = true)
	public long countByIdAutorAndIdEditorial(int idAutor,int idEditorial);

	@Query(
			value= "select e.id, e.correo,e.nit,e.nombre  from editorial as e left  join autor_editorial on autor_editorial.id_editorial = e.id where autor_editorial.id_autor = ?1",
			nativeQuery = true			
			)	
	Page<EditorialAutorDto> findEditorialesPorAutor(Integer idAutor,Pageable pageable);
	
	@Query(
			value = "select a.id, a.apellido,a.cedula,a.correo,a.nombre from autor as a left  join autor_editorial on autor_editorial.id_autor = a.id where autor_editorial.id_editorial =?1",
			nativeQuery =  true
			)
	Page<IAutorDto> findAutoresPorEditorial(Integer idEditorial,Pageable pageable);
	
	
}
