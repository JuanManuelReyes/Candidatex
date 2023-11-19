/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import java.io.*;
import dominio.*;
import javax.swing.*;

public class VentanaInicio extends javax.swing.JFrame {

    public VentanaInicio() {
        initComponents();
        modelo = new Sistema();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JButton();
        btnNuevoSistema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("¡Bienvenido a Candidatex!");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(20, 10, 340, 33);

        btnAbrirArchivo.setText("Abrir desde archivo");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrirArchivo);
        btnAbrirArchivo.setBounds(110, 140, 160, 23);

        btnNuevoSistema.setText("Nuevo sistema");
        btnNuevoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoSistemaActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoSistema);
        btnNuevoSistema.setBounds(110, 100, 160, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 320);

        setBounds(500, 200, 396, 328);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        try {
            FileInputStream arch = new FileInputStream("DATOS");
            ObjectInputStream entrada = new ObjectInputStream(arch);
            modelo = (Sistema) entrada.readObject();

            int contadorGuardado = entrada.readInt();
            Entrevista.setContador(contadorGuardado);

            entrada.close();

            dispose();
            VentanaMenu test = new VentanaMenu(modelo);
            test.setVisible(true);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo DATOS no encontrado.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar el archivo DATOS.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar el archivo DATOS.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnNuevoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoSistemaActionPerformed
        dispose();
        VentanaMenu test = new VentanaMenu(modelo);
        test.setVisible(true);
    }//GEN-LAST:event_btnNuevoSistemaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnNuevoSistema;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    Sistema modelo;
}
