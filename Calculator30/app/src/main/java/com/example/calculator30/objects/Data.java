package com.example.calculator30.objects;

import android.widget.TextView;

public class Data {

    private String equation;
    private String result;

    public Data(){

    }

    public Data(String equation, String result) {
        this.equation = equation;
        this.result = result;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
