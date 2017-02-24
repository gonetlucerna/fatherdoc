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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "CONSULTORIO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Consultorio.findAll", query = "SELECT c FROM Consultorio c"),
	@NamedQuery(name = "Consultorio.findById", query = "SELECT c FROM Consultorio c WHERE c.id = :id"),
	@NamedQuery(name = "Consultorio.findByEmail", query = "SELECT c FROM Consultorio c WHERE c.email = :email"),
	@NamedQuery(name = "Consultorio.findByTelefonos", query = "SELECT c FROM Consultorio c WHERE c.telefonos = :telefonos"),
	@NamedQuery(name = "Consultorio.findByDireccion", query = "SELECT c FROM Consultorio c WHERE c.direccion = :direccion"),
	@NamedQuery(name = "Consultorio.findByCodigoPostal", query = "SELECT c FROM Consultorio c WHERE c.codigoPostal = :codigoPostal"),
	@NamedQuery(name = "Consultorio.findByUrl", query = "SELECT c FROM Consultorio c WHERE c.url = :url"),
	@NamedQuery(name = "Consultorio.findByUrlGeolocalizacion", query = "SELECT c FROM Consultorio c WHERE c.urlGeolocalizacion = :urlGeolocalizacion")})
public class Consultorio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Column(name = "EMAIL", nullable = false)
	private int email;
	@Size(max = 255)
    @Column(name = "TELEFONOS", length = 255)
	private String telefonos;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCION", nullable = false, length = 255)
	private String direccion;
	@Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_POSTAL", nullable = false)
	private int codigoPostal;
	@Size(max = 255)
    @Column(name = "URL", length = 255)
	private String url;
	@Size(max = 255)
    @Column(name = "URL_GEOLOCALIZACION", length = 255)
	private String urlGeolocalizacion;
	@JoinTable(name = "CONSULTORIO_MEDICO", joinColumns = {
    	@JoinColumn(name = "CONSULTORIO_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
    	@JoinColumn(name = "MEDICO_CEDULA_PROFESIONAL", referencedColumnName = "CEDULA_PROFESIONAL", nullable = false)})
    @ManyToMany
	private List<Medico> medicoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consultorioId")
	private List<HorarioAtencion> horarioAtencionList;

	public Consultorio() {
	}

	public Consultorio(Integer id) {
		this.id = id;
	}

	public Consultorio(Integer id, int email, String direccion, int codigoPostal) {
		this.id = id;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlGeolocalizacion() {
		return urlGeolocalizacion;
	}

	public void setUrlGeolocalizacion(String urlGeolocalizacion) {
		this.urlGeolocalizacion = urlGeolocalizacion;
	}

	@XmlTransient
	public List<Medico> getMedicoList() {
		return medicoList;
	}

	public void setMedicoList(List<Medico> medicoList) {
		this.medicoList = medicoList;
	}

	@XmlTransient
	public List<HorarioAtencion> getHorarioAtencionList() {
		return horarioAtencionList;
	}

	public void setHorarioAtencionList(List<HorarioAtencion> horarioAtencionList) {
		this.horarioAtencionList = horarioAtencionList;
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
		if (!(object instanceof Consultorio)) {
			return false;
		}
		Consultorio other = (Consultorio) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.gonet.testconn.Consultorio[ id=" + id + " ]";
	}
	
}
