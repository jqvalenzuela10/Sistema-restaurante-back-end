package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tbl_sucursales database table.
 * 
 */
@Entity
@Table(name="tbl_sucursales")
@NamedQuery(name="TblSucursale.findAllSucursal", query="SELECT t FROM TblSucursale t")
public class TblSucursale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SUCURSAL")
	private int idSucursal;

	private String nombre;

	private String telefono;

	private String ubicacion;

	//bi-directional many-to-one association to TblEmpleado
	@JsonIgnore
	@OneToMany(mappedBy="tblSucursale")
	private List<TblEmpleado> tblEmpleados;

	//bi-directional many-to-one association to TblIngreXSucursal
	@JsonIgnore
	@OneToMany(mappedBy="tblSucursale")
	private List<TblIngreXSucursal> tblIngreXSucursals;

	//bi-directional many-to-one association to TblMesa
	@JsonIgnore
	@OneToMany(mappedBy="tblSucursale")
	private List<TblMesa> tblMesas;

	//bi-directional many-to-one association to TblPedido
	@JsonIgnore
	@OneToMany(mappedBy="tblSucursale")
	private List<TblPedido> tblPedidos;

	public TblSucursale() {
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

	public TblEmpleado addTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().add(tblEmpleado);
		tblEmpleado.setTblSucursale(this);

		return tblEmpleado;
	}

	public TblEmpleado removeTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().remove(tblEmpleado);
		tblEmpleado.setTblSucursale(null);

		return tblEmpleado;
	}

	public List<TblIngreXSucursal> getTblIngreXSucursals() {
		return this.tblIngreXSucursals;
	}

	public void setTblIngreXSucursals(List<TblIngreXSucursal> tblIngreXSucursals) {
		this.tblIngreXSucursals = tblIngreXSucursals;
	}

	public TblIngreXSucursal addTblIngreXSucursal(TblIngreXSucursal tblIngreXSucursal) {
		getTblIngreXSucursals().add(tblIngreXSucursal);
		tblIngreXSucursal.setTblSucursale(this);

		return tblIngreXSucursal;
	}

	public TblIngreXSucursal removeTblIngreXSucursal(TblIngreXSucursal tblIngreXSucursal) {
		getTblIngreXSucursals().remove(tblIngreXSucursal);
		tblIngreXSucursal.setTblSucursale(null);

		return tblIngreXSucursal;
	}

	public List<TblMesa> getTblMesas() {
		return this.tblMesas;
	}

	public void setTblMesas(List<TblMesa> tblMesas) {
		this.tblMesas = tblMesas;
	}

	public TblMesa addTblMesa(TblMesa tblMesa) {
		getTblMesas().add(tblMesa);
		tblMesa.setTblSucursale(this);

		return tblMesa;
	}

	public TblMesa removeTblMesa(TblMesa tblMesa) {
		getTblMesas().remove(tblMesa);
		tblMesa.setTblSucursale(null);

		return tblMesa;
	}

	public List<TblPedido> getTblPedidos() {
		return this.tblPedidos;
	}

	public void setTblPedidos(List<TblPedido> tblPedidos) {
		this.tblPedidos = tblPedidos;
	}

	public TblPedido addTblPedido(TblPedido tblPedido) {
		getTblPedidos().add(tblPedido);
		tblPedido.setTblSucursale(this);

		return tblPedido;
	}

	public TblPedido removeTblPedido(TblPedido tblPedido) {
		getTblPedidos().remove(tblPedido);
		tblPedido.setTblSucursale(null);

		return tblPedido;
	}

}