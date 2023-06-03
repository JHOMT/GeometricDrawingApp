package pe.edu.utp;

import java.awt.*;

public class Circulo extends Figura {
    public Circulo(double lado) {
        super(lado);
    }
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(lado , 2);
    }
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawOval(200, 100, (int) lado, (int) lado);
    }
}
