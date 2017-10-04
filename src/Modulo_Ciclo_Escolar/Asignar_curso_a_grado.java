/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ciclo_Escolar;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Asignar_curso_a_grado extends javax.swing.JDialog {
    Connection base;
    String ciclo;
    ArrayList<String> Id_grado,Id_curso,Id_catedratico;
   
    ArrayList<String> Nombres,apellidos;
    //Contiene informacion de las relaciones que se tienen en la base
    ArrayList<String> conjunto_actuales, conjunto_agregados,conjunto_borrados;
    ArrayList<String[]> id_conjunto_actuales,id_conjunto_agregados,id_conjunto_borrados;
    int posicion =0,pos_cur,pos_cat,pos_tab;
    /**
     * Creates new form Asignar_curso_a_grado
     */
    public Asignar_curso_a_grado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public Asignar_curso_a_grado(java.awt.Frame parent, boolean modal,Connection base, String ciclo, String nombreCiclo) throws SQLException {
        super(parent, modal);
        initComponents();
        this.base = base;
        this.ciclo = ciclo;
        Id_grado = new ArrayList<>();
        Id_curso = new ArrayList<>();
        Id_catedratico = new ArrayList<>();
        id_conjunto_actuales = new ArrayList<>();
        id_conjunto_agregados = new ArrayList<>();
        id_conjunto_borrados = new ArrayList<>();
        conjunto_actuales = new ArrayList<>();
        conjunto_agregados = new ArrayList<>();
        conjunto_borrados = new ArrayList<>();
        pos_cur = 0;
        pos_cat = 0;
        pos_tab= -1;
        //Agrego todos los grados al combobox
        Statement a = base.createStatement();
        ResultSet consulta = a.executeQuery("SELECT  grado.*  FROM asignacioncat INNER JOIN grado ON asignacioncat.Grado_Id = grado.Id INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Curso_Id is null AND asignacioncat.Catedratico_Id is null;");
        while(consulta.next()){
            String Id = consulta.getString(1);
            String Nombre = consulta.getString(2)+" "+consulta.getString(3);
            Id_grado.add(Id);
            grado.addItem(Nombre);
        }
         //obtengo todos los cursos que corresponden al año seleccionado
        a = base.createStatement();
        consulta = a.executeQuery("SELECT curso.Id, curso.Nombre FROM asignacioncat INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id INNER JOIN curso ON asignacioncat.Curso_Id = Curso.Id WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Grado_Id is null AND asignacioncat.Catedratico_Id is null ORDER BY Curso.Nombre");
        while(consulta.next()){
           String Id = consulta.getString(1);
           String Nombre = consulta.getString(2);
           Id_curso.add(Id);
           Asig_cursos.addItem(Nombre);
        } Asig_cursos.setSelectedIndex(-1);
        //Obtengo todos los catedraticos existentes
        a = base.createStatement();
        consulta = a.executeQuery("SELECT Id, Nombres, Apellidos FROM catedratico ORDER BY Nombres");
        while(consulta.next()){
            String Id = consulta.getString(1);
            String Nombre = consulta.getString(2)+" "+consulta.getString(3);
            Id_catedratico.add(Id);
            Asig_catedraticos.addItem(Nombre);
        } Asig_catedraticos.setSelectedIndex(-1);
        this.setTitle("Asignación de Cursos a Grado del Ciclo Escolar "+nombreCiclo);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox<>();
        regresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cursos = new javax.swing.JTable();
        desasignar_cat_a_curso = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Asig_catedraticos = new javax.swing.JComboBox<>();
        Asig_cursos = new javax.swing.JComboBox<>();
        asignar_cat_a_curso = new javax.swing.JButton();
        guardar_cambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignación de Cursos a Grado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Grado:");

        grado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        grado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gradoItemStateChanged(evt);
            }
        });

        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras(25x26).PNG"))); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos asignados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        Cursos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Curso", "Catedrático asignado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Cursos.setRowHeight(20);
        Cursos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Cursos.getTableHeader().setReorderingAllowed(false);
        Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CursosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CursosMousePressed(evt);
            }
        });
        Cursos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CursosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Cursos);

        desasignar_cat_a_curso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        desasignar_cat_a_curso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar(16x16).png"))); // NOI18N
        desasignar_cat_a_curso.setText("Eliminar Asiganción");
        desasignar_cat_a_curso.setEnabled(false);
        desasignar_cat_a_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desasignar_cat_a_cursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(desasignar_cat_a_curso))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desasignar_cat_a_curso))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Curso :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Catedratico :");

        Asig_catedraticos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Asig_catedraticos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Asig_catedraticosItemStateChanged(evt);
            }
        });

        Asig_cursos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Asig_cursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Asig_cursosItemStateChanged(evt);
            }
        });

        asignar_cat_a_curso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        asignar_cat_a_curso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptar(16x16).png"))); // NOI18N
        asignar_cat_a_curso.setText("Asignar");
        asignar_cat_a_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_cat_a_cursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Asig_cursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Asig_catedraticos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(asignar_cat_a_curso)
                .addGap(139, 139, 139))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Asig_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Asig_catedraticos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(asignar_cat_a_curso)
                .addContainerGap())
        );

        guardar_cambios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        guardar_cambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar(36x36).png"))); // NOI18N
        guardar_cambios.setText("Guardar cambios");
        guardar_cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_cambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresar))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(guardar_cambios))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(regresar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar_cambios)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gradoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            if(conjunto_agregados.size()> 0 || conjunto_borrados.size() > 0){
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, "Desea guardar los cambios realizados", "Cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
                 Guardar_cambios();
                 posicion = grado.getSelectedIndex();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
                 Actualizar_tabla();
            }else{
                 id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
                 posicion = grado.getSelectedIndex();
                Actualizar_tabla();
            }
            }else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               posicion = grado.getSelectedIndex();
                Actualizar_tabla(); 
            }
        }
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, grado.getSelectedIndex()==-1 ? "" : "Cursos Asignados al Grado "+grado.getSelectedItem().toString(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
    }//GEN-LAST:event_gradoItemStateChanged

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
        if(id_conjunto_agregados.size()> 0 || id_conjunto_borrados.size() > 0){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, "Desea guardar los cambios realizados", "Cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               Actualizar_tabla();
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
        
    }//GEN-LAST:event_regresarActionPerformed

    private void asignar_cat_a_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_cat_a_cursoActionPerformed
        if (Asig_cursos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un Curso", "Error en datos", JOptionPane.ERROR_MESSAGE);
            return;
        } if (Asig_catedraticos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un Catedrático", "Error en datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String curso = Asig_cursos.getSelectedItem().toString(), catedratico = Asig_catedraticos.getSelectedItem().toString();
        String curso_cat = curso+" "+catedratico;
        if (conjunto_borrados.contains(curso_cat)){
            int aux = conjunto_borrados.indexOf(curso_cat);
            id_conjunto_borrados.remove(aux);
            conjunto_borrados.remove(aux);
            ((DefaultTableModel)Cursos.getModel()).addRow(new String[]{
                ""+(Cursos.getRowCount()+1), curso, catedratico
            });
            Asig_cursos.setSelectedIndex(-1);
            Asig_catedraticos.setSelectedIndex(-1);
        } else if(!conjunto_actuales.contains(curso_cat)){
            if(!conjunto_agregados.contains(curso_cat)){
                String[] Id = new String[2];
                Id[0] = Id_curso.get(pos_cur);
                Id[1] = Id_catedratico.get(pos_cat);
                id_conjunto_agregados.add(Id);
                conjunto_agregados.add(curso_cat);
                ((DefaultTableModel)Cursos.getModel()).addRow(new String[]{
                    ""+(Cursos.getRowCount()+1), curso, catedratico
                });
                Asig_cursos.setSelectedIndex(-1);
                Asig_catedraticos.setSelectedIndex(-1);
            }else{
                 JOptionPane.showMessageDialog(this, "La asignacion ya se ha hecho con anteioridad", "ERROR", JOptionPane.ERROR_MESSAGE, null);
            }
        }else{
             JOptionPane.showMessageDialog(this, "La asignacion ya se ha hecho con anteioridad", "ERROR", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_asignar_cat_a_cursoActionPerformed

    private void CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosMouseClicked
        pos_tab = Cursos.getSelectedRow();
    }//GEN-LAST:event_CursosMouseClicked

    private void desasignar_cat_a_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desasignar_cat_a_cursoActionPerformed
        int asignacionSelec = Cursos.getSelectedRow();
        eliminar_asignacion(asignacionSelec);
    }//GEN-LAST:event_desasignar_cat_a_cursoActionPerformed

    private void Asig_cursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Asig_cursosItemStateChanged
        pos_cur = Asig_cursos.getSelectedIndex();
    }//GEN-LAST:event_Asig_cursosItemStateChanged

    private void Asig_catedraticosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Asig_catedraticosItemStateChanged
        pos_cat = Asig_catedraticos.getSelectedIndex();
    }//GEN-LAST:event_Asig_catedraticosItemStateChanged

    private void guardar_cambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_cambiosActionPerformed
        if(id_conjunto_agregados.size()> 0 || id_conjunto_borrados.size() > 0){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, "Desea guardar los cambios realizados", "Cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               Actualizar_tabla();
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
    }//GEN-LAST:event_guardar_cambiosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(id_conjunto_agregados.size()> 0 || id_conjunto_borrados.size() > 0){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, "Desea guardar los cambios realizados", "Cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               Actualizar_tabla();
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void CursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosMousePressed
        desasignar_cat_a_curso.setEnabled(true);
    }//GEN-LAST:event_CursosMousePressed

    private void CursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CursosKeyPressed
        int codigoTecla = (int)evt.getKeyChar();
        if (codigoTecla==8 || codigoTecla==127) {   // Son las teclas de Retroceso y Suprimir, respectivamente
            int indexCurso = Cursos.getSelectedRow();
            if (indexCurso != -1)
                eliminar_asignacion(indexCurso);
        }
    }//GEN-LAST:event_CursosKeyPressed

    private void eliminar_asignacion(int indexCurso) {
        String nombre = Cursos.getValueAt(indexCurso, 1) +" "+Cursos.getValueAt(indexCurso, 2);
        if(conjunto_agregados.contains(nombre)){
            int aux = conjunto_agregados.indexOf(nombre);
            conjunto_agregados.remove(aux);
            id_conjunto_agregados.remove(aux);
        }else{
            int aux = conjunto_actuales.indexOf(nombre);
            conjunto_borrados.add(nombre);
            id_conjunto_borrados.add(id_conjunto_actuales.get(aux));
        }
        // Actualización del No. relacionado a cada Asignación que queda
        int cantidad = Cursos.getRowCount();
        for(int fil=indexCurso+1; fil<cantidad; fil++)
            Cursos.setValueAt(""+fil, fil, 0);
        // Eliminación del registro en la tabla donde se muestra
        ((DefaultTableModel)Cursos.getModel()).removeRow(indexCurso);
        pos_tab = -1;
        desasignar_cat_a_curso.setEnabled(false);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Asignar_curso_a_grado dialog = new Asignar_curso_a_grado(new javax.swing.JFrame(), true);
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
    
    public void Actualizar_tabla(){
        try {
            Statement a = base.createStatement();
            ResultSet consulta = a.executeQuery("SELECT  curso.Nombre , catedratico.Nombres, catedratico.Apellidos, curso.Id,catedratico.Id FROM asignacioncat INNER JOIN grado ON asignacioncat.Grado_Id = grado.Id INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id INNER JOIN curso ON asignacioncat.Curso_Id = curso.Id INNER JOIN catedratico ON asignacioncat.Catedratico_Id = catedratico.Id WHERE asignacioncat.CicloEscolar_Id ="+ciclo+" AND asignacioncat.Grado_Id = "+Id_grado.get(posicion)+";");
            DefaultTableModel modelTabla = (DefaultTableModel)Cursos.getModel();
            modelTabla.setRowCount(0);
            int contador = 0;
            while(consulta.next()) {
                modelTabla.addRow(new String[]{
                    ""+(++contador),
                    consulta.getString(1),
                    consulta.getString(2)+" "+consulta.getString(3)
                });
                conjunto_actuales.add(consulta.getString(1)+" "+consulta.getString(2)+" "+consulta.getString(3));
                String[] Id = new String[2];
                Id[0] = consulta.getString(4);
                Id[1] = consulta.getString(5);
                id_conjunto_actuales.add(Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Guardar_cambios(){
        try {
            for (int i = 0; i < id_conjunto_agregados.size(); i++) {
                String[] Id = id_conjunto_agregados.get(i);
                String instruccion_asignacion = "INSERT INTO asignacioncat(asignacioncat.CicloEscolar_Id,asignacioncat.Grado_Id,asignacioncat.Curso_Id,asignacioncat.Catedratico_Id) VALUES("+ciclo+","+Id_grado.get(posicion)+","+Id[0]+","+Id[1]+");";
                PreparedStatement pst = base.prepareStatement(instruccion_asignacion);
                pst.executeUpdate();
            }
            for (int i = 0; i < id_conjunto_borrados.size(); i++) {
                String[] Id = id_conjunto_borrados.get(i);
                String instruccion_asignacion = "DELETE FROM asignacioncat WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Grado_Id = "+Id_grado.get(posicion)+" AND asignacioncat.Curso_Id= "+Id[0] +" AND asignacioncat.Catedratico_Id = "+Id[1]+";";
                PreparedStatement pst = base.prepareStatement(instruccion_asignacion);
                pst.executeUpdate(); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Asig_catedraticos;
    private javax.swing.JComboBox<String> Asig_cursos;
    private javax.swing.JTable Cursos;
    private javax.swing.JButton asignar_cat_a_curso;
    private javax.swing.JButton desasignar_cat_a_curso;
    private javax.swing.JComboBox<String> grado;
    private javax.swing.JButton guardar_cambios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
