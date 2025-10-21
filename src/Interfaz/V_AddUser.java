/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author abril
 */




public class V_AddUser extends JFrame {
    public JLabel lblVolver;
    public JLabel lblRol;
    public JTextField txtCorreo; 
    public JButton btnGuardar;
    public JComboBox<String> comboStatus;
    public JComboBox<String> comboStatusRol;
    

    public V_AddUser() {

        setTitle("Administrador - Agregar Usuario");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);


        JLabel lblTitulo = new JLabel("Add new user");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 120, 215)); 
        lblTitulo.setBounds(20, 20, 300, 30);
        add(lblTitulo);

        
        JLabel lblCorreo = new JLabel("Email:");
        lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblCorreo.setBounds(20, 70, 100, 25);
        add(lblCorreo);

     
        txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCorreo.setBounds(120, 70, 220, 30);
        txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); 
        add(txtCorreo);
        
        
   
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblStatus.setBounds(20, 120, 100, 25);
        add(lblStatus);
        
       

        String[] estados = {"Activo", "Pendiente"};
        comboStatus = new JComboBox<>(estados);
        comboStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboStatus.setBounds(120, 120, 150, 30);
        comboStatus.setBackground(Color.WHITE);
        add(comboStatus);
        
        lblRol = new JLabel("Rol:");
        lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblRol.setBounds(20, 135, 100, 100);
        add(lblRol);
        
        String [] roles = {"Profesor", "Usuario", "Administrativo"};
        comboStatusRol = new JComboBox<>(roles);
        comboStatusRol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboStatusRol.setBounds(120, 170, 150, 35);
        comboStatusRol.setBackground(Color.WHITE);
        add(comboStatusRol);

  
        btnGuardar = new JButton("Done");
        btnGuardar.setBounds(70, 250, 150, 45);
        btnGuardar.setBackground(new Color(0, 120, 215));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder()); 
        add(btnGuardar);
        
        lblVolver = new JLabel("Return");
        lblVolver.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblVolver.setForeground(new Color(0, 120, 215));
        lblVolver.setBounds(250, 260, 50, 30);
        lblVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lblVolver);


        setUndecorated(false);
    }
}
