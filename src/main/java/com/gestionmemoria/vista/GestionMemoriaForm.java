
package com.gestionmemoria.vista;

import com.gestionmemoria.controlador.Controlador;
import com.gestionmemoria.utils.Constants;
import javax.swing.table.DefaultTableModel;
import com.gestionmemoria.modelo.Modelo;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class GestionMemoriaForm extends javax.swing.JFrame {
     
    private Modelo modelo;
    private Controlador controlador;
    private DefaultTableModel tablaParticionesModel;
    private DefaultTableModel tablaProcesosModel;

 
    public GestionMemoriaForm(Modelo modelo) {
        this.modelo = modelo;
        initComponents();
        initValoresComponentes();
        initValoresAjuste();
        if(modelo.getModeloMemoria() != null ){
            getComboModelosMemoria().setSelectedItem(modelo.getModeloMemoria().getNombreModelo());
        }else{
            getComboModelosMemoria().setSelectedItem(Constants.SELECCIONE);
        }
        registrarEventos();
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
    
     private void initValoresAjuste(){
        this.comboModelosAjuste.setModel
            (new javax.swing.DefaultComboBoxModel<>
            (new String[] { Constants.SELECCIONE,
                            Constants.MEJOR_AJUSTE, 
                            Constants.PRIMER_AJUSTE, 
                            Constants.PEOR_AJUSTE,
                            }));
    }

    public Controlador getControlador() {
        if(controlador == null){
            controlador = new Controlador(this);
        }
        return controlador;
    }
    
    public void registrarEventos(){
        jBotonCrearProceso.addActionListener(getControlador().crearProceso());
        jBotonCrearParticiones.addActionListener(getControlador().crearParticiones());
        comboModelosMemoria.addActionListener(getControlador().seleccionModeloMemoria());
        jBotonComenzarSimulacion.addActionListener(getControlador().lanzarSimulacion());
    }
    
    public Modelo getModel() {
        return modelo;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMemoria = new javax.swing.JPanel();
        jBotonComenzarSimulacion = new javax.swing.JButton();
        comboModelosMemoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        panelConfiguracionParticiones = new javax.swing.JPanel();
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
        comboModelosAjuste = new javax.swing.JComboBox<>();
        JlabelAjuste = new javax.swing.JLabel();
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

        jBotonComenzarSimulacion.setText("Comenzar Simulaci??n");
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

        jLabel1.setText("Modelo Gesti??n Memoria:");

        panelConfiguracionParticiones.setBackground(new java.awt.Color(153, 204, 255));
        panelConfiguracionParticiones.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setText("Configuraci??n Modelo");

        jLabel4.setText("Cantidad de Particiones:");

        jBotonCrearParticiones.setText("Crear Particiones");
        jBotonCrearParticiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCrearParticionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfiguracionParticionesLayout = new javax.swing.GroupLayout(panelConfiguracionParticiones);
        panelConfiguracionParticiones.setLayout(panelConfiguracionParticionesLayout);
        panelConfiguracionParticionesLayout.setHorizontalGroup(
            panelConfiguracionParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionParticionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConfiguracionParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelConfiguracionParticionesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCantidadParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBotonCrearParticiones))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelConfiguracionParticionesLayout.setVerticalGroup(
            panelConfiguracionParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionParticionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelConfiguracionParticionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCantidadParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelConfiguracionParticionesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonCrearParticiones)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setText("Configuraci??n Procesos");

        jLabel6.setText("Nombre Proceso:");

        jLabel7.setText("Tama??o .text:");

        jLabel8.setText("Tama??o .data:");

        jLabel9.setText("Tama??o bss:");

        jBotonCrearProceso.setText("Crear Proceso");
        jBotonCrearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCrearProcesoActionPerformed(evt);
            }
        });

        jLabel10.setText("MBs");

        jLabel11.setText("MBs");

        jLabel12.setText("MBs");

        comboModelosAjuste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboModelosAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelosAjusteActionPerformed(evt);
            }
        });

        JlabelAjuste.setText("Ajuste Modelo");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(JlabelAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboModelosAjuste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboModelosAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlabelAjuste))
                .addGap(34, 34, 34))
        );

        comboModelosAjuste.getAccessibleContext().setAccessibleDescription("");
        comboModelosAjuste.getAccessibleContext().setAccessibleParent(this);

        jPanelTablaParticiones.setBackground(new java.awt.Color(102, 204, 255));

        jLabel5.setText("Tabla de Particiones");

        jTableParticiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Memoria Base Bytes", "Memoria Limite Bytes", "Direcci??n Memoria Base", "Direcci??n Memoria Limite", "MBs", "Proceso"
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
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                "Nombre Proceso", "Tama??o .text", "Tama??o data", "Tama??o bss", "Tiempo Ejecucion (seg)", "Estado"
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConfiguracionParticiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboModelosMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jBotonComenzarSimulacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTablaParticiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTablaParticiones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
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
                        .addComponent(panelConfiguracionParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    }//GEN-LAST:event_jBotonComenzarSimulacionActionPerformed

    private void comboModelosMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelosMemoriaActionPerformed

    }//GEN-LAST:event_comboModelosMemoriaActionPerformed

    private void jBotonCrearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCrearProcesoActionPerformed

    }//GEN-LAST:event_jBotonCrearProcesoActionPerformed

    private void jBotonCrearParticionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCrearParticionesActionPerformed
  
    }//GEN-LAST:event_jBotonCrearParticionesActionPerformed

    private void comboModelosAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelosAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelosAjusteActionPerformed


    public JPanel getjPanelMemoria() {
        return jPanelMemoria;
    }

    public JTextField getTextCantidadParticiones() {
        return textCantidadParticiones;
    }

    public DefaultTableModel getTablaParticionesModel() {
        return tablaParticionesModel;
    }

    public void setTablaParticionesModel(DefaultTableModel tablaParticionesModel) {
        this.tablaParticionesModel = tablaParticionesModel;
    }

    public DefaultTableModel getTablaProcesosModel() {
        return tablaProcesosModel;
    }

    public void setTablaProcesosModel(DefaultTableModel tablaProcesosModel) {
        this.tablaProcesosModel = tablaProcesosModel;
    }

    public JTable getjTableParticiones() {
        return jTableParticiones;
    }

    public JTable getjTableProcesos() {
        return jTableProcesos;
    }

    public JTextField getjTextBss() {
        return jTextBss;
    }

    public JTextField getjTextDataProceso() {
        return jTextDataProceso;
    }

    public JTextField getjTextNombreProceso() {
        return jTextNombreProceso;
    }

    public JTextField getjTextProceso() {
        return jTextProceso;
    }

    public JComboBox<String> getComboModelosMemoria() {
        return comboModelosMemoria;
    }

    public void setComboModelosMemoria(JComboBox<String> comboModelosMemoria) {
        this.comboModelosMemoria = comboModelosMemoria;
    }

    public JPanel getPanelConfiguracionParticiones() {
        return panelConfiguracionParticiones;
    }

    public JLabel getJlabelAjuste() {
        return JlabelAjuste;
    }

    public JComboBox<String> getComboModelosAjuste() {
        return comboModelosAjuste;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelAjuste;
    public javax.swing.JComboBox<String> comboModelosAjuste;
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
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel panelConfiguracionParticiones;
    private javax.swing.JTextField textCantidadParticiones;
    // End of variables declaration//GEN-END:variables
}
