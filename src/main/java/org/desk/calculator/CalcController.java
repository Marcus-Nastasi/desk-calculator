package org.desk.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcController {
    @FXML
    private TextField calculatorInput;

    @FXML
    protected void handleInputText(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        calculatorInput.setText(calculatorInput.getText() + clickedButton.getText());
    }

    @FXML
    protected void enter() {
        Pattern pattern = Pattern.compile("(-?[0-9]+(?:\\.[0-9]+)?)([+\\-/*])(-?[0-9]+(?:\\.[0-9]+)?)");
        Matcher matcher = pattern.matcher(calculatorInput.getText());
        if (matcher.matches()) {
            String leftOperand = matcher.group(1);
            String operator = matcher.group(2);
            String rightOperand = matcher.group(3);
            double result = performCalculation(leftOperand, operator, rightOperand);
            DecimalFormat df = new DecimalFormat("#.###");
            String out = df.format(result);
            calculatorInput.setText(out.replace(",", "."));
            return;
        }
        calculatorInput.setText("Erro: Entrada inválida!");
    }

    private double performCalculation(String leftOperand, String operator, String rightOperand) {
        double num1 = Double.parseDouble(leftOperand);
        double num2 = Double.parseDouble(rightOperand);
        return operator.equals("+") ? num1 + num2
            : operator.equals("-") ? num1 - num2
            : operator.equals("*") ? num1 * num2
            : operator.equals("/") && num2 != 0 ? num1 / num2 : num1;
    }

    @FXML
    protected void delete() {
        calculatorInput.clear();
    }

    @FXML
    protected void handleEnterMouseEntered(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #A1E8A1;");
    }

    @FXML
    protected void handleEnterMouseLeave(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #C7F7C7;");
    }

    @FXML
    protected void handleDelMouseEntered(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #E47474;");
    }

    @FXML
    protected void handleDelMouseLeave(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #F09898;");
    }
}
