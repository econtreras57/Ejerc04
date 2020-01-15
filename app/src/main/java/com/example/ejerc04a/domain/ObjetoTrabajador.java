package com.example.ejerc04a.domain;

public class ObjetoTrabajador extends ObjetoPersona {
    String fecha_inicio;
    String salario;

    public ObjetoTrabajador(String nombre, String dni, String direccion) {
        super(nombre, dni, direccion);
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
}
