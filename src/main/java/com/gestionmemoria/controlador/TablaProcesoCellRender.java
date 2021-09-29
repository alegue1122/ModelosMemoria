
package com.gestionmemoria.controlador;

import com.gestionmemoria.utils.Constants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TablaProcesoCellRender extends DefaultTableCellRenderer{
    
    public TablaProcesoCellRender() {
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
  
    String estado = (String)value;

    switch (estado) {
        case Constants.ESTADO_LISTO:
            setForeground(Color.GREEN);
        break;
        case Constants.ESTADO_EJECUCION:
             setForeground(Color.RED);
        break; 
        case Constants.ESTADO_TERMINADO:
             setForeground(Color.BLUE);
        break; 
        default:
             setForeground(Color.BLACK);
        break;
    }
     setText(value !=null ? value.toString() : "");
     return this;
    }
}
