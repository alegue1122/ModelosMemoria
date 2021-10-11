/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmemoria.sistema;

import static com.gestionmemoria.sistema.Memoria.pixelUltimaParticion;
import com.gestionmemoria.utils.Constants;
import com.gestionmemoria.utils.Utils;
import com.gestionmemoria.vista.GestionMemoriaForm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CAMILA GUT
 */
public class ParticionesVariables extends ModeloMemoria {

    private final GestionMemoriaForm gestion;

    public ParticionesVariables(GestionMemoriaForm gestion) {
        super();
        this.gestion = gestion;
    }

    @Override
    public void particionarMemoria() {

        double memoriaDisponibleMbs = (Memoria.memoriaTotalMbs - Memoria.memoriaUtilizadaMbs);
        double tamanoParticionMbs = getMemoria().getCantidadParticiones();
        double pixelesParticion = tamanoParticionMbs * Constants.PIXELES_POR_MB;
        if (memoriaDisponibleMbs >= tamanoParticionMbs) {
            long bytesInicioParticion = Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs) + 1;
            long bytesFinParticion = Utils.convertMbsaBytes(Memoria.memoriaUtilizadaMbs + tamanoParticionMbs);
            int coordenadaYPanel = pixelUltimaParticion - new Double(pixelesParticion).intValue();
            pixelUltimaParticion = coordenadaYPanel;
            PanelParticionUI panelParticionUI = new PanelParticionUI(coordenadaYPanel, (int) Math.round(pixelesParticion), Constants.ANCHO_PANEL_PARTICION, Utils.convertDecimaltoHexa(bytesInicioParticion) + " - " + Utils.convertDecimaltoHexa(bytesFinParticion), "");
            Particion particionUsuario = new Particion(getMemoria().getIdParticion(), "Particion ", bytesInicioParticion, bytesFinParticion, Utils.convertDecimaltoHexa(bytesInicioParticion), Utils.convertDecimaltoHexa(bytesFinParticion), tamanoParticionMbs, panelParticionUI);
            getMemoria().getParticionesUsuario().add(particionUsuario);
            Memoria.memoriaUtilizadaMbs = Memoria.memoriaUtilizadaMbs + tamanoParticionMbs;
        }
    }

    /**
     *
     * @param dataModelProcesos
     * @param dataModelParticiones
     * @param gestion
     * @return
     */
    @Override
    public List<Thread> gestionarMemoria(DefaultTableModel dataModelProcesos, DefaultTableModel dataModelParticiones) {
        List<Thread> hilosEjecucion = new ArrayList<>();

        try {
            for (Proceso proceso : getProcesos()) {
                Particion particionEjecucion = buscarParticionEjecucionProceso(proceso);
                particionEjecucion.setState(true);

                if (particionEjecucion != null) {
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
                                if (i == proceso.getTiempoEjecucion()) {
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
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return hilosEjecucion;
    }

    public synchronized Particion buscarParticionEjecucionProceso(Proceso process) {

        Particion particionLibre = null;

        switch (gestion.comboModelosAjuste.getSelectedItem().toString()) {

            case Constants.MEJOR_AJUSTE:
                particionLibre = mejorAjuste(process);
                break;
            case Constants.PRIMER_AJUSTE:
                particionLibre = primerAjuste(process);
                break;

            case Constants.PEOR_AJUSTE:
                particionLibre = peorAjuste(process);
                break;
            default:
                System.out.println("No seleccionado");
                break;
        }
        /**
         * for (Particion particion : getMemoria().getParticionesUsuario()) {
         * System.out.println(particion.getTotalMemoriaParticion());
         * System.out.println(process.getCantidadMemoriaProceso());
         * if(particion.getTotalMemoriaParticion() >
         * process.getCantidadMemoriaProceso() && (!particion.isState())){
         *
         * System.out.println("busca ADENTRO");
         * particion.setProcesoEnParticion(process.getNombreProceso());
         * particionLibre = particion;
         *
         * }
         * }
         */

        return particionLibre;
    }

    public Particion mejorAjuste(Proceso process) {
        Particion particionLibre = null;
        double min = process.getCantidadMemoriaProceso();
        for (Particion particion : getMemoria().getParticionesUsuario()) {
            if (particion.getTotalMemoriaParticion() > process.getCantidadMemoriaProceso() && (!particion.isState())) {

                if (min > particion.getTotalMemoriaParticion() - process.getCantidadMemoriaProceso()) {
                    min = particion.getTotalMemoriaParticion() - process.getCantidadMemoriaProceso();
                    particion.setProcesoEnParticion(process.getNombreProceso());
                    particionLibre = particion;
                }

            }
        }

        return particionLibre;
    }

    public Particion primerAjuste(Proceso process) {
        Particion particionLibre = null;
        for (Particion particion : getMemoria().getParticionesUsuario()) {
            if (particion.getTotalMemoriaParticion() >= process.getCantidadMemoriaProceso() && (!particion.isState())) {

                particion.setProcesoEnParticion(process.getNombreProceso());
                particionLibre = particion;
                break;

            }
        }

        return particionLibre;
    }

    public Particion peorAjuste(Proceso process) {
        Particion particionLibre = null;
        double max = 0;
        for (Particion particion : getMemoria().getParticionesUsuario()) {
            if (particion.getTotalMemoriaParticion() >= process.getCantidadMemoriaProceso() && (!particion.isState())) {

                if (max < particion.getTotalMemoriaParticion() - process.getCantidadMemoriaProceso()) {
                    max = particion.getTotalMemoriaParticion() - process.getCantidadMemoriaProceso();

                    particion.setProcesoEnParticion(process.getNombreProceso());
                    particionLibre = particion;
                }

            }
        }
        return particionLibre;
    }

}
