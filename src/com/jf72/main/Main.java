package com.jf72.main;

import com.fazecast.jSerialComm.SerialPort;
import com.jf72.controller.Controller;
import com.jf72.job.SerialManager;
import com.jf72.ui.MainFrame;

public class Main {
    public static void main(String[] args) {

        SerialManager sm = new SerialManager();

        MainFrame mainFrame = new MainFrame();
        Controller controller = new Controller(mainFrame, sm);
        controller.initialize();





    }
}
