/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototiporeque;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author abril
 */
public class VentanaCuenta extends JFrame {
    public VentanaCuenta() {
        
        setTitle("Crear cuenta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblTitulo = new JLabel("Crear nueva cuenta");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitulo);

        JTextField txtNombre = new JTextField(20);
        txtNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
        add(txtNombre);

        JTextField txtCorreo = new JTextField(20);
        txtCorreo.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
        add(txtCorreo);

        JPasswordField txtPassword = new JPasswordField(20);
        txtPassword.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        add(txtPassword);

        JButton btnCrear = new JButton("Crear cuenta");
        btnCrear.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cuenta creada exitosamente"));
        add(btnCrear);
    }
   
}
