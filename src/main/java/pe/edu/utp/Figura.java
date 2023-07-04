package pe.edu.utp;

import java.awt.*;

abstract class Figura {
    protected double lado;
    protected Color colorRelleno;

    public Figura(double lado) {
        this.lado = lado;
        this.colorRelleno = Color.white;
    }

    public abstract double calcularArea();
    public abstract void dibujar(Graphics g);
    public void setColorRelleno(Color color){
        this.colorRelleno= color;
    }

    public Color getColorRelleno() {
        return colorRelleno;
    }
}
