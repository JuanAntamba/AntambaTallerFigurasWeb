package org.example.figuras;

public abstract class Figura {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public void mostrarInfo() {
        System.out.println("Soy una figura geométrica.");
    }
}