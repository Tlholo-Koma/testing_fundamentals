package service;

public class Division extends Operator {

    @Override
    public Double execute(Double value1, Double value2) {
        return value1 / value2;
    }
    
}
