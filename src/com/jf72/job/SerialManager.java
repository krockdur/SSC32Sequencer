package com.jf72.job;


import com.fazecast.jSerialComm.SerialPort;

public class SerialManager {

    SerialPort[] tabSerialPorts;
    SerialPort serialConnection;


    private String selectedSerialPort;

    public SerialManager(){
        System.out.println("check serial ports");

        System.out.println("check serial ports");
    }

    public boolean connection(String comPort, String baudRate){
        boolean success = false;
        int nbSerialPort = SerialPort.getCommPorts().length;

        for (int i = 0; i < nbSerialPort; i++){
            if( comPort.equals(SerialPort.getCommPorts()[i].getSystemPortName())){
                serialConnection = SerialPort.getCommPorts()[i];
                serialConnection.setBaudRate(Integer.parseInt(baudRate));
                serialConnection.setNumDataBits(8);
                serialConnection.setNumStopBits(1);
                serialConnection.setParity(1);
                serialConnection.openPort();
                success = true;
            }
        }
        return success;
    }

    public void deconnection(){
        if(serialConnection.isOpen()){
            serialConnection.closePort();
        }
    }

    /**
     * List of serials ports
     * @return a String's tab
     */
    public String[] getListStrSerialPort(){
        int nbSerialPort = SerialPort.getCommPorts().length;
        String[] tabStrSerialPort = new String[nbSerialPort];

        for (int i = 0; i < nbSerialPort; i++){
            tabStrSerialPort[i] = SerialPort.getCommPorts()[i].getSystemPortName();
        }

        return tabStrSerialPort;
    }

    // Getters & Setters

    public String getSelectedSerialPort() {
        return selectedSerialPort;
    }

    public void setSelectedSerialPort(String selectedSerialPort) {
        this.selectedSerialPort = selectedSerialPort;
    }
}
