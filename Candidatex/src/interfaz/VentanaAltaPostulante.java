/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import javax.swing.*;
import dominio.*;

public class VentanaAltaPostulante extends javax.swing.JFrame  {

    public VentanaAltaPostulante(Sistema sistema) {
        modelo = sistema; // Sistema de la aplicacion.
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupFormato = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabelLinkedin = new javax.swing.JLabel();
        txtLinkedin = new javax.swing.JTextField();
        jLabelFormato = new javax.swing.JLabel();
        radioRemoto = new javax.swing.JRadioButton();
        radioPresencial = new javax.swing.JRadioButton();
        radioMixto = new javax.swing.JRadioButton();
        btnCancelar = new javax.swing.JToggleButton();
        btnSiguiente = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Alta Postulante");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(120, 10, 235, 33);

        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre);
        jLabelNombre.setBounds(50, 60, 70, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(130, 60, 290, 22);

        jLabelCedula.setText("Cédula:");
        jPanel1.add(jLabelCedula);
        jLabelCedula.setBounds(50, 100, 70, 16);
        jPanel1.add(txtCedula);
        txtCedula.setBounds(130, 100, 290, 22);

        jLabelDireccion.setText("Dirección:");
        jPanel1.add(jLabelDireccion);
        jLabelDireccion.setBounds(50, 140, 70, 16);
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(130, 140, 290, 22);

        jLabelTelefono.setText("Teléfono:");
        jPanel1.add(jLabelTelefono);
        jLabelTelefono.setBounds(50, 180, 70, 16);
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(130, 180, 290, 22);

        jLabelMail.setText("Mail:");
        jPanel1.add(jLabelMail);
        jLabelMail.setBounds(50, 220, 70, 16);
        jPanel1.add(txtMail);
        txtMail.setBounds(130, 220, 290, 22);

        jLabelLinkedin.setText("LinkedIn:");
        jPanel1.add(jLabelLinkedin);
        jLabelLinkedin.setBounds(50, 260, 70, 16);
        jPanel1.add(txtLinkedin);
        txtLinkedin.setBounds(130, 260, 290, 22);

        jLabelFormato.setText("Formato:");
        jPanel1.add(jLabelFormato);
        jLabelFormato.setBounds(50, 300, 70, 16);

        groupFormato.add(radioRemoto);
        radioRemoto.setSelected(true);
        radioRemoto.setText("Remoto");
        jPanel1.add(radioRemoto);
        radioRemoto.setBounds(130, 300, 90, 21);

        groupFormato.add(radioPresencial);
        radioPresencial.setText("Presencial");
        jPanel1.add(radioPresencial);
        radioPresencial.setBounds(230, 300, 110, 21);

        groupFormato.add(radioMixto);
        radioMixto.setText("Mixto");
        jPanel1.add(radioMixto);
        radioMixto.setBounds(350, 300, 70, 21);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(210, 360, 100, 23);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSiguiente);
        btnSiguiente.setBounds(319, 360, 100, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 420);

        setBounds(450, 200, 466, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // Toma de datos de los campos de texto.
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String telefono = txtTelefono.getText();
        String mail = txtMail.getText();
        String linkedin = txtLinkedin.getText();
        String direccion = txtDireccion.getText();
        String formato;

        if (radioRemoto.isSelected()) {
            formato = radioRemoto.getText();
        } else if (radioPresencial.isSelected()) {
            formato = radioPresencial.getText();
        } else {
            formato = radioMixto.getText();
        }
        
        // Validacion de los campos
        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() || mail.isEmpty() || linkedin.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (modelo.cedulaInvalida(cedula)) {
            JOptionPane.showMessageDialog(null, "Cédula no valida. Por favor reingrese una cédula sin puntos ni guiones.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (modelo.cedulaRepetida(cedula)){
            JOptionPane.showMessageDialog(null, "Persona o cédula ya registrada.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (modelo.telefonoInvalido(telefono)) {
            JOptionPane.showMessageDialog(null, "Telefono no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!modelo.mailValido(mail)) {
            JOptionPane.showMessageDialog(null, "Mail no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!modelo.linkValido(linkedin)) {
            JOptionPane.showMessageDialog(null, "Linkedin no válido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            dispose();
            if (!linkedin.startsWith("https://")) {
                linkedin = "https://"+linkedin;
            }
            VentanaSiguienteAltaPostulante vent = new VentanaSiguienteAltaPostulante(modelo, nombre, cedula, direccion, telefono, mail, linkedin, formato);
            modelo.addObserver(vent);
            vent.setVisible(true); // Se muestra la ventana siguiente para finalizar el alta.
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnSiguiente;
    private javax.swing.ButtonGroup groupFormato;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelLinkedin;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioMixto;
    private javax.swing.JRadioButton radioPresencial;
    private javax.swing.JRadioButton radioRemoto;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLinkedin;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
