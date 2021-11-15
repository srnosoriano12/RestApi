package cundi.edu.co.registro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ModelNotFoundException(String mensaje) {
			super(mensaje);
	}
			
}