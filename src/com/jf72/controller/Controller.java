package com.jf72.controller;

import com.jf72.job.SerialManager;
import com.jf72.ui.MainFrame;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.io.Serial;

public class Controller {
    MainFrame mainFrame;
    SerialManager serialManager;

    public Controller(MainFrame mainFrame, SerialManager serialManager){
        this.mainFrame = mainFrame;
        this.serialManager = serialManager;

    }

    public void initialize() {
        // Btn
        mainFrame.getMenuConnectionConnect().addActionListener( e->btnMenuConnectClick() );
        mainFrame.getMenuConnectionDisconnect().addActionListener( e->btnMenuDisconnectClick() );
        mainFrame.getBtnToolBarConnection().addActionListener(e->btnMenuConnectClick());
        mainFrame.getBtnToolBarDisconnection().addActionListener( e->btnMenuDisconnectClick() );

        // Load Combobox Serial List
        for( int i = 0; i < serialManager.getListStrSerialPort().length; i++){
            mainFrame.getComboBoxListSerialPort().addItem(serialManager.getListStrSerialPort()[i]);
        }
        //Change comboboxListSerial selection change selectedSerialPort value
        mainFrame.getComboBoxListSerialPort().addActionListener(e -> {serialManager.setSelectedSerialPort(mainFrame.getComboBoxListSerialPort().getSelectedItem().toString());});

    }


    private void btnMenuDisconnectClick() {
    }

    private void btnMenuConnectClick() {
        
    }
}
