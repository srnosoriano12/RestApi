package cundi.edu.co.registro.service;



import java.util.List;

import cundi.edu.co.registro.Dto.PersonaDto;
import cundi.edu.co.registro.exception.ModelNotFoundException;

public interface IPersonaService {
	
	
	public PersonaDto obtener(int id) throws ModelNotFoundException;
	
	public void guardar(PersonaDto persona);
	
	public void editar(PersonaDto persona);
	
	public void eliminar(int id);
	
	public List<PersonaDto> listaPersonas() throws ModelNotFoundException;
	
}
