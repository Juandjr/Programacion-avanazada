package com.u3.lab1_JuanJ.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private Double total;
    private String estado; // PENDIENTE, PAGADO, ENVIADO

    // Constructores
    public Pedido() {}

    public Pedido(Long id, String cliente, Double total, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}