package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_acreditaciones database table.
 * 
 */
@Entity
@Table(name="tbl_acreditaciones")
@NamedQuery(name="TblAcreditacione.findAll", query="SELECT t FROM TblAcreditacione t")
public class TblAcreditacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblAcreditacionePK id;

	//bi-directional many-to-one association to TblAlteracionesEmpleado
	@OneToMany(mappedBy="tblAcreditacione")
	private List<TblAlteracionesEmpleado> tblAlteracionesEmpleados;

	public TblAcreditacione() {
	}

	public TblAcreditacionePK getId() {
		return this.id;
	}

	public void setId(TblAcreditacionePK id) {
		this.id = id;
	}

	public List<TblAlteracionesEmpleado> getTblAlteracionesEmpleados() {
		return this.tblAlteracionesEmpleados;
	}

	public void setTblAlteracionesEmpleados(List<TblAlteracionesEmpleado> tblAlteracionesEmpleados) {
		this.tblAlteracionesEmpleados = tblAlteracionesEmpleados;
	}

	public TblAlteracionesEmpleado addTblAlteracionesEmpleado(TblAlteracionesEmpleado tblAlteracionesEmpleado) {
		getTblAlteracionesEmpleados().add(tblAlteracionesEmpleado);
		tblAlteracionesEmpleado.setTblAcreditacione(this);

		return tblAlteracionesEmpleado;
	}

	public TblAlteracionesEmpleado removeTblAlteracionesEmpleado(TblAlteracionesEmpleado tblAlteracionesEmpleado) {
		getTblAlteracionesEmpleados().remove(tblAlteracionesEmpleado);
		tblAlteracionesEmpleado.setTblAcreditacione(null);

		return tblAlteracionesEmpleado;
	}

}