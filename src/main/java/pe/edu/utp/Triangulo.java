package pe.edu.utp;

import java.awt.*;

class Triangulo extends Figura {
    public Triangulo(double lado) {
        super(lado);
    }
    @Override
    public double calcularArea() {
        return (lado * lado) / 2;
    }
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        int x[] = {50, 50 + (int) lado, 50};
        int y[] = {100, 100 + (int) lado, 100 + (int) lado};
        g.drawPolygon(x, y, 3);
    }

}
