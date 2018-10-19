package net.netasystems;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import net.netasystems.client.ClienteApplication;
import net.netasystems.client.controller.rest.ClienteRestController;
import net.netasystems.client.dto.ClienteDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ClienteApplication.class)
public class ClienteApplicationTests {
	@Autowired
	private ClienteRestController controller;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testObtenerTodos() {
		ResponseEntity<List<ClienteDTO>> responseEntity = controller.fetchAll();
		int statusCode = responseEntity.getStatusCodeValue();
		assertEquals(200, statusCode);
		List<ClienteDTO> listClientes = responseEntity.getBody();
		assertNotNull(listClientes);
		int size = listClientes.size();
		assertNotEquals(0, size);	
	}
	
	@Test
	public void testAdd() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombreCliente("Spike");
		clienteDTO.setEmailCliente("spike@gmail.com");
		clienteDTO.setCelCliente("38391034");
		clienteDTO.setApellidoMatCliente("materno");
		clienteDTO.setApellidoPatCliente("paterno");
		ResponseEntity<ClienteDTO> responseEntity = controller.addCliente(clienteDTO);
		int statusCode = responseEntity.getStatusCodeValue();
		assertEquals(201, statusCode);
		assertNotNull(responseEntity.getBody());
		assertNotEquals(0, responseEntity.getBody().getIdCliente());
		
	} 
	
	

}
