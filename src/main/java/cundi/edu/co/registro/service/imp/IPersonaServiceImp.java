package cundi.edu.co.registro.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cundi.edu.co.registro.Dto.PersonaDto;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.service.IPersonaService;


@Service
public class IPersonaServiceImp implements IPersonaService{

	@Override
	public PersonaDto obtener(int id) throws ModelNotFoundException {
		
		if(id>100) {
			throw new ModelNotFoundException("Objeto no encontrado");
		}
		PersonaDto personas = new PersonaDto(id,"Juan","juan@gmail.com", "calle 5 ", true, 12);
							
		return personas;
		
	}

	@Override
	public void guardar(PersonaDto persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(PersonaDto persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonaDto> listaPersonas() throws ModelNotFoundException {

		List<PersonaDto> listaPersonas  =  new ArrayList<>();
		for(int i = 0 ; i <= 4 ; i++) {
			PersonaDto personas = new PersonaDto(i+1,"Juan","juan@gmail.com", "calle 5 ", true, 12);
			
			listaPersonas.add(personas);
		}
		
		return listaPersonas;
		
	}

}
