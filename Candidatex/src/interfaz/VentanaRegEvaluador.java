/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import java.time.*;
import javax.swing.*;

public class VentanaRegEvaluador extends javax.swing.JFrame {

    public VentanaRegEvaluador(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarComboFechas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelDireccion1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        comboFecha = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Registro de Evaluador");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(80, 10, 235, 33);

        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre);
        jLabelNombre.setBounds(40, 60, 70, 16);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(150, 60, 200, 22);

        jLabelCedula.setText("Cédula:");
        jPanel1.add(jLabelCedula);
        jLabelCedula.setBounds(40, 100, 70, 16);
        jPanel1.add(txtCedula);
        txtCedula.setBounds(150, 100, 200, 22);

        jLabelDireccion.setText("Dirección:");
        jPanel1.add(jLabelDireccion);
        jLabelDireccion.setBounds(40, 140, 80, 16);

        jLabelDireccion1.setText("Año de ingreso:");
        jPanel1.add(jLabelDireccion1);
        jLabelDireccion1.setBounds(40, 180, 110, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(150, 220, 100, 23);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(256, 220, 100, 23);
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(150, 140, 200, 22);

        jPanel1.add(comboFecha);
        comboFecha.setBounds(150, 180, 200, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 280);

        setBounds(450, 200, 396, 288);
    }// </editor-fold>//GEN-END:initComponents

    public void cargarComboFechas() {
        int añoActual = LocalDate.now().getYear();
        int añoInicio = 1950;
        comboFecha.removeAllItems();

        for (int año = añoActual-1; año >= añoInicio; año--) {
            comboFecha.addItem(String.valueOf(año));
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String fechaText = comboFecha.getSelectedItem().toString();

        if (nombre.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || fechaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(modelo.cedulaRepetida(cedula)){
            JOptionPane.showMessageDialog(null, "Persona o cédula ya registrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(modelo.cedulaInvalida(cedula)){
            JOptionPane.showMessageDialog(null, "Cédula no valida. Por favor reingrese una cédula sin puntos ni guiones.", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Evaluador registrado correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            int fecha = Integer.parseInt(fechaText);
            Evaluador eva = new Evaluador(nombre, cedula, direccion, fecha);
            modelo.agregarEvaluador(eva);
            dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboFecha;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDireccion1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
