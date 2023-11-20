/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import java.util.*;
import javax.swing.*;

public class VentanaRegPuesto extends javax.swing.JFrame implements Observer {

    public VentanaRegPuesto(Sistema sistema) {
        initComponents();
        modelo = sistema; // Sistema de la aplicaciOn.
        requeridos = new ArrayList<>(); // Lista para almacenar los temas requeridos del puesto.
        cargarLista(); // Carga la lista de temas disponibles.
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
        comboTipo.setBounds(170, 100, 190, 22);

        jLabelTipo.setText("Tipo:");
        jPanel1.add(jLabelTipo);
        jLabelTipo.setBounds(30, 100, 40, 20);

        txtNombrePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePuestoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombrePuesto);
        txtNombrePuesto.setBounds(172, 60, 190, 22);

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
        btnRegistrar.setBounds(256, 390, 100, 23);

        listaTemasFinales.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTemasFinalesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaTemasFinales);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(150, 260, 210, 100);

        jScrollPane2.setViewportView(listaTemas);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(150, 140, 210, 100);

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1);
        btnCancelar1.setBounds(150, 390, 100, 23);

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
        jPanel1.setBounds(0, 0, 380, 450);

        setBounds(450, 200, 396, 458);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePuestoActionPerformed

    // Metodo para agregar un tema a la lista de requeridos.
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Valida que haya un tema seleccionado y lo agrega.
        if (listaTemas.getSelectedValue()!=null) {
            Tematica tema = (Tematica) listaTemas.getSelectedValue();

            if (requeridos.contains(tema)) {
                JOptionPane.showMessageDialog(null, "Temática ya agregada.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                requeridos.add(tema);
                cargarLista();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una temática.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Metodo para registrar un nuevo puesto en el sistema.
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // Toma los datos de los campos de la interfaz.
        String nombrePuesto = txtNombrePuesto.getText();
        String tipo = comboTipo.getSelectedItem().toString();
        
        // Valida los datos y en caso positivo hace el registro.
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

    // Metodo para eliminar un tema de la lista de requeridos.
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Valida que haya un tema seleccionado y lo elimina.
        if (listaTemasFinales.getSelectedValue() != null) {
            Tematica selected = (Tematica) listaTemasFinales.getSelectedValue();
            for (Tematica elem : requeridos) {
                if (elem.equals(selected)) {
                    requeridos.remove(elem);
                    cargarLista();
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un tema a eliminar.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listaTemasFinalesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaTemasFinalesValueChanged

    }//GEN-LAST:event_listaTemasFinalesValueChanged
    
    // Metodo para cargar las listas de temas en la interfaz.
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
