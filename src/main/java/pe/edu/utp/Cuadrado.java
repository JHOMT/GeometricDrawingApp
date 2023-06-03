package pe.edu.utp;

import java.awt.*;

class Cuadrado extends Figura {
    public Cuadrado(double lado) {
        super(lado);
    }

    public double calcularArea() {
        return lado * lado;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(100, 100, (int) lado, (int) lado);
    }
}
