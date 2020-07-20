package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_ingredientes database table.
 * 
 */
@Entity
@Table(name="tbl_ingredientes")
@NamedQuery(name="TblIngrediente.findAllIngredients", query="SELECT t FROM TblIngrediente t")
public class TblIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INGREDIENTE")
	private int idIngrediente;

	private String ingrediente;

	private String marca;

	private String presentacion;

	@Temporal(TemporalType.DATE)
	private Date vencimiento;

	//bi-directional many-to-one association to TblIngreXProd
	@JsonIgnore
	@OneToMany(mappedBy="tblIngrediente")
	private List<TblIngreXProd> tblIngreXProds;

	//bi-directional many-to-one association to TblIngreXSucursal
	@JsonIgnore
	@OneToMany(mappedBy="tblIngrediente")
	private List<TblIngreXSucursal> tblIngreXSucursals;

	//bi-directional many-to-one association to TblProveedore
	@ManyToOne
	@JoinColumn(name="ID_PROVEEDOR")
	private TblProveedore tblProveedore;

	public TblIngrediente() {
	}

	public int getIdIngrediente() {
		return this.idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getIngrediente() {
		return this.ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Date getVencimiento() {
		return this.vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public List<TblIngreXProd> getTblIngreXProds() {
		return this.tblIngreXProds;
	}

	public void setTblIngreXProds(List<TblIngreXProd> tblIngreXProds) {
		this.tblIngreXProds = tblIngreXProds;
	}

	public TblIngreXProd addTblIngreXProd(TblIngreXProd tblIngreXProd) {
		getTblIngreXProds().add(tblIngreXProd);
		tblIngreXProd.setTblIngrediente(this);

		return tblIngreXProd;
	}

	public TblIngreXProd removeTblIngreXProd(TblIngreXProd tblIngreXProd) {
		getTblIngreXProds().remove(tblIngreXProd);
		tblIngreXProd.setTblIngrediente(null);

		return tblIngreXProd;
	}

	public List<TblIngreXSucursal> getTblIngreXSucursals() {
		return this.tblIngreXSucursals;
	}

	public void setTblIngreXSucursals(List<TblIngreXSucursal> tblIngreXSucursals) {
		this.tblIngreXSucursals = tblIngreXSucursals;
	}

	public TblIngreXSucursal addTblIngreXSucursal(TblIngreXSucursal tblIngreXSucursal) {
		getTblIngreXSucursals().add(tblIngreXSucursal);
		tblIngreXSucursal.setTblIngrediente(this);

		return tblIngreXSucursal;
	}

	public TblIngreXSucursal removeTblIngreXSucursal(TblIngreXSucursal tblIngreXSucursal) {
		getTblIngreXSucursals().remove(tblIngreXSucursal);
		tblIngreXSucursal.setTblIngrediente(null);

		return tblIngreXSucursal;
	}

	public TblProveedore getTblProveedore() {
		return this.tblProveedore;
	}

	public void setTblProveedore(TblProveedore tblProveedore) {
		this.tblProveedore = tblProveedore;
	}

}