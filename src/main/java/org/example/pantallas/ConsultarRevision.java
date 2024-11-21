package org.example.pantallas;

import org.example.gestores.GestorRevision;
import org.example.modelos.Revision;

import javax.swing.*;
import java.util.ArrayList;

public class ConsultarRevision extends JFrame{
    private JPanel panelPrincipal;
    private GestorRevision gestorRevision;
    private JTextField TFNumDoc;
    private JLabel LNumDoc;
    private JTextField TFPatente;
    private JLabel LPatente;
    private JLabel LRevisiones;
    private JList ListRevisiones;
    private JButton BBuscar;

    public ConsultarRevision(GestorRevision gestorRevision) {
        this.gestorRevision = gestorRevision;
        setContentPane(panelPrincipal);

        setTitle("Consultar Vehiculo");  //configurar el título de la ventana
        setSize(400, 400); //configurar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //define el comportamiento de cierre (lo que hace cuando se toca la cruz)
        setLocationRelativeTo(null); //indicamos respecto a que se centre, al poner null es respecto al centro.
        setVisible(true); //esto es lo más importante, sin esto no va a abrir la ventana


        //Dividir de acuerdo a que dato se ingreso
        //addElement solo funciona con DefaultListModel

        //ArrayList<Revision> r = gestorRevision.buscarRevisionesCliente(TFNumDoc.getText().toUpperCase(), TFPatente.getText().toUpperCase());
        //for(Revision revision: r){
        //    ListRevisiones.addElement(revision);
        //}
    }
}
