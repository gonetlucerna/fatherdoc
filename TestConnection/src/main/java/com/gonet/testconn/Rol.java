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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "ROL")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
	@NamedQuery(name = "Rol.findById", query = "SELECT r FROM Rol r WHERE r.id = :id"),
	@NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPCION", nullable = false, length = 255)
	private String descripcion;
	@JoinTable(name = "ROL_USUARIO", joinColumns = {
    	@JoinColumn(name = "ROL_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
    	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
	private List<Usuario> usuarioList;
	@JoinTable(name = "ROL_ACCION_OPERATIVA", joinColumns = {
    	@JoinColumn(name = "ROLID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
    	@JoinColumn(name = "ACCION_OPERATIVA_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
	private List<AccionOperativa> accionOperativaList;

	public Rol() {
	}

	public Rol(Integer id) {
		this.id = id;
	}

	public Rol(Integer id, String descripcion) {
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
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	@XmlTransient
	public List<AccionOperativa> getAccionOperativaList() {
		return accionOperativaList;
	}

	public void setAccionOperativaList(List<AccionOperativa> accionOperativaList) {
		this.accionOperativaList = accionOperativaList;
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
		if (!(object instanceof Rol)) {
			return false;
		}
		Rol other = (Rol) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.Rol[ id=" + id + " ]";
	}
	
}
