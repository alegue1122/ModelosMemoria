
package com.gestionmemoria.controlador;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PanelParticionUI{
    
    private JPanel panelParticion;
    private int coordenadaxPanel;
    private int coordenadayPanel;
    private int alto;
    private int ancho;
    private JLabel labelDireccionesMemoria;
    private JTextField textFieldProcesoParticion;
    private String direccionesMemoria;
    private String procesoEnParticion;
    
    public PanelParticionUI(int coordenadayPanel, int alto, int ancho , String direccionesMemoria, String procesoEnParticion) {
        this.coordenadaxPanel = 1;
        this.coordenadayPanel = coordenadayPanel;
        this.alto = alto;
        this.ancho = ancho;
        this.direccionesMemoria = direccionesMemoria;
        this.procesoEnParticion = procesoEnParticion;
        panelParticion = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
        labelDireccionesMemoria = new JLabel(direccionesMemoria , JLabel.CENTER);
        labelDireccionesMemoria.setBounds(1,0, ancho, 10);
        textFieldProcesoParticion = new JTextField(12);
        textFieldProcesoParticion.setText(procesoEnParticion);
        textFieldProcesoParticion.setEditable(false);
        textFieldProcesoParticion.setVisible(true);
        textFieldProcesoParticion.setForeground(Color.RED);
        textFieldProcesoParticion.setFont(textFieldProcesoParticion.getFont().deriveFont(10f));
        Random r=new Random();
        Color color=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
        panelParticion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelParticion.setBounds(coordenadaxPanel, coordenadayPanel, ancho ,alto);
        panelParticion.setBackground(color);
        panelParticion.add(labelDireccionesMemoria);
        panelParticion.add(textFieldProcesoParticion);
    }

    public JPanel getPanelParticion() {
        return panelParticion;
    }

    public void setPanelParticion(JPanel panelParticion) {
        this.panelParticion = panelParticion;
    }

    public int getCoordenadaxPanel() {
        return coordenadaxPanel;
    }

    public void setCoordenadaxPanel(int coordenadaxPanel) {
        this.coordenadaxPanel = coordenadaxPanel;
    }

    public int getCoordenadayPanel() {
        return coordenadayPanel;
    }

    public void setCoordenadayPanel(int coordenadayPanel) {
        this.coordenadayPanel = coordenadayPanel;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public JLabel getLabelDireccionesMemoria() {
        return labelDireccionesMemoria;
    }

    public void setLabelDireccionesMemoria(JLabel labelDireccionesMemoria) {
        this.labelDireccionesMemoria = labelDireccionesMemoria;
    }

    public JTextField getTextFieldProcesoParticion() {
        return textFieldProcesoParticion;
    }

    public void setTextFieldProcesoParticion(JTextField textFieldProcesoParticion) {
        this.textFieldProcesoParticion = textFieldProcesoParticion;
    }

    public String getDireccionesMemoria() {
        return direccionesMemoria;
    }

    public void setDireccionesMemoria(String direccionesMemoria) {
        this.direccionesMemoria = direccionesMemoria;
    }

    public String getProcesoEnParticion() {
        return procesoEnParticion;
    }

    public void setProcesoEnParticion(String procesoEnParticion) {
        this.procesoEnParticion = procesoEnParticion;
    }
    
    
}
