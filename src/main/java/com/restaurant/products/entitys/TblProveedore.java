package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import java.util.List;


/**
 * The persistent class for the tbl_proveedores database table.
 * 
 */
@Entity
@Table(name="tbl_proveedores")
@NamedQuery(name="TblProveedore.findAllProveedores", query="SELECT t FROM TblProveedore t")
public class TblProveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PROVEEDOR")
	private int idProveedor;

	@Column(name="NOMBRE_CONTACTO")
	private String nombreContacto;

	private String proveedor;

	@Column(name="SITIO_WEB")
	private String sitioWeb;

	private String telefonos;

	//bi-directional many-to-one association to TblIngrediente
	@JsonIgnore
	@OneToMany(mappedBy="tblProveedore")
	private List<TblIngrediente> tblIngredientes;

	public TblProveedore() {
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getSitioWeb() {
		return this.sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public List<TblIngrediente> getTblIngredientes() {
		return this.tblIngredientes;
	}

	public void setTblIngredientes(List<TblIngrediente> tblIngredientes) {
		this.tblIngredientes = tblIngredientes;
	}

	public TblIngrediente addTblIngrediente(TblIngrediente tblIngrediente) {
		getTblIngredientes().add(tblIngrediente);
		tblIngrediente.setTblProveedore(this);

		return tblIngrediente;
	}

	public TblIngrediente removeTblIngrediente(TblIngrediente tblIngrediente) {
		getTblIngredientes().remove(tblIngrediente);
		tblIngrediente.setTblProveedore(null);

		return tblIngrediente;
	}

}