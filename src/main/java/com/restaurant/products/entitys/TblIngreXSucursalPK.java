package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_ingre_x_sucursal database table.
 * 
 */
@Embeddable
public class TblIngreXSucursalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_SUCURSAL", insertable=false, updatable=false)
	private int idSucursal;

	@Column(name="ID_INGREDIENTE", insertable=false, updatable=false)
	private int idIngrediente;

	public TblIngreXSucursalPK() {
	}
	public int getIdSucursal() {
		return this.idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public int getIdIngrediente() {
		return this.idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblIngreXSucursalPK)) {
			return false;
		}
		TblIngreXSucursalPK castOther = (TblIngreXSucursalPK)other;
		return 
			(this.idSucursal == castOther.idSucursal)
			&& (this.idIngrediente == castOther.idIngrediente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSucursal;
		hash = hash * prime + this.idIngrediente;
		
		return hash;
	}
}