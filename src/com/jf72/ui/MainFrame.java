package com.jf72.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        setTitle("SSC32Sequencer");
        setSize(new Dimension(1280, 768));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MenuBar
        setJMenuBar(createMenuBar());

        // ToolBar
        getContentPane().add(createToolBar(), BorderLayout.NORTH);

        // StatusBar

        // Content

        setVisible(true);
    }

    /***************************************************************************/
    /*      TOOLBAR       */
    private JComboBox comboBoxListSerialPort;
    private JButton btnToolBarConnection;
    private JButton btnToolBarDisconnection;
    private JComboBox comboBoxBaudRate;
    private JPanel createToolBar(){
        JPanel toolBar = new JPanel();
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lbl4ComboboxSerialPort = new JLabel("Serial Port :");

        comboBoxListSerialPort = new JComboBox();
        getComboBoxListSerialPort().setPreferredSize(new Dimension(100, 25));

        comboBoxBaudRate = new JComboBox();
        getComboBoxBaudRate().addItem("9600");
        getComboBoxBaudRate().addItem("38400");
        getComboBoxBaudRate().addItem("115200");

        btnToolBarConnection = new JButton("Connection");
        btnToolBarDisconnection = new JButton("Disconnection");

        toolBar.add(lbl4ComboboxSerialPort);
        toolBar.add(getComboBoxListSerialPort());
        toolBar.add(getComboBoxBaudRate());
        toolBar.add(btnToolBarConnection);
        toolBar.add(btnToolBarDisconnection);

        return toolBar;
    }

    /***************************************************************************/
    /*      MENUBAR       */
    private JMenuItem menuConnectionConnect;
    private JMenuItem menuConnectionDisconnect;
    private JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu menuConnection = new JMenu("Connection");
        menuConnectionConnect = new JMenuItem("Connect");
        menuConnectionDisconnect = new JMenuItem("Disconnect");
        menuConnection.add(getMenuConnectionConnect());
        menuConnection.add(getMenuConnectionDisconnect());

        jMenuBar.add(menuConnection);
        return jMenuBar;
    }

    /***************************************************************************/
    /*      GETTERS & SETTERS       */

    public JMenuItem getMenuConnectionConnect() {
        return menuConnectionConnect;
    }

    public JMenuItem getMenuConnectionDisconnect() {
        return menuConnectionDisconnect;
    }

    public JComboBox getComboBoxListSerialPort() {
        return comboBoxListSerialPort;
    }

    public JButton getBtnToolBarDisconnection() {
        return btnToolBarDisconnection;
    }

    public JButton getBtnToolBarConnection() {
        return btnToolBarConnection;
    }

    public JComboBox getComboBoxBaudRate() {
        return comboBoxBaudRate;
    }
}
