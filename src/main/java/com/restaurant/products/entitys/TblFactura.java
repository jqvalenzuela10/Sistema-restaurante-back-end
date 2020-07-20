package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_factura database table.
 * 
 */
@Entity
@Table(name="tbl_factura")
@NamedQuery(name="TblFactura.findAll", query="SELECT t FROM TblFactura t")
public class TblFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FACTURA")
	private int idFactura;

	private double cambio;

	private double efectivo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="I_S_V")
	private int iSV;

	@Column(name="TOTAL_PAGAR")
	private double totalPagar;

	//bi-directional many-to-one association to TblCliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private TblCliente tblCliente;

	//bi-directional many-to-one association to TblFormasPa
	@ManyToOne
	@JoinColumn(name="ID_FORMA_PA")
	private TblFormasPa tblFormasPa;

	//bi-directional many-to-many association to TblOrdene
	@ManyToMany(mappedBy="tblFacturas")
	private List<TblOrdene> tblOrdenes;

	//bi-directional many-to-one association to TblPasTarjeta
	@OneToMany(mappedBy="tblFactura")
	private List<TblPasTarjeta> tblPasTarjetas;

	public TblFactura() {
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public double getCambio() {
		return this.cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

	public double getEfectivo() {
		return this.efectivo;
	}

	public void setEfectivo(double efectivo) {
		this.efectivo = efectivo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getISV() {
		return this.iSV;
	}

	public void setISV(int iSV) {
		this.iSV = iSV;
	}

	public double getTotalPagar() {
		return this.totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public TblCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(TblCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public TblFormasPa getTblFormasPa() {
		return this.tblFormasPa;
	}

	public void setTblFormasPa(TblFormasPa tblFormasPa) {
		this.tblFormasPa = tblFormasPa;
	}

	public List<TblOrdene> getTblOrdenes() {
		return this.tblOrdenes;
	}

	public void setTblOrdenes(List<TblOrdene> tblOrdenes) {
		this.tblOrdenes = tblOrdenes;
	}

	public List<TblPasTarjeta> getTblPasTarjetas() {
		return this.tblPasTarjetas;
	}

	public void setTblPasTarjetas(List<TblPasTarjeta> tblPasTarjetas) {
		this.tblPasTarjetas = tblPasTarjetas;
	}

	public TblPasTarjeta addTblPasTarjeta(TblPasTarjeta tblPasTarjeta) {
		getTblPasTarjetas().add(tblPasTarjeta);
		tblPasTarjeta.setTblFactura(this);

		return tblPasTarjeta;
	}

	public TblPasTarjeta removeTblPasTarjeta(TblPasTarjeta tblPasTarjeta) {
		getTblPasTarjetas().remove(tblPasTarjeta);
		tblPasTarjeta.setTblFactura(null);

		return tblPasTarjeta;
	}

}