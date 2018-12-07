package de.mlu.nn.visualization.guicomponent;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mlu.nn.NeuralNetwork;
import de.mlu.nn.data.GeoCalcDataProvider;

public class NetInformationPanel implements GUIComponent {

    private NeuralNetwork net;

    private JPanel panel;
    private JLabel recentAverageError = new JLabel();
    private JLabel lastError = new JLabel();
    private JLabel trainingPasses = new JLabel();

    public NetInformationPanel(NeuralNetwork net, GeoCalcDataProvider provider) {
        this.net = net;

        panel = new JPanel(new GridLayout(0, 2));

        panel.add(new JLabel("Recent Average Error"));
        panel.add(recentAverageError);

        panel.add(new JLabel("Last Error"));
        panel.add(lastError);

        panel.add(new JLabel("Training Passes"));
        panel.add(trainingPasses);

        panel.add(new JLabel("Durchschnittl. Entf. in km angenommen (" + provider.getCountAngenommen() + "): "));
        panel.add(new JLabel(String.valueOf((provider.getAvgAngenommen()))));
        panel.add(new JLabel("Durchschnittl. Entf. in km abgelehnt (" + provider.getCountAbgelehnt() + "): "));
        panel.add(new JLabel(String.valueOf((provider.getAvgAbgelehnt()))));
    }

    @Override
    public Component getComponent() {
        return panel;
    }

    public void update(int trainingPass) {
        recentAverageError.setText(String.valueOf(net.getRecentAverageError()));
        lastError.setText(String.valueOf(net.getError()));
        trainingPasses.setText(String.valueOf(trainingPass));
    }
}
