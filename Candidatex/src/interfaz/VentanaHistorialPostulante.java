package interfaz;

import dominio.*;
import static java.awt.Color.*;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VentanaHistorialPostulante extends javax.swing.JFrame implements Observer {

    public VentanaHistorialPostulante(Sistema sistema) {
        initComponents();
        modelo = sistema; // Sistema de la aplicacion.
        cargarPostulantes(); // Metodo para cargar la lista de postulantes en la interfaz.
        originalTableModel = (DefaultTableModel) tblBuscador.getModel(); // Guarda el modelo de la tabla tblBuscador.

        // Este listener se activara cuando se presione el boton de busqueda.
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBuscarActionPerformed(evt); // Llama al metodo btnBuscarActionPerformed cuando se produce el evento.
            }
        });

        resetearTabla(); // Llama al metodo para volver al estado inicial de la tabla.
    }

    // Metodo para cargar y mostrar la lista de postulantes en la interfaz.
    private void cargarPostulantes() {
        DefaultListModel<String> model = new DefaultListModel<>(); // Crea un modelo de lista para los postulantes.
        // Obtiene la lista de postulantes del sistema.
        List<Postulante> postulantes = new ArrayList<>(modelo.getListaPostulantes());

        // Ordena los postulantes por su cedula.
        postulantes.sort(Comparator.comparing(Postulante::getCedula));

        for (Postulante postulante : postulantes) {
            // Agrega cada postulante a la lista.
            model.addElement(postulante.getNombre() + " (" + postulante.getCedula() + ")");
        }
        
        // Establece el modelo de la lista con los postulantes cargados.
        listaPostulantes.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaPostulantes = new javax.swing.JList();
        jLabelPostulantes = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCedula = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        jLabelLinkedin = new javax.swing.JLabel();
        jLabelFormato = new javax.swing.JLabel();
        jLabelFormato1 = new javax.swing.JLabel();
        outFormato = new javax.swing.JLabel();
        outNombre = new javax.swing.JLabel();
        outCedula = new javax.swing.JLabel();
        outDireccion = new javax.swing.JLabel();
        outTelefono = new javax.swing.JLabel();
        outMail = new javax.swing.JLabel();
        outLinkedin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBuscar = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnResetear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscador = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        outListaExp = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(689, 350));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Historial Postulante");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(320, 10, 235, 33);

        listaPostulantes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPostulantesValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(listaPostulantes);

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(50, 90, 320, 350);

        jLabelPostulantes.setText("Postulantes:");
        jPanel1.add(jLabelPostulantes);
        jLabelPostulantes.setBounds(50, 60, 90, 16);

        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre);
        jLabelNombre.setBounds(450, 60, 70, 16);

        jLabelCedula.setText("Cédula:");
        jPanel1.add(jLabelCedula);
        jLabelCedula.setBounds(450, 100, 60, 16);

        jLabelDireccion.setText("Dirección:");
        jPanel1.add(jLabelDireccion);
        jLabelDireccion.setBounds(450, 140, 80, 16);

        jLabelTelefono.setText("Teléfono:");
        jPanel1.add(jLabelTelefono);
        jLabelTelefono.setBounds(450, 180, 70, 16);

        jLabelMail.setText("Mail:");
        jPanel1.add(jLabelMail);
        jLabelMail.setBounds(450, 220, 50, 16);

        jLabelLinkedin.setText("LinkedIn:");
        jPanel1.add(jLabelLinkedin);
        jLabelLinkedin.setBounds(450, 260, 70, 16);

        jLabelFormato.setText("Experiencia:");
        jPanel1.add(jLabelFormato);
        jLabelFormato.setBounds(450, 340, 80, 16);

        jLabelFormato1.setText("Formato:");
        jPanel1.add(jLabelFormato1);
        jLabelFormato1.setBounds(450, 300, 70, 16);

        outFormato.setText("Sin datos.");
        jPanel1.add(outFormato);
        outFormato.setBounds(530, 300, 290, 16);

        outNombre.setText("Sin datos.");
        jPanel1.add(outNombre);
        outNombre.setBounds(530, 60, 290, 16);

        outCedula.setText("Sin datos.");
        jPanel1.add(outCedula);
        outCedula.setBounds(530, 100, 290, 16);

        outDireccion.setText("Sin datos.");
        jPanel1.add(outDireccion);
        outDireccion.setBounds(530, 140, 290, 16);

        outTelefono.setText("Sin datos.");
        jPanel1.add(outTelefono);
        outTelefono.setBounds(530, 180, 290, 16);

        outMail.setText("Sin datos.");
        jPanel1.add(outMail);
        outMail.setBounds(530, 220, 290, 16);

        outLinkedin.setText("Sin datos.");
        outLinkedin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outLinkedinMouseClicked(evt);
            }
        });
        jPanel1.add(outLinkedin);
        outLinkedin.setBounds(530, 260, 290, 16);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(50, 460, 770, 10);

        jLabelBuscar.setText("Buscar:");
        jPanel1.add(jLabelBuscar);
        jLabelBuscar.setBounds(50, 480, 38, 20);
        jPanel1.add(txtBuscador);
        txtBuscador.setBounds(100, 480, 220, 22);

        btnResetear.setText("Resetar");
        btnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearActionPerformed(evt);
            }
        });
        jPanel1.add(btnResetear);
        btnResetear.setBounds(440, 480, 100, 23);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(330, 480, 100, 23);

        tblBuscador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro", "Evaluador", "Puntaje", "Comentarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBuscador.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tblBuscadorComponentResized(evt);
            }
        });
        jScrollPane3.setViewportView(tblBuscador);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(50, 512, 770, 400);

        jScrollPane4.setViewportView(outListaExp);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(530, 340, 290, 100);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(750, 920, 72, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 980);

        setBounds(300, 200, 866, 988);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBuscadorComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblBuscadorComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBuscadorComponentResized

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void listaPostulantesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPostulantesValueChanged
        mostrarDatos();
    }//GEN-LAST:event_listaPostulantesValueChanged

    // Metodo para mostrar los datos del postulante seleccionado en la interfaz.
    public void mostrarDatos() {
        ArrayList<String> res = new ArrayList<>();
        
        // Verifica si hay un postulante seleccionado en la lista.
        if (listaPostulantes.getSelectedValue() != null) {
            Postulante selected = null;
            String selectedPost = listaPostulantes.getSelectedValue().toString();
            
            // Extrae la cEdula del postulante seleccionado del texto.
            int posIni = selectedPost.indexOf(" (");
            int posEnd = selectedPost.indexOf(")");
            String selectedCedula = selectedPost.substring(posIni + 2, posEnd);
            
            // Busca el postulante correspondiente en la lista del sistema.
            ArrayList<Postulante> list = modelo.getListaPostulantes();
            for (Postulante post : list) {
                if (selectedCedula.equals(post.getCedula())) {
                    selected = post;
                }
            }

            // Muestra la informaciOn del postulante seleccionado en la interfaz.
            outNombre.setText(selected.getNombre());
            outCedula.setText(selected.getCedula());
            outDireccion.setText(selected.getDireccion());
            outTelefono.setText(selected.getTelefono());
            outMail.setText(selected.getMail());
            outLinkedin.setText(selected.getLinkedin());
            outFormato.setText(selected.getFormato());

            // Itera sobre la experiencia del postulante y la agrega a la lista de experiencia.
            Map<Tematica, Integer> mapExp = selected.getConocimientos();
            for (Map.Entry<Tematica, Integer> entry : mapExp.entrySet()) {
                Tematica tema = entry.getKey();
                Integer nivel = entry.getValue();
                res.add(tema.getNombre() + " (" + nivel + ")");
            }
            outListaExp.setListData(res.toArray());

            // Carga las entrevistas del postulante seleccionado.
            cargarEntrevistas(selected, modelo);
        } else {
            // Si no hay postulante seleccionado, se muestra "Sin datos" en los campos de informacion.
            outNombre.setText("Sin datos.");
            outCedula.setText("Sin datos.");
            outDireccion.setText("Sin datos.");
            outTelefono.setText("Sin datos.");
            outMail.setText("Sin datos.");
            outLinkedin.setText("Sin datos.");
            outFormato.setText("Sin datos.");
            
            // Limpia la lista de experiencia y resetea la tabla de entrevistas.
            res.clear();
            outListaExp.setListData(res.toArray());
            resetearTabla();
        }

        // Establece el estilo del enlace de LinkedIn si hay un enlace disponible.
        if (!"Sin datos.".equals(outLinkedin.getText())) {
            Font font = outLinkedin.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            // Configura el enlace como subrayado y en color azul.
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            outLinkedin.setFont(font.deriveFont(attributes));
            outLinkedin.setForeground(blue);
        } else {
            // Restablece el estilo del enlace de LinkedIn si no hay enlace.
            Font font = outLinkedin.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, null);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            outLinkedin.setFont(font.deriveFont(attributes));
            outLinkedin.setForeground(null);
        }
    }

    // Metodo que se ejecuta al hacer clic en el enlace de LinkedIn en la interfaz.
    private void outLinkedinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outLinkedinMouseClicked
        // Obtiene el URL de LinkedIn del postulante mostrado en la interfaz.
        String linkedinURL = outLinkedin.getText();
        if (linkedinURL.startsWith("https://")) {
            try {
                // Intenta abrir el enlace de LinkedIn en el navegador.
                Desktop.getDesktop().browse(new URI(linkedinURL));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_outLinkedinMouseClicked

    // Metodo para manejar la busqueda cuando se presiona el boton "Buscar".
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Obtiene el texto ingresado en el campo de busqueda y lo convierte a minusculas.
        String textoBusqueda = txtBuscador.getText().toLowerCase();
        // Crea un TableRowSorter para el modelo de la tabla tblBuscador.
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblBuscador.getModel());
        // Asigna el sorter a la tabla tblBuscador.
        tblBuscador.setRowSorter(sorter);

        // Limpia los posibles formatos HTML previos en la tabla (para evitar textos erroneos).
        limpiarHTML();
        
        // Si el texto de busqueda no esta vacio, aplica el filtro en la tabla
        if (!textoBusqueda.isEmpty()) {
            // Establece un filtro de fila en el sorter que busca el texto en la columna de comentarios (índice 3).
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(textoBusqueda), 3));

            // Itera en las filas de la tabla y resalta el texto buscado.
            for (int i = 0; i < tblBuscador.getRowCount(); i++) {
                // Obtiene el comentario de la fila y resalta las coincidencias.
                String comentario = (String) sorter.getModel().getValueAt(sorter.convertRowIndexToModel(i), 3);
                comentario = comentario.replaceAll("(?i)(" + textoBusqueda + ")", "<font color='red'>$1</font>");
                sorter.getModel().setValueAt("<html>" + comentario + "</html>", sorter.convertRowIndexToModel(i), 3);
            }
        } else {
            // Si el texto de busqueda esta vacio, elimina el filtro de la tabla.
            sorter.setRowFilter(null);

            // Restablece los comentarios a su formato original sin HTML.
            for (int i = 0; i < tblBuscador.getRowCount(); i++) {
                String comentario = (String) sorter.getModel().getValueAt(sorter.convertRowIndexToModel(i), 3);
                comentario = comentario.replaceAll("<html>", "").replaceAll("</html>", "")
                                       .replaceAll("<font color='red'>", "").replaceAll("</font>", "");
                sorter.getModel().setValueAt(comentario, sorter.convertRowIndexToModel(i), 3);
            }
        }
        // Restablece los comentarios a su formato original sin HTML.
        tblBuscador.repaint();
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Metodo para restablecer la vista de la tabla cuando se presiona el boton "Resetear".
    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetearActionPerformed
        // Limpia el campo de texto del buscador.
        txtBuscador.setText("");
        // Obtiene el TableRowSorter actualmente asignado a la tabla tblBuscador.
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tblBuscador.getRowSorter();
        // Elimina cualquier filtro aplicado a la tabla, mostrando todas las filas.
        sorter.setRowFilter(null);
        
        // Itera en todas las filas de la tabla.
        for (int i = 0; i < tblBuscador.getRowCount(); i++) {
            // Obtiene el comentario de la fila actual y elimina cualquier formato HTML.
            String comentario = (String) sorter.getModel().getValueAt(sorter.convertRowIndexToModel(i), 3);
            comentario = comentario.replaceAll("<html>", "").replaceAll("</html>", "")
                                   .replaceAll("<font color='red'>", "").replaceAll("</font>", "");
            // Actualiza el comentario en la fila con el formato original sin resaltado.
            sorter.getModel().setValueAt(comentario, sorter.convertRowIndexToModel(i), 3);
        }
        // Refresca la tabla para mostrar los cambios realizados.
        tblBuscador.repaint();
    }//GEN-LAST:event_btnResetearActionPerformed
    
    // Metodo para eliminar el formato HTML de los comentarios en la tabla.
    private void limpiarHTML(){
        // Obtiene el sorter actual de la tabla.
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tblBuscador.getRowSorter();

        // Elimina cualquier filtro aplicado.
        sorter.setRowFilter(null);

        // Itera en todas las filas de la tabla.
        for (int i = 0; i < tblBuscador.getRowCount(); i++) {
            // Obtiene el comentario de la fila y elimina el formato HTML.
            String comentario = (String) sorter.getModel().getValueAt(sorter.convertRowIndexToModel(i), 3);

            comentario = comentario.replaceAll("<html>", "").replaceAll("</html>", "")
                                   .replaceAll("<font color='red'>", "").replaceAll("</font>", "");

            // Actualiza el comentario en la fila sin formato HTML.
            sorter.getModel().setValueAt(comentario, sorter.convertRowIndexToModel(i), 3);
        }

        // Refresca la tabla para mostrar los cambios.
        tblBuscador.repaint();
    }
    
    // Metodo para cargar las entrevistas de un postulante seleccionado en la tabla.
    private void cargarEntrevistas(Postulante postulante, Sistema modelo) {
        // Obtiene y limpia el modelo de la tabla.
        DefaultTableModel tableModel = (DefaultTableModel) tblBuscador.getModel();
        tableModel.setRowCount(0);

        // Obtiene y ordena las entrevistas del postulante.
        List<Entrevista> entrevistas = postulante.getEntrevistas(modelo);
        Collections.sort(entrevistas, Comparator.comparingInt(Entrevista::getNumero));

        // Añade cada entrevista a la tabla.
        for (Entrevista entrevista : entrevistas) {
            Object[] rowData = new Object[]{
                entrevista.getNumero(),
                entrevista.getEvaluador().getNombre(),
                entrevista.getPuntaje(),
                entrevista.getComentarios()
            };
            tableModel.addRow(rowData);
        }
    }

    // Metodo para restablecer la tabla de entrevistas a su estado original.
    private void resetearTabla() {
        // Obtiene el modelo actual de la tabla y lo limpia.
        DefaultTableModel currentModel = (DefaultTableModel) tblBuscador.getModel();
        currentModel.setRowCount(0);

        // Agrega cada fila del modelo original de la tabla al modelo actual.
        for (int i = 0; i < originalTableModel.getRowCount(); i++) {
            Vector rowData = (Vector) originalTableModel.getDataVector().get(i);
            currentModel.addRow(rowData);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnResetear;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelFormato1;
    private javax.swing.JLabel jLabelLinkedin;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPostulantes;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listaPostulantes;
    private javax.swing.JLabel outCedula;
    private javax.swing.JLabel outDireccion;
    private javax.swing.JLabel outFormato;
    private javax.swing.JLabel outLinkedin;
    private javax.swing.JList outListaExp;
    private javax.swing.JLabel outMail;
    private javax.swing.JLabel outNombre;
    private javax.swing.JLabel outTelefono;
    private javax.swing.JTable tblBuscador;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private DefaultTableModel originalTableModel;

    @Override
    public void update(Observable o, Object arg) {
        cargarPostulantes();
        resetearTabla();
    }
}
