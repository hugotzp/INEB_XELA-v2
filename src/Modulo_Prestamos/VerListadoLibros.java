/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Prestamos;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Wilson Xicará
 */
public class VerListadoLibros extends javax.swing.JDialog {
    private Connection conexion;
    private boolean hacerVisible;
    private ArrayList<Integer> listaIDLibros;
    private TableRowSorter filtroTabla;
    private int indexLibroEditado;
    /**
     * Creates new form VerListadoLibros
     */
    public VerListadoLibros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public VerListadoLibros(java.awt.Frame parent, Connection conexion) {
        super(parent, true);
        initComponents();
        this.conexion = conexion;
        hacerVisible = true;
        
        // Obtengo la información de todos los Libros guardados en la Base de Datos
        try {
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet cConsulta = sentencia.executeQuery("SELECT * FROM Libro");
            listaIDLibros = new ArrayList<>();
            int contador = 0;
            DefaultTableModel modelLibros = (DefaultTableModel)tabla_libros.getModel();
            while(cConsulta.next()) {
                listaIDLibros.add(cConsulta.getInt("Id"));
                modelLibros.addRow(new String[]{
                    ""+(++contador),
                    cConsulta.getString("Codigo"),
                    cConsulta.getString("Nombre"),
                    cConsulta.getString("Autor")==null ? "<Sin especificar>" : cConsulta.getString("Autor"),
                    cConsulta.getString("Editorial")==null ? "<Sin especificar>" : cConsulta.getString("Editorial"),
                    estado_libro.getItemAt(cConsulta.getInt("Estado")-1),
                    cConsulta.getInt("Estado")==6 ? "<No asignado>" : cConsulta.getString("PaqueteLibro_Id")
                });
            }
            // Otras configuraciones importantes
            filtroTabla = new TableRowSorter(tabla_libros.getModel()); // Objeto que permite filtrar filas de la Tabla
            tabla_libros.setShowHorizontalLines(true);  // Para mostrar los bordes de las celdas de la tabla
            tabla_libros.setShowVerticalLines(true);
            panel_datos_libro.setVisible(false);
            this.setLocationRelativeTo(null);   // Para centrar esta ventana sobre la pantalla
        } catch (SQLException ex) {
            hacerVisible = false;
            JOptionPane.showMessageDialog(this, "No se puede extraer alguno de los registros.\n\nDescripción:\n"+ex.getMessage(), "Error en conexión", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VerListadoLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_datos_libro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigo_libro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombre_libro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        autor_libro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        editorial_libro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        estado_libro = new javax.swing.JComboBox<>();
        aceptar_edicion_libro = new javax.swing.JButton();
        cancelar_edicion_libro = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_libros = new javax.swing.JTable();
        editar_libro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        filtrar_por = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        valor_a_filtrar = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Libros registrados");

        panel_datos_libro.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Libro seleccionado"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        codigo_libro.setEditable(false);
        codigo_libro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigo_libroKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setText("Autor:");

        jLabel4.setText("Editorial:");

        jLabel5.setText("Estado:");

        estado_libro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Excelente", "Bueno", "Medio", "Malo", "Muy malo", "Inservible" }));
        estado_libro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                estado_libroItemStateChanged(evt);
            }
        });

