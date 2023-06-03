package pe.edu.utp;

import javax.swing.*;
import java.awt.*;

class PanelFigura extends JPanel {
    private Figura figura;
    public void setFigura(Figura figura) {
        this.figura = figura;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figura != null) {
            figura.dibujar(g);
        }
    }
}
