package com.bebetteratjava.inheritance.Calculator.calEngine;

/**
 * Created by pb033954 on 3/24/2017.
 */
public class Subtractor extends CalculateBase{

    public Subtractor(){}

    public Subtractor(double leftVal,double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal()-getRightVal();
        setResult(value);
    }
}
