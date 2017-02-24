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
import javax.persistence.ManyToMany;
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
@Table(name = "MEDICO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
	@NamedQuery(name = "Medico.findByCedulaProfesional", query = "SELECT m FROM Medico m WHERE m.cedulaProfesional = :cedulaProfesional"),
	@NamedQuery(name = "Medico.findByIntroduccion", query = "SELECT m FROM Medico m WHERE m.introduccion = :introduccion")})
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CEDULA_PROFESIONAL", nullable = false, length = 16)
	private String cedulaProfesional;
	@Size(max = 255)
    @Column(name = "INTRODUCCION", length = 255)
	private String introduccion;
	@ManyToMany(mappedBy = "medicoList")
	private List<Consultorio> consultorioList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
	private List<EspecialidadMedico> especialidadMedicoList;
	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
	private Usuario usuarioId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoCedulaProfesional")
	private List<CitaMedica> citaMedicaList;

	public Medico() {
	}

	public Medico(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}

	public String getCedulaProfesional() {
		return cedulaProfesional;
	}

	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}

	public String getIntroduccion() {
		return introduccion;
	}

	public void setIntroduccion(String introduccion) {
		this.introduccion = introduccion;
	}

	@XmlTransient
	public List<Consultorio> getConsultorioList() {
		return consultorioList;
	}

	public void setConsultorioList(List<Consultorio> consultorioList) {
		this.consultorioList = consultorioList;
	}

	@XmlTransient
	public List<EspecialidadMedico> getEspecialidadMedicoList() {
		return especialidadMedicoList;
	}

	public void setEspecialidadMedicoList(List<EspecialidadMedico> especialidadMedicoList) {
		this.especialidadMedicoList = especialidadMedicoList;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	@XmlTransient
	public List<CitaMedica> getCitaMedicaList() {
		return citaMedicaList;
	}

	public void setCitaMedicaList(List<CitaMedica> citaMedicaList) {
		this.citaMedicaList = citaMedicaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cedulaProfesional != null ? cedulaProfesional.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Medico)) {
			return false;
		}
		Medico other = (Medico) object;
		if ((this.cedulaProfesional == null && other.cedulaProfesional != null) || (this.cedulaProfesional != null && !this.cedulaProfesional.equals(other.cedulaProfesional))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.Medico[ cedulaProfesional=" + cedulaProfesional + " ]";
	}
	
}
