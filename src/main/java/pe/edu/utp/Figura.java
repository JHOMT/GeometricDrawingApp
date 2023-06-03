package pe.edu.utp;

import java.awt.*;

abstract class Figura {
    protected double lado;
    public Figura(double lado) {
        this.lado = lado;
    }
    public abstract double calcularArea();
    public abstract void dibujar(Graphics g);
}
