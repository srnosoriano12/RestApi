package cundi.edu.co.registro;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class RegistroApplicationTests {

	
	@Autowired
	private BCryptPasswordEncoder bcrypy;
	
	/**
	@Test
	void verificarClave() {
		System.out.println("resultado : -----------"+bcrypy.encode("123456"));
		assertTrue(true);
	}
	*/
	
	
}
