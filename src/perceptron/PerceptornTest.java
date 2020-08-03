/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author femi
 */
public class PerceptornTest {

    public static void main(String[] args) {
        double[][] dataSet = {{2.7810836, 2.550537003, 0}, {1.465489372, 2.362125076, 0},
        {3.396561688, 4.400293529, 0}, {1.38807019, 1.850293529, 0},
        {3.06407232, 3.005305973, 0}, {7.627531214, 2.759262235, 1},
        {5.332441248, 2.088626775, 1}, {6.922596716, 1.77106367, 1},
        {8.675418651, -0.242068655, 1}, {7.673756466, 3.508563011, 1}
        };
      //  double weight[] = {-0.1, 0.20653640140000007, -0.23418227720000003};
        //double[] s = trainNeuron(dataSet, 0.1, 4);

        Perceptron p = new Perceptron();
       // double[] final_weight = p.trainNeuron();
        //System.out.println(Perceptron.prettyPrintArray(final_weight));
        p.setTraing_data_set(dataSet);
        double[] final_weight_2 = p.trainNeuron();
        System.out.println(Utilities.prettyPrintArray(final_weight_2));
    }
}
