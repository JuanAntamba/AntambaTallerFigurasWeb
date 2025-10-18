package org.example.figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) { this.radio = radio; }

    @Override
    public double calcularArea() { return Math.PI * radio * radio; }

    @Override
    public double calcularPerimetro() { return 2 * Math.PI * radio; }

    @Override
    public void mostrarInfo() {
        System.out.println("Círculo con radio: " + radio);
    }
}
