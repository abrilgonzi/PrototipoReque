/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototiporeque;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author abril
 */

public class V_AdminPanel  extends JFrame {

    public V_AdminPanel() {
        setTitle("Choose");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

     
        JLabel lblTitulo = new JLabel("Choose the option");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 120, 215));
        lblTitulo.setBounds(30, 15, 200, 30);
        add(lblTitulo);


        JButton btnOpcion1 = new JButton("Add a new user");
        btnOpcion1.setBounds(50, 70, 120, 40);
        btnOpcion1.setBackground(new Color(0, 120, 215)); 
        btnOpcion1.setForeground(Color.WHITE);
        btnOpcion1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOpcion1.setFocusPainted(false);
        btnOpcion1.setBorder(BorderFactory.createEmptyBorder());
        btnOpcion1.addActionListener(e -> {
            V_AddUser admi = new V_AddUser();
            admi.setVisible(true);
            dispose();
        });
        add(btnOpcion1);


        JButton btnOpcion2 = new JButton("Manage account");
        btnOpcion2.setBounds(220, 70, 120, 40);
        btnOpcion2.setBackground(new Color(0, 120, 215)); 
        btnOpcion2.setForeground(Color.WHITE);
        btnOpcion2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOpcion2.setFocusPainted(false);
        btnOpcion2.setBorder(BorderFactory.createEmptyBorder());
        btnOpcion2.addActionListener(e -> {
            V_ManageAccounts admi = new V_ManageAccounts();
            admi.setVisible(true);
            dispose();
        });
        add(btnOpcion2);
        
        // Botón Cerrar Sesión
        JButton btnCerrarSesion = new JButton("Sign out");
        btnCerrarSesion.setBounds(50, 160, 120, 35);
        btnCerrarSesion.setBackground(new Color(220, 53, 69));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder());
        btnCerrarSesion.addActionListener(e -> {
            new V_Login().setVisible(true);
            dispose(); 
        });
        add(btnCerrarSesion);
    }


}
