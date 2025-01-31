package com.uisrael.legalPro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "caso")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int casoId;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String tipo;
    private String descripcion;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "caso")
    @JsonIgnore
    private List<Seguimiento> seguimientos = new ArrayList<>();

    @OneToMany(mappedBy = "caso")
    @JsonIgnore
    private List<Tarea> tareas = new ArrayList<>();

    public Caso() {
    }

    public Caso(int casoId, Date fechaCreacion, Date fechaActualizacion, String tipo, String descripcion, String estado, Cliente cliente, List<Seguimiento> seguimientos, List<Tarea> tareas) {
        this.casoId = casoId;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cliente = cliente;
        this.seguimientos = seguimientos;
        this.tareas = tareas;
    }

    public int getCasoId() {
        return casoId;
    }

    public void setCasoId(int casoId) {
        this.casoId = casoId;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Seguimiento> getSeguimientos() {
        return seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
