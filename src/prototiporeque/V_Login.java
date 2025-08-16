
package prototiporeque;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author abril
 */


public class V_Login extends JFrame {

    public V_Login() {
        
        setTitle("Sistema de autorización");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

       
        JLabel logo = new JLabel("(logo) TEC");
        logo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        logo.setBounds(20, 20, 200, 30);
        add(logo);

        
        JLabel lblSignIn = new JLabel("Sign in");
        lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblSignIn.setBounds(20, 60, 200, 30);
        add(lblSignIn);

  
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(20, 110, 340, 40);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createTitledBorder("Email"));
        add(txtEmail);
        
        JTextField txtPass = new JTextField();
        txtPass.setBounds(20, 155, 340, 40);
        txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPass.setBorder(BorderFactory.createTitledBorder("Password"));
        add(txtPass);

        
        // Enlace: No account?
        JLabel lblCreate = new JLabel("<html>No account? <font color='blue'>Create one!</font></html>");
        lblCreate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblCreate.setBounds(20, 195, 250, 20);
        lblCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblCreate.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                new V_AskEmailCreateAccount().setVisible(true); 
                dispose(); 
            }
        });
        add(lblCreate);

        // Enlace: Can't access your account?
        JLabel lblAccess = new JLabel("<html><font color='blue'>Forgot your password?</font></html>");
        lblAccess.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblAccess.setBounds(20, 215, 250, 20);
        lblAccess.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblAccess.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                new V_AskEmailResetPassword().setVisible(true); 
                dispose();
            }
        });
        add(lblAccess);

      
        JButton btnNext = new JButton("Next");
        btnNext.setBackground(new Color(0, 120, 215));
        btnNext.setForeground(Color.WHITE);
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNext.setBounds(260, 250, 100, 35);
        btnNext.setFocusPainted(false);
        btnNext.addActionListener(e -> {
            String email = txtEmail.getText();
            if (email.equalsIgnoreCase("admin@gmail.com"))
            {
             V_Admin ventana = new V_Admin();
             ventana.setVisible(true);
             //VentanaAdministrador admi = new VentanaAdministrador(); 

            }
            else {
                V_LandingPlace ventana = new V_LandingPlace();
                ventana.setVisible(true);
            }
            
            dispose();
            //JOptionPane.showMessageDialog(this, "Email ingresado: " + email);
        });
        add(btnNext);
    }

}
