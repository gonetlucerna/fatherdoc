/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alfredo
 */
@Entity
@Table(name = "ACCION_OPERATIVA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "AccionOperativa.findAll", query = "SELECT a FROM AccionOperativa a"),
	@NamedQuery(name = "AccionOperativa.findById", query = "SELECT a FROM AccionOperativa a WHERE a.id = :id"),
	@NamedQuery(name = "AccionOperativa.findByDescripcion", query = "SELECT a FROM AccionOperativa a WHERE a.descripcion = :descripcion")})
public class AccionOperativa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DESCRIPCION", nullable = false, length = 64)
	private String descripcion;
	@ManyToMany(mappedBy = "accionOperativaList")
	private List<Rol> rolList;

	public AccionOperativa() {
	}

	public AccionOperativa(Integer id) {
		this.id = id;
	}

	public AccionOperativa(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlTransient
	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AccionOperativa)) {
			return false;
		}
		AccionOperativa other = (AccionOperativa) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.AccionOperativa[ id=" + id + " ]";
	}
	
}
