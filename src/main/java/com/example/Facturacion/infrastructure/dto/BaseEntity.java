package com.example.Facturacion.infrastructure.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCreacion", nullable = false, updatable = false )
	@CreatedDate
	@CreationTimestamp
	private Calendar fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaModificacion", nullable = false, updatable = true )
	@LastModifiedDate
	@UpdateTimestamp
	private Calendar  fechaModificacion;

	public String getCodigo() {
		return codigo; 
	}
	public void setCodigo(String codigo) { 
		this.codigo = codigo;
	}
	
	public Calendar  getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Calendar  fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Calendar  getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
