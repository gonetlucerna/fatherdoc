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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CITA_MEDICA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CitaMedica.findAll", query = "SELECT c FROM CitaMedica c"),
	@NamedQuery(name = "CitaMedica.findById", query = "SELECT c FROM CitaMedica c WHERE c.id = :id"),
	@NamedQuery(name = "CitaMedica.findByFecha", query = "SELECT c FROM CitaMedica c WHERE c.fecha = :fecha"),
	@NamedQuery(name = "CitaMedica.findByTiempoEstimado", query = "SELECT c FROM CitaMedica c WHERE c.tiempoEstimado = :tiempoEstimado"),
	@NamedQuery(name = "CitaMedica.findByMotivo", query = "SELECT c FROM CitaMedica c WHERE c.motivo = :motivo"),
	@NamedQuery(name = "CitaMedica.findByFechaAtencion", query = "SELECT c FROM CitaMedica c WHERE c.fechaAtencion = :fechaAtencion"),
	@NamedQuery(name = "CitaMedica.findByTiempoAtendido", query = "SELECT c FROM CitaMedica c WHERE c.tiempoAtendido = :tiempoAtendido"),
	@NamedQuery(name = "CitaMedica.findByCalificacion", query = "SELECT c FROM CitaMedica c WHERE c.calificacion = :calificacion"),
	@NamedQuery(name = "CitaMedica.findByCriteriosSatisfactorios", query = "SELECT c FROM CitaMedica c WHERE c.criteriosSatisfactorios = :criteriosSatisfactorios"),
	@NamedQuery(name = "CitaMedica.findByComentariosMejora", query = "SELECT c FROM CitaMedica c WHERE c.comentariosMejora = :comentariosMejora")})
public class CitaMedica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO_ESTIMADO", nullable = false)
	private int tiempoEstimado;
	@Size(max = 255)
    @Column(name = "MOTIVO", length = 255)
	private String motivo;
	@Column(name = "FECHA_ATENCION")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaAtencion;
	@Column(name = "TIEMPO_ATENDIDO")
	private Integer tiempoAtendido;
	@Column(name = "CALIFICACION")
	private Integer calificacion;
	@Size(max = 255)
    @Column(name = "CRITERIOS_SATISFACTORIOS", length = 255)
	private String criteriosSatisfactorios;
	@Size(max = 255)
    @Column(name = "COMENTARIOS_MEJORA", length = 255)
	private String comentariosMejora;
	@JoinColumn(name = "MEDICO_CEDULA_PROFESIONAL", referencedColumnName = "CEDULA_PROFESIONAL", nullable = false)
    @ManyToOne(optional = false)
	private Medico medicoCedulaProfesional;
	@JoinColumn(name = "PACIENTE_CURP", referencedColumnName = "CURP", nullable = false)
    @ManyToOne(optional = false)
	private Paciente pacienteCurp;

	public CitaMedica() {
	}

	public CitaMedica(Integer id) {
		this.id = id;
	}

	public CitaMedica(Integer id, Date fecha, int tiempoEstimado) {
		this.id = id;
		this.fecha = fecha;
		this.tiempoEstimado = tiempoEstimado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Integer getTiempoAtendido() {
		return tiempoAtendido;
	}

	public void setTiempoAtendido(Integer tiempoAtendido) {
		this.tiempoAtendido = tiempoAtendido;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getCriteriosSatisfactorios() {
		return criteriosSatisfactorios;
	}

	public void setCriteriosSatisfactorios(String criteriosSatisfactorios) {
		this.criteriosSatisfactorios = criteriosSatisfactorios;
	}

	public String getComentariosMejora() {
		return comentariosMejora;
	}

	public void setComentariosMejora(String comentariosMejora) {
		this.comentariosMejora = comentariosMejora;
	}

	public Medico getMedicoCedulaProfesional() {
		return medicoCedulaProfesional;
	}

	public void setMedicoCedulaProfesional(Medico medicoCedulaProfesional) {
		this.medicoCedulaProfesional = medicoCedulaProfesional;
	}

	public Paciente getPacienteCurp() {
		return pacienteCurp;
	}

	public void setPacienteCurp(Paciente pacienteCurp) {
		this.pacienteCurp = pacienteCurp;
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
		if (!(object instanceof CitaMedica)) {
			return false;
		}
		CitaMedica other = (CitaMedica) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.CitaMedica[ id=" + id + " ]";
	}
	
}
