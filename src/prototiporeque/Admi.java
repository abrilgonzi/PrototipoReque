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




public class Admi extends JFrame {

    public Admi() {

        setTitle("Administrador - Agregar Usuario");
        setSize(400, 300);
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

     
        JTextField txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCorreo.setBounds(120, 70, 220, 30);
        txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); 
        add(txtCorreo);

   
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblStatus.setBounds(20, 120, 100, 25);
        add(lblStatus);


        String[] estados = {"Activo", "Pendiente"};
        JComboBox<String> comboStatus = new JComboBox<>(estados);
        comboStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboStatus.setBounds(120, 120, 150, 30);
        comboStatus.setBackground(Color.WHITE);
        add(comboStatus);

  
        JButton btnGuardar = new JButton("Done");
        btnGuardar.setBounds(250, 200, 100, 35);
        btnGuardar.setBackground(new Color(0, 120, 215));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder()); 
        btnGuardar.addActionListener(e -> {
            String correo = txtCorreo.getText().trim();
            String estado = (String) comboStatus.getSelectedItem();

            if (correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese el correo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Usuario agregado:\nCorreo: " + correo + "\nEstado: " + estado,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

           
            txtCorreo.setText("");
            comboStatus.setSelectedIndex(0);
        });
        add(btnGuardar);


        setUndecorated(false);
    }
}
