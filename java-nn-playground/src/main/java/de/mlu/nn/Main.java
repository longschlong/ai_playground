package de.mlu.nn;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.exceptions.NeurophException;
import org.neuroph.core.learning.IterativeLearning;
import org.neuroph.nnet.RBFNetwork;
import org.neuroph.nnet.comp.neuron.ThresholdNeuron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.BinaryDeltaRule;
import org.neuroph.nnet.learning.ConvolutionalBackpropagation;
import org.neuroph.nnet.learning.DynamicBackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.nnet.learning.RBFLearning;
import org.neuroph.nnet.learning.ResilientPropagation;
import org.neuroph.nnet.learning.SupervisedHebbianLearning;
import org.neuroph.util.NeuralNetworkFactory;
import org.neuroph.util.TransferFunctionType;

import de.mlu.nn.data.Data;
import de.mlu.nn.data.GeoCalcDataProvider;
import de.mlu.nn.util.OnlineNormalEstimator;
import de.mlu.nn.visualization.SpeedControl;
import de.mlu.nn.visualization.Visualization;
import de.mlu.nn.visualization.guicomponent.ErrorGraph;
import de.mlu.nn.visualization.guicomponent.InputValueGraph;
import de.mlu.nn.visualization.guicomponent.NetInformationPanel;
import de.mlu.nn.visualization.guicomponent.OutputValueGraph;

public class Main {

    public void startWithGUI() throws InterruptedException {
        GeoCalcDataProvider dataProvider = getDataProvider();
        int[] topology = new int[]{dataProvider.getNumberOfNeuronsInInputLayer(), 8, 1};
        NeuralNetwork net = new NeuralNetwork(topology);

        Visualization visualization = new Visualization();

        ErrorGraph errorGraph = new ErrorGraph();
        InputValueGraph inputValueGraph = new InputValueGraph(10, net.getLayers()[0].neurons.length);
        OutputValueGraph outputValueGraph = new OutputValueGraph(10, net.getLayers()[net.getLayers().length - 1].neurons.length);
        NetInformationPanel netInformationPanel = new NetInformationPanel(net, dataProvider);
        visualization.addMain(inputValueGraph);
        visualization.addMain(errorGraph);
        visualization.addMain(outputValueGraph);
        visualization.addMain(netInformationPanel);
        SpeedControl speedControl = new SpeedControl();
        visualization.addTop(speedControl);
        visualization.visualize();

        int trainingPass = 0;

        for (Data d : dataProvider) {
            if (speedControl.isPaused()) continue;

            ++trainingPass;

            double[] results = net.process(d);

            inputValueGraph.addSample(trainingPass, d.getInput());
            outputValueGraph.addSample(trainingPass, results, d.getResult());
            errorGraph.addErrorSample(trainingPass, net.getError());
            errorGraph.addRecentAverageErrorSample(trainingPass, net.getRecentAverageError());
            netInformationPanel.update(trainingPass);

//            System.out.println("Pass " + trainingPass);
//            System.out.println("Inputs: " + Arrays.toString(d.getInput()));
//            System.out.println("Results: " + Arrays.toString(results));
//            System.out.println("Expected Results: " + Arrays.toString(d.getResult()));
//            System.out.println("Recent average error: " + net.getRecentAverageError());
//            System.out.println("Time to process: " + (stop - start) + "ns");
//            System.out.println();

            if (speedControl.getSpeed() != 0) {
                Thread.sleep(speedControl.getSpeed());
            }

            if (trainingPass == 10000) {
            	break;
            }
        }
        // Hier mal neue Ausprobieren
        // Anlagenmechaniker für Heizung/Sanitärinstallation (m/w/d)
        // Durchnittliche Entfernung eingestellt 45,7538818270394
        // Durchnittliche Entfernung nicht eingestellt 78,7316313759464

        List<Data> testData = dataProvider.getTestData();
        visualization = new Visualization();

        for (Data d : testData) {
            ++trainingPass;

            double[] results = net.process(d);
            System.err.println("Input=[" + d.getInput()[0] + "] Error=[" + results[0] + "]" + net.getLayers()[2].toString());
		}
    }

