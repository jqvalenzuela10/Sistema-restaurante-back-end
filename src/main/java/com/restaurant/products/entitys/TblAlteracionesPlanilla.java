package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_alteraciones_planilla database table.
 * 
 */
@Entity
@Table(name="tbl_alteraciones_planilla")
@NamedQuery(name="TblAlteracionesPlanilla.findAll", query="SELECT t FROM TblAlteracionesPlanilla t")
public class TblAlteracionesPlanilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ALTERACION")
	private int idAlteracion;

	@Column(name="TIPO_ALTERACION")
	private String tipoAlteracion;

	//bi-directional one-to-one association to TblAlteracionesEmpleado
	@OneToOne(mappedBy="tblAlteracionesPlanilla")
	private TblAlteracionesEmpleado tblAlteracionesEmpleado;

	public TblAlteracionesPlanilla() {
	}

	public int getIdAlteracion() {
		return this.idAlteracion;
	}

	public void setIdAlteracion(int idAlteracion) {
		this.idAlteracion = idAlteracion;
	}

	public String getTipoAlteracion() {
		return this.tipoAlteracion;
	}

	public void setTipoAlteracion(String tipoAlteracion) {
		this.tipoAlteracion = tipoAlteracion;
	}

	public TblAlteracionesEmpleado getTblAlteracionesEmpleado() {
		return this.tblAlteracionesEmpleado;
	}

	public void setTblAlteracionesEmpleado(TblAlteracionesEmpleado tblAlteracionesEmpleado) {
		this.tblAlteracionesEmpleado = tblAlteracionesEmpleado;
	}

}