package interfaz;

import dominio.*;
import java.util.*;
import javax.swing.*;

public class VentanaRegPuesto extends javax.swing.JFrame implements Observer{

    public VentanaRegPuesto(Sistema sistema) {
        initComponents();
        modelo = sistema;
        requeridos = new ArrayList<>();
        cargarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelTemas = new javax.swing.JLabel();
        jLabelNombrePuesto = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabelTipo = new javax.swing.JLabel();
        txtNombrePuesto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTemasFinales = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTemas = new javax.swing.JList();
        btnCancelar1 = new javax.swing.JButton();
        jLabelTemas1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Registro de Puesto");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(80, 10, 235, 33);

        jLabelTemas.setText("Temas requeridos:");
        jPanel1.add(jLabelTemas);
        jLabelTemas.setBounds(30, 260, 120, 20);

        jLabelNombrePuesto.setText("Nombre del puesto:");
        jPanel1.add(jLabelNombrePuesto);
        jLabelNombrePuesto.setBounds(31, 60, 130, 20);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Remoto", "Presencial", "Mixto" }));
        jPanel1.add(comboTipo);
        comboTipo.setBounds(170, 100, 190, 23);

        jLabelTipo.setText("Tipo:");
        jPanel1.add(jLabelTipo);
        jLabelTipo.setBounds(30, 100, 40, 20);

        txtNombrePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePuestoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombrePuesto);
        txtNombrePuesto.setBounds(172, 60, 190, 23);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(30, 170, 81, 23);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(280, 390, 82, 23);

        listaTemasFinales.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTemasFinalesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaTemasFinales);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(170, 260, 190, 100);

        jScrollPane2.setViewportView(listaTemas);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(170, 140, 190, 100);

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1);
        btnCancelar1.setBounds(190, 390, 81, 23);

        jLabelTemas1.setText("Temas disponibles:");
        jPanel1.add(jLabelTemas1);
        jLabelTemas1.setBounds(30, 140, 120, 20);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(30, 290, 81, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 430);

        setBounds(450, 200, 400, 458);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePuestoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Tematica tema = (Tematica) listaTemas.getSelectedValue();

        if (requeridos.contains(tema)) {
            System.out.println("YA ESTÁ EL TEMA");
        } else {
            requeridos.add(tema);
            cargarLista();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombrePuesto = txtNombrePuesto.getText();
        String tipo = comboTipo.getSelectedItem().toString();
        if (nombrePuesto.isEmpty() || requeridos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Puesto puesto = new Puesto(nombrePuesto, tipo, requeridos);
            if (modelo.puestoRepetido(puesto)) {
                JOptionPane.showMessageDialog(null, "Puesto ya registrado.", "Alerta", JOptionPane.WARNING_MESSAGE);
            } else {
                modelo.agregarPuesto(puesto);
                txtNombrePuesto.setText("");
                JOptionPane.showMessageDialog(null, "Puesto registrado correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                System.out.println(modelo.getListaPuestos());
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Tematica selected = (Tematica) listaTemasFinales.getSelectedValue();
        for (Tematica elem : requeridos) {
            if (elem.equals(selected)) {
                requeridos.remove(elem);
                cargarLista();
                break;
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listaTemasFinalesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaTemasFinalesValueChanged

    }//GEN-LAST:event_listaTemasFinalesValueChanged
    public void cargarLista() {
        listaTemas.setListData(modelo.getListaTematica().toArray());
        listaTemasFinales.setListData(requeridos.toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabelNombrePuesto;
    private javax.swing.JLabel jLabelTemas;
    private javax.swing.JLabel jLabelTemas1;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaTemas;
    private javax.swing.JList listaTemasFinales;
    private javax.swing.JTextField txtNombrePuesto;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private ArrayList<Tematica> requeridos;

    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }
}
