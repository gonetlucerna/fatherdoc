/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonet.testconn;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alfredo
 */
@Entity
@Table(name = "HORARIO_ATENCION")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "HorarioAtencion.findAll", query = "SELECT h FROM HorarioAtencion h"),
	@NamedQuery(name = "HorarioAtencion.findById", query = "SELECT h FROM HorarioAtencion h WHERE h.id = :id"),
	@NamedQuery(name = "HorarioAtencion.findByDia", query = "SELECT h FROM HorarioAtencion h WHERE h.dia = :dia"),
	@NamedQuery(name = "HorarioAtencion.findByHoraInicio", query = "SELECT h FROM HorarioAtencion h WHERE h.horaInicio = :horaInicio"),
	@NamedQuery(name = "HorarioAtencion.findByHoraFin", query = "SELECT h FROM HorarioAtencion h WHERE h.horaFin = :horaFin")})
public class HorarioAtencion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Column(name = "DIA", nullable = false)
	private int dia;
	@Basic(optional = false)
    @NotNull
    @Column(name = "HORA_INICIO", nullable = false)
	private int horaInicio;
	@Basic(optional = false)
    @NotNull
    @Column(name = "HORA_FIN", nullable = false)
	private int horaFin;
	@JoinColumn(name = "CONSULTORIO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
	private Consultorio consultorioId;

	public HorarioAtencion() {
	}

	public HorarioAtencion(Integer id) {
		this.id = id;
	}

	public HorarioAtencion(Integer id, int dia, int horaInicio, int horaFin) {
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}

	public Consultorio getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Consultorio consultorioId) {
		this.consultorioId = consultorioId;
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
		if (!(object instanceof HorarioAtencion)) {
			return false;
		}
		HorarioAtencion other = (HorarioAtencion) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.HorarioAtencion[ id=" + id + " ]";
	}
	
}
