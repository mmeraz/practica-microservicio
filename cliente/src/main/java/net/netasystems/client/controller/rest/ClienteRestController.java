package net.netasystems.client.controller.rest;

import net.netasystems.client.dto.ClienteDTO;
import net.netasystems.client.persistence.dao.ClienteDAO;
import net.netasystems.client.persistence.entities.CatalogoGeneral;
import net.netasystems.client.persistence.entities.Cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/cliente")
@CrossOrigin
public class ClienteRestController {

    @Autowired
    private ClienteDAO clienteDAO;
    private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
    
    @RequestMapping( value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> delete(Integer id){
    	try {
    	clienteDAO.deleteById(id);
    	return new ResponseEntity<>(id, HttpStatus.OK);
    	}catch(Exception e) {
    		log.error("Error en el delete con mensahe: {}",e.getMessage());
    		log.error("Traza {}",e);
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @RequestMapping(value = "/fetch",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> fetchAll(){
        try{
            List<Cliente> listaClientes = clienteDAO.findAll();
            if(listaClientes == null || listaClientes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<ClienteDTO> clienteDTOList = new ArrayList<>();
            for(Cliente c : listaClientes){
                ClienteDTO dto = new ClienteDTO();
                dto.setIdCliente(c.getIdCliente());
                dto.setApellidoMatCliente(c.getApellidoMatCliente());
                dto.setApellidoPatCliente(c.getApellidoPatCliente());
                dto.setCelCliente(c.getCelCliente());
                dto.setEmailCliente(c.getEmailCliente());
                dto.setNombreCliente(c.getNombreCliente());
                clienteDTOList.add(dto);
            }
            return new ResponseEntity<>(clienteDTOList, HttpStatus.OK);
        }catch (Exception e){
            log.error("Ocurrio un error con el mensaje: {}", e.getMessage());
            log.error("Trace: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT,
    		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ClienteDTO> updateCliente(ClienteDTO dto){
    	if(dto == null || dto.getIdCliente() == 0) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	Optional<Cliente> clienteOrigenBaseDatos = clienteDAO.findById(dto.getIdCliente());
    	if(clienteOrigenBaseDatos.isPresent()) {
    		Cliente clienteBD = clienteOrigenBaseDatos.get();
    		clienteBD.setNombreCliente(dto.getNombreCliente());
    		clienteBD.setFchModi(new Date());
    		clienteBD.setUsrModi("miguel");
    		try {
    		Cliente clienteModif = clienteDAO.save(clienteBD);
    		return new ResponseEntity<>(dto, HttpStatus.OK);
    		}catch(Exception e) {
    			log.error("Error en el update con mensaje {}", e.getMessage());
    			log.error("Error traza {}",e);
    		}
    			
    	}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
  @RequestMapping(value = "/add", method = RequestMethod.POST
                                , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ClienteDTO> addCliente(ClienteDTO dto){
    	if(dto == null || dto.getEmailCliente() == null|| dto.getCelCliente() == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	Cliente cliente = new Cliente();
    	cliente.setApellidoMatCliente(dto.getApellidoMatCliente());
    	cliente.setApellidoPatCliente(dto.getApellidoPatCliente());
    	cliente.setCelCliente(dto.getCelCliente());
    	cliente.setEmailCliente(dto.getEmailCliente());
    	cliente.setNombreCliente(dto.getNombreCliente());
    	CatalogoGeneral catalogoGeneral = new CatalogoGeneral();
    	catalogoGeneral.setIdCatalogo(1);
    	cliente.setFchCrea(new Date());
    	cliente.setUsrCrea("mike");
    	try {
        	Cliente saved = clienteDAO.save(cliente);
        	dto.setIdCliente(saved.getIdCliente());
        	return new ResponseEntity<>(dto, HttpStatus.CREATED);
    	}catch(Exception e) {
    		log.error("Error en addCliente con mensaje {}", e.getMessage());
    		log.error("Traza: {}", e);
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
//    	Transformar resultados

    }
    
    @RequestMapping(value="/findAllByCelCiente/{celCliente}", method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Cliente>> findAllByCelCliente(@PathVariable String cel){
    	try {
    		List<Cliente>list = clienteDAO.findAllByCelCliente(cel);
    		if(list == null || list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    		List<ClienteDTO> listDTO = new ArrayList<>();
    		for (Cliente c : list) {
    			ClienteDTO dto = new ClienteDTO();
    			dto.setApellidoMatCliente(c.getApellidoMatCliente());
    			dto.setApellidoPatCliente(c.getApellidoPatCliente());
    			dto.setCelCliente(c.getCelCliente());
    			dto.setEmailCliente(c.getEmailCliente());
    			dto.setIdCliente(c.getIdCliente());
    			dto.setNombreCliente(c.getNombreCliente());
    			listDTO.add(dto);
    		}
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en findAllByCel con mensaje: {}", e.getMessage());
            log.error("Traza: {}" , e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    	}
    

    @RequestMapping(value = "/findAllByEmail/{email}", method = RequestMethod.GET
                    , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Cliente>> findAllByEmail(@PathVariable String email){
        try{
            List<Cliente> list = clienteDAO.findAllByEmailCliente(email);
            if(list == null || list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en findAllByEmail con mensaje: {}", e.getMessage());
            log.error("Traza: {}" , e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        try{
            Optional<Cliente> found = clienteDAO.findById(id);
            if(found.isPresent()){
                return new ResponseEntity<>(found.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            log.error("Error en findById con mensaje: {}", e.getMessage());
            log.error("Traza del error: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fetchActive", method = RequestMethod.GET
                    , produces = MediaType.APPLICATION_JSON_UTF8_VALUE   )
    public ResponseEntity<List<Cliente>> findActivos(){
        //TODO mejorar el definir cuales son activos
        final int idActivo = 1;
        try{
            List<Cliente> listaActivos = clienteDAO
                    .findAllByCatalogoGeneralIdCatalogo(idActivo);
            for (Cliente c :
                    listaActivos) {
                log.info("Cliente: {}", c);
            }
            if(listaActivos == null || listaActivos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(listaActivos, HttpStatus.OK);
        }catch(Exception e){
            log.error("Error en findActivos con mensaje: {}", e.getMessage());
            log.error("Traza: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    



    
}