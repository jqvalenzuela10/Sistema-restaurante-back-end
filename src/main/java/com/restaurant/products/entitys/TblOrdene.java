package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ordenes database table.
 * 
 */
@Entity
@Table(name="tbl_ordenes")
@NamedQuery(name="TblOrdene.findAll", query="SELECT t FROM TblOrdene t")
public class TblOrdene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ORDEN")
	private int idOrden;

	@Column(name="ID_COMBO")
	private int idCombo;

	//bi-directional many-to-one association to TblMesa
	@ManyToOne
	@JoinColumn(name="ID_MESA")
	private TblMesa tblMesa;

	//bi-directional many-to-one association to TblProducto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private TblProducto tblProducto;

	//bi-directional many-to-one association to TblReservacione
	@ManyToOne
	@JoinColumn(name="ID_RESERVA")
	private TblReservacione tblReservacione;

	//bi-directional many-to-many association to TblFactura
	@ManyToMany
	@JoinTable(
		name="tbl_ordenes_facturadas"
		, joinColumns={
			@JoinColumn(name="ID_ORDEN")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_FACTURA")
			}
		)
	private List<TblFactura> tblFacturas;

	public TblOrdene() {
	}

	public int getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdCombo() {
		return this.idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public TblMesa getTblMesa() {
		return this.tblMesa;
	}

	public void setTblMesa(TblMesa tblMesa) {
		this.tblMesa = tblMesa;
	}

	public TblProducto getTblProducto() {
		return this.tblProducto;
	}

	public void setTblProducto(TblProducto tblProducto) {
		this.tblProducto = tblProducto;
	}

	public TblReservacione getTblReservacione() {
		return this.tblReservacione;
	}

	public void setTblReservacione(TblReservacione tblReservacione) {
		this.tblReservacione = tblReservacione;
	}

	public List<TblFactura> getTblFacturas() {
		return this.tblFacturas;
	}

	public void setTblFacturas(List<TblFactura> tblFacturas) {
		this.tblFacturas = tblFacturas;
	}

}