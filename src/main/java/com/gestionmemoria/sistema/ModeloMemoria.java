package com.gestionmemoria.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public abstract class ModeloMemoria {
        
    public Memoria memoria;
    public List<Proceso> procesos;
    
    public ModeloMemoria(){
        this.memoria = new Memoria();
        this.procesos = new ArrayList<>();
    }
    
    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }
    
    public int getIdProcesos(){
       return procesos.size();  
    }
    
    public abstract void particionarMemoria();
    
    public abstract List<Thread> gestionarMemoria(DefaultTableModel dataModelProcesos, DefaultTableModel dataModelParticiones);

    
}
