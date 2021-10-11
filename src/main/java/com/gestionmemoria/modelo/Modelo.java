package com.gestionmemoria.modelo;

import com.gestionmemoria.sistema.Memoria;
import com.gestionmemoria.vista.GestionMemoriaForm;
import com.gestionmemoria.sistema.ModeloMemoria;
import com.gestionmemoria.sistema.Particion;
import com.gestionmemoria.sistema.ParticionesFijas;
import com.gestionmemoria.sistema.ParticionesVariables;
import com.gestionmemoria.sistema.Proceso;
import com.gestionmemoria.vista.TablaProcesoCellRender;
import com.gestionmemoria.utils.Constants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Modelo {
    
    private GestionMemoriaForm gestionMemoriaForm;
    private ModeloMemoria modeloMemoria;

    public GestionMemoriaForm getGestionMemoriaForm() {
        if(gestionMemoriaForm == null){
            gestionMemoriaForm = new GestionMemoriaForm(this);
        }
        return gestionMemoriaForm;
    }

    public ModeloMemoria getModeloMemoria() {
        return modeloMemoria;
    }
    
    
    public void iniciarAplicacion(){
        getGestionMemoriaForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getGestionMemoriaForm().setLayout(new BorderLayout());
        getGestionMemoriaForm().setVisible(true);
    }
    
    public void seleccionarModeloMemoria(ActionEvent e){
        String modeloSeleccionado = (String)((JComboBox)e.getSource()).getSelectedItem();
        switch (modeloSeleccionado) {
            case Constants.MODEL_PARTICION_EFIJA:
                modeloMemoria = new ParticionesFijas();
                gestionMemoriaForm.jLabel4.setText("Cantidad de Particiones:");
            break;
            case Constants.MODEL_PARTICION_EDINAMICA:
                
                modeloMemoria = new ParticionesVariables(gestionMemoriaForm);
                gestionMemoriaForm.jLabel4.setText("Tamaño de la Partición: (MBs)");
            break;
            default: 
                System.out.println("No seleccionado");
            break;
        }
        getGestionMemoriaForm().getjPanelMemoria().add(modeloMemoria.getMemoria().particionOS.getPanelParticionUI().getPanelParticion());
        getGestionMemoriaForm().getjPanelMemoria().validate();
        getGestionMemoriaForm().getjPanelMemoria().repaint();
    }
    
    public void crearParticiones(){
        String cantidadparticiones = getGestionMemoriaForm().getTextCantidadParticiones().getText();
        double memoriaDisponibleMbs = (Memoria.memoriaTotalMbs - Memoria.memoriaUtilizadaMbs);
        if(cantidadparticiones != null && !cantidadparticiones.isEmpty() && memoriaDisponibleMbs >= Double.parseDouble(cantidadparticiones)){
            try {
                getModeloMemoria().getMemoria().setCantidadParticiones(Integer.parseInt(cantidadparticiones));
                getModeloMemoria().particionarMemoria();
                if (getModeloMemoria().getMemoria().getParticionesUsuario() != null && !getModeloMemoria().getMemoria().getParticionesUsuario().isEmpty()) {
                    for (Particion particion : getModeloMemoria().getMemoria().getParticionesUsuario()) {
                        getGestionMemoriaForm().getjPanelMemoria().add(particion.getPanelParticionUI().getPanelParticion());
                    }
                    getGestionMemoriaForm().getjPanelMemoria().validate();
                    getGestionMemoriaForm().getjPanelMemoria().repaint();
                }
                llenarTablaParticiones();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(getGestionMemoriaForm(), "El campo cantidad de particiones debe ser numerico entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(getGestionMemoriaForm(), "El campo cantidad de particiones es obligatorio", "Error", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    public void llenarTablaParticiones() {
        if (!getModeloMemoria().getMemoria().getParticionesUsuario().isEmpty()) {
            getGestionMemoriaForm().setTablaParticionesModel((DefaultTableModel) getGestionMemoriaForm().getjTableParticiones().getModel());

            if (modeloMemoria instanceof ParticionesFijas) {
                    for (Particion particion : getModeloMemoria().getMemoria().getParticionesUsuario()) {
                        Object[] registroParticion = {particion.getNombre(), particion.getDireccionInicio(), particion.getDireccionFin(), particion.getDireccionInicioHexa(), particion.getDireccionFinHexa(), particion.getTotalMemoriaParticion(), ""};
                        getGestionMemoriaForm().getTablaParticionesModel().addRow(registroParticion);
                    }
                   
            }
            if (modeloMemoria instanceof ParticionesVariables) {
                        Integer sizeList = getModeloMemoria().getMemoria().getParticionesUsuario().size();
                        Object[] registroParticion = {getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getNombre(), getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getDireccionInicio(), getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getDireccionFin(), getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getDireccionInicioHexa(), getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getDireccionFinHexa(), getModeloMemoria().getMemoria().getParticionesUsuario().get(sizeList - 1).getTotalMemoriaParticion(), ""};
                        getGestionMemoriaForm().getTablaParticionesModel().addRow(registroParticion);
                  
            }

        }
    }
    
    public void crearProceso(){
        try {
            double data = Double.parseDouble(getGestionMemoriaForm().getjTextDataProceso().getText());
            double text = Double.parseDouble(getGestionMemoriaForm().getjTextProceso().getText());
            double bss = Double.parseDouble(getGestionMemoriaForm().getjTextBss().getText());
            double cantidadMemoriaProceso = data+text+bss;
            String nombreProceso = getGestionMemoriaForm().getjTextNombreProceso().getText();
            Proceso proceso = new Proceso(getModeloMemoria().getIdProcesos(), nombreProceso, data, text, bss,cantidadMemoriaProceso,Constants.ESTADO_LISTO);
            getModeloMemoria().getProcesos().add(proceso);
            getGestionMemoriaForm().setTablaProcesosModel((DefaultTableModel)getGestionMemoriaForm().getjTableProcesos().getModel());
            getGestionMemoriaForm().getjTableProcesos().setDefaultRenderer(Object.class, new TablaProcesoCellRender());
            Object [] registroProceso = {nombreProceso,data+"" ,text+"",bss+"",proceso.getTiempoEjecucion()+"",Constants.ESTADO_LISTO};
            getGestionMemoriaForm().getTablaProcesosModel().addRow(registroProceso);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(getGestionMemoriaForm(),"Los campos Tamaño .text , Tamaño .data y Tamaño bss deben ser numericos decimales.","Error" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void lanzarSimulacion(){
        if(validarComienzoSimulacion()){
            getModeloMemoria().gestionarMemoria(getGestionMemoriaForm().getTablaProcesosModel(), getGestionMemoriaForm().getTablaParticionesModel());
        }
    }
    
    
    public boolean validarComienzoSimulacion(){
        boolean validacion = true;
        if(getModeloMemoria() == null){
            JOptionPane.showMessageDialog(getGestionMemoriaForm(),"Debe seleccionar un modelo de gestión de memoria","Error" , JOptionPane.WARNING_MESSAGE);
            validacion = false;
        }else{
            if(getModeloMemoria().getMemoria().getParticionesUsuario().isEmpty()){
                JOptionPane.showMessageDialog(getGestionMemoriaForm(),"Debe crear al menos una partición","Error" , JOptionPane.WARNING_MESSAGE);
                validacion = false;
            }
            if(getModeloMemoria().getProcesos().isEmpty()){
                JOptionPane.showMessageDialog(getGestionMemoriaForm(),"Debe ingresar al menos un proceso","Error" , JOptionPane.WARNING_MESSAGE);
                validacion = false;
            }
        }
        return validacion; 
    }
 
}
