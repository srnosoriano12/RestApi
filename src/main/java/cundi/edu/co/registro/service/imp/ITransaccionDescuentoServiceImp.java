package cundi.edu.co.registro.service.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cundi.edu.co.registro.service.ITransaccionService;

@Service
@Qualifier("transaccionConDescuento")
public class ITransaccionDescuentoServiceImp implements ITransaccionService{

	@Override
	public String compraContado(int idProducto) {

		return "Compra de contado con descuento "+ idProducto;
	}

	@Override
	public String compraCredito(int idProducto) {
		
		return "Compra a credito con descuento "+ idProducto;
		
	}	
	
	

}
