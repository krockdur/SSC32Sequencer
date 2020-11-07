package com.jf72.ui;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class ServoUI extends JPanel {

    private int servoNumber;
    private final int LOW_PULSE = 500;
    private final int HIGH_PULSE = 2500;
    private int maxPulse = HIGH_PULSE;
    private int minPulse = LOW_PULSE;

    public ServoUI(int servoNumber){
        this.servoNumber = servoNumber;

        //setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
        sliderPulse.setMinimum(minPulse);
        sliderPulse.setMaximum(maxPulse);
        sliderPulse.setOrientation(JSlider.HORIZONTAL);
        sliderPulse.setValue((maxPulse + minPulse) / 2);
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
    private JTextField txtMinPulse;
    private JTextField txtMaxPulse;
    private JPanel createContent(){
        JPanel contentPanel = new JPanel(new GridLayout(3,2));

        txtPulse = new JTextField();
        txtPulse.setColumns(5);
        txtPulse.setHorizontalAlignment(JTextField.CENTER);
        txtPulse.setText(Integer.toString((maxPulse + minPulse) / 2));
        txtPulse.addActionListener(e -> {
            int tmp_value = Integer.parseInt(txtPulse.getText());
            if(tmp_value < minPulse){
                tmp_value = minPulse;
                txtPulse.setText(Integer.toString(minPulse));
            }
            if(tmp_value > maxPulse){
                tmp_value = maxPulse;
                txtPulse.setText(Integer.toString(maxPulse));
            }
            sliderPulse.setValue(tmp_value);
        });

        // LOW END
        txtMinPulse = new JTextField();
        txtMinPulse.setColumns(5);
        txtMinPulse.setHorizontalAlignment(JTextField.CENTER);
        txtMinPulse.setText(Integer.toString(minPulse));
        txtMinPulse.addActionListener(e -> {
            if(Integer.parseInt(txtMinPulse.getText()) >= LOW_PULSE){
                minPulse = Integer.parseInt(txtMinPulse.getText());
                if( Integer.parseInt(txtPulse.getText()) < Integer.parseInt(txtMinPulse.getText()) ){
                    txtPulse.setText(txtMinPulse.getText());
                }
            }
            else{
                minPulse = LOW_PULSE;
                txtMinPulse.setText(Integer.toString(minPulse));
            }
        });

        // HIGH END
        txtMaxPulse = new JTextField();
        txtMaxPulse.setColumns(5);
        txtMaxPulse.setHorizontalAlignment(JTextField.CENTER);
        txtMaxPulse.setText(Integer.toString(maxPulse));
        txtMaxPulse.addActionListener(e -> {
            if(Integer.parseInt(txtMaxPulse.getText()) <= HIGH_PULSE){
                maxPulse = Integer.parseInt(txtMaxPulse.getText());
                if( Integer.parseInt(txtPulse.getText()) > Integer.parseInt(txtMaxPulse.getText()) ){
                    txtPulse.setText(txtMaxPulse.getText());
                }
            }
            else{
                maxPulse = HIGH_PULSE;
                txtMaxPulse.setText(Integer.toString(maxPulse));
            }
        });

        contentPanel.add(new JLabel("min"));
        contentPanel.add(txtMinPulse);
        contentPanel.add(new JLabel("current"));
        contentPanel.add(txtPulse);
        contentPanel.add(new JLabel("max"));
        contentPanel.add(txtMaxPulse);

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

    public JTextField getTxtMinPulse() {
        return txtMinPulse;
    }

    public JTextField getTxtMaxPulse() {
        return txtMaxPulse;
    }
}
