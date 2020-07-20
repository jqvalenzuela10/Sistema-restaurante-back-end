package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_mesas database table.
 * 
 */
@Entity
@Table(name="tbl_mesas")
@NamedQuery(name="TblMesa.findAll", query="SELECT t FROM TblMesa t")
public class TblMesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MESAS")
	private int idMesas;

	private int capacidad;

	//bi-directional many-to-one association to TblSucursale
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL")
	private TblSucursale tblSucursale;

	//bi-directional many-to-many association to TblReservacione
	@ManyToMany
	@JoinTable(
		name="tbl_mesas_x_reserva"
		, joinColumns={
			@JoinColumn(name="ID_MESA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_RESERVA")
			}
		)
	private List<TblReservacione> tblReservaciones;

	//bi-directional many-to-one association to TblOrdene
	@OneToMany(mappedBy="tblMesa")
	private List<TblOrdene> tblOrdenes;

	public TblMesa() {
	}

	public int getIdMesas() {
		return this.idMesas;
	}

	public void setIdMesas(int idMesas) {
		this.idMesas = idMesas;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public TblSucursale getTblSucursale() {
		return this.tblSucursale;
	}

	public void setTblSucursale(TblSucursale tblSucursale) {
		this.tblSucursale = tblSucursale;
	}

	public List<TblReservacione> getTblReservaciones() {
		return this.tblReservaciones;
	}

	public void setTblReservaciones(List<TblReservacione> tblReservaciones) {
		this.tblReservaciones = tblReservaciones;
	}

	public List<TblOrdene> getTblOrdenes() {
		return this.tblOrdenes;
	}

	public void setTblOrdenes(List<TblOrdene> tblOrdenes) {
		this.tblOrdenes = tblOrdenes;
	}

	public TblOrdene addTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().add(tblOrdene);
		tblOrdene.setTblMesa(this);

		return tblOrdene;
	}

	public TblOrdene removeTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().remove(tblOrdene);
		tblOrdene.setTblMesa(null);

		return tblOrdene;
	}

}