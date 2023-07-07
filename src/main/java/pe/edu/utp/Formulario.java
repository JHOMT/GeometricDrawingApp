package pe.edu.utp;

import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame{
    private PanelFigura panelFigura;
    private Figura figuraActual;

    public Formulario() {
        Color colorPanel= new Color(8,16,46);
        Color colorbotones= new Color(18,23,46);

        JButton botonCuadrado = new JButton("Cuadrado");
        botonCuadrado.setBackground(colorbotones);
        botonCuadrado.setForeground(Color.white);
        botonCuadrado.addActionListener(e -> crearFigura("cuadrado","lado"));

        JButton botonTriangulo = new JButton("Triangulo");
        botonTriangulo.setBackground(colorbotones);
        botonTriangulo.setForeground(Color.white);
        botonTriangulo.addActionListener(e -> crearFigura("triangulo","lado"));

        JButton botonCirculo = new JButton("Circulo");
        botonCirculo.setBackground(colorbotones);
        botonCirculo.setForeground(Color.white);
        botonCirculo.addActionListener(e -> crearFigura("circulo","diametro"));

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setBackground(colorbotones);
        botonBorrar.setForeground(Color.white);
        botonBorrar.addActionListener(e -> panelFigura.setFigura(null));

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonCuadrado);
        panelBotones.add(botonTriangulo);
        panelBotones.add(botonCirculo);
        panelBotones.add(botonBorrar);
        panelFigura = new PanelFigura();
        panelFigura.setBackground(colorPanel);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelBotones, BorderLayout.NORTH);
        getContentPane().add(panelFigura, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FormDrawingApp");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\avanceProyecto\\src\\main\\java\\pe\\edu\\utp\\Logo\\logo-utp.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
    }
    public void crearFigura(String nombre, String nombreMedida){
        String input= JOptionPane.showInputDialog(null,"Ingrese el "+nombreMedida+" de la figura "+nombre);
        try {
            Integer numero = Integer.parseInt(input);
            switch (nombre) {
                case "cuadrado":
                    figuraActual = new Cuadrado(numero);
                    break;
                case "circulo":
                    figuraActual = new Circulo(numero);
                    break;
                case "triangulo":
                    figuraActual = new Triangulo(numero);
                    break;
                default:
            }
            panelFigura.setFigura(figuraActual);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Ingrese un valor numerico valido");
        }
    }
    public static void main(String[] args) {
        Formulario formulario = new Formulario();
        formulario.setLocationRelativeTo(null);
    }

}