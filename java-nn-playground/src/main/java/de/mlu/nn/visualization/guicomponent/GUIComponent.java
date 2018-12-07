package de.mlu.nn.visualization.guicomponent;

import java.awt.*;

import de.mlu.nn.visualization.Visualization;

public interface GUIComponent {

    Component getComponent();


    default void initialize(Visualization visualization) {
    }

}
