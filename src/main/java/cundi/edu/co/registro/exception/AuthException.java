package cundi.edu.co.registro.exception;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthException implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		final Map<String, Object> mapException = new HashMap<>();

		arg2.printStackTrace();
		
		ExceptionWrapperS ex = new ExceptionWrapperS();
		

		
		ex.setError("UNAUTHORIZED");
		ex.setMensaje("No esta autorizado para acceder a este recurso");
		ex.setPath(request.getServletPath());
		ex.setStatus(401);
		ex.setTimestamp(LocalTime.now().toString());
		
	
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(response.getOutputStream(),ex);
	}

}