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
    private static V_AskEmailCreateAccount crearCuenta;
    private static V_CheckEmailCreateAccount checkCuenta;
    private static V_ChangePassword cambiarContraAdmi;
    private static V_CheckEmailStepsResetPassw cambiarContra;
    private static V_AddUser anadirUsuarioV;
    private static V_ManageAccounts manager;
    
    private static boolean bd = false;
    
    //login credenciales incorrectas 
    //cambiar contraseña usuario normal
    //agregar administrator 
    
    private static void mostrarLogin() {
        loginView = new V_Login();
        loginView.setVisible(true);
        
        loginView.lblAccess.addMouseListener(new MouseAdapter() { 
        public void mouseClicked(MouseEvent e) {
            loginView.dispose();
            mostrarForgotPassword();
        }
        }); 
        loginView.lblCreate.addMouseListener(new MouseAdapter() { 
        public void mouseClicked(MouseEvent e) { 
            loginView.dispose(); 
            mostrarCrearCuenta();
        }
        });

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
        landingView.jButton2.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                landingView.dispose();
                cambiarContrasenaUsuarioNormal();
            }
        });
        
    }
    
    
    
    public static void mostrarAdminPanel() {
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
        
        adminView.jButton3.addActionListener(e -> {
            adminView.dispose(); 
            mostrarContrasena();
        });
        
        adminView.btnOpcion1.addActionListener(e -> {
            adminView.dispose(); 
            anadirUsuario();
        });

        adminView.btnOpcion2.addActionListener(e -> {
        adminView.dispose();
        mostrarManageAccounts();
    });
        
      
    }
    
    private static void mostrarManageAccounts(){
        manager = new V_ManageAccounts();
        manager.setVisible(true);
};

    
    private static void mostrarMarcas() {
        marcasView = new V_SCHsystem();
        marcasView.setVisible(true);

        marcasView.lblVolver.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                bd=false;
                marcasView.dispose(); 
                mostrarAdminPanel();
            }
        });
        
        marcasView.SCH.addActionListener(e -> {
            if (bd) {
                bd=false;
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
                    JOptionPane.showMessageDialog(marcasView,
                                "Check-in time successfully saved.",
                                "Confirmation",
                                JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(marcasView,
                                "Check-out time successfully saved.",
                                "Confirmation",
                                JOptionPane.INFORMATION_MESSAGE);

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
    
    private static void anadirUsuario()
    {
        anadirUsuarioV = new V_AddUser();
        anadirUsuarioV.setVisible(true);
        
        anadirUsuarioV.lblVolver.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                anadirUsuarioV.dispose();
                mostrarAdminPanel();
            }
        });
        
        anadirUsuarioV.btnGuardar.addActionListener(e -> {
        String correo = anadirUsuarioV.txtCorreo.getText().trim();
        String estado = (String) anadirUsuarioV.comboStatus.getSelectedItem();
        String rol = (String) anadirUsuarioV.comboStatusRol.getSelectedItem();

        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(anadirUsuarioV,
                    "Por favor ingrese el correo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } 
        else if (correo.equalsIgnoreCase("Error")) {
            JOptionPane.showMessageDialog(anadirUsuarioV,
                    "Verify the Email! It is not an institutional email.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } 
        else if (correo.equalsIgnoreCase("Existe")) {
            JOptionPane.showMessageDialog(anadirUsuarioV,
                    "This Email is already registered.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            anadirUsuarioV.txtCorreo.setText("");
            anadirUsuarioV.comboStatus.setSelectedIndex(0);
        } 
        else if (correo.equalsIgnoreCase("ErrorBD")) {
            anadirUsuarioV.dispose();
            mostrarErrorBD();
        } 
        else {
            JOptionPane.showMessageDialog(anadirUsuarioV,
                    "Usuario agregado:\nCorreo: " + correo +
                    "\nEstado: " + estado +
                    "\nRol: " + rol,
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            anadirUsuarioV.txtCorreo.setText("");
            anadirUsuarioV.comboStatus.setSelectedIndex(0);
            anadirUsuarioV.comboStatusRol.setSelectedIndex(0);
        }
    });

        
    
    }
    
    private static void mostrarForgotPassword()
    {
        cambiarContra = new V_CheckEmailStepsResetPassw();
        cambiarContra.setVisible(true);
        
        cambiarContra.jButton1.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                cambiarContra.dispose(); 
                mostrarLogin();
            }
        });
        
       
        
    }
    
    private static void cambiarContrasenaUsuarioNormal()
    {
        cambiarContraAdmi = new V_ChangePassword();
        cambiarContraAdmi.setVisible(true);
        cambiarContraAdmi.lblBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cambiarContraAdmi.dispose();
                mostrarLogin();
            }
        });
        cambiarContraAdmi.btnSave.addActionListener(e -> {
        String actual = new String(cambiarContraAdmi.txtCurrentPass.getPassword());
        String nueva = new String(cambiarContraAdmi.txtNewPass.getPassword());
        String confirmar = new String(cambiarContraAdmi.txtConfirmPass.getPassword());

        if (actual.equalsIgnoreCase("ErrorBD")) {
            cambiarContraAdmi.dispose();
            mostrarErrorBD();
        } else if (nueva.equalsIgnoreCase("ErrorPoliticas")) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New password doesn't match security policies.\nPlease enter a different password.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "All fields are required.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New passwords do not match.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (nueva.equals(actual)) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New password cannot be the same as current password.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "Password updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
            cambiarContraAdmi.dispose();
            mostrarLogin();
        }
    });

        
        
    }
    
    private static void mostrarContrasena()
    {
        cambiarContraAdmi = new V_ChangePassword();
        cambiarContraAdmi.setVisible(true);
        cambiarContraAdmi.lblBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cambiarContraAdmi.dispose();
                mostrarAdminPanel();
            }
        });
        cambiarContraAdmi.btnSave.addActionListener(e -> {
        String actual = new String(cambiarContraAdmi.txtCurrentPass.getPassword());
        String nueva = new String(cambiarContraAdmi.txtNewPass.getPassword());
        String confirmar = new String(cambiarContraAdmi.txtConfirmPass.getPassword());

        if (actual.equalsIgnoreCase("ErrorBD")) {
            cambiarContraAdmi.dispose();
            mostrarErrorBD();
        } else if (nueva.equalsIgnoreCase("ErrorPoliticas")) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New password doesn't match security policies.\nPlease enter a different password.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "All fields are required.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New passwords do not match.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (nueva.equals(actual)) {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "New password cannot be the same as current password.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                cambiarContraAdmi,
                "Password updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
            cambiarContraAdmi.dispose();
            mostrarLogin();
        }
    });

    
    }
    private static void mostrarCrearCuenta(){
        crearCuenta = new V_AskEmailCreateAccount();
        crearCuenta.setVisible(true);
        
        crearCuenta.jLabel4.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
            crearCuenta.dispose();
            mostrarLogin();
             }
        });
        
        crearCuenta.jButton1.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
            crearCuenta.dispose();
            mostrarCheckCuenta();
            
             }
        });
    };
    private static void mostrarCheckCuenta()
    {
        checkCuenta = new V_CheckEmailCreateAccount();
        checkCuenta.setVisible(true);
        checkCuenta.jButton1.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                checkCuenta.dispose(); 
                mostrarLogin();
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
