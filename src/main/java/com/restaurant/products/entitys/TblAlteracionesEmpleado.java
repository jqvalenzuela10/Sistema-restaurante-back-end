package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_alteraciones_empleado database table.
 * 
 */
@Entity
@Table(name="tbl_alteraciones_empleado")
@NamedQuery(name="TblAlteracionesEmpleado.findAll", query="SELECT t FROM TblAlteracionesEmpleado t")
public class TblAlteracionesEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ALTERACION")
	private int idAlteracion;

	private String concepto;

	private double monto;

	//bi-directional many-to-one association to TblAcreditacione
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_EMPLEADO", referencedColumnName="ID_EMPLEADO"),
		@JoinColumn(name="ID_PLANILLA", referencedColumnName="ID_PLANILLA")
		})
	private TblAcreditacione tblAcreditacione;

	//bi-directional one-to-one association to TblAlteracionesPlanilla
	@OneToOne
	@JoinColumn(name="ID_ALTERACION")
	private TblAlteracionesPlanilla tblAlteracionesPlanilla;

	public TblAlteracionesEmpleado() {
	}

	public int getIdAlteracion() {
		return this.idAlteracion;
	}

	public void setIdAlteracion(int idAlteracion) {
		this.idAlteracion = idAlteracion;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public TblAcreditacione getTblAcreditacione() {
		return this.tblAcreditacione;
	}

	public void setTblAcreditacione(TblAcreditacione tblAcreditacione) {
		this.tblAcreditacione = tblAcreditacione;
	}

	public TblAlteracionesPlanilla getTblAlteracionesPlanilla() {
		return this.tblAlteracionesPlanilla;
	}

	public void setTblAlteracionesPlanilla(TblAlteracionesPlanilla tblAlteracionesPlanilla) {
		this.tblAlteracionesPlanilla = tblAlteracionesPlanilla;
	}

}