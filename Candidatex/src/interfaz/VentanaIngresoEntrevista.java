package interfaz;

import javax.swing.*;
import java.util.*;
import dominio.*;

public class VentanaIngresoEntrevista extends javax.swing.JFrame implements Observer {

    public VentanaIngresoEntrevista(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEvaluador = new javax.swing.JList();
        jLabelPountaje = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPostulantes = new javax.swing.JList();
        jLabelPostulantes = new javax.swing.JLabel();
        jLabelComentarios = new javax.swing.JLabel();
        spnPuntaje = new javax.swing.JSpinner();
        jLabelEvaluador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Ingreso de Entrevista");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(120, 10, 235, 33);

        jScrollPane2.setViewportView(listaEvaluador);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 90, 160, 210);

        jLabelPountaje.setText("Puntaje:");
        jPanel1.add(jLabelPountaje);
        jLabelPountaje.setBounds(50, 550, 90, 20);

        jScrollPane3.setViewportView(listaPostulantes);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(260, 90, 160, 210);

        jLabelPostulantes.setText("Postulantes:");
        jPanel1.add(jLabelPostulantes);
        jLabelPostulantes.setBounds(260, 60, 90, 17);

        jLabelComentarios.setText("Comentarios:");
        jPanel1.add(jLabelComentarios);
        jLabelComentarios.setBounds(50, 320, 90, 17);

        spnPuntaje.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jPanel1.add(spnPuntaje);
        spnPuntaje.setBounds(120, 550, 68, 23);

        jLabelEvaluador.setText("Evaluador:");
        jPanel1.add(jLabelEvaluador);
        jLabelEvaluador.setBounds(50, 60, 90, 17);

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 350, 370, 180);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(250, 550, 81, 23);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar);
        btnIngresar.setBounds(340, 550, 76, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 470, 600);

        setBounds(450, 200, 470, 628);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Evaluador eva = (Evaluador) listaEvaluador.getSelectedValue();
        Postulante post = (Postulante) listaPostulantes.getSelectedValue();
        int puntaje = (int) spnPuntaje.getValue();
        String comentarios = txtComentarios.getText();

        if (comentarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (eva == null || post == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un Evaluador y Postulante", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Entrevista entrevista = new Entrevista(eva, post, puntaje, comentarios);
            modelo.agregarEntrevista(entrevista);
            JOptionPane.showMessageDialog(null, "Entrevista registrada correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    public void cargarLista() {
        listaEvaluador.setListData(modelo.getListaEvaluador().toArray());
        listaPostulantes.setListData(modelo.getListaPostulantes().toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabelComentarios;
    private javax.swing.JLabel jLabelEvaluador;
    private javax.swing.JLabel jLabelPostulantes;
    private javax.swing.JLabel jLabelPountaje;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaEvaluador;
    private javax.swing.JList listaPostulantes;
    private javax.swing.JSpinner spnPuntaje;
    private javax.swing.JTextArea txtComentarios;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }
}
