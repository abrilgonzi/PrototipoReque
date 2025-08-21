/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototiporeque;

/**
 *
 * @author abril
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class V_ChangePassword extends JFrame {

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

   
        JPasswordField txtCurrentPass = new JPasswordField();
        txtCurrentPass.setBounds(20, 110, 340, 40);
        txtCurrentPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCurrentPass.setBorder(BorderFactory.createTitledBorder("Current password"));
        add(txtCurrentPass);

        
        JPasswordField txtNewPass = new JPasswordField();
        txtNewPass.setBounds(20, 160, 340, 40);
        txtNewPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNewPass.setBorder(BorderFactory.createTitledBorder("New password"));
        add(txtNewPass);


        JPasswordField txtConfirmPass = new JPasswordField();
        txtConfirmPass.setBounds(20, 210, 340, 40);
        txtConfirmPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmPass.setBorder(BorderFactory.createTitledBorder("Confirm password"));
        add(txtConfirmPass);

   
        JLabel lblBack = new JLabel("<html><font color='blue'>Return</font></html>");
        lblBack.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBack.setBounds(20, 260, 200, 20);
        lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new V_LandingPlace().setVisible(true);
                dispose();
            }
        });
        add(lblBack);

      
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(new Color(0, 120, 215));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setBounds(260, 300, 100, 35);
        btnSave.setFocusPainted(false);

        btnSave.addActionListener(e -> {
            String actual = new String(txtCurrentPass.getPassword());
            String nueva = new String(txtNewPass.getPassword());
            String confirmar = new String(txtConfirmPass.getPassword());

            
            
            
            
            if (actual.equalsIgnoreCase("ErrorBD"))
            {
                V_Error ventana = new V_Error();
                ventana.setVisible(true);
                dispose();
            }
             else 
            {
                if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "All fields are required.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!nueva.equals(confirmar)) {
                JOptionPane.showMessageDialog(this,
                        "New passwords do not match.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (nueva.equals(actual)) {
                JOptionPane.showMessageDialog(this,
                        "New password cannot be the same as current password.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
                
            else 
            {JOptionPane.showMessageDialog(this,
                        "Password updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                new V_LandingPlace().setVisible(true);
                dispose();
            }
            }
           
        
        });
       
        add(btnSave);
        }
    }
