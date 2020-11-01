package com.jf72.ui;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class ServoUI extends JPanel {


    private int servoNumber;

    public ServoUI(int servoNumber){
        this.servoNumber = servoNumber;

        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        setLayout(new BorderLayout());



        add(createTopPanel(), BorderLayout.NORTH);
        add(createContent(), BorderLayout.CENTER);
        add(createBottom(), BorderLayout.SOUTH);

    }

    /***************************************************************************/
    /*      BOTTOM       */
    private JSlider sliderPulse;
    private JPanel createBottom(){
        JPanel contentPanel = new JPanel();

        sliderPulse = new JSlider();
        sliderPulse.setMinimum(0);
        sliderPulse.setMaximum(3000);
        sliderPulse.setOrientation(JSlider.HORIZONTAL);
        sliderPulse.setValue(1500);
        sliderPulse.setMinorTickSpacing(200);
        sliderPulse.setMajorTickSpacing(1000);
        sliderPulse.setPaintTicks(true);
        sliderPulse.setPaintLabels(true);
        sliderPulse.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));
        sliderPulse.addChangeListener(e -> {
            txtPulse.setText(Integer.toString(sliderPulse.getValue()));
        });

        contentPanel.add(sliderPulse, BorderLayout.NORTH);

        return contentPanel;
    }


    /***************************************************************************/
    /*      CONTENT       */
    private JTextField txtPulse;
    private JPanel createContent(){
        JPanel contentPanel = new JPanel();
        txtPulse = new JTextField();
        txtPulse.setColumns(5);
        txtPulse.setHorizontalAlignment(JTextField.CENTER);
        txtPulse.setText("1500");
        contentPanel.add(txtPulse);
        return contentPanel;
    }

    /***************************************************************************/
    /*      TOP PANEL       */
    private JCheckBox activeServoCheckBox;
    private JPanel createTopPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        activeServoCheckBox = new JCheckBox();
        topPanel.add(activeServoCheckBox);
        topPanel.add(new JLabel(Integer.toString(servoNumber)));
        return topPanel;
    }

    /***************************************************************************/
    /*      GETTERS & SETTERS       */

    public JCheckBox getActiveServoCheckBox() {
        return activeServoCheckBox;
    }

    public JTextField getTxtPulse() {
        return txtPulse;
    }

    public JSlider getSliderPulse() {
        return sliderPulse;
    }
}