        aceptar_edicion_libro.setText("Aceptar");
        aceptar_edicion_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_edicion_libroActionPerformed(evt);
            }
        });

        cancelar_edicion_libro.setText("Cancelar");
        cancelar_edicion_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_edicion_libroActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Los campos en negrita son obligatorios");

        javax.swing.GroupLayout panel_datos_libroLayout = new javax.swing.GroupLayout(panel_datos_libro);
        panel_datos_libro.setLayout(panel_datos_libroLayout);
        panel_datos_libroLayout.setHorizontalGroup(
            panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datos_libroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(aceptar_edicion_libro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar_edicion_libro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_datos_libroLayout.createSequentialGroup()
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_datos_libroLayout.createSequentialGroup()
                        .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estado_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(editorial_libro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(autor_libro, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jLabel9))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_datos_libroLayout.setVerticalGroup(
            panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datos_libroLayout.createSequentialGroup()
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(autor_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editorial_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(estado_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datos_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar_edicion_libro)
                    .addComponent(aceptar_edicion_libro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Libros registrados"));

        tabla_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Código", "Nombre", "Autor", "Editorial", "Estado", "Código de Paquete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_libros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_librosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_libros);

        editar_libro.setText("Editar");
        editar_libro.setEnabled(false);
        editar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_libroActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtrar por:");

        filtrar_por.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "Código Libro", "Nombre", "Autor", "Editorial", "Estado", "Código Paquete" }));

        jLabel7.setText("Valor:");

        valor_a_filtrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valor_a_filtrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar_libro)
                .addGap(205, 205, 205))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtrar_por, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valor_a_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(filtrar_por, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(valor_a_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editar_libro))
        );

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_datos_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(regresar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresar)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_datos_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valor_a_filtrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valor_a_filtrarKeyReleased
        String valor = valor_a_filtrar.getText();
        if (valor.length() != 0) {
            int filtro = filtrar_por.getSelectedIndex();    // Obtengo el tipo de filtro en el que se basará la búsqueda
            // Si filtro==0 se buscará cualquier coincidencia (Código, Nombre, ...). En caso contrario, se busca en la columna 'filtro'
            if (filtro == 0)
                filtroTabla.setRowFilter(RowFilter.regexFilter(valor));
            else
                filtroTabla.setRowFilter(RowFilter.regexFilter(valor, filtro));
            tabla_libros.setRowSorter(filtroTabla);
            if (editar_libro.isEnabled())   // Al filtrar las filas, se pierde la última fila seleccionada
                editar_libro.setEnabled(false);
        }
    }//GEN-LAST:event_valor_a_filtrarKeyReleased

    private void tabla_librosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_librosMousePressed
        if (!editar_libro.isEnabled())
            editar_libro.setEnabled(true);
    }//GEN-LAST:event_tabla_librosMousePressed

    private void editar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_libroActionPerformed
        // Inhabilito la tabla y este botón para evitar que se seleccione otro registro
        tabla_libros.setEnabled(false);
        editar_libro.setEnabled(false);
        filtrar_por.setEnabled(false);
        valor_a_filtrar.setEnabled(false);
        // Cargo los datos del libro seleccionado en los campos correspondientes y los muestro
        indexLibroEditado = filtroTabla.convertRowIndexToModel(tabla_libros.getSelectedRow());
        DefaultTableModel modelLibros = (DefaultTableModel)tabla_libros.getModel();
        codigo_libro.setText(modelLibros.getValueAt(indexLibroEditado, 1).toString());
        nombre_libro.setText(modelLibros.getValueAt(indexLibroEditado, 2).toString());
        autor_libro.setText("<Sin especificar>".equals(modelLibros.getValueAt(indexLibroEditado, 3).toString()) ? "" : modelLibros.getValueAt(indexLibroEditado, 3).toString());
        editorial_libro.setText("<Sin especificar>".equals(modelLibros.getValueAt(indexLibroEditado, 4).toString()) ? "" : modelLibros.getValueAt(indexLibroEditado, 4).toString());
        estado_libro.setSelectedItem(modelLibros.getValueAt(indexLibroEditado, 5).toString());
        panel_datos_libro.setVisible(true);
    }//GEN-LAST:event_editar_libroActionPerformed

    private void codigo_libroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo_libroKeyTyped
        if (codigo_libro.getText().length() == 5)
            evt.consume();
    }//GEN-LAST:event_codigo_libroKeyTyped

    private void estado_libroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_estado_libroItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && estado_libro.getSelectedIndex()==(estado_libro.getItemCount()-1)) {
            JOptionPane.showMessageDialog(this, "Marcar este libro como 'INSERVIBLE' eliminará el libro del paquete donde está actualmente.\nMás adelante, sólo desde aquí podrá volver a visualizar y editar la información de este libro.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_estado_libroItemStateChanged

    private void aceptar_edicion_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_edicion_libroActionPerformed
        // El Código del Libro no puede ser editado
        if (nombre_libro.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Asigne un nombre al Libro", "Error en datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Se editará el registro en la Base de Datos
        try {
            String instruccion = "UPDATE Libro SET"
                    + " Nombre = '"+nombre_libro.getText()+"', "
                    + " Autor = "+(autor_libro.getText().length()==0 ? "NULL" : "'"+autor_libro.getText()+"'")+", "
                    + " Editorial = "+(editorial_libro.getText().length()==0 ? "NULL" : "'"+editar_libro.getText()+"'")+", "
                    + " Estado = '"+(estado_libro.getSelectedIndex()+1)+"'"
                    + " WHERE Id = "+listaIDLibros.get(indexLibroEditado);
            conexion.prepareStatement(instruccion).executeUpdate();
            JOptionPane.showMessageDialog(this, "Cambios guardados con éxito", "Editar registro", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel modelLibros = (DefaultTableModel)tabla_libros.getModel();
            modelLibros.setValueAt(nombre_libro.getText(), indexLibroEditado, 2);   // Actualizo los datos en la Tabla
            modelLibros.setValueAt(autor_libro.getText().length()==0 ? "<Sin especificar>" : autor_libro.getText(), indexLibroEditado, 3);
            modelLibros.setValueAt(editorial_libro.getText().length()==0 ? "<Sin especificar>" : editorial_libro.getText(), indexLibroEditado, 4);
            modelLibros.setValueAt(estado_libro.getSelectedItem().toString(), indexLibroEditado, 5);
            modelLibros.setValueAt(estado_libro.getSelectedIndex()==(estado_libro.getItemCount()-1) ? "<No asignado>" : modelLibros.getValueAt(indexLibroEditado, 6).toString(), indexLibroEditado, 6);
            limpiar_campos_libro();     // Limpio los campos del Libro
            tabla_libros.setEnabled(true);  // Habilito la tabla y los componentes relacionado a él
            tabla_libros.removeRowSelectionInterval(0, tabla_libros.getRowCount()-1);
            filtrar_por.setEnabled(true);
            valor_a_filtrar.setEnabled(true);
            panel_datos_libro.setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede actualizar el registro.\n\nDescripción:\n"+ex.getMessage(), "Error en conexión", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VerListadoLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptar_edicion_libroActionPerformed

    private void cancelar_edicion_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_edicion_libroActionPerformed
        limpiar_campos_libro(); // Limpio los campos
        tabla_libros.setEnabled(true);  // Habilito la tabla y los componentes relacionado a él
        editar_libro.setEnabled(true);
        filtrar_por.setEnabled(true);
        valor_a_filtrar.setEnabled(true);
        panel_datos_libro.setVisible(false);
    }//GEN-LAST:event_cancelar_edicion_libroActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    public boolean getHacerVisible() { return hacerVisible; }
    private void limpiar_campos_libro() {
        codigo_libro.setText("");
        nombre_libro.setText("");
        autor_libro.setText("");
        editorial_libro.setText("");
        estado_libro.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerListadoLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerListadoLibros dialog = new VerListadoLibros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar_edicion_libro;
    private javax.swing.JTextField autor_libro;
    private javax.swing.JButton cancelar_edicion_libro;
    private javax.swing.JTextField codigo_libro;
    private javax.swing.JButton editar_libro;
    private javax.swing.JTextField editorial_libro;
    private javax.swing.JComboBox<String> estado_libro;
    private javax.swing.JComboBox<String> filtrar_por;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre_libro;
    private javax.swing.JPanel panel_datos_libro;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tabla_libros;
    private javax.swing.JTextField valor_a_filtrar;
    // End of variables declaration//GEN-END:variables
}