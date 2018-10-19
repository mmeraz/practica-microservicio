package net.netasystems.client.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.netasystems.client.persistence.entities.Cliente;
import net.netasystems.client.persistence.entities.IdentificacionOficial;
import net.netasystems.client.persistence.entities.IdentificacionesCliente;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CatalogoDTO implements Serializable {
	
	@NonNull
	private int idCatalogo;
	private Integer idTipoCatalogo;
	private String valCatalogo;
	private String descCatalogo;
	private int idEstatus;
	private String usrCrea;
	private Date fchCrea;
	private String usrModi;
	private Date fchModi;
	

}
