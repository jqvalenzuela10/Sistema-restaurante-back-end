package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import java.util.List;


/**
 * The persistent class for the tbl_categoria database table.
 * 
 */
@Entity
@Table(name="tbl_categoria")
@NamedQuery(name="TblCategoria.findAllCategories", query="SELECT t FROM TblCategoria t")
public class TblCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORIA")
	private int idCategoria;

	private String cateria;

	//bi-directional many-to-one association to TblProducto
	@JsonIgnore
	@OneToMany(mappedBy="tblCategoria")
	private List<TblProducto> tblProductos;

	public TblCategoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCateria() {
		return this.cateria;
	}

	public void setCateria(String cateria) {
		this.cateria = cateria;
	}

	public List<TblProducto> getTblProductos() {
		return this.tblProductos;
	}

	public void setTblProductos(List<TblProducto> tblProductos) {
		this.tblProductos = tblProductos;
	}

	public TblProducto addTblProducto(TblProducto tblProducto) {
		getTblProductos().add(tblProducto);
		tblProducto.setTblCategoria(this);

		return tblProducto;
	}

	public TblProducto removeTblProducto(TblProducto tblProducto) {
		getTblProductos().remove(tblProducto);
		tblProducto.setTblCategoria(null);

		return tblProducto;
	}

}