    public void startWithoutGUI() throws InterruptedException {
        GeoCalcDataProvider dataProvider = getDataProvider();
        int[] topology = new int[]{dataProvider.getNumberOfNeuronsInInputLayer(), 8, 1};
        NeuralNetwork net = new NeuralNetwork(topology);

        int trainingPass = 0;

        OnlineNormalEstimator onlineNormalEstimator = new OnlineNormalEstimator();

        for (Data d : dataProvider) {
            ++trainingPass;

            long start = System.nanoTime();
            double[] results = net.process(d);
            long stop = System.nanoTime();

//            System.out.println("Pass " + trainingPass);
//            System.out.println("Inputs: " + Arrays.toString(d.getInput()));
//            System.out.println("Results: " + Arrays.toString(results));
//            System.out.println("Expected Results: " + Arrays.toString(d.getResult()));
//            System.out.println("Recent average error: " + net.getRecentAverageError());
            if (trainingPass > 1000000) {
                onlineNormalEstimator.handle(stop - start);

                if (onlineNormalEstimator.numSamples() % 1000000 == 0) {
                    System.out.println("Time Report:");
                    System.out.println("Passes:\t" + onlineNormalEstimator.numSamples());
                    System.out.println("Mean:\t" + onlineNormalEstimator.mean() + "ns");
                    System.out.println("Std:\t" + onlineNormalEstimator.standardDeviation() + "ns");
                    System.out.println("Var:\t" + onlineNormalEstimator.variance() + "ns");
                    System.out.println();
                }
                break;
            }
        }
        // Hier mal neue Ausprobieren
        // Anlagenmechaniker für Heizung/Sanitärinstallation (m/w/d)
        // Durchnittliche Entfernung eingestellt 45,7538818270394
        // Durchnittliche Entfernung nicht eingestellt 78,7316313759464
        System.out.println("startWithoutGUI");
        List<Data> testData = dataProvider.getTestData();
        for (Data d : testData) {
            ++trainingPass;

            double[] results = net.process(d);
            System.err.println("Input=[" + d.getInput()[0] + "] Error=[" + results[0] + "]" + net.getLayers()[2].toString());
		}
    }

    public static void main(String[] args) throws IOException, InterruptedException {
    	Main main = new Main();
//        main.startWithGUI();
    	new Thread() {
    		public void run() {
    			main.startWithNeuroph();
    		};
    	}.start();

//    	new Thread() {
//    		public void run() {
//    			try {
//					main.startWithoutGUI();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//    		};
//    	}.start();
//    	new Thread() {
//    		public void run() {
//    			try {
//					main.startWithGUI();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//    		};
//    	}.start();
    }

