package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_registro_jornada_trabajo database table.
 * 
 */
@Entity
@Table(name="tbl_registro_jornada_trabajo")
@NamedQuery(name="TblRegistroJornadaTrabajo.findAll", query="SELECT t FROM TblRegistroJornadaTrabajo t")
public class TblRegistroJornadaTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_REGISTRO_JORNADA_TRABAJO")
	private int codRegistroJornadaTrabajo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HORA_ENTRADA_MARCADA")
	private Date horaEntradaMarcada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HORA_SALIDA_MARCADA")
	private Date horaSalidaMarcada;

	@Column(name="HORAS_TRABAJADAS")
	private double horasTrabajadas;

	//bi-directional many-to-one association to TblEmpleado
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO")
	private TblEmpleado tblEmpleado;

	public TblRegistroJornadaTrabajo() {
	}

	public int getCodRegistroJornadaTrabajo() {
		return this.codRegistroJornadaTrabajo;
	}

	public void setCodRegistroJornadaTrabajo(int codRegistroJornadaTrabajo) {
		this.codRegistroJornadaTrabajo = codRegistroJornadaTrabajo;
	}

	public Date getHoraEntradaMarcada() {
		return this.horaEntradaMarcada;
	}

	public void setHoraEntradaMarcada(Date horaEntradaMarcada) {
		this.horaEntradaMarcada = horaEntradaMarcada;
	}

	public Date getHoraSalidaMarcada() {
		return this.horaSalidaMarcada;
	}

	public void setHoraSalidaMarcada(Date horaSalidaMarcada) {
		this.horaSalidaMarcada = horaSalidaMarcada;
	}

	public double getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public TblEmpleado getTblEmpleado() {
		return this.tblEmpleado;
	}

	public void setTblEmpleado(TblEmpleado tblEmpleado) {
		this.tblEmpleado = tblEmpleado;
	}

}