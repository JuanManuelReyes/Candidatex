/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import java.io.*;
import javax.swing.*;

public class VentanaMenu extends javax.swing.JFrame {

    public VentanaMenu(Sistema sistema) {
        modelo = sistema;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        newTematica = new javax.swing.JMenuItem();
        newPostulante = new javax.swing.JMenuItem();
        newEvaluador = new javax.swing.JMenuItem();
        newPuesto = new javax.swing.JMenuItem();
        newEntrevista = new javax.swing.JMenuItem();
        menuVentana = new javax.swing.JMenu();
        ventConsTematica = new javax.swing.JMenuItem();
        ventConsPuesto = new javax.swing.JMenuItem();
        ventHistPostulantes = new javax.swing.JMenuItem();
        ventBajaPostulante = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        opcionAyuda = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        debug = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        menuArchivo.setText("Crear");

        newTematica.setText("Temática");
        newTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTematicaActionPerformed(evt);
            }
        });
        menuArchivo.add(newTematica);

        newPostulante.setText("Postulante");
        newPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPostulanteActionPerformed(evt);
            }
        });
        menuArchivo.add(newPostulante);

        newEvaluador.setText("Evaluador");
        newEvaluador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEvaluadorActionPerformed(evt);
            }
        });
        menuArchivo.add(newEvaluador);

        newPuesto.setText("Puesto");
        newPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPuestoActionPerformed(evt);
            }
        });
        menuArchivo.add(newPuesto);

        newEntrevista.setText("Entrevista");
        newEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntrevistaActionPerformed(evt);
            }
        });
        menuArchivo.add(newEntrevista);

        jMenuBar1.add(menuArchivo);

        menuVentana.setText("Ventana");

        ventConsTematica.setText("Consulta por temática");
        ventConsTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventConsTematicaActionPerformed(evt);
            }
        });
        menuVentana.add(ventConsTematica);

        ventConsPuesto.setText("Consulta para puesto");
        ventConsPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventConsPuestoActionPerformed(evt);
            }
        });
        menuVentana.add(ventConsPuesto);

        ventHistPostulantes.setText("Historial de postulantes");
        ventHistPostulantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventHistPostulantesActionPerformed(evt);
            }
        });
        menuVentana.add(ventHistPostulantes);

        ventBajaPostulante.setText("Dar de baja a postulante");
        ventBajaPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventBajaPostulanteActionPerformed(evt);
            }
        });
        menuVentana.add(ventBajaPostulante);

        jMenuBar1.add(menuVentana);

        menuAyuda.setText("Ayuda");

        opcionAyuda.setText("¯\\_(ツ)_/¯");
        opcionAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAyudaActionPerformed(evt);
            }
        });
        menuAyuda.add(opcionAyuda);
        menuAyuda.add(jSeparator1);

        debug.setText("DeBug");
        debug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugActionPerformed(evt);
            }
        });
        menuAyuda.add(debug);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        setBounds(300, 100, 800, 628);
    }// </editor-fold>//GEN-END:initComponents

    private void opcionAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionAyudaActionPerformed

    private void newPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPuestoActionPerformed
        VentanaRegPuesto vent = new VentanaRegPuesto(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_newPuestoActionPerformed

    private void ventHistPostulantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventHistPostulantesActionPerformed
        VentanaHistorialPostulante vent = new VentanaHistorialPostulante(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_ventHistPostulantesActionPerformed

    private void newTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTematicaActionPerformed
        VentanaRegTematica vent = new VentanaRegTematica(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_newTematicaActionPerformed

    private void newPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPostulanteActionPerformed
        VentanaAltaPostulante vent = new VentanaAltaPostulante(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_newPostulanteActionPerformed

    private void newEvaluadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEvaluadorActionPerformed
        VentanaRegEvaluador vent = new VentanaRegEvaluador(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_newEvaluadorActionPerformed

    private void newEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntrevistaActionPerformed
        VentanaIngresoEntrevista vent = new VentanaIngresoEntrevista(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_newEntrevistaActionPerformed

    private void ventConsTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventConsTematicaActionPerformed
        VentanaConsultaTematica vent = new VentanaConsultaTematica(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_ventConsTematicaActionPerformed

    private void ventConsPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventConsPuestoActionPerformed
        VentanaConsulta vent = new VentanaConsulta(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_ventConsPuestoActionPerformed

    private void ventBajaPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventBajaPostulanteActionPerformed
        VentanaBajaPostulante vent = new VentanaBajaPostulante(modelo);
        modelo.addObserver(vent);
        vent.setVisible(true);
    }//GEN-LAST:event_ventBajaPostulanteActionPerformed

    private void debugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugActionPerformed
        System.out.println(modelo.getListaTematica());
        System.out.println(modelo.getListaPostulantes());
        System.out.println(modelo.getListaPuestos());
        System.out.println(modelo.getListaEntrevistas());
        System.out.println(modelo.getListaEvaluador());
    }//GEN-LAST:event_debugActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            FileOutputStream arch = new FileOutputStream("DATOS");
            ObjectOutputStream salida = new ObjectOutputStream(arch);
            salida.writeObject(modelo);
            salida.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se creó el archivo de guardado DATOS.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el archivo DATOS.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem debug;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuVentana;
    private javax.swing.JMenuItem newEntrevista;
    private javax.swing.JMenuItem newEvaluador;
    private javax.swing.JMenuItem newPostulante;
    private javax.swing.JMenuItem newPuesto;
    private javax.swing.JMenuItem newTematica;
    private javax.swing.JMenuItem opcionAyuda;
    private javax.swing.JMenuItem ventBajaPostulante;
    private javax.swing.JMenuItem ventConsPuesto;
    private javax.swing.JMenuItem ventConsTematica;
    private javax.swing.JMenuItem ventHistPostulantes;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
