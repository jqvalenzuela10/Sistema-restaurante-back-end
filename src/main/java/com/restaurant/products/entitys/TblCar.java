package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tbl_cars database table.
 * 
 */
@Entity
@Table(name="tbl_cars")
@NamedQuery(name="TblCar.findAllCargos", query="SELECT t FROM TblCar t")
public class TblCar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CAR")
	private int idCar;

	private String car;

	//bi-directional many-to-one association to TblEmpleado
	@JsonIgnore
	@OneToMany(mappedBy="tblCar")
	private List<TblEmpleado> tblEmpleados;

	public TblCar() {
	}

	public int getIdCar() {
		return this.idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getCar() {
		return this.car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

	public TblEmpleado addTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().add(tblEmpleado);
		tblEmpleado.setTblCar(this);

		return tblEmpleado;
	}

	public TblEmpleado removeTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().remove(tblEmpleado);
		tblEmpleado.setTblCar(null);

		return tblEmpleado;
	}

}