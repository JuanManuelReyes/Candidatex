/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class VentanaSiguienteAltaPostulante extends javax.swing.JFrame implements Observer {

    public VentanaSiguienteAltaPostulante(Sistema sistema, String nombre, String cedula, String direccion, String telefono, String mail, String linkedin, String formato) {
        initComponents();
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.linkedin = linkedin;
        this.formato = formato;
        exp = new HashMap<>();
        modelo = sistema;

        cargarCombo();

        actualizarEstadoBotonRegistrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelTema = new javax.swing.JLabel();
        jLabelTema1 = new javax.swing.JLabel();
        comboTema = new javax.swing.JComboBox();
        spnNivel = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelExperiencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaExperiencia = new javax.swing.JList();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(472, 391));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Alta Postulante");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(120, 10, 235, 33);

        jLabelTema.setText("Tema:");
        jPanel1.add(jLabelTema);
        jLabelTema.setBounds(140, 60, 50, 16);

        jLabelTema1.setText("Nivel:");
        jPanel1.add(jLabelTema1);
        jLabelTema1.setBounds(140, 100, 50, 20);

        jPanel1.add(comboTema);
        comboTema.setBounds(190, 60, 150, 22);

        spnNivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        jPanel1.add(spnNivel);
        spnNivel.setBounds(190, 100, 64, 22);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(260, 100, 80, 23);

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 70));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(50, 150, 380, 10);

        jLabelExperiencia.setText("Experiencia:");
        jPanel1.add(jLabelExperiencia);
        jLabelExperiencia.setBounds(60, 170, 80, 16);

        listaExperiencia.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaExperienciaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaExperiencia);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(150, 170, 260, 170);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(60, 190, 80, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(200, 360, 100, 23);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(306, 360, 100, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 420);

        setBounds(450, 200, 466, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int nivelValue = (int) spnNivel.getValue();

        boolean experienciaExistente = false;

        if (comboTema.getSelectedItem() != null) {
            Tematica tematica = (Tematica) comboTema.getSelectedItem();
            for (Tematica key : exp.keySet()) {
                if (key.equals(tematica)) {
                    experienciaExistente = true;
                }
            }

            if (experienciaExistente) {
                System.out.println("ERROR: La experiencia ya existe en la lista.");
            } else {
                exp.put(tematica, nivelValue);
                cargarLista();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes crear una Temática antes de registrar un postulante.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (listaExperiencia.getSelectedValue() != null) {
            String enLista = listaExperiencia.getSelectedValue().toString();
            int pos = enLista.indexOf(" (");
            String nombreTematica = enLista.substring(0, pos);
            Tematica selected = null;

            for (Map.Entry<Tematica, Integer> entry : exp.entrySet()) {
                if (entry.getKey().getNombre().equals(nombreTematica)) {
                    selected = entry.getKey();
                }
            }

            System.out.println(selected);

            if (selected != null) {
                exp.remove(selected);
                cargarLista();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una temática a eliminar.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listaExperienciaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaExperienciaValueChanged

    }//GEN-LAST:event_listaExperienciaValueChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Postulante post = new Postulante(nombre, cedula, direccion, telefono, mail, linkedin, formato, exp);
        modelo.agregarPostulante(post);
        JOptionPane.showMessageDialog(null, "Postulante registrado correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(modelo.getListaPostulantes());
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public void cargarLista() {
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<Tematica, Integer> entry : exp.entrySet()) {
            Tematica tema = entry.getKey();
            Integer nivel = entry.getValue();
            res.add(tema.getNombre() + " (" + nivel + ")");
        }
        listaExperiencia.setListData(res.toArray());
        actualizarEstadoBotonRegistrar();
    }

    public void cargarCombo() {
        ArrayList<Tematica> listaTemas = modelo.getListaTematica();
        comboTema.removeAllItems();
        for (Tematica elem : listaTemas) {
            comboTema.addItem(elem);
        }
    }

    private void actualizarEstadoBotonRegistrar() {
        btnRegistrar.setEnabled(listaExperiencia.getModel().getSize() > 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox comboTema;
    private javax.swing.JLabel jLabelExperiencia;
    private javax.swing.JLabel jLabelTema;
    private javax.swing.JLabel jLabelTema1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listaExperiencia;
    private javax.swing.JSpinner spnNivel;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String mail;
    private String linkedin;
    private String formato;
    private HashMap<Tematica, Integer> exp;

    @Override
    public void update(Observable o, Object arg) {
        cargarCombo();
    }
}
