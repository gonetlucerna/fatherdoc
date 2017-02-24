/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alfredo
 */
@Entity
@Table(name = "ESPECIALIDAD_MEDICO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "EspecialidadMedico.findAll", query = "SELECT e FROM EspecialidadMedico e"),
	@NamedQuery(name = "EspecialidadMedico.findByEspecialidadId", query = "SELECT e FROM EspecialidadMedico e WHERE e.especialidadMedicoPK.especialidadId = :especialidadId"),
	@NamedQuery(name = "EspecialidadMedico.findByMedicoCedulaProfesional", query = "SELECT e FROM EspecialidadMedico e WHERE e.especialidadMedicoPK.medicoCedulaProfesional = :medicoCedulaProfesional"),
	@NamedQuery(name = "EspecialidadMedico.findByCedula", query = "SELECT e FROM EspecialidadMedico e WHERE e.cedula = :cedula"),
	@NamedQuery(name = "EspecialidadMedico.findByUniversidad", query = "SELECT e FROM EspecialidadMedico e WHERE e.universidad = :universidad"),
	@NamedQuery(name = "EspecialidadMedico.findByPaisCertificacion", query = "SELECT e FROM EspecialidadMedico e WHERE e.paisCertificacion = :paisCertificacion"),
	@NamedQuery(name = "EspecialidadMedico.findByAnioCertificacion", query = "SELECT e FROM EspecialidadMedico e WHERE e.anioCertificacion = :anioCertificacion")})
public class EspecialidadMedico implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected EspecialidadMedicoPK especialidadMedicoPK;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CEDULA", nullable = false, length = 16)
	private String cedula;
	@Size(max = 128)
    @Column(name = "UNIVERSIDAD", length = 128)
	private String universidad;
	@Size(max = 3)
    @Column(name = "PAIS_CERTIFICACION", length = 3)
	private String paisCertificacion;
	@Column(name = "ANIO_CERTIFICACION")
    @Temporal(TemporalType.DATE)
	private Date anioCertificacion;
	@JoinColumn(name = "ESPECIALIDAD_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Especialidad especialidad;
	@JoinColumn(name = "MEDICO_CEDULA_PROFESIONAL", referencedColumnName = "CEDULA_PROFESIONAL", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Medico medico;

	public EspecialidadMedico() {
	}

	public EspecialidadMedico(EspecialidadMedicoPK especialidadMedicoPK) {
		this.especialidadMedicoPK = especialidadMedicoPK;
	}

	public EspecialidadMedico(EspecialidadMedicoPK especialidadMedicoPK, String cedula) {
		this.especialidadMedicoPK = especialidadMedicoPK;
		this.cedula = cedula;
	}

	public EspecialidadMedico(int especialidadId, String medicoCedulaProfesional) {
		this.especialidadMedicoPK = new EspecialidadMedicoPK(especialidadId, medicoCedulaProfesional);
	}

	public EspecialidadMedicoPK getEspecialidadMedicoPK() {
		return especialidadMedicoPK;
	}

	public void setEspecialidadMedicoPK(EspecialidadMedicoPK especialidadMedicoPK) {
		this.especialidadMedicoPK = especialidadMedicoPK;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getPaisCertificacion() {
		return paisCertificacion;
	}

	public void setPaisCertificacion(String paisCertificacion) {
		this.paisCertificacion = paisCertificacion;
	}

	public Date getAnioCertificacion() {
		return anioCertificacion;
	}

	public void setAnioCertificacion(Date anioCertificacion) {
		this.anioCertificacion = anioCertificacion;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (especialidadMedicoPK != null ? especialidadMedicoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EspecialidadMedico)) {
			return false;
		}
		EspecialidadMedico other = (EspecialidadMedico) object;
		if ((this.especialidadMedicoPK == null && other.especialidadMedicoPK != null) || (this.especialidadMedicoPK != null && !this.especialidadMedicoPK.equals(other.especialidadMedicoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.EspecialidadMedico[ especialidadMedicoPK=" + especialidadMedicoPK + " ]";
	}
	
}
