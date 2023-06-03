package pe.edu.utp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame {
    private PanelFigura panelFigura;

    public Formulario() {
        super("Dibuja figuras");

        JButton botonCuadrado = new JButton("Cuadrado");
        botonCuadrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingresa el lado del cuadrado:");
                try {
                    double lado = Double.parseDouble(input);
                    Figura figura = new Cuadrado(lado);
                    panelFigura.setFigura(figura);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numérico válido.");
                }
            }
        });

        JButton botonTriangulo = new JButton("Triangulo");
        botonTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingresa el lado del triángulo:");
                try {
                    double lado = Double.parseDouble(input);
                    Figura figura = new Triangulo(lado);
                    panelFigura.setFigura(figura);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numérico válido.");
                }
            }
        });

        JButton botonCirculo = new JButton("Circulo");
        botonCirculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input = JOptionPane.showInputDialog("Ingresa el diámetro del círculo:");
                try {
                    double diametro = Double.parseDouble(input);
                    Figura figura = new Circulo(diametro);
                    panelFigura.setFigura(figura);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numérico válido.");
                }
            }
        });

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelFigura.setFigura(null);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonCuadrado);
        panelBotones.add(botonTriangulo);
        panelBotones.add(botonCirculo);
        panelBotones.add(botonBorrar);
        panelFigura = new PanelFigura();
        panelFigura.setBackground(Color.black);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelBotones, BorderLayout.NORTH);
        getContentPane().add(panelFigura, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Formulario formulario = new Formulario();
        formulario.setLocationRelativeTo(null);
    }

}