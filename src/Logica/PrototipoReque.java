/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import Interfaz.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author abril
 */
public class PrototipoReque {

    private static V_Login loginView;
    private static V_LandingPlace landingView;
    private static V_AdminPanel adminView;
    private static V_SCHsystem marcasView;
    private static V_ErrorBD errorBDView;
    private static boolean bd = false;
    
    private static void mostrarLogin() {
        loginView = new V_Login();
        loginView.setVisible(true);
        
        loginView.btnNext.addActionListener(e -> {
            String email = loginView.txtEmail.getText();
            javax.swing.JFrame ventana;
            loginView.dispose();
            if (email.equalsIgnoreCase("admin"))
            {
             mostrarAdminPanel();
            }
            else if (email.equalsIgnoreCase(("ErrorBD")))
            {
                mostrarErrorBD();
            }
            else if (email.equalsIgnoreCase("CuentaSuspendida"))
            {
              ventana = new V_SAccount();
              ventana.setVisible(true);
            }
            else if (email.equalsIgnoreCase("Error")) {
                JOptionPane.showMessageDialog(loginView,
                        "Verify your Email and Password!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                mostrarLogin();
                
            }
            else {
                mostrarLandingPlace();
            }
            
        });
        
    }
    
    private static void mostrarLandingPlace() {
        landingView = new V_LandingPlace();
        landingView.setVisible(true);
        
        landingView.cerrarSesion.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                landingView.dispose();
                mostrarLogin();
            }
        });
    }
    
    private static void mostrarAdminPanel() {
        adminView = new V_AdminPanel();
        adminView.setVisible(true);

        adminView.btnSchSystem.addActionListener(e -> {
            adminView.dispose();
            mostrarMarcas();
        });

        adminView.btnCerrarSesion.addActionListener(e -> {
            adminView.dispose();
            mostrarLogin();
        });
    }
    
    private static void mostrarMarcas() {
        marcasView = new V_SCHsystem();
        marcasView.setVisible(true);

        marcasView.lblVolver.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                marcasView.dispose(); 
                mostrarAdminPanel();
            }
        });
        
        marcasView.SCH.addActionListener(e -> {
            if (bd) {
                marcasView.dispose();
                mostrarErrorBD();
            } else {
                if (marcasView.BDMarcas.getValueAt(0, 0)==null) {
                    Date fecha = new Date();

                    String hora, minutos, segundos;
                    hora = String.valueOf(fecha.getHours());
                    minutos = String.valueOf(fecha.getMinutes());
                    segundos = String.valueOf(fecha.getSeconds());

                    String horaCompleta = hora.concat(":");
                    horaCompleta = horaCompleta.concat(minutos);
                    horaCompleta = horaCompleta.concat(":");
                    horaCompleta = horaCompleta.concat(segundos);

                    marcasView.BDMarcas.setValueAt(horaCompleta, 0, 0);
                    marcasView.SCH.setBackground(Color.red);
                    marcasView.SCH.setText("End shift");
                }
                else {
                    if (marcasView.BDMarcas.getValueAt(0, 1)==null) {
                    Date fecha = new Date();

                    String hora, minutos, segundos;
                    hora = String.valueOf(fecha.getHours());
                    minutos = String.valueOf(fecha.getMinutes());
                    segundos = String.valueOf(fecha.getSeconds());

                    String horaCompleta = hora.concat(":");
                    horaCompleta = horaCompleta.concat(minutos);
                    horaCompleta = horaCompleta.concat(":");
                    horaCompleta = horaCompleta.concat(segundos);
                    marcasView.BDMarcas.setValueAt(horaCompleta, 0, 1);
                    marcasView.SCH.setBackground(Color.gray);
                    marcasView.SCH.setText("Shift ended");

                    }
                    else {
                        JOptionPane.showMessageDialog(marcasView,
                                "You already scheduled In and Out.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        bd = true;
                    }
                }
            }
        });
    }
    
    private static void mostrarErrorBD() {
        errorBDView = new V_ErrorBD();
        errorBDView.setVisible(true);
        
        errorBDView.btnDone.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                errorBDView.dispose(); 
                mostrarLogin();
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mostrarLogin();
    }
    
}
