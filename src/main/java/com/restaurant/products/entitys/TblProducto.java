package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tbl_productos database table.
 * 
 */
@Entity
@Table(name="tbl_productos")
@NamedQuery(name="TblProducto.findAllProducts", query="SELECT t FROM TblProducto t")
public class TblProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRODUCTO")
	private int idProducto;

	private String descripcion;

	private String nombre;

	private double precio;

	//bi-directional many-to-one association to TblIngreXProd
	@JsonIgnore
	@OneToMany(mappedBy="tblProducto")
	private List<TblIngreXProd> tblIngreXProds;

	//bi-directional many-to-one association to TblOrdene
	@JsonIgnore
	@OneToMany(mappedBy="tblProducto")
	private List<TblOrdene> tblOrdenes;

	//bi-directional many-to-one association to TblCategoria
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private TblCategoria tblCategoria;

	public TblProducto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<TblIngreXProd> getTblIngreXProds() {
		return this.tblIngreXProds;
	}

	public void setTblIngreXProds(List<TblIngreXProd> tblIngreXProds) {
		this.tblIngreXProds = tblIngreXProds;
	}

	public TblIngreXProd addTblIngreXProd(TblIngreXProd tblIngreXProd) {
		getTblIngreXProds().add(tblIngreXProd);
		tblIngreXProd.setTblProducto(this);

		return tblIngreXProd;
	}

	public TblIngreXProd removeTblIngreXProd(TblIngreXProd tblIngreXProd) {
		getTblIngreXProds().remove(tblIngreXProd);
		tblIngreXProd.setTblProducto(null);

		return tblIngreXProd;
	}

	public List<TblOrdene> getTblOrdenes() {
		return this.tblOrdenes;
	}

	public void setTblOrdenes(List<TblOrdene> tblOrdenes) {
		this.tblOrdenes = tblOrdenes;
	}

	public TblOrdene addTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().add(tblOrdene);
		tblOrdene.setTblProducto(this);

		return tblOrdene;
	}

	public TblOrdene removeTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().remove(tblOrdene);
		tblOrdene.setTblProducto(null);

		return tblOrdene;
	}

	public TblCategoria getTblCategoria() {
		return this.tblCategoria;
	}

	public void setTblCategoria(TblCategoria tblCategoria) {
		this.tblCategoria = tblCategoria;
	}

}