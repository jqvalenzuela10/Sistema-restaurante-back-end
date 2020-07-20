package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tbl_empleos database table.
 * 
 */
@Entity
@Table(name="tbl_empleos")
@NamedQuery(name="TblEmpleo.findAllTipoEmpleos", query="SELECT t FROM TblEmpleo t")
public class TblEmpleo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_EMPLEO")
	private int idTipoEmpleo;

	@Column(name="TIPO_EMPLEO")
	private String tipoEmpleo;

	//bi-directional many-to-one association to TblEmpleado
	@JsonIgnore
	@OneToMany(mappedBy="tblEmpleo")
	private List<TblEmpleado> tblEmpleados;

	public TblEmpleo() {
	}

	public int getIdTipoEmpleo() {
		return this.idTipoEmpleo;
	}

	public void setIdTipoEmpleo(int idTipoEmpleo) {
		this.idTipoEmpleo = idTipoEmpleo;
	}

	public String getTipoEmpleo() {
		return this.tipoEmpleo;
	}

	public void setTipoEmpleo(String tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

	public TblEmpleado addTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().add(tblEmpleado);
		tblEmpleado.setTblEmpleo(this);

		return tblEmpleado;
	}

	public TblEmpleado removeTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().remove(tblEmpleado);
		tblEmpleado.setTblEmpleo(null);

		return tblEmpleado;
	}

}