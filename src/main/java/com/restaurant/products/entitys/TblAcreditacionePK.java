package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_acreditaciones database table.
 * 
 */
@Embeddable
public class TblAcreditacionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_EMPLEADO", insertable=false, updatable=false)
	private int idEmpleado;

	@Column(name="ID_PLANILLA", insertable=false, updatable=false)
	private int idPlanilla;

	public TblAcreditacionePK() {
	}
	public int getIdEmpleado() {
		return this.idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdPlanilla() {
		return this.idPlanilla;
	}
	public void setIdPlanilla(int idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblAcreditacionePK)) {
			return false;
		}
		TblAcreditacionePK castOther = (TblAcreditacionePK)other;
		return 
			(this.idEmpleado == castOther.idEmpleado)
			&& (this.idPlanilla == castOther.idPlanilla);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEmpleado;
		hash = hash * prime + this.idPlanilla;
		
		return hash;
	}
}