/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ESPECIALIDAD")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
	@NamedQuery(name = "Especialidad.findById", query = "SELECT e FROM Especialidad e WHERE e.id = :id"),
	@NamedQuery(name = "Especialidad.findByNombre", query = "SELECT e FROM Especialidad e WHERE e.nombre = :nombre")})
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE", nullable = false, length = 128)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidad")
	private List<EspecialidadMedico> especialidadMedicoList;
	@OneToMany(mappedBy = "padreEspecialidadId")
	private List<Especialidad> especialidadList;
	@JoinColumn(name = "PADRE_ESPECIALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
	private Especialidad padreEspecialidadId;

	public Especialidad() {
	}

	public Especialidad(Integer id) {
		this.id = id;
	}

	public Especialidad(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlTransient
	public List<EspecialidadMedico> getEspecialidadMedicoList() {
		return especialidadMedicoList;
	}

	public void setEspecialidadMedicoList(List<EspecialidadMedico> especialidadMedicoList) {
		this.especialidadMedicoList = especialidadMedicoList;
	}

	@XmlTransient
	public List<Especialidad> getEspecialidadList() {
		return especialidadList;
	}

	public void setEspecialidadList(List<Especialidad> especialidadList) {
		this.especialidadList = especialidadList;
	}

	public Especialidad getPadreEspecialidadId() {
		return padreEspecialidadId;
	}

	public void setPadreEspecialidadId(Especialidad padreEspecialidadId) {
		this.padreEspecialidadId = padreEspecialidadId;
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
		if (!(object instanceof Especialidad)) {
			return false;
		}
		Especialidad other = (Especialidad) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.Especialidad[ id=" + id + " ]";
	}
	
}
