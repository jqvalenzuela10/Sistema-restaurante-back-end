 package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_ingre_x_pedido database table.
 * 
 */
@Entity
@Table(name="tbl_ingre_x_pedido")
@NamedQuery(name="TblIngreXPedido.findAll", query="SELECT t FROM TblIngreXPedido t")
public class TblIngreXPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INGRE_PEDIDO")
	private int idIngrePedido;

	private int cantidad;

	private String observaciones;

	//bi-directional many-to-one association to TblIngreXSucursal
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_INGREDIENTE", referencedColumnName="ID_INGREDIENTE"),
		@JoinColumn(name="ID_SUCURSAL", referencedColumnName="ID_SUCURSAL")
		})
	private TblIngreXSucursal tblIngreXSucursal;

	//bi-directional many-to-one association to TblPedido
	@ManyToOne
	@JoinColumn(name="ID_PEDIDO")
	private TblPedido tblPedido;

	public TblIngreXPedido() {
	}

	public int getIdIngrePedido() {
		return this.idIngrePedido;
	}

	public void setIdIngrePedido(int idIngrePedido) {
		this.idIngrePedido = idIngrePedido;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public TblIngreXSucursal getTblIngreXSucursal() {
		return this.tblIngreXSucursal;
	}

	public void setTblIngreXSucursal(TblIngreXSucursal tblIngreXSucursal) {
		this.tblIngreXSucursal = tblIngreXSucursal;
	}

	public TblPedido getTblPedido() {
		return this.tblPedido;
	}

	public void setTblPedido(TblPedido tblPedido) {
		this.tblPedido = tblPedido;
	}

}