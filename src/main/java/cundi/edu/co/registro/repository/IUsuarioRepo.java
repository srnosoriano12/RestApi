package cundi.edu.co.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cundi.edu.co.registro.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	
	public Boolean existsByNick(String nick);
	
	public Boolean existsByDocumento(String documento);
	
	public Boolean existsByDocumentoAndNick(String documento,String nick);
	
	public Usuario findOneByNick(String nick);
	
	
	@Query(
			value = "SELECT COUNT(*) FROM usuario WHERE nick=?2 AND NOT id =?1",
			nativeQuery = true)	
	public long countByIdAndNickExceptOwn(int id,String nick);
		
	@Query(
			value = "SELECT COUNT(*) FROM usuario WHERE documento=?2 AND NOT id=?1",
			nativeQuery = true
			)
	public long countByIdAndDocumentexceptOwn(int id,String documento);
}
