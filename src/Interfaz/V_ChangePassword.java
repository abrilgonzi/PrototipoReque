/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author abril
 */

import Interfaz.V_Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class V_ChangePassword extends JFrame {
    
    public JLabel lblBack;
    public JButton btnSave;
    public JPasswordField txtConfirmPass;
    public JPasswordField txtCurrentPass;
    public JPasswordField txtNewPass;
     
    public V_ChangePassword() {
        setTitle("Change your password");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

   
        JLabel logo = new JLabel("(logo) TEC");
        logo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        logo.setBounds(20, 20, 200, 30);
        add(logo);

  
        JLabel lblTitle = new JLabel("Change your password");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setBounds(20, 60, 300, 30);
        add(lblTitle);

   
        txtCurrentPass = new JPasswordField();
        txtCurrentPass.setBounds(20, 110, 340, 40);
        txtCurrentPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCurrentPass.setBorder(BorderFactory.createTitledBorder("Current password"));
        add(txtCurrentPass);

        
        txtNewPass = new JPasswordField();
        txtNewPass.setBounds(20, 160, 340, 40);
        txtNewPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNewPass.setBorder(BorderFactory.createTitledBorder("New password"));
        add(txtNewPass);


        txtConfirmPass = new JPasswordField();
        txtConfirmPass.setBounds(20, 210, 340, 40);
        txtConfirmPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmPass.setBorder(BorderFactory.createTitledBorder("Confirm password"));
        add(txtConfirmPass);

   
        lblBack = new JLabel("<html><font color='blue'>Return</font></html>");
        lblBack.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBack.setBounds(20, 260, 200, 20);
        lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lblBack);

      
        btnSave = new JButton("Save");
        btnSave.setBackground(new Color(0, 120, 215));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setBounds(260, 300, 100, 35);
        btnSave.setFocusPainted(false);
        add(btnSave);
        }
    }
