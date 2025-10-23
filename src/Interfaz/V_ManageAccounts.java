package Interfaz;

import Logica.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class V_ManageAccounts extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboFiltro;
    private TableRowSorter<DefaultTableModel> sorter;

    public V_ManageAccounts() {
        setTitle("Account Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        JLabel lblTitulo = new JLabel("Account Management");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 120, 215));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        
        JLabel lblFiltro = new JLabel("Filter by status:");
        lblFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblFiltro.setBounds(20, 50, 120, 25);
        add(lblFiltro);
        
        JLabel lblVolver = new JLabel("Return");
        lblVolver.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblVolver.setForeground(new Color(0, 120, 215));
        lblVolver.setBounds(450, 315, 90, 30);
        lblVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblVolver.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        dispose();
        // Llama al método del main para volver al Admin Panel
        PrototipoReque.mostrarAdminPanel();
    }
});
        add(lblVolver);

        String[] estados = {"All", "Active", "Suspended", "Pending"};
        comboFiltro = new JComboBox<>(estados);
        comboFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboFiltro.setBounds(150, 50, 150, 25);
        add(comboFiltro);

        
        model = new DefaultTableModel(new Object[]{"Email", "Status"}, 0);
        table = new JTable(model);

        
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 90, 540, 200);
        add(scroll);

        
        JButton btnActivar = new JButton("Activate");
        btnActivar.setBounds(20, 310, 120, 35);
        estiloBoton(btnActivar);
        btnActivar.addActionListener(e -> cambiarEstado("Active"));
        add(btnActivar);

        JButton btnSuspender = new JButton("Suspend");
        btnSuspender.setBounds(160, 310, 120, 35);
        estiloBoton(btnSuspender);
        btnSuspender.addActionListener(e -> cambiarEstado("Suspended"));
        add(btnSuspender);

        JButton btnEliminar = new JButton("Delete");
        btnEliminar.setBounds(300, 310, 120, 35);
        btnEliminar.setBackground(new Color(220, 53, 69)); 
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(BorderFactory.createEmptyBorder());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        add(btnEliminar);
        
        model.addRow(new Object[]{"user1@example.com", "Active"});
        model.addRow(new Object[]{"user2@example.com", "Pending"});
        model.addRow(new Object[]{"user3@example.com", "Suspended"});

    
        comboFiltro.addActionListener(e -> aplicarFiltro());
    }

    private void estiloBoton(JButton btn) {
        btn.setBackground(new Color(0, 120, 215));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
    }

    private void aplicarFiltro() {
        String filtro = (String) comboFiltro.getSelectedItem();
        if (filtro.equals("All")) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 1));
        }
    }

    private void cambiarEstado(String nuevoEstado) {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Select a user.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
  
        int filaModelo = table.convertRowIndexToModel(fila);
        model.setValueAt(nuevoEstado, filaModelo, 1);
        JOptionPane.showMessageDialog(this, "Status switched to " + nuevoEstado);
    }

    private void eliminarUsuario() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Select a user.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this user?", "Confirm deletion",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int filaModelo = table.convertRowIndexToModel(fila);
            model.removeRow(filaModelo);
            JOptionPane.showMessageDialog(this, "User successfully deleted.");
        }
    }

   
}
