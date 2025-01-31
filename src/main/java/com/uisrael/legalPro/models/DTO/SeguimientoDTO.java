package com.uisrael.legalPro.models.DTO;

import java.util.Date;

public class SeguimientoDTO {
    private int seguimientoId;
    private String estado;
    private String clienteNombre;
    private String clienteDni;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaLimite;
    private String descripcion;
    private Boolean recordatorio;

    public int getSeguimientoId() {
        return seguimientoId;
    }

    public void setSeguimientoId(int seguimientoId) {
        this.seguimientoId = seguimientoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(Boolean recordatorio) {
        this.recordatorio = recordatorio;
    }
}