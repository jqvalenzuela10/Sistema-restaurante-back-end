package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_planillas database table.
 * 
 */
@Entity
@Table(name="tbl_planillas")
@NamedQuery(name="TblPlanilla.findAll", query="SELECT t FROM TblPlanilla t")
public class TblPlanilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PLANILLA")
	private int idPlanilla;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_EMISION")
	private Date fechaEmision;

	@Column(name="MONTO_NOMINA")
	private double montoNomina;

	@Column(name="TOTAL_DEDUCIONES")
	private double totalDeduciones;

	@Column(name="TOTAL_EMPLEADOS")
	private int totalEmpleados;

	@Column(name="TOTAL_GRATIFICACIONES")
	private double totalGratificaciones;

	//bi-directional many-to-many association to TblEmpleado
	@ManyToMany(mappedBy="tblPlanillas")
	private List<TblEmpleado> tblEmpleados;

	public TblPlanilla() {
	}

	public int getIdPlanilla() {
		return this.idPlanilla;
	}

	public void setIdPlanilla(int idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getMontoNomina() {
		return this.montoNomina;
	}

	public void setMontoNomina(double montoNomina) {
		this.montoNomina = montoNomina;
	}

	public double getTotalDeduciones() {
		return this.totalDeduciones;
	}

	public void setTotalDeduciones(double totalDeduciones) {
		this.totalDeduciones = totalDeduciones;
	}

	public int getTotalEmpleados() {
		return this.totalEmpleados;
	}

	public void setTotalEmpleados(int totalEmpleados) {
		this.totalEmpleados = totalEmpleados;
	}

	public double getTotalGratificaciones() {
		return this.totalGratificaciones;
	}

	public void setTotalGratificaciones(double totalGratificaciones) {
		this.totalGratificaciones = totalGratificaciones;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

}