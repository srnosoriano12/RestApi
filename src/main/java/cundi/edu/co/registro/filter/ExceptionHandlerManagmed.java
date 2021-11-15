package cundi.edu.co.registro.filter;


import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cundi.edu.co.registro.exception.ExceptionWrapper;
import cundi.edu.co.registro.exception.ModelNotFoundException;
import cundi.edu.co.registro.exception.IntegridadException;


@ControllerAdvice
@RestController
public class ExceptionHandlerManagmed  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ExceptionWrapper>  managerModelNotFoundException(ModelNotFoundException e,WebRequest resquest){
		
		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(),
				e.getMessage(),resquest.getDescription(false)); 		
		return new ResponseEntity<>(ew,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionWrapper>  managerException(Exception e,WebRequest resquest){
		
		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),	
				e.getMessage(),resquest.getDescription(false));
				e.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(IntegridadException.class)
	public final ResponseEntity<ExceptionWrapper> managerIntegridadException(IntegridadException e,WebRequest resquest){
		
		ExceptionWrapper ew = new ExceptionWrapper(HttpStatus.CONFLICT.value(),HttpStatus.CONFLICT.toString(),
				e.getMessage(), resquest.getDescription(false));
		return new ResponseEntity<>(ew,HttpStatus.CONFLICT);	
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(),	
				ex.getMessage(),request.getDescription(false));
				ex.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),	
				ex.getMessage(),request.getDescription(false));
				ex.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.METHOD_NOT_ALLOWED.value(),HttpStatus.METHOD_NOT_ALLOWED.toString(),	
				ex.getMessage(),request.getDescription(false));
				ex.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.METHOD_NOT_ALLOWED);
	}

	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),	
				ex.getMessage(),request.getDescription(false));
				ex.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.BAD_REQUEST);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		String mensaje ="" ; 

			
		for (FieldError p :ex.getFieldErrors()) {
			
			mensaje =  mensaje + p.getField() + " : " + p.getDefaultMessage() + " || ";
		}
				ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),	
				mensaje,request.getDescription(false));
				ex.printStackTrace();
				
		return new ResponseEntity<>(ew,HttpStatus.BAD_REQUEST);
		
				
		
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		ExceptionWrapper ew = new  ExceptionWrapper(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(),	
				ex.getMessage(),request.getDescription(false));
				ex.printStackTrace();
		return new ResponseEntity<>(ew,HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
	/* intentar disparar
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingPathVariable(ex, headers, status, request);
	}
	*/
	
}
