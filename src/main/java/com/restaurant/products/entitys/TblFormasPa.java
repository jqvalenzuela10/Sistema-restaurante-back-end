package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_formas_pa database table.
 * 
 */
@Entity
@Table(name="tbl_formas_pa")
@NamedQuery(name="TblFormasPa.findAll", query="SELECT t FROM TblFormasPa t")
public class TblFormasPa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FORMA_PA")
	private int idFormaPa;

	@Column(name="FORMA_PA")
	private String formaPa;

	//bi-directional many-to-one association to TblFactura
	@OneToMany(mappedBy="tblFormasPa")
	private List<TblFactura> tblFacturas;

	public TblFormasPa() {
	}

	public int getIdFormaPa() {
		return this.idFormaPa;
	}

	public void setIdFormaPa(int idFormaPa) {
		this.idFormaPa = idFormaPa;
	}

	public String getFormaPa() {
		return this.formaPa;
	}

	public void setFormaPa(String formaPa) {
		this.formaPa = formaPa;
	}

	public List<TblFactura> getTblFacturas() {
		return this.tblFacturas;
	}

	public void setTblFacturas(List<TblFactura> tblFacturas) {
		this.tblFacturas = tblFacturas;
	}

	public TblFactura addTblFactura(TblFactura tblFactura) {
		getTblFacturas().add(tblFactura);
		tblFactura.setTblFormasPa(this);

		return tblFactura;
	}

	public TblFactura removeTblFactura(TblFactura tblFactura) {
		getTblFacturas().remove(tblFactura);
		tblFactura.setTblFormasPa(null);

		return tblFactura;
	}

}