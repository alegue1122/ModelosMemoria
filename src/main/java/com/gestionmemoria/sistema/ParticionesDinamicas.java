package com.gestionmemoria.sistema;

import static com.gestionmemoria.sistema.Memoria.pixelUltimaParticion;
import com.gestionmemoria.utils.Constants;
import com.gestionmemoria.utils.Utils;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ParticionesDinamicas extends ModeloMemoria{

    @Override
    public void particionarMemoria() {
        double memoriaDisponibleMbs = (Memoria.memoriaTotalMbs-Memoria.memoriaUtilizadaMbs) ;
        int posicionUltimoProceso = getProcesos().size()-1;
        Proceso proceso = getProcesos().get(posicionUltimoProceso);
        double tamanoParticionMbs = proceso.getCantidadMemoriaProceso();
        double pixelesParticion = tamanoParticionMbs * Constants.PIXELES_POR_MB;
        long bytesInicioParticion = Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs)+1;
        long bytesFinParticion =  Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs+tamanoParticionMbs);
        int coordenadaYPanel =  pixelUltimaParticion - new Double (pixelesParticion).intValue();
        pixelUltimaParticion = coordenadaYPanel;
        PanelParticionUI panelParticionUI = new PanelParticionUI(coordenadaYPanel,(int)Math.round(pixelesParticion),Constants.ANCHO_PANEL_PARTICION, Utils.convertDecimaltoHexa(bytesInicioParticion)+" - "+Utils.convertDecimaltoHexa(bytesFinParticion), "");
        Particion particionUsuario = new Particion(getMemoria().getIdParticion(), "Particion "+getMemoria().getIdParticion(), bytesInicioParticion, bytesFinParticion, Utils.convertDecimaltoHexa(bytesInicioParticion), Utils.convertDecimaltoHexa(bytesFinParticion),tamanoParticionMbs, panelParticionUI);
        getMemoria().getParticionesUsuario().add(particionUsuario);
        Memoria.memoriaUtilizadaMbs  = Memoria.memoriaUtilizadaMbs+tamanoParticionMbs;
        
    }

    @Override
    public void gestionarMemoria(DefaultTableModel dataModelProcesos, DefaultTableModel dataModelParticiones , JPanel panelMemoria) {
       try {         
            int numeroParticion = 0;
            for (Proceso proceso : getProcesos()) {
                Particion particionEjecucion = getMemoria().getParticionesUsuario().get(numeroParticion);
                 if(particionEjecucion !=null){
                    new Thread(new Runnable() {
                    
                    @Override
                    public void run() {
                        dataModelProcesos.setValueAt(Constants.ESTADO_EJECUCION, proceso.getIdProceso(), 5);
                        dataModelParticiones.setValueAt(proceso.getNombreProceso(), particionEjecucion.getId(), 6);
                        for (int i = 1; i <= proceso.getTiempoEjecucion(); i++) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    particionEjecucion.getPanelParticionUI().getTextFieldProcesoParticion().setText(proceso.getNombreProceso());
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                               
                            }
                            if(i == proceso.getTiempoEjecucion()){
                                int posicionParticion = 0;
                                for (int j = 0; j < dataModelParticiones.getRowCount(); j++) {
                                    if(particionEjecucion.getNombre().equals((String)dataModelParticiones.getValueAt(j, 0))){
                                        posicionParticion = j;
                                        break;
                                    }
                                }
                                dataModelParticiones.removeRow(posicionParticion);
                                dataModelProcesos.removeRow(posicionParticion);
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        particionEjecucion.getPanelParticionUI().getPanelParticion().setVisible(false);
                                        getMemoria().pixelUltimaParticion = (getMemoria().pixelUltimaParticion + particionEjecucion.getPanelParticionUI().getAlto());
                                        getMemoria().getParticionesUsuario().remove(particionEjecucion);
                                        getProcesos().remove(proceso);
                                        panelMemoria.validate();
                                        panelMemoria.repaint();
                                    }
                                });
                            }
                        }
                    }
                    }).start();
                 }
                 numeroParticion++;
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e.getMessage());
        }        
    }
    
}
