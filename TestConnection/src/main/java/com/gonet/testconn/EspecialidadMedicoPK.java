/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alfredo
 */
@Embeddable
public class EspecialidadMedicoPK implements Serializable {

	@Basic(optional = false)
    @NotNull
    @Column(name = "ESPECIALIDAD_ID", nullable = false)
	private int especialidadId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "MEDICO_CEDULA_PROFESIONAL", nullable = false, length = 16)
	private String medicoCedulaProfesional;

	public EspecialidadMedicoPK() {
	}

	public EspecialidadMedicoPK(int especialidadId, String medicoCedulaProfesional) {
		this.especialidadId = especialidadId;
		this.medicoCedulaProfesional = medicoCedulaProfesional;
	}

	public int getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}

	public String getMedicoCedulaProfesional() {
		return medicoCedulaProfesional;
	}

	public void setMedicoCedulaProfesional(String medicoCedulaProfesional) {
		this.medicoCedulaProfesional = medicoCedulaProfesional;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) especialidadId;
		hash += (medicoCedulaProfesional != null ? medicoCedulaProfesional.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EspecialidadMedicoPK)) {
			return false;
		}
		EspecialidadMedicoPK other = (EspecialidadMedicoPK) object;
		if (this.especialidadId != other.especialidadId) {
			return false;
		}
		if ((this.medicoCedulaProfesional == null && other.medicoCedulaProfesional != null) || (this.medicoCedulaProfesional != null && !this.medicoCedulaProfesional.equals(other.medicoCedulaProfesional))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.EspecialidadMedicoPK[ especialidadId=" + especialidadId + ", medicoCedulaProfesional=" + medicoCedulaProfesional + " ]";
	}
	
}
