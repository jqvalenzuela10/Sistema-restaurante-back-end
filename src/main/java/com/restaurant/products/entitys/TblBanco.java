package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_bancos database table.
 * 
 */
@Entity
@Table(name="tbl_bancos")
@NamedQuery(name="TblBanco.findAll", query="SELECT t FROM TblBanco t")
public class TblBanco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_BANCO")
	private int idBanco;

	@Column(name="NOMBRE_BANCO")
	private String nombreBanco;

	//bi-directional many-to-one association to TblPasTarjeta
	@OneToMany(mappedBy="tblBanco")
	private List<TblPasTarjeta> tblPasTarjetas;

	public TblBanco() {
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombreBanco() {
		return this.nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public List<TblPasTarjeta> getTblPasTarjetas() {
		return this.tblPasTarjetas;
	}

	public void setTblPasTarjetas(List<TblPasTarjeta> tblPasTarjetas) {
		this.tblPasTarjetas = tblPasTarjetas;
	}

	public TblPasTarjeta addTblPasTarjeta(TblPasTarjeta tblPasTarjeta) {
		getTblPasTarjetas().add(tblPasTarjeta);
		tblPasTarjeta.setTblBanco(this);

		return tblPasTarjeta;
	}

	public TblPasTarjeta removeTblPasTarjeta(TblPasTarjeta tblPasTarjeta) {
		getTblPasTarjetas().remove(tblPasTarjeta);
		tblPasTarjeta.setTblBanco(null);

		return tblPasTarjeta;
	}

}