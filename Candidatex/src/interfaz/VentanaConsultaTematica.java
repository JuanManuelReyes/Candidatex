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
        modelo = sistema; // Sistema de la aplicacion.
        arraylistPostulantes = new ArrayList<>(); // Inicializa la lista de postulantes.
        arraylistPuestos = new ArrayList<>(); // Inicializa la lista de puestos.

        // Agrega un listener para detectar cambios en la seleccion de la lista de tematicas.
        listaTematicas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTematicasValueChanged(evt); // Maneja el cambio de seleccion.
            }
        });

        cargarTematicas(); // Carga las tematicas disponibles en la interfaz.
    }

    // Metodo para cargar las tematicas en la interfaz.
    public void cargarTematicas() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Tematica tema : modelo.getListaTematica()) {
            model.addElement(tema.getNombre()); // Agrega cada tematica a la lista.
        }
        listaTematicas.setModel(model); // Establece el modelo en la lista de tematicas.

    }

    // Metodo para actualizar las listas de postulantes y puestos en la interfaz.
    public void cargarListas() {
        listaPostulantes.setListData(arraylistPostulantes.toArray()); // Actualiza la lista de postulantes.
        listaPuestos.setListData(arraylistPuestos.toArray()); // Actualiza la lista de puestos.
    }

    // Método para limpiar las listas de postulantes y puestos.
    public void limpiarListas() {
        arraylistPostulantes.clear(); // Limpia la lista de postulantes.
        arraylistPuestos.clear(); // Limpia la lista de puestos.
    }

    // Metodo que se ejecuta cuando cambia la seleccion en la lista de tematicas.
    private void listaTematicasValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) { // Evita que el evento se dispare dos veces.
            String nombreTematicaSeleccioanda = (String) listaTematicas.getSelectedValue(); // Obtiene la tematica seleccionada.
            Tematica tematicaSeleccionada = modelo.buscarTematicaPorNombre(nombreTematicaSeleccioanda); // Busca la tematica en el sistema.

            limpiarListas(); // Limpia las listas antes de cargar los nuevos datos.

            int postulantesCount = 0;
            int puestosCount = 0;

            // Recorre los postulantes y verifica si cumplen con el nivel en la tematica seleccionada.
            for (Postulante postulante : modelo.getListaPostulantes()) {
                if (postulante.getNivelEnTema(tematicaSeleccionada) > 5) {
                    postulantesCount++;
                    arraylistPostulantes.add(postulante);
                }
            }
            
            // Recorre los puestos y verifica si requieren la tematica seleccionada.
            for (Puesto puesto : modelo.getListaPuestos()) {
                if (puesto.getTemasRequeridos().contains(tematicaSeleccionada)) {
                    puestosCount++;
                    arraylistPuestos.add(puesto);
                }
            }

            // Actualiza las etiquetas con la cantidad de postulantes y puestos.
            jLabelPostulantes.setText("Postulantes: " + postulantesCount);
            jLabelPuestos.setText("Puestos: " + puestosCount);

            cargarListas(); // Carga las listas actualizadas en la interfaz.
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
        jLabelTitulo.setBounds(110, 10, 235, 33);

        jScrollPane1.setViewportView(listaTematicas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 90, 350, 130);

        jLabelTematicas.setText("Temáticas:");
        jPanel1.add(jLabelTematicas);
        jLabelTematicas.setBounds(50, 60, 80, 16);

        jScrollPane2.setViewportView(listaPostulantes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 300, 160, 160);

        jLabelPostNivel.setText("(nivel mayor a 5)");
        jPanel1.add(jLabelPostNivel);
        jLabelPostNivel.setBounds(50, 280, 160, 16);

        jScrollPane3.setViewportView(listaPuestos);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(240, 300, 160, 160);

        jLabelPuestos.setText("Puestos:");
        jPanel1.add(jLabelPuestos);
        jLabelPuestos.setBounds(240, 260, 80, 16);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(320, 480, 78, 23);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(50, 250, 350, 10);

        jLabelPostulantes.setText("Postulantes: ");
        jPanel1.add(jLabelPostulantes);
        jLabelPostulantes.setBounds(50, 260, 160, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 540);

        setBounds(450, 200, 466, 548);
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
