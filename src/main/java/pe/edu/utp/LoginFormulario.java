package pe.edu.utp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginFormulario extends JFrame {
    private static final String DB_FILE = "C:\\Users\\Jhon\\IdeaProjects\\avanceProyecto\\src\\main\\resources\\usuarios.csv";
    private static final String CSV_SEPARATOR = ",";
    private JPanel panel1;
    private JTextField txtCorreo;
    private JButton ingresarbtn;
    private JButton registrarbtn;
    private JPasswordField txtContraseña;
    private JLabel lblSalida;

    public LoginFormulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FormDrawingApp");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\avanceProyecto\\src\\main\\java\\pe\\edu\\utp\\Logo\\logo-utp.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        ingresarbtn.addActionListener(e -> {
            String correo = txtCorreo.getText();
            String contraseña = new String(txtContraseña.getPassword());
            if (checkCredentials(correo, contraseña)) {
                new Formulario();
            } else {
                lblSalida.setText("Correo o contraseña incorrectos");
            }
        });

        registrarbtn.addActionListener(e -> {
            String correo = txtCorreo.getText();
            String contraseña = new String(txtContraseña.getPassword());
            if (registerUser(correo, contraseña)) {
                lblSalida.setText("Registro exitoso");
            } else {
                lblSalida.setText("Error al registrar usuario");
            }
        });
    }

    private boolean checkCredentials(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(CSV_SEPARATOR);
                if (values.length == 2 && values[0].equals(email) && values[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerUser(String email, String password) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(DB_FILE, true))) {
            pw.println(email + CSV_SEPARATOR + password);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFormulario loginFormulario = new LoginFormulario();
            loginFormulario.setContentPane(loginFormulario.panel1);
        });
    }
}
