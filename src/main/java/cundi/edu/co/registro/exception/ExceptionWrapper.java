package cundi.edu.co.registro.exception;

import java.time.LocalTime;

public class ExceptionWrapper {
	
	private LocalTime timestamp;
	
	private int status;
	
	private String error;
	
	private String mensaje;
	
	private String path;
	
	
	public ExceptionWrapper( int status, String error, String mensaje, String path) {		
		this.timestamp = LocalTime.now();
		this.status = status;
		this.error = error;
		this.mensaje = mensaje;
		this.path = path;
	}


	public LocalTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	


	
	
}
