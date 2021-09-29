package com.gestionmemoria.controlador;

import static com.gestionmemoria.controlador.Memoria.pixelUltimaParticion;
import com.gestionmemoria.utils.Constants;
import com.gestionmemoria.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ParticionesFijas extends ModeloMemoria{

    public ParticionesFijas() {
        super();
    }
    
    @Override
    public void particionarMemoria() {
        double memoriaDisponibleMbs = (Memoria.memoriaTotalMbs-Memoria.memoriaUtilizadaMbs) ;
        double tamanoParticionMbs = memoriaDisponibleMbs / getMemoria().getCantidadParticiones();
        double pixelesParticion = tamanoParticionMbs * Constants.PIXELES_POR_MB;
        
        for (int i = 1; i <= getMemoria().getCantidadParticiones() ; i++) {
            long bytesInicioParticion = Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs)+1;
            long bytesFinParticion =  Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs+tamanoParticionMbs);
            int coordenadaYPanel =  pixelUltimaParticion - new Double (pixelesParticion).intValue();
            pixelUltimaParticion = coordenadaYPanel;
            PanelParticionUI panelParticionUI = new PanelParticionUI(coordenadaYPanel,(int)Math.round(pixelesParticion),Constants.ANCHO_PANEL_PARTICION, Utils.convertDecimaltoHexa(bytesInicioParticion)+" - "+Utils.convertDecimaltoHexa(bytesFinParticion), "");
            Particion particionUsuario = new Particion(getMemoria().getIdParticion(), "Particion "+i, bytesInicioParticion, bytesFinParticion, Utils.convertDecimaltoHexa(bytesInicioParticion), Utils.convertDecimaltoHexa(bytesFinParticion),tamanoParticionMbs, panelParticionUI);
            getMemoria().getParticionesUsuario().add(particionUsuario);
            Memoria.memoriaUtilizadaMbs  = Memoria.memoriaUtilizadaMbs+tamanoParticionMbs;
        }
    }

    
    @Override
    public List<Thread> gestionarMemoria(DefaultTableModel dataModelProcesos , DefaultTableModel dataModelParticiones) {
        List<Thread> hilosEjecucion = new ArrayList<>();
        try {
            for (Proceso proceso : getProcesos()) {
                Particion particionEjecucion = buscarParticionEjecucionProceso(proceso);
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
                                dataModelProcesos.setValueAt(Constants.ESTADO_TERMINADO, proceso.getIdProceso(), 5);
                                dataModelParticiones.setValueAt("", particionEjecucion.getId(), 6);
                                particionEjecucion.setProcesoEnParticion("");
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        particionEjecucion.getPanelParticionUI().getTextFieldProcesoParticion().setText("");
                                    }
                                });
                            }
                        }
                    }
                    }).start();
                 }
                
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e.getMessage());
        }        
        return hilosEjecucion;
    }
    
    
     public synchronized  Particion buscarParticionEjecucionProceso(Proceso process){
        Particion particionLibre= null;
        for (Particion particion : getMemoria().getParticionesUsuario()) {
            if(particion.getTotalMemoriaParticion() <= process.getCantidadMemoriaProceso() &&  (particion.getProcesoEnParticion() == null || particion.getProcesoEnParticion().isEmpty())){
                particion.setProcesoEnParticion(process.getNombreProceso());
                particionLibre = particion;
                break;
            }
        }
        return particionLibre;
    }
}
