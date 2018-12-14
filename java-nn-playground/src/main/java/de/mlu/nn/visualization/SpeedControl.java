package de.mlu.nn.visualization;

import javax.swing.*;

import de.mlu.nn.visualization.guicomponent.GUIComponent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpeedControl implements GUIComponent, KeyListener {
    private static final int STEP_SIZE = 25;
    private JSlider slider;
    private boolean paused = false;

    public SpeedControl() {
        slider = new JSlider(0, 1000);
        slider.setValue(50);
    }

    @Override
    public Component getComponent() {
        return slider;
    }

    public int getSpeed() {
        return slider.getMaximum() - slider.getValue();
    }


    public boolean isPaused() {
        return this.paused;
    }

    @Override
    public void initialize(Visualization visualization) {
        visualization.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_ADD) {
            slider.setValue(slider.getValue() + STEP_SIZE);
        } else if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            slider.setValue(slider.getValue() - STEP_SIZE);
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            this.paused ^= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
