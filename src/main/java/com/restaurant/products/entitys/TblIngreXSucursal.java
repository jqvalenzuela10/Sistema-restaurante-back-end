package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tbl_ingre_x_sucursal database table.
 * 
 */
@Entity
@Table(name="tbl_ingre_x_sucursal")
@NamedQuery(name="TblIngreXSucursal.findAll", query="SELECT t FROM TblIngreXSucursal t")
public class TblIngreXSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblIngreXSucursalPK id;

	private double saldo;

	//bi-directional many-to-one association to TblIngreXPedido
	@JsonIgnore
	@OneToMany(mappedBy="tblIngreXSucursal")
	private List<TblIngreXPedido> tblIngreXPedidos;

	//bi-directional many-to-one association to TblIngrediente
	@ManyToOne
	@JoinColumn(name="ID_INGREDIENTE",referencedColumnName="ID_INGREDIENTE", insertable=false, updatable=false )
	private TblIngrediente tblIngrediente;

	//bi-directional many-to-one association to TblSucursale
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL",referencedColumnName="ID_SUCURSAL", insertable=false, updatable=false)
	private TblSucursale tblSucursale;

	public TblIngreXSucursal() {
	}

	public TblIngreXSucursalPK getId() {
		return this.id;
	}

	public void setId(TblIngreXSucursalPK id) {
		this.id = id;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<TblIngreXPedido> getTblIngreXPedidos() {
		return this.tblIngreXPedidos;
	}

	public void setTblIngreXPedidos(List<TblIngreXPedido> tblIngreXPedidos) {
		this.tblIngreXPedidos = tblIngreXPedidos;
	}

	public TblIngreXPedido addTblIngreXPedido(TblIngreXPedido tblIngreXPedido) {
		getTblIngreXPedidos().add(tblIngreXPedido);
		tblIngreXPedido.setTblIngreXSucursal(this);

		return tblIngreXPedido;
	}

	public TblIngreXPedido removeTblIngreXPedido(TblIngreXPedido tblIngreXPedido) {
		getTblIngreXPedidos().remove(tblIngreXPedido);
		tblIngreXPedido.setTblIngreXSucursal(null);

		return tblIngreXPedido;
	}

	public TblIngrediente getTblIngrediente() {
		return this.tblIngrediente;
	}

	public void setTblIngrediente(TblIngrediente tblIngrediente) {
		this.tblIngrediente = tblIngrediente;
	}

	public TblSucursale getTblSucursale() {
		return this.tblSucursale;
	}

	public void setTblSucursale(TblSucursale tblSucursale) {
		this.tblSucursale = tblSucursale;
	}

}