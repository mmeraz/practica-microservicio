package net.netasystems.client.persistence.entities;
// Generated 27/09/2018 11:28:55 AM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IdentificacionOficial generated by hbm2java
 */
@Entity
@Table(name = "identificacion_oficial", schema = "public")
public class IdentificacionOficial implements java.io.Serializable {

	private int idIdentificacion;
	private CatalogoGeneral catalogoGeneral;
	private int idTipoIdentificacion;
	private String valIdentificacion;
	private String anversoIdentificacion;
	private String reversoIdentificacion;
	private String usrCrea;
	private Date fchCrea;
	private String usrModi;
	private Date fchModi;
	private Set<IdentificacionesCliente> identificacionesClientes = new HashSet<IdentificacionesCliente>(0);

	public IdentificacionOficial() {
	}

	public IdentificacionOficial(int idIdentificacion, int idTipoIdentificacion) {
		this.idIdentificacion = idIdentificacion;
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public IdentificacionOficial(int idIdentificacion, CatalogoGeneral catalogoGeneral, int idTipoIdentificacion,
			String valIdentificacion, String anversoIdentificacion, String reversoIdentificacion, String usrCrea,
			Date fchCrea, String usrModi, Date fchModi, Set<IdentificacionesCliente> identificacionesClientes) {
		this.idIdentificacion = idIdentificacion;
		this.catalogoGeneral = catalogoGeneral;
		this.idTipoIdentificacion = idTipoIdentificacion;
		this.valIdentificacion = valIdentificacion;
		this.anversoIdentificacion = anversoIdentificacion;
		this.reversoIdentificacion = reversoIdentificacion;
		this.usrCrea = usrCrea;
		this.fchCrea = fchCrea;
		this.usrModi = usrModi;
		this.fchModi = fchModi;
		this.identificacionesClientes = identificacionesClientes;
	}

	@Id

	@Column(name = "id_identificacion", unique = true, nullable = false)
	public int getIdIdentificacion() {
		return this.idIdentificacion;
	}

	public void setIdIdentificacion(int idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus")
	public CatalogoGeneral getCatalogoGeneral() {
		return this.catalogoGeneral;
	}

	public void setCatalogoGeneral(CatalogoGeneral catalogoGeneral) {
		this.catalogoGeneral = catalogoGeneral;
	}

	@Column(name = "id_tipo_identificacion", nullable = false)
	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	@Column(name = "val_identificacion", length = 2000)
	public String getValIdentificacion() {
		return this.valIdentificacion;
	}

	public void setValIdentificacion(String valIdentificacion) {
		this.valIdentificacion = valIdentificacion;
	}

	@Column(name = "anverso_identificacion")
	public String getAnversoIdentificacion() {
		return this.anversoIdentificacion;
	}

	public void setAnversoIdentificacion(String anversoIdentificacion) {
		this.anversoIdentificacion = anversoIdentificacion;
	}

	@Column(name = "reverso_identificacion")
	public String getReversoIdentificacion() {
		return this.reversoIdentificacion;
	}

	public void setReversoIdentificacion(String reversoIdentificacion) {
		this.reversoIdentificacion = reversoIdentificacion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "identificacionOficial")
	public Set<IdentificacionesCliente> getIdentificacionesClientes() {
		return this.identificacionesClientes;
	}

	public void setIdentificacionesClientes(Set<IdentificacionesCliente> identificacionesClientes) {
		this.identificacionesClientes = identificacionesClientes;
	}

}