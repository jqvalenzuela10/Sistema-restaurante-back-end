package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.querydsl.binding.QuerydslPredicate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_empleados database table.
 * 
 */
@Entity
@Table(name="tbl_empleados")
@NamedQuery(name="TblEmpleado.findAllUsers", query="SELECT t FROM TblEmpleado t")
public class TblEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EMPLEADO")
	private int idEmpleado;

	@Column(name="ANIOS_EXPERIENCIA")
	private int aniosExperiencia;

	private String apellidos;

	private String correo;

	private String direccion;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nombres;

	private BigDecimal salario;

	private String telefono;
	
	private String clave;



	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	//bi-directional many-to-many association to TblPlanilla
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name="tbl_acreditaciones"
		, joinColumns={
			@JoinColumn(name="ID_EMPLEADO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PLANILLA")
			}
		)
	private List<TblPlanilla> tblPlanillas;

	//bi-directional many-to-one association to TblCar
	@ManyToOne
	@JoinColumn(name="ID_CAR")
	private TblCar tblCar;

	//bi-directional many-to-one association to TblEmpleado
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO_SUPE")
	private TblEmpleado tblEmpleado;

	//bi-directional many-to-one association to TblEmpleado
	@JsonIgnore
	@OneToMany(mappedBy="tblEmpleado")
	private List<TblEmpleado> tblEmpleados;

	//bi-directional many-to-one association to TblEmpleo
	@ManyToOne
	@JoinColumn(name="ID_TIPO_EMPLEADO")
	private TblEmpleo tblEmpleo;

	//bi-directional many-to-one association to TblSucursale
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL")
	private TblSucursale tblSucursale;

	//bi-directional many-to-one association to TblRegistroJornadaTrabajo
	@JsonIgnore	
	@OneToMany(mappedBy="tblEmpleado")
	private List<TblRegistroJornadaTrabajo> tblRegistroJornadaTrabajos;

	public TblEmpleado() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getAniosExperiencia() {
		return this.aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TblPlanilla> getTblPlanillas() {
		return this.tblPlanillas;
	}

	public void setTblPlanillas(List<TblPlanilla> tblPlanillas) {
		this.tblPlanillas = tblPlanillas;
	}

	public TblCar getTblCar() {
		return this.tblCar;
	}

	public void setTblCar(TblCar tblCar) {
		this.tblCar = tblCar;
	}

	public TblEmpleado getTblEmpleado() {
		return this.tblEmpleado;
	}

	public void setTblEmpleado(TblEmpleado tblEmpleado) {
		this.tblEmpleado = tblEmpleado;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

	public TblEmpleado addTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().add(tblEmpleado);
		tblEmpleado.setTblEmpleado(this);

		return tblEmpleado;
	}

	public TblEmpleado removeTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().remove(tblEmpleado);
		tblEmpleado.setTblEmpleado(null);

		return tblEmpleado;
	}

	public TblEmpleo getTblEmpleo() {
		return this.tblEmpleo;
	}

	public void setTblEmpleo(TblEmpleo tblEmpleo) {
		this.tblEmpleo = tblEmpleo;
	}

	public TblSucursale getTblSucursale() {
		return this.tblSucursale;
	}

	public void setTblSucursale(TblSucursale tblSucursale) {
		this.tblSucursale = tblSucursale;
	}

	public List<TblRegistroJornadaTrabajo> getTblRegistroJornadaTrabajos() {
		return this.tblRegistroJornadaTrabajos;
	}

	public void setTblRegistroJornadaTrabajos(List<TblRegistroJornadaTrabajo> tblRegistroJornadaTrabajos) {
		this.tblRegistroJornadaTrabajos = tblRegistroJornadaTrabajos;
	}

	public TblRegistroJornadaTrabajo addTblRegistroJornadaTrabajo(TblRegistroJornadaTrabajo tblRegistroJornadaTrabajo) {
		getTblRegistroJornadaTrabajos().add(tblRegistroJornadaTrabajo);
		tblRegistroJornadaTrabajo.setTblEmpleado(this);

		return tblRegistroJornadaTrabajo;
	}

	public TblRegistroJornadaTrabajo removeTblRegistroJornadaTrabajo(TblRegistroJornadaTrabajo tblRegistroJornadaTrabajo) {
		getTblRegistroJornadaTrabajos().remove(tblRegistroJornadaTrabajo);
		tblRegistroJornadaTrabajo.setTblEmpleado(null);

		return tblRegistroJornadaTrabajo;
	}

}