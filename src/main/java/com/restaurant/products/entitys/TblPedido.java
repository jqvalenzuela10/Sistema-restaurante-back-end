package com.restaurant.products.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_pedidos database table.
 * 
 */
@Entity
@Table(name="tbl_pedidos")
@NamedQuery(name="TblPedido.findAll", query="SELECT t FROM TblPedido t")
public class TblPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PEDIDO")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to TblIngreXPedido
	@OneToMany(mappedBy="tblPedido")
	private List<TblIngreXPedido> tblIngreXPedidos;

	//bi-directional many-to-one association to TblSucursale
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL")
	private TblSucursale tblSucursale;

	public TblPedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<TblIngreXPedido> getTblIngreXPedidos() {
		return this.tblIngreXPedidos;
	}

	public void setTblIngreXPedidos(List<TblIngreXPedido> tblIngreXPedidos) {
		this.tblIngreXPedidos = tblIngreXPedidos;
	}

	public TblIngreXPedido addTblIngreXPedido(TblIngreXPedido tblIngreXPedido) {
		getTblIngreXPedidos().add(tblIngreXPedido);
		tblIngreXPedido.setTblPedido(this);

		return tblIngreXPedido;
	}

	public TblIngreXPedido removeTblIngreXPedido(TblIngreXPedido tblIngreXPedido) {
		getTblIngreXPedidos().remove(tblIngreXPedido);
		tblIngreXPedido.setTblPedido(null);

		return tblIngreXPedido;
	}

	public TblSucursale getTblSucursale() {
		return this.tblSucursale;
	}

	public void setTblSucursale(TblSucursale tblSucursale) {
		this.tblSucursale = tblSucursale;
	}

}