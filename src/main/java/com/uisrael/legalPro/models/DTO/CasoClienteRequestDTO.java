package com.uisrael.legalPro.models.DTO;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.Cliente;

public class CasoClienteRequestDTO {
    private Caso caso;
    private Cliente cliente;

    // Getters and Setters
    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}