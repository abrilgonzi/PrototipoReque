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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Logica.*;

/**
 *
 * @author abril
 */


public class V_AdminPanel extends JFrame {

  
    public JButton btnOpcion1;  
    public JButton btnOpcion2;  
    public JButton btnSchSystem; 
    public JButton jButton3; 
    public JButton btnCerrarSesion; 

    public V_AdminPanel() {
        setTitle("Admin Panel");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

     
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 900, 48);
        headerPanel.setBackground(new Color(0, 120, 215));
        headerPanel.setLayout(null);
        add(headerPanel);

      
        JLabel lblTitulo = new JLabel("Admin Panel");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(20, 10, 200, 30);
        headerPanel.add(lblTitulo);

        btnCerrarSesion = crearBotonMicrosoft("Sign Out", new Color(0, 120, 215));
        btnCerrarSesion.setBounds(750, 8, 120, 32);
        btnCerrarSesion.setBackground(new Color(0, 120, 215));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        headerPanel.add(btnCerrarSesion);

  
        JPanel navPanel = new JPanel();
        navPanel.setBounds(0, 48, 220, 512);
        navPanel.setBackground(new Color(250, 250, 250));
        navPanel.setLayout(null);
        navPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(225, 225, 225)));
        add(navPanel);

        // Título navegación
        JLabel lblNavTitle = new JLabel("NAVIGATION");
        lblNavTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNavTitle.setForeground(new Color(116, 116, 116));
        lblNavTitle.setBounds(20, 20, 150, 20);
        navPanel.add(lblNavTitle);

       
   
        btnOpcion1 = crearNavButton("👥 Add New User", 60);
        navPanel.add(btnOpcion1);

        
        btnOpcion2 = crearNavButton("⚙️ Manage Accounts", 110);
        btnOpcion2.addActionListener(e -> {
            V_ManageAccounts admi = new V_ManageAccounts();
            admi.setVisible(true);
            dispose();
        });

        navPanel.add(btnOpcion2);

        
        btnSchSystem = crearNavButton("📊 SCH System", 160);
        navPanel.add(btnSchSystem);

        jButton3 = crearNavButton("🔒 Change Password", 210);
        navPanel.add(jButton3);

       
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(220, 48, 680, 512);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel);

        JLabel lblDashboard = new JLabel("Dashboard");
        lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblDashboard.setForeground(new Color(32, 32, 32));
        lblDashboard.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
        contentPanel.add(lblDashboard, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel();
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setLayout(new GridLayout(2, 2, 20, 20));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        contentPanel.add(cardsPanel, BorderLayout.CENTER);

        cardsPanel.add(crearCard("Users", "Manage system users", "👥", new Color(0, 120, 215)));
        cardsPanel.add(crearCard("Settings", "System configuration", "⚙️", new Color(16, 124, 16)));
        cardsPanel.add(crearCard("Security", "Password and access", "🔒", new Color(216, 59, 1)));
        cardsPanel.add(crearCard("Reports", "View reports", "📊", new Color(107, 80, 164)));

        JPanel statusPanel = new JPanel();
        statusPanel.setBounds(0, 560, 900, 40);
        statusPanel.setBackground(new Color(250, 250, 250));
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(225, 225, 225)));
        add(statusPanel);

        JLabel lblStatus = new JLabel("Ready");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblStatus.setForeground(new Color(116, 116, 116));
        lblStatus.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        statusPanel.add(lblStatus, BorderLayout.WEST);

        JLabel lblVersion = new JLabel("Admin Panel v1.0");
        lblVersion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblVersion.setForeground(new Color(116, 116, 116));
        lblVersion.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        statusPanel.add(lblVersion, BorderLayout.EAST);
    }

    private JButton crearNavButton(String texto, int y) {
        JButton boton = new JButton(texto);
        boton.setBounds(10, y, 200, 40);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setForeground(new Color(32, 32, 32));
        boton.setBackground(new Color(250, 250, 250));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        boton.setFocusPainted(false);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(237, 235, 233));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(new Color(0, 120, 215));
                boton.setForeground(Color.WHITE);
            }
        });

        return boton;
    }

    private JButton crearBotonMicrosoft(String texto, Color colorBase) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setForeground(colorBase);
        boton.setBackground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(225, 225, 225), 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(248, 248, 248));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(new Color(240, 240, 240));
            }
        });

        return boton;
    }

    private JPanel crearCard(String titulo, String descripcion, String icono, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(225, 225, 225), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblIcono = new JLabel(icono);
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        lblIcono.setForeground(color);
        card.add(lblIcono, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(32, 32, 32));

        JLabel lblDesc = new JLabel(descripcion);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDesc.setForeground(new Color(116, 116, 116));

        contentPanel.add(lblTitulo, BorderLayout.NORTH);
        contentPanel.add(lblDesc, BorderLayout.CENTER);
        card.add(contentPanel, BorderLayout.CENTER);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(color, 2),
                    BorderFactory.createEmptyBorder(19, 19, 19, 19)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(225, 225, 225), 1),
                    BorderFactory.createEmptyBorder(20, 20, 20, 20)
                ));
            }
        });

        return card;
    }
}



    /*public V_AdminPanel() {
      
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


    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setForeground(Color.BLACK);
        boton.setBackground(color);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

       
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

}/*
