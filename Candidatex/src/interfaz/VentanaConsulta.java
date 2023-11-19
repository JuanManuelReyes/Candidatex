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
import javax.swing.*;

public class VentanaConsulta extends javax.swing.JFrame implements Observer {

    public VentanaConsulta(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarPuestos();
        arraylistPostAptos = new ArrayList<>();
    }

    public void cargarPostulantes() {
        listPostulantes.setListData(arraylistPostAptos.toArray());
    }

    public void limpiarListas() {
        arraylistPostAptos.clear();
    }

    public void cargarPuestos() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Puesto puesto : modelo.getListaPuestos()) {
            model.addElement(puesto.getNombre());
        }
        listaPuestos.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPuestos = new javax.swing.JList();
        jLabelPuestos = new javax.swing.JLabel();
        spnNivel = new javax.swing.JSpinner();
        btnConsultar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPostulantes = new javax.swing.JList();
        jLabelPostulantes = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Consulta para Puesto");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(120, 10, 235, 33);

        jLabelNivel.setText("Nivel:");
        jPanel1.add(jLabelNivel);
        jLabelNivel.setBounds(50, 250, 50, 20);

        jScrollPane1.setViewportView(listaPuestos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 90, 350, 130);

        jLabelPuestos.setText("Puestos:");
        jPanel1.add(jLabelPuestos);
        jLabelPuestos.setBounds(50, 60, 70, 16);

        spnNivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        jPanel1.add(spnNivel);
        spnNivel.setBounds(90, 250, 64, 22);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar);
        btnConsultar.setBounds(300, 250, 100, 23);

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 70));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(40, 290, 370, 10);

        jScrollPane2.setViewportView(listPostulantes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 340, 350, 130);

        jLabelPostulantes.setText("Postulantes:");
        jPanel1.add(jLabelPostulantes);
        jLabelPostulantes.setBounds(50, 310, 90, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(210, 500, 90, 23);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportar);
        btnExportar.setBounds(310, 500, 90, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 580);

        setBounds(450, 200, 466, 588);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        limpiarListas();

        int nivelRequerido = (Integer) spnNivel.getValue();
        String nombrePuestoSeleccionado = (String) listaPuestos.getSelectedValue();

        Puesto puestoSeleccionado = modelo.buscarPuestoPorNombre(nombrePuestoSeleccionado);

        if (puestoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "El puesto seleccionado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Postulante postulante : modelo.getListaPostulantes()) {
            if (postulante.getEntrevistas(modelo).isEmpty()) {
                continue;
            }

            if (!postulante.getFormato().equals(puestoSeleccionado.getTipo())) {
                continue;
            }
            boolean cumpleConNivel = true;

            for (Tematica tema : puestoSeleccionado.getTemasRequeridos()) {
                if (postulante.getNivelEnTema(tema) < nivelRequerido) {
                    cumpleConNivel = false;
                    break;
                }
            }

            if (cumpleConNivel) {
                arraylistPostAptos.add(postulante);
            }
        }

        Collections.sort(arraylistPostAptos, new Comparator<Postulante>() {
            @Override
            public int compare(Postulante p1, Postulante p2) {
                return Integer.compare(p2.getPuntajeUltimaEntrevista(modelo), p1.getPuntajeUltimaEntrevista(modelo));
            }
        });
        
        cargarPostulantes();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String nombrePuestoSeleccionado = (String) listaPuestos.getSelectedValue();
        Puesto puestoSeleccionado = modelo.buscarPuestoPorNombre(nombrePuestoSeleccionado);

        if (puestoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "El puesto seleccionado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Postulante> postulantesAExportar = new ArrayList<>(arraylistPostAptos);

        try {
            ArchivoGrabacion archivoGrabacion = new ArchivoGrabacion("Consulta.txt", false);

            archivoGrabacion.grabarLinea(puestoSeleccionado.getNombre());

            for (Postulante postulante : postulantesAExportar) {
                String linea = postulante.getNombre() + ", " + postulante.getCedula() + ", " + postulante.getMail();
                archivoGrabacion.grabarLinea(linea);
            }

            archivoGrabacion.cerrar();

            JOptionPane.showMessageDialog(this, "Exportado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al exportar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelPostulantes;
    private javax.swing.JLabel jLabelPuestos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listPostulantes;
    private javax.swing.JList listaPuestos;
    private javax.swing.JSpinner spnNivel;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private ArrayList<Postulante> arraylistPostAptos;

    @Override
    public void update(Observable o, Object arg) {
        cargarPuestos();
    }
}
