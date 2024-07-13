package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label prevNum;

    @FXML
    private Label result;
    @FXML
    private Button clear;
    private double num1;
    private double total = 0;
    private String operator = "";
    private boolean check = true;

    public Double create(double num1, double num2, String operator){
        switch (operator){
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                if (num2 == 0){
                    return 0.0;
                }else {
                    return (num1 / num2);
                }
            default:
                break;
        }
        return 0.0;
    }
    public void number(String number){
        result.setText(result.getText() + number);
    }
    public void prevNumber(String number){
        prevNum.setText(prevNum.getText() + number);
    }
    public void prevOperator(String operator){
        prevNum.setText(prevNum.getText()+" "+operator+" ");
    }
    public void computeProcess(ActionEvent event){
        if (check){
            result.setText("");
            prevNum.setText("");

            check = false;
        }

        Button button = (Button) event.getSource();
        String value = button.getText();

        number(value);
        prevNumber(value);
    }
    public void operatorProcess(ActionEvent event){
        Button button = (Button) event.getSource();
        String value = button.getText();
        if (!value.equals("Ans")){
            if (!operator.isEmpty())
                return;
            operator = value;
            prevOperator(operator);
            num1 = Double.parseDouble(result.getText());
            result.setText("");
        }else {
            if (operator.isEmpty())
                return;
            double num2 = Double.parseDouble(result.getText());
            total = create(num1,num2,operator);
            result.setText(String.valueOf(total));
            operator = "";
            check = true;
        }
    }
    public void clear (ActionEvent event){
        if (event.getSource() == clear){
            result.setText("0");
            prevNum.setText("");
        }
    }
    public void exit() {
        System.exit(0);
    }
}