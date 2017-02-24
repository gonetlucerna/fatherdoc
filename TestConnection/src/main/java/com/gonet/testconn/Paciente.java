/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alfredo
 */
@Entity
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
	@NamedQuery(name = "Paciente.findByCurp", query = "SELECT p FROM Paciente p WHERE p.curp = :curp"),
	@NamedQuery(name = "Paciente.findByTipo", query = "SELECT p FROM Paciente p WHERE p.tipo = :tipo"),
	@NamedQuery(name = "Paciente.findByClavePoliza", query = "SELECT p FROM Paciente p WHERE p.clavePoliza = :clavePoliza"),
	@NamedQuery(name = "Paciente.findByVigenciaPoliza", query = "SELECT p FROM Paciente p WHERE p.vigenciaPoliza = :vigenciaPoliza")})
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CURP", nullable = false, length = 64)
	private String curp;
	@Basic(optional = false)
    @NotNull
    @Column(name = "TIPO", nullable = false)
	private int tipo;
	@Size(max = 64)
    @Column(name = "CLAVE_POLIZA", length = 64)
	private String clavePoliza;
	@Column(name = "VIGENCIA_POLIZA")
    @Temporal(TemporalType.DATE)
	private Date vigenciaPoliza;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteCurp")
	private List<CitaMedica> citaMedicaList;
	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
	private Usuario usuarioId;

	public Paciente() {
	}

	public Paciente(String curp) {
		this.curp = curp;
	}

	public Paciente(String curp, int tipo) {
		this.curp = curp;
		this.tipo = tipo;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getClavePoliza() {
		return clavePoliza;
	}

	public void setClavePoliza(String clavePoliza) {
		this.clavePoliza = clavePoliza;
	}

	public Date getVigenciaPoliza() {
		return vigenciaPoliza;
	}

	public void setVigenciaPoliza(Date vigenciaPoliza) {
		this.vigenciaPoliza = vigenciaPoliza;
	}

	@XmlTransient
	public List<CitaMedica> getCitaMedicaList() {
		return citaMedicaList;
	}

	public void setCitaMedicaList(List<CitaMedica> citaMedicaList) {
		this.citaMedicaList = citaMedicaList;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (curp != null ? curp.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Paciente)) {
			return false;
		}
		Paciente other = (Paciente) object;
		if ((this.curp == null && other.curp != null) || (this.curp != null && !this.curp.equals(other.curp))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.Paciente[ curp=" + curp + " ]";
	}
	
}
