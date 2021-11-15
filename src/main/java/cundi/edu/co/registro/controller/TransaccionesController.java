package cundi.edu.co.registro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.registro.service.ITransaccionService;

@RestController
@RequestMapping("/transacciones")


public class TransaccionesController {
	
	@Autowired
	@Qualifier("transaccionSinDescuento")
	private ITransaccionService transaccionSinDescuento; 
	
	
	@Autowired
	@Qualifier("transaccionConDescuento")
	private ITransaccionService transaccionConDescuento;
	
	
	@PutMapping(value="/comprardescuentocredito/{idProducto}",produces="apllication/json")
	
	public ResponseEntity<?> compraDescuentoCredito(@PathVariable int idProducto) {
		return new ResponseEntity<Object>(transaccionConDescuento.compraCredito(idProducto),HttpStatus.OK);
	}
	
	@PutMapping(value="/comprardescuentocontado/{idProducto}",produces="apllication/json")
	public ResponseEntity<?> compraDescuentoContado(@PathVariable int idProducto) {
		return new ResponseEntity<Object>(transaccionConDescuento.compraContado(idProducto),HttpStatus.OK);
	}
	
	@PutMapping(value="/comprarsindescuentocredito/{idProducto}",produces="apllication/json")
	public ResponseEntity<?> compraSinDescuentoCredito(@PathVariable int idProducto) {
		return new ResponseEntity<Object>(transaccionSinDescuento.compraCredito(idProducto),HttpStatus.OK);
	}
	
	@PutMapping(value="/comprarsindescuentocontado/{idProducto}",produces="apllication/json")
	public ResponseEntity<?> compraSinDescuentoContado(@PathVariable int idProducto) {
		return new ResponseEntity<Object>(transaccionSinDescuento.compraContado(idProducto),HttpStatus.OK);
	}
	

}
