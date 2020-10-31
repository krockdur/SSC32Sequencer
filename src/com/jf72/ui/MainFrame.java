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

        // StatusBar

        // Content

        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu menuConnection = new JMenu("Connection");
        JMenuItem menuConnectionConnect = new JMenuItem("Connect");
        JMenuItem menuConnectionDisconnect = new JMenuItem("Disconnect");
        menuConnection.add(menuConnectionConnect);
        menuConnection.add(menuConnectionDisconnect);

        jMenuBar.add(menuConnection);
        return jMenuBar;
    }

}
