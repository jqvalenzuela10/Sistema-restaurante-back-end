package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_ingre_x_prod database table.
 * 
 */
@Entity
@Table(name="tbl_ingre_x_prod")
@NamedQuery(name="TblIngreXProd.findAllIngreXProd", query="SELECT t FROM TblIngreXProd t")
public class TblIngreXProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INGRE_PROD")
	private int idIngreProd;

	private double cantidad;

	//bi-directional many-to-one association to TblIngrediente
	@ManyToOne
	@JoinColumn(name="ID_INGREDIENTE")
	private TblIngrediente tblIngrediente;

	//bi-directional many-to-one association to TblProducto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private TblProducto tblProducto;

	public TblIngreXProd() {
	}

	public int getIdIngreProd() {
		return this.idIngreProd;
	}

	public void setIdIngreProd(int idIngreProd) {
		this.idIngreProd = idIngreProd;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public TblIngrediente getTblIngrediente() {
		return this.tblIngrediente;
	}

	public void setTblIngrediente(TblIngrediente tblIngrediente) {
		this.tblIngrediente = tblIngrediente;
	}

	public TblProducto getTblProducto() {
		return this.tblProducto;
	}

	public void setTblProducto(TblProducto tblProducto) {
		this.tblProducto = tblProducto;
	}

}