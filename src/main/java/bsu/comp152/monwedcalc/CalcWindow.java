package bsu.comp152.monwedcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcWindow {
    private long firstNumber;
    private OperatorType operation;
    @FXML
    private TextField numberField;

    @FXML
    public void numberButtonPressed(ActionEvent event){
           var pressedButton = (Button)event.getSource();
           var buttonText = pressedButton.getText();
           var currentNumberText = numberField.getText();
           numberField.setText(currentNumberText+buttonText);
    }

    @FXML
    public void clearButtonPressed(){
        numberField.clear();
    }

    @FXML
    public void equalPressed(){
        var secondNumberText = numberField.getText();
        var secondNumber = Long.parseLong(secondNumberText);
        var result = 0.0;
        switch (operation){
            case Add -> result = secondNumber+firstNumber;
            case Multiply -> result = firstNumber * secondNumber;
            case Subtract -> result = firstNumber - secondNumber;
            case Divide -> result = (double)firstNumber / secondNumber;
        }
        numberField.setText(String.valueOf(result));
    }

    @FXML
    public void plusPressed(){
         var numberAsText = numberField.getText();
         firstNumber = Long.parseLong(numberAsText);
         numberField.setText("");
         operation = OperatorType.Add;
    }

}
