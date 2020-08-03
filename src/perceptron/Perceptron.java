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
public class Perceptron {

    
    private double[][] traing_data_set;
    private double learing_rate;
    private double epoch;
    
    private static final double[][] DEMO_AND_DATA = {{1.0,1.0,1},{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,0.0}};
    private static final double DEMO_LEARNING_RATE = 0.1;
    private static final int DEMO_EPOCH = 8;
    
    public Perceptron(double[][] t_d_s,double l_r,int e){
        setTraing_data_set(t_d_s);
        setLearing_rate(l_r);
        setEpoch(e);
    }
    public Perceptron(double[][] t_d_s){
        this(t_d_s,DEMO_LEARNING_RATE,DEMO_EPOCH);
    }
    
    public Perceptron(){
        this(DEMO_AND_DATA,DEMO_LEARNING_RATE,DEMO_EPOCH);
    }
    
    /**
     * This is used by the neuron to predict the class of a set of input.
     *
     * @param row an array that contains the set of input it should be one
     * dimension less than the weight array dimension
     * @param weight The weight associated with each input in the neuron The
     * first element always represent the weight of the bias. Thus an example
     * input may be: predict({1.0,0.0},{-1.2,0.0,1.1}) Where the weight and
     * input are allocated as below bias = -1.2, x1 = 1.0, w1 = 0.0 x2 = 0.0, w2 = 1.1
     * @return the prediction of the input variables in row
     */
    public double predict(double[] row, double[] weight) {
        double activation = weight[0];
        for (int i = 1; i < weight.length; i++) {
            activation += weight[i] * row[i - 1];
        }
        //System.out.println("Activation " + activation);
        return activation >= 0 ? 1.0 : 0.0;
    }

    /**
     * This is used to tain the neuron giving a set of training data
     * @return the trained associated weight with each input variable the bias
     * inclusive
     */
    public double[] trainNeuron() {
        double weight[] = new double[traing_data_set[0].length];
        for (int g = 0; g < weight.length; g++) {
            weight[g] = 0.0;
        }
        for (int i = 1; i <= epoch; i++) {
            double sumOfError = 0.0;
            for (double[] row : traing_data_set) {
                double[] input = new double[row.length - 1];
                for (int u = 0; u < row.length - 1; u++) {
                    input[u] = row[u];
                }
                double prediction = predict(input, weight);
                double error = row[row.length - 1] - prediction;
                sumOfError += (Math.pow(error, 2));
                weight[0] = weight[0] + (learing_rate * error);
                for (int h = 1; h < weight.length; h++) {
                    weight[h] = weight[h] + (learing_rate * error * input[h - 1]);
                }
            }
            System.out.println("ERROR IN TRAINING Epoch " + i + " is " + sumOfError + " Weight "+Utilities.prettyPrintArray(weight));

        }

        return weight;
    }

    

    /**
     * @return the traing_data_set
     */
    public double[][] getTraing_data_set() {
        return traing_data_set;
    }

    /**
     *@param traing_data_set a 2D array with each row containing a set of input
     * array and the last element represent the expected output which the neuron
     * will learn This expected output inclusion makes the dimension of the
     * input equal to the weight as the weight will also have the bias which is
     * not associated with any input.
     */
    public void setTraing_data_set(double[][] traing_data_set) {
        
        this.traing_data_set = traing_data_set;
    }

    /**
     * @return the learing_rate
     */
    public double getLearing_rate() {
        return learing_rate;
    }

    /**
     *@param learing_rate used to limit the amount of adjustment we makes to
     * the weights
     */
    public void setLearing_rate(double learing_rate) {
        this.learing_rate = learing_rate;
    }

    /**
     * @return the epoch
     */
    public double getEpoch() {
        return epoch;
    }

    /**
     @param epoch to represent the number of time of times to run through the
     *  training set in learning the [entire] set
     */
    public void setEpoch(double epoch) {
        this.epoch = epoch;
    }

}
