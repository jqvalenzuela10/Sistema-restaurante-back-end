package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_reservaciones database table.
 * 
 */
@Entity
@Table(name="tbl_reservaciones")
@NamedQuery(name="TblReservacione.findAll", query="SELECT t FROM TblReservacione t")
public class TblReservacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RESERVA")
	private int idReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//bi-directional many-to-many association to TblMesa
	@ManyToMany(mappedBy="tblReservaciones")
	private List<TblMesa> tblMesas;

	//bi-directional many-to-one association to TblOrdene
	@OneToMany(mappedBy="tblReservacione")
	private List<TblOrdene> tblOrdenes;

	//bi-directional many-to-one association to TblCliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private TblCliente tblCliente;

	public TblReservacione() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<TblMesa> getTblMesas() {
		return this.tblMesas;
	}

	public void setTblMesas(List<TblMesa> tblMesas) {
		this.tblMesas = tblMesas;
	}

	public List<TblOrdene> getTblOrdenes() {
		return this.tblOrdenes;
	}

	public void setTblOrdenes(List<TblOrdene> tblOrdenes) {
		this.tblOrdenes = tblOrdenes;
	}

	public TblOrdene addTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().add(tblOrdene);
		tblOrdene.setTblReservacione(this);

		return tblOrdene;
	}

	public TblOrdene removeTblOrdene(TblOrdene tblOrdene) {
		getTblOrdenes().remove(tblOrdene);
		tblOrdene.setTblReservacione(null);

		return tblOrdene;
	}

	public TblCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(TblCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

}