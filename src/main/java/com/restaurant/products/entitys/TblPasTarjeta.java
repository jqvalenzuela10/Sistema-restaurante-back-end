package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_pas_tarjeta database table.
 * 
 */
@Entity
@Table(name="tbl_pas_tarjeta")
@NamedQuery(name="TblPasTarjeta.findAll", query="SELECT t FROM TblPasTarjeta t")
public class TblPasTarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PA")
	private int idPa;

	private String moneda;

	@Column(name="NUMERO_TRANSACCION")
	private int numeroTransaccion;

	//bi-directional many-to-one association to TblBanco
	@ManyToOne
	@JoinColumn(name="ID_BANCO")
	private TblBanco tblBanco;

	//bi-directional many-to-one association to TblFactura
	@ManyToOne
	@JoinColumn(name="ID_FACTURA")
	private TblFactura tblFactura;

	public TblPasTarjeta() {
	}

	public int getIdPa() {
		return this.idPa;
	}

	public void setIdPa(int idPa) {
		this.idPa = idPa;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getNumeroTransaccion() {
		return this.numeroTransaccion;
	}

	public void setNumeroTransaccion(int numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public TblBanco getTblBanco() {
		return this.tblBanco;
	}

	public void setTblBanco(TblBanco tblBanco) {
		this.tblBanco = tblBanco;
	}

	public TblFactura getTblFactura() {
		return this.tblFactura;
	}

	public void setTblFactura(TblFactura tblFactura) {
		this.tblFactura = tblFactura;
	}

}