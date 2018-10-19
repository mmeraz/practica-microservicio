package net.netasystems.client.persistence.entities;
// Generated 27/09/2018 11:28:55 AM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {

	private int idCliente;
	private CatalogoGeneral catalogoGeneral;
	private String nombreCliente;
	private String apellidoPatCliente;
	private String apellidoMatCliente;
	private String emailCliente;
	private Date fnacCliente;
	private String celCliente;
	private String usrCrea;
	private Date fchCrea;
	private String usrModi;
	private Date fchModi;
	private Set<IdentificacionesCliente> identificacionesClientes = new HashSet<IdentificacionesCliente>(0);

	public Cliente() {
	}

	public Cliente(int idCliente, String nombreCliente, String apellidoPatCliente, String emailCliente,
			Date fnacCliente, String celCliente) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoPatCliente = apellidoPatCliente;
		this.emailCliente = emailCliente;
		this.fnacCliente = fnacCliente;
		this.celCliente = celCliente;
	}

	public Cliente(int idCliente, CatalogoGeneral catalogoGeneral, String nombreCliente, String apellidoPatCliente,
			String apellidoMatCliente, String emailCliente, Date fnacCliente, String celCliente, String usrCrea,
			Date fchCrea, String usrModi, Date fchModi, Set<IdentificacionesCliente> identificacionesClientes) {
		this.idCliente = idCliente;
		this.catalogoGeneral = catalogoGeneral;
		this.nombreCliente = nombreCliente;
		this.apellidoPatCliente = apellidoPatCliente;
		this.apellidoMatCliente = apellidoMatCliente;
		this.emailCliente = emailCliente;
		this.fnacCliente = fnacCliente;
		this.celCliente = celCliente;
		this.usrCrea = usrCrea;
		this.fchCrea = fchCrea;
		this.usrModi = usrModi;
		this.fchModi = fchModi;
		this.identificacionesClientes = identificacionesClientes;
	}

	@Id
	@SequenceGenerator(name= "idClienteSeqGen", sequenceName = "cliente_id_cliente_seq", allocationSize = 1)
	@GeneratedValue(generator = "idClienteSeqGen", strategy= GenerationType.SEQUENCE)
	@Column(name = "id_cliente", unique = true, nullable = false)
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus")
	public CatalogoGeneral getCatalogoGeneral() {
		return this.catalogoGeneral;
	}

	public void setCatalogoGeneral(CatalogoGeneral catalogoGeneral) {
		this.catalogoGeneral = catalogoGeneral;
	}

	@Column(name = "nombre_cliente", nullable = false, length = 30)
	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Column(name = "apellido_pat_cliente", nullable = false, length = 30)
	public String getApellidoPatCliente() {
		return this.apellidoPatCliente;
	}

	public void setApellidoPatCliente(String apellidoPatCliente) {
		this.apellidoPatCliente = apellidoPatCliente;
	}

	@Column(name = "apellido_mat_cliente", length = 30)
	public String getApellidoMatCliente() {
		return this.apellidoMatCliente;
	}

	public void setApellidoMatCliente(String apellidoMatCliente) {
		this.apellidoMatCliente = apellidoMatCliente;
	}

	@Column(name = "email_cliente", nullable = false, length = 50)
	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fnac_cliente", nullable = false, length = 13)
	public Date getFnacCliente() {
		return this.fnacCliente;
	}

	public void setFnacCliente(Date fnacCliente) {
		this.fnacCliente = fnacCliente;
	}

	@Column(name = "cel_cliente", nullable = false, length = 20)
	public String getCelCliente() {
		return this.celCliente;
	}

	public void setCelCliente(String celCliente) {
		this.celCliente = celCliente;
	}

	@Column(name = "usr_crea", length = 20)
	public String getUsrCrea() {
		return this.usrCrea;
	}

	public void setUsrCrea(String usrCrea) {
		this.usrCrea = usrCrea;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fch_crea", length = 35)
	public Date getFchCrea() {
		return this.fchCrea;
	}

	public void setFchCrea(Date fchCrea) {
		this.fchCrea = fchCrea;
	}

	@Column(name = "usr_modi", length = 20)
	public String getUsrModi() {
		return this.usrModi;
	}

	public void setUsrModi(String usrModi) {
		this.usrModi = usrModi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fch_modi", length = 35)
	public Date getFchModi() {
		return this.fchModi;
	}

	public void setFchModi(Date fchModi) {
		this.fchModi = fchModi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<IdentificacionesCliente> getIdentificacionesClientes() {
		return this.identificacionesClientes;
	}

	public void setIdentificacionesClientes(Set<IdentificacionesCliente> identificacionesClientes) {
		this.identificacionesClientes = identificacionesClientes;
	}

}
