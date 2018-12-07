package de.mlu.nn;

public class Connection {

    public double weight;
    public double deltaWeight;

    @Override
    public String toString() {
        return "Connection{" +
                "weight=" + weight +
                ", deltaWeight=" + deltaWeight +
                '}';
    }
}
