/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
import Interfaz.V_AddUser;
import Interfaz.V_Login;
import Interfaz.V_SCHsystem;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author abril
 */



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class V_AdminPanel extends JFrame {

    public JButton btnSchSystem;
    public JButton btnCerrarSesion;
    public JButton btnOpcion1;
    public JButton btnOpcion2;
    public JButton jButton3;

    public V_AdminPanel() {
        // Ventana más grande
        setTitle("Admin Panel");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240)); // gris neutro
        setLayout(null);

        // ----------------- Título -----------------
        JLabel lblTitulo = new JLabel("Choose an Option");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(60, 60, 60)); // gris oscuro
        lblTitulo.setBounds(30, 20, 400, 40);
        add(lblTitulo);

        // ----------------- Botones -----------------
        btnOpcion1 = crearBoton("Add a New User", new Color(200, 200, 200));
        btnOpcion1.setBounds(100, 100, 220, 70);
        add(btnOpcion1);

        btnOpcion2 = crearBoton("Manage Account", new Color(200, 200, 200));
        btnOpcion2.setBounds(380, 100, 220, 70);
        btnOpcion2.addActionListener(e -> {
            V_ManageAccounts admi = new V_ManageAccounts();
            admi.setVisible(true);
            dispose();
        });
        add(btnOpcion2);

        btnSchSystem = crearBoton("SCH System", new Color(200, 200, 200));
        btnSchSystem.setBounds(100, 220, 220, 70);
        add(btnSchSystem);

        jButton3 = crearBoton("Change Password", new Color(200, 200, 200));
        jButton3.setBounds(380, 220, 220, 70);
        add(jButton3);

        // ----------------- Botón Cerrar Sesión -----------------
        btnCerrarSesion = crearBoton("Sign Out", new Color(220, 53, 69));
        btnCerrarSesion.setBounds(550, 20, 120, 35);
        add(btnCerrarSesion);
    }

    // ----------------- Método para crear botones estilo neutro -----------------
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setForeground(Color.BLACK);
        boton.setBackground(color);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        // Efecto hover: se oscurece un poco
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(color.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(color);
            }
        });

        return boton;
    }

}
