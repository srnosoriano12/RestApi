package cundi.edu.co.registro.service.imp;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.entity.Usuario;
import cundi.edu.co.registro.exception.IntegridadException;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.repository.IUsuarioRepo;
import cundi.edu.co.registro.service.IUsuarioService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Service
public class IUsuarioServiceImp implements IUsuarioService,UserDetailsService{

	
	@Autowired
	private IUsuarioRepo repoUsuario;
	
	
	@Autowired
	private BCryptPasswordEncoder bcrypy;
	
	@Override
	public Page<Usuario> retornarPaginado(int page, int size) {
		return repoUsuario.findAll(PageRequest.of(page, size));
	}

	@Override
	public Usuario retornarPorId(Integer id) throws ModelNotFoundException {
		return repoUsuario.findById(id).orElseThrow(() -> new ModelNotFoundException("Usuario no encontrado"));
	}

	@Override
	public void guardar(Usuario object) throws IntegridadException {

		if(repoUsuario.existsByDocumento(object.getDocumento()) || repoUsuario.existsByNick(object.getNick())){
			if(repoUsuario.existsByDocumento(object.getDocumento())) {
				throw new IntegridadException("El Documento ya existe, por favor ingrese otro");
			}else {
				throw new IntegridadException("El Nick ya existe, por favor ingrese otro");
			}
		}else {
			
			String encodeKey =bcrypy.encode(object.getClave()); 
			object.setClave(encodeKey);
			repoUsuario.save(object);
			
		}
	}

	@Override
	public void editar(Usuario object) throws IntegridadException, ModelNotFoundException {
		
		if(!repoUsuario.existsById(object.getId())) {
			throw new ModelNotFoundException("Usuario no encontrado");
		}else {
			if(repoUsuario.countByIdAndDocumentexceptOwn(object.getId(), object.getDocumento())>0) {
				throw new IntegridadException("El Documento ya existe, por favor ingrese otro");
			}else if(repoUsuario.countByIdAndNickExceptOwn(object.getId(), object.getNick())>0) {
				throw new IntegridadException("El Nick ya existe, por favor ingrese otro");
			}
			String encodeKey =bcrypy.encode(object.getClave()); 
			object.setClave(encodeKey);
			repoUsuario.save(object);
		}
		
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		if(!repoUsuario.existsById(id)) {
			throw new ModelNotFoundException("Usuario no encontrado");
		}
		repoUsuario.delete(repoUsuario.getById(id));
	}

	//hacer login aca.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = repoUsuario.findOneByNick(username);
		
		if(usuario==null) {
			new UsernameNotFoundException("Usuario no encontrado");			
		}			
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		UserDetails ud = new User(usuario.getNick(),usuario.getClave(),roles);
		return ud;
	}

}
