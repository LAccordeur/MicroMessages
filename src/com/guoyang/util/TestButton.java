package com.guoyang.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by L'Accordeur on 2016/10/24.
 */
public class TestButton {
    public static void main(String args[]) {
        Frame frame = new Frame("Test");
        Button button = new Button("Press me");
        button.addActionListener(new ButtonHandler());
        frame.add("Center",button);
        frame.pack();
        frame.setVisible(true);
        System.out.println();
    }
}

class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action occured " + e.getActionCommand());
    }
}