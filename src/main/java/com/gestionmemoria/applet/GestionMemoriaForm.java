
package com.gestionmemoria.applet;

import com.gestionmemoria.controlador.ModeloMemoria;
import com.gestionmemoria.controlador.Particion;
import com.gestionmemoria.controlador.ParticionesFijas;
import com.gestionmemoria.controlador.Proceso;
import com.gestionmemoria.controlador.TablaProcesoCellRender;
import com.gestionmemoria.utils.Constants;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestionMemoriaForm extends javax.swing.JFrame {
     
    private ModeloMemoria modelo = null;
    private DefaultTableModel tablaParticionesModel;
    private DefaultTableModel tablaProcesosModel;

 
    public GestionMemoriaForm() {
        initComponents();
        initValoresComponentes();
    }

    private void initValoresComponentes(){
        this.comboModelosMemoria.setModel
            (new javax.swing.DefaultComboBoxModel<>
            (new String[] { Constants.SELECCIONE,
                            Constants.MODEL_PARTICION_EFIJA, 
                            Constants.MODEL_PARTICION_EDINAMICA, 
                            Constants.MODEL_PARTICION_DINAMICA,
                            Constants.MODEL_SEGMENTACION,
                            Constants.MODEL_PAGINACION
                            }));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMemoria = new javax.swing.JPanel();
        jBotonComenzarSimulacion = new javax.swing.JButton();
        comboModelosMemoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCantidadParticiones = new javax.swing.JTextField();
        jBotonCrearParticiones = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBotonCrearProceso = new javax.swing.JButton();
        jTextNombreProceso = new javax.swing.JTextField();
        jTextProceso = new javax.swing.JTextField();
        jTextDataProceso = new javax.swing.JTextField();
        jTextBss = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelTablaParticiones = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParticiones = new javax.swing.JTable();
        jPanelTablaParticiones1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProcesos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMemoria.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMemoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelMemoriaLayout = new javax.swing.GroupLayout(jPanelMemoria);
        jPanelMemoria.setLayout(jPanelMemoriaLayout);
        jPanelMemoriaLayout.setHorizontalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanelMemoriaLayout.setVerticalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        jBotonComenzarSimulacion.setText("Comenzar Simulación");
        jBotonComenzarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonComenzarSimulacionActionPerformed(evt);
            }
        });

        comboModelosMemoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        comboModelosMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelosMemoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Modelo Gestión Memoria:");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setText("Configuración Modelo");

        jLabel4.setText("Cantidad de Particiones:");

        jBotonCrearParticiones.setText("Crear Particiones");
        jBotonCrearParticiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCrearParticionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCantidadParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBotonCrearParticiones))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCantidadParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonCrearParticiones)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setText("Configuración Procesos");

        jLabel6.setText("Nombre Proceso:");

        jLabel7.setText("Tamaño .text:");

        jLabel8.setText("Tamaño .data:");

        jLabel9.setText("Tamaño bss:");

        jBotonCrearProceso.setText("Crear Proceso");
        jBotonCrearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCrearProcesoActionPerformed(evt);
            }
        });

        jLabel10.setText("MBs");

        jLabel11.setText("MBs");

        jLabel12.setText("MBs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextBss, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextDataProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addComponent(jTextNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))))
                    .addComponent(jBotonCrearProceso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextDataProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextBss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jBotonCrearProceso)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanelTablaParticiones.setBackground(new java.awt.Color(102, 204, 255));

        jLabel5.setText("Tabla de Particiones");

        jTableParticiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Memoria Base Bytes", "Memoria Limite Bytes", "Dirección Memoria Base", "Dirección Memoria Limite", "Mbs", "Proceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableParticiones);

        javax.swing.GroupLayout jPanelTablaParticionesLayout = new javax.swing.GroupLayout(jPanelTablaParticiones);
        jPanelTablaParticiones.setLayout(jPanelTablaParticionesLayout);
        jPanelTablaParticionesLayout.setHorizontalGroup(
            jPanelTablaParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaParticionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30))
        );
        jPanelTablaParticionesLayout.setVerticalGroup(
            jPanelTablaParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaParticionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanelTablaParticiones1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel13.setText("Tabla de Procesos");

        jTableProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Proceso", "Tamaño .text", "Tamaño data", "Tamaño bss", "Tiempo Ejecucion (seg)", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableProcesos);

        javax.swing.GroupLayout jPanelTablaParticiones1Layout = new javax.swing.GroupLayout(jPanelTablaParticiones1);
        jPanelTablaParticiones1.setLayout(jPanelTablaParticiones1Layout);
        jPanelTablaParticiones1Layout.setHorizontalGroup(
            jPanelTablaParticiones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaParticiones1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaParticiones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTablaParticiones1Layout.setVerticalGroup(
            jPanelTablaParticiones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaParticiones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboModelosMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jBotonComenzarSimulacion)
                        .addGap(139, 139, 139)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTablaParticiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTablaParticiones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboModelosMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jBotonComenzarSimulacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTablaParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTablaParticiones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonComenzarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonComenzarSimulacionActionPerformed
        if(validarComienzoSimulacion()){
//          List<Thread> hilosEjecucion = 
                  modelo.gestionarMemoria(tablaProcesosModel, tablaParticionesModel);
//            for (Thread hilo : hilosEjecucion) {
//                hilo.start();
//            }
        }
    }//GEN-LAST:event_jBotonComenzarSimulacionActionPerformed

    public boolean validarComienzoSimulacion(){
        boolean validacion = true;
        if(modelo == null){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un modelo de gestión de memoria","Error" , JOptionPane.WARNING_MESSAGE);
            validacion = false;
        }else{
            if(modelo.getMemoria().getParticionesUsuario().isEmpty()){
                JOptionPane.showMessageDialog(this,"Debe crear al menos una partición","Error" , JOptionPane.WARNING_MESSAGE);
                validacion = false;
            }
            if(modelo.getProcesos().isEmpty()){
                JOptionPane.showMessageDialog(this,"Debe ingresar al menos un proceso","Error" , JOptionPane.WARNING_MESSAGE);
                validacion = false;
            }
        }
        return validacion;
    }
    private void comboModelosMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelosMemoriaActionPerformed
        String modeloSeleccionado = (String)((JComboBox)evt.getSource()).getSelectedItem();
        switch (modeloSeleccionado) {
            case Constants.MODEL_PARTICION_EFIJA:
                modelo = new ParticionesFijas();
            break;
            default: 
                System.out.println("No seleccionado");
            break;
        }
        jPanelMemoria.add(modelo.getMemoria().particionOS.getPanelParticionUI().getPanelParticion());
        jPanelMemoria.validate();
        jPanelMemoria.repaint();
    }//GEN-LAST:event_comboModelosMemoriaActionPerformed

    private void jBotonCrearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCrearProcesoActionPerformed
        try {
            double data = Double.parseDouble(jTextDataProceso.getText());
            double text = Double.parseDouble(jTextProceso.getText());
            double bss = Double.parseDouble(jTextBss.getText());
            double cantidadMemoriaProceso = data+text+bss;
            Proceso proceso = new Proceso(modelo.getIdProcesos(), jTextNombreProceso.getText(), data, text, bss,cantidadMemoriaProceso,Constants.ESTADO_LISTO);
            modelo.getProcesos().add(proceso);
            tablaProcesosModel = (DefaultTableModel)jTableProcesos.getModel();
            jTableProcesos.setDefaultRenderer(Object.class, new TablaProcesoCellRender());
            Object [] registroProceso = {jTextNombreProceso.getText(),data+"" ,text+"",bss+"",proceso.getTiempoEjecucion()+"",Constants.ESTADO_LISTO};
            tablaProcesosModel.addRow(registroProceso);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Los campos Tamaño .text , Tamaño .data y Tamaño bss deben ser numericos decimales.","Error" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBotonCrearProcesoActionPerformed

    private void jBotonCrearParticionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCrearParticionesActionPerformed
        if(textCantidadParticiones.getText() != null && !textCantidadParticiones.getText().isEmpty()){
            try {
                modelo.getMemoria().setCantidadParticiones(Integer.parseInt(textCantidadParticiones.getText()));
                modelo.particionarMemoria();
                if (modelo.getMemoria().getParticionesUsuario() != null && !modelo.getMemoria().getParticionesUsuario().isEmpty()) {
                    for (Particion particion : modelo.getMemoria().getParticionesUsuario()) {
                        jPanelMemoria.add(particion.getPanelParticionUI().getPanelParticion());
                    }
                    jPanelMemoria.validate();
                    jPanelMemoria.repaint();
                }
                llenarTablaParticiones();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El campo cantidad de particiones debe ser numerico entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "El campo cantidad de particiones es obligatorio", "Error", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_jBotonCrearParticionesActionPerformed

    private void llenarTablaParticiones(){
        if(!modelo.getMemoria().getParticionesUsuario().isEmpty()){
            tablaParticionesModel = (DefaultTableModel)jTableParticiones.getModel();
            for (Particion particion : modelo.getMemoria().getParticionesUsuario()) {
                Object [] registroParticion = {particion.getNombre(),particion.getDireccionInicio(),particion.getDireccionFin(),particion.getDireccionInicioHexa(),particion.getDireccionFinHexa(),particion.getTotalMemoriaParticion(),""};
                tablaParticionesModel.addRow(registroParticion);
            }
        }
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
            java.util.logging.Logger.getLogger(GestionMemoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionMemoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionMemoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionMemoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionMemoriaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboModelosMemoria;
    private javax.swing.JButton jBotonComenzarSimulacion;
    private javax.swing.JButton jBotonCrearParticiones;
    private javax.swing.JButton jBotonCrearProceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMemoria;
    private javax.swing.JPanel jPanelTablaParticiones;
    private javax.swing.JPanel jPanelTablaParticiones1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableParticiones;
    private javax.swing.JTable jTableProcesos;
    private javax.swing.JTextField jTextBss;
    private javax.swing.JTextField jTextDataProceso;
    private javax.swing.JTextField jTextNombreProceso;
    private javax.swing.JTextField jTextProceso;
    private javax.swing.JTextField textCantidadParticiones;
    // End of variables declaration//GEN-END:variables
}
