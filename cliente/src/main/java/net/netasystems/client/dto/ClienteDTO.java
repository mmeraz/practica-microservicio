package net.netasystems.client.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class ClienteDTO  implements Serializable{
	
	private int idCliente;
	private String nombreCliente;
	private String apellidoPatCliente;
	private String apellidoMatCliente;
	private String emailCliente;
	private Date fnacCliente;
	private String celCliente;

	
	
	
}
