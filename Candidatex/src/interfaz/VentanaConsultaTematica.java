/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package interfaz;

import dominio.*;
import java.util.*;
import javax.swing.DefaultListModel;

public class VentanaConsultaTematica extends javax.swing.JFrame implements Observer {

    public VentanaConsultaTematica(Sistema sistema) {
        initComponents();
        modelo = sistema;
        arraylistPostulantes = new ArrayList<>();
        arraylistPuestos = new ArrayList<>();

        listaTematicas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTematicasValueChanged(evt);
            }
        });

        cargarTematicas();
    }

    public void cargarTematicas() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Tematica tema : modelo.getListaTematica()) {
            model.addElement(tema.getNombre());
        }
        listaTematicas.setModel(model);

    }

    public void cargarListas() {
        listaPostulantes.setListData(arraylistPostulantes.toArray());
        listaPuestos.setListData(arraylistPuestos.toArray());
    }

    public void limpiarListas() {
        arraylistPostulantes.clear();
        arraylistPuestos.clear();
    }

    private void listaTematicasValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) { // This line prevents double firing
            String nombreTematicaSeleccioanda = (String) listaTematicas.getSelectedValue();
            Tematica tematicaSeleccionada = modelo.buscarTematicaPorNombre(nombreTematicaSeleccioanda);

            limpiarListas();

            // Compute statistics based on selectedTematica
            int postulantesCount = 0;
            int puestosCount = 0;

            // I'm making assumptions on the structure of your Tematica and other classes 
            // since they're not provided.
            for (Postulante postulante : modelo.getListaPostulantes()) {
                if (postulante.getNivelEnTema(tematicaSeleccionada) > 5) {
                    postulantesCount++;
                    arraylistPostulantes.add(postulante);
                }
            }

            for (Puesto puesto : modelo.getListaPuestos()) {
                if (puesto.getTemasRequeridos().contains(tematicaSeleccionada)) {
                    puestosCount++;
                    arraylistPuestos.add(puesto);
                }
            }

            // Now, update your UI to display these statistics
            // You can use JLabels or any other component to display these statistics
            jLabelPostulantes.setText("Postulantes: " + postulantesCount);
            jLabelPuestos.setText("Puestos: " + puestosCount);

            cargarListas();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTematicas = new javax.swing.JList();
        jLabelTematicas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPostulantes = new javax.swing.JList();
        jLabelPostNivel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPuestos = new javax.swing.JList();
        jLabelPuestos = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelPostulantes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Consulta por Temática");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(120, 10, 235, 33);

        jScrollPane1.setViewportView(listaTematicas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 90, 350, 130);

        jLabelTematicas.setText("Temáticas:");
        jPanel1.add(jLabelTematicas);
        jLabelTematicas.setBounds(60, 60, 80, 17);

        jScrollPane2.setViewportView(listaPostulantes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 300, 160, 160);

        jLabelPostNivel.setText("(nivel mayor a 5)");
        jPanel1.add(jLabelPostNivel);
        jLabelPostNivel.setBounds(60, 280, 160, 17);

        jScrollPane3.setViewportView(listaPuestos);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(250, 300, 160, 160);

        jLabelPuestos.setText("Puestos:");
        jPanel1.add(jLabelPuestos);
        jLabelPuestos.setBounds(250, 257, 80, 17);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(330, 480, 78, 23);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(60, 250, 350, 10);

        jLabelPostulantes.setText("Postulantes: ");
        jPanel1.add(jLabelPostulantes);
        jLabelPostulantes.setBounds(60, 260, 160, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 470, 520);

        setBounds(450, 200, 470, 548);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabelPostNivel;
    private javax.swing.JLabel jLabelPostulantes;
    private javax.swing.JLabel jLabelPuestos;
    private javax.swing.JLabel jLabelTematicas;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listaPostulantes;
    private javax.swing.JList listaPuestos;
    private javax.swing.JList listaTematicas;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private ArrayList<Postulante> arraylistPostulantes;
    private ArrayList<Puesto> arraylistPuestos;

    @Override
    public void update(Observable o, Object arg) {
        cargarTematicas();
    }
}
