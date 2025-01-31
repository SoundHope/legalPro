package com.uisrael.legalPro.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seguimientoId;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaLimite;
    private String estado;
    private String descripcion;
    private Boolean recordatorio;

    @ManyToOne
    @JoinColumn(name = "casoId")
    private Caso caso;

    public Seguimiento(int seguimientoId, Date fechaCreacion, Date fechaActualizacion, Date fechaLimite, String estado, String descripcion, Boolean recordatorio, Caso caso) {
        this.seguimientoId = seguimientoId;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
        this.descripcion = descripcion;
        this.recordatorio = recordatorio;
        this.caso = caso;
    }

    public Seguimiento() {
    }

    public int getSeguimientoId() {
        return seguimientoId;
    }

    public void setSeguimientoId(int seguimientoId) {
        this.seguimientoId = seguimientoId;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }
}
