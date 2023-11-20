/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import javax.swing.*;

public class VentanaRegTematica extends javax.swing.JFrame {

    public VentanaRegTematica(Sistema sistema) {
        modelo = sistema; // Sistema de la aplicacion.
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDesc = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Registro de Temática");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(80, 10, 235, 33);

        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre);
        jLabelNombre.setBounds(31, 60, 80, 16);

        jLabelDesc.setText("Descripción:");
        jPanel1.add(jLabelDesc);
        jLabelDesc.setBounds(31, 113, 90, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(110, 60, 232, 22);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(110, 260, 110, 23);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(230, 260, 110, 23);

        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 120, 230, 130);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 320);

        setBounds(450, 200, 396, 328);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // Verifica si los campos de texto estan vacíos.
        if (txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Crea una nueva tematica y verifica si ya existe en el sistema.
            Tematica tema = new Tematica(txtNombre.getText(), txtDescripcion.getText());
            if (modelo.temaRepetido(tema)) {
                JOptionPane.showMessageDialog(null, "Temática ya registrada.", "Alerta", JOptionPane.WARNING_MESSAGE);
            } else {
                // Agrega la nueva tematica al sistema y muestra un mensaje de confirmacion.
                modelo.agregarTematica(tema);
                JOptionPane.showMessageDialog(null, "Temática registrada correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabelDesc;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
