package pe.edu.utp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame implements ActionListener {
    private static final String DB_FILE = "C:\\Users\\Jhon\\IdeaProjects\\avanceProyecto\\src\\main\\resources\\usuarios.csv";
    private static final String CSV_SEPARATOR = ",";
    private JLabel l1, l2;
    private JTextField tf1;
    private JPasswordField p1;
    private JButton btn1, btn2;
    private JPanel panel;
    private JLabel statusLabel;
    Login() {
        l1 = new JLabel("Correo:");
        l2 = new JLabel("Contraseña:");
        tf1 = new JTextField(15);
        p1 = new JPasswordField(15);
        btn1 = new JButton("Ingresar");
        btn2 = new JButton("Registrar");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(l1);
        panel.add(tf1);
        panel.add(l2);
        panel.add(p1);
        panel.add(btn1);
        panel.add(btn2);
        statusLabel = new JLabel();
        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setSize(300, 170);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String correo = tf1.getText();
        String contrasena = new String(p1.getPassword());
        if (ae.getSource() == btn1) {
            if (checkCredentials(correo, contrasena)) {
                openFormularioInterface();
            } else {
                statusLabel.setText("Correo o contraseña incorrectos");
            }
        } else {
            if (registerUser(correo, contrasena)) {
                statusLabel.setText("Registro exitoso");
            } else {
                statusLabel.setText("Error al registrar usuario");
            }
        }
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
    private void openFormularioInterface() {
        Formulario formularioFrame = new Formulario();
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
       Login login = new Login();
    }
}