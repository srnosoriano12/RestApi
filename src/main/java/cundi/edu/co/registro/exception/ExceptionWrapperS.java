package cundi.edu.co.registro.exception;



public class ExceptionWrapperS {

	
	private String timestamp;
	
	private int status;
	
	private String error;
	
	private String mensaje;
	
	private String path;
	
	
	public ExceptionWrapperS() {
		
		
	}
	
	public ExceptionWrapperS(String timestamp, int status, String error, String mensaje, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.mensaje = mensaje;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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