    private static GeoCalcDataProvider getDataProvider() {
    	return new GeoCalcDataProvider(false);
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void startWithNeuroph() {
		GeoCalcDataProvider dataProvider = getDataProvider();

		// create training set
		DataSet trainingSet = new DataSet(dataProvider.getNumberOfNeuronsInInputLayer(), dataProvider.getNumberOfNeuronsInOutputLayer());
		// add training data to training set
		dataProvider.getDataList().forEach(d -> {
			trainingSet.addRow(new DataSetRow(d.getInput(), d.getResult()));
		});

		// load the saved network
		getSupervisedLearningRules(trainingSet, getNumberOfHiddenLayers()).forEach((entry,rule) -> {
	    	new Thread() {
	    		public void run() {
	    			boolean isNew = false;
	    			org.neuroph.core.NeuralNetwork neuralNetwork = null;
	    			try {
	    				neuralNetwork = org.neuroph.core.NeuralNetwork.load(getOrCreateLearnedNetFile(entry));
	    			} catch (NeurophException ex) {
	    				if (neuralNetwork == null) {
	    					isNew = true;
	    					// create new network
	    					neuralNetwork = entry.getValue();
	    				}
	    			}
	    			if (isNew) {
	    				((IterativeLearning)neuralNetwork.getLearningRule()).setMaxIterations(getMaxIterations());
	    				timerStart();
	    				neuralNetwork.learn(trainingSet, neuralNetwork.getLearningRule());
	    				timerStop();
	    				// save the trained network into file
	    				neuralNetwork.save(getOrCreateLearnedNetFile(entry));
	    			}
	    			// set network input
	    			System.out.println("startWithNeuroph result " + neuralNetwork.getClass().getSimpleName() + ": " + neuralNetwork.getLearningRule().getClass().getSimpleName());
	    			final org.neuroph.core.NeuralNetwork nn = neuralNetwork;
	    			dataProvider.getTestData().forEach(d -> {
	    				double[] input = d.getInput();
	    				nn.setInput(input);
	    				// calculate network
	    				nn.calculate();
	    				// get network output
	    				double[] networkOutput = nn.getOutput();
	    				if (!Double.isNaN(networkOutput[0])) {
	    					System.out.println("Input[" + Arrays.toString(input) + "] Output[" + networkOutput[0] + "]");
	    				}
	    			});
	    		};
	    	}.start();
		});
	}

	// https://www.researchgate.net/post/How_to_decide_the_number_of_hidden_layers_and_nodes_in_a_hidden_layer
	// https://www.heatonresearch.com/2017/06/01/hidden-layers.html
	private int getNumberOfHiddenLayers() {
		return 2;
	}

	private int getMaxIterations() {
		return 200000;
	}

	static class CustomPerceptionLearning extends BinaryDeltaRule {
		/**
		 * Comment for <code>serialVersionUID</code>
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void updateNeuronWeights(Neuron neuron) {
			// avoid java.lang.ClassCastException: org.neuroph.core.Neuron cannot be cast to org.neuroph.nnet.comp.neuron.ThresholdNeuron
			super.updateNeuronWeights(new ThresholdNeuron(neuron.getInputFunction(), neuron.getTransferFunction()));
		}
	}

	private String getOrCreateLearnedNetFile(@SuppressWarnings("rawtypes") SimpleEntry<Integer, org.neuroph.core.NeuralNetwork> n) {
		String basePath = getBasePath();
		File baseDir = new File(basePath);
	    if (!baseDir.exists()){
	        baseDir.mkdir();
	    }
	    String networkType = n.getValue().getClass().getSimpleName();
		File networkDir = new File(baseDir.getPath() + File.separator + networkType);
	    if (!networkDir.exists()){
	    	networkDir.mkdir();
	    }
	    String learningRule = n.getValue().getLearningRule().getClass().getSimpleName();
	    File learningRuleDir = new File(networkDir.getPath() + File.separator + learningRule);
	    if (!learningRuleDir.exists()){
	    	learningRuleDir.mkdir();
	    }
	    String functionType = n.getValue().getLayerAt(0).getNeuronAt(0).getTransferFunction().getClass().getSimpleName();
	    File functionTypeDir = new File(learningRuleDir.getPath() + File.separator + functionType);
	    if (!functionTypeDir.exists()){
	    	functionTypeDir.mkdir();
	    }
	    String numMaxIterations = String.valueOf(getMaxIterations());
	    File numMaxIterationsDir = new File(functionTypeDir.getPath() + File.separator + numMaxIterations);
	    if (!numMaxIterationsDir.exists()){
	    	numMaxIterationsDir.mkdir();
	    }
	    String key = String.valueOf(n.getKey());
	    File keyDir = new File(numMaxIterationsDir.getPath() + File.separator + key);
	    if (!keyDir.exists()){
	    	keyDir.mkdir();
	    }
		return keyDir + File.separator + n.getKey() + "_" + networkType + "_" + learningRule + "_" + functionType + "_" + getNumberOfHiddenLayers() + "_" + ".nnet";
	}

	private String getBasePath() {
		return "D:\\git\\ai_playground\\java-nn-playground\\trainednets\\";
	}

	private long startTime;

	private void timerStart() {
		startTime = System.currentTimeMillis();
	}
	private void timerStop() {
		long endTime = System.currentTimeMillis();
		System.out.println("Duration learning " + (endTime - startTime)/1000 + " Sek.");
	}

	@SuppressWarnings("rawtypes")
	private Map<SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>, IterativeLearning> getSupervisedLearningRules(DataSet trainingSet, int numOfHiddenLayers) {
		final Map<SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>, IterativeLearning> holyMap = new LinkedHashMap<>();

		AtomicInteger key = new AtomicInteger(0);
		String numHiddenLayers = " " + numOfHiddenLayers + " ";
		List<TransferFunctionType> transFunctions = Arrays.asList(TransferFunctionType.values());
		transFunctions.forEach(f -> {
			holyMap.put(new SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>(key.getAndIncrement(), NeuralNetworkFactory.createPerceptron(trainingSet.getInputSize(), trainingSet.getOutputSize(), f, CustomPerceptionLearning.class)), new CustomPerceptionLearning());

			final List<BackPropagation> bPropRules = new ArrayList<>();
			bPropRules.add(new BackPropagation());
			bPropRules.add(new ConvolutionalBackpropagation());
			bPropRules.add(new DynamicBackPropagation());
			bPropRules.add(new ResilientPropagation());
			bPropRules.add(new MomentumBackpropagation());
			bPropRules.forEach(r -> {
				holyMap.put(new SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>(key.getAndIncrement(), NeuralNetworkFactory.createMLPerceptron(new String(trainingSet.getInputSize() + numHiddenLayers + trainingSet.getOutputSize()), f, bPropRules.getClass(), true, false)), new CustomPerceptionLearning());
			});
			holyMap.put(new SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>(key.getAndIncrement(), NeuralNetworkFactory.createSupervisedHebbian(trainingSet.getInputSize(), trainingSet.getOutputSize(), f)), new SupervisedHebbianLearning());
		});

		RBFNetwork rbfNet = NeuralNetworkFactory.createRbfNetwork(trainingSet.getInputSize(), numOfHiddenLayers, trainingSet.getOutputSize());
		RBFLearning rbfLearning = new RBFLearning();
		rbfLearning.setTrainingSet(trainingSet);
		holyMap.put(new SimpleEntry<Integer, org.neuroph.core.NeuralNetwork>(key.getAndIncrement(), rbfNet), rbfLearning);
		return holyMap;
	}
}
