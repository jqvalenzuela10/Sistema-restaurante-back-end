package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_clientes database table.
 * 
 */
@Entity
@Table(name="tbl_clientes")
@NamedQuery(name="TblCliente.findAll", query="SELECT t FROM TblCliente t")
public class TblCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENTE")
	private int idCliente;

	private String apellidos;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to TblFactura
	@OneToMany(mappedBy="tblCliente")
	private List<TblFactura> tblFacturas;

	//bi-directional many-to-one association to TblReservacione
	@OneToMany(mappedBy="tblCliente")
	private List<TblReservacione> tblReservaciones;

	public TblCliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TblFactura> getTblFacturas() {
		return this.tblFacturas;
	}

	public void setTblFacturas(List<TblFactura> tblFacturas) {
		this.tblFacturas = tblFacturas;
	}

	public TblFactura addTblFactura(TblFactura tblFactura) {
		getTblFacturas().add(tblFactura);
		tblFactura.setTblCliente(this);

		return tblFactura;
	}

	public TblFactura removeTblFactura(TblFactura tblFactura) {
		getTblFacturas().remove(tblFactura);
		tblFactura.setTblCliente(null);

		return tblFactura;
	}

	public List<TblReservacione> getTblReservaciones() {
		return this.tblReservaciones;
	}

	public void setTblReservaciones(List<TblReservacione> tblReservaciones) {
		this.tblReservaciones = tblReservaciones;
	}

	public TblReservacione addTblReservacione(TblReservacione tblReservacione) {
		getTblReservaciones().add(tblReservacione);
		tblReservacione.setTblCliente(this);

		return tblReservacione;
	}

	public TblReservacione removeTblReservacione(TblReservacione tblReservacione) {
		getTblReservaciones().remove(tblReservacione);
		tblReservacione.setTblCliente(null);

		return tblReservacione;
	}

}