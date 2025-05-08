package org.desk.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marcus V. R. Nastasi
 * @version 1.0.1
 * @since 2024
 */
public class CalcController {

    /**
     * The input element text 'display'.
     */
    @FXML
    private TextField calculatorInput;

    /**
     * This function handle the keyword inputs on display.
     *
     * @param event a click event that is called on button click.
     */
    @FXML
    protected void handleInputText(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        calculatorInput.setText(calculatorInput.getText() + clickedButton.getText());
    }

    /**
     * Function responsible for verify the pattern match, call to perform calculation
     * and formatting response or error.
     */
    @FXML
    protected void enter() {
        Pattern pattern = Pattern.compile("(-?[0-9]+(?:\\.[0-9]+)?)([+\\-/*])(-?[0-9]+(?:\\.[0-9]+)?)");
        Matcher matcher = pattern.matcher(calculatorInput.getText());
        if (matcher.matches()) {
            double result = performCalculation(matcher.group(1), matcher.group(2), matcher.group(3));
            calculatorInput.setText(new DecimalFormat("#.##").format(result).replace(",", "."));
            return;
        }
        calculatorInput.setText("Erro: Entrada inválida!");
    }

    /**
     * This function does the calculation based on two operands and an operator.
     *
     * @param leftOperand first operand.
     * @param operator the operator (+, -, *, /).
     * @param rightOperand second operand.
     * @return a double value that represents the calculation results.
     */
    private double performCalculation(String leftOperand, String operator, String rightOperand) {
        double num1 = Double.parseDouble(leftOperand);
        double num2 = Double.parseDouble(rightOperand);
        return operator.equals("+") ? num1 + num2
            : operator.equals("-") ? num1 - num2
            : operator.equals("*") ? num1 * num2
            : operator.equals("/") && num2 != 0 ? num1 / num2 : num1;
    }

    /**
     * Clear the display.
     */
    @FXML
    protected void delete() {
        calculatorInput.clear();
    }

    /**
     * Button 'enter' mouse over's color change.
     *
     * @param event the mouse event.
     */
    @FXML
    protected void handleEnterMouseEntered(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #A1E8A1;");
    }

    /**
     * Button 'enter' mouse leave's color change.
     *
     * @param event the mouse event.
     */
    @FXML
    protected void handleEnterMouseLeave(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #C7F7C7;");
    }

    /**
     * Button 'delete' mouse over's color change.
     *
     * @param event the mouse event.
     */
    @FXML
    protected void handleDelMouseEntered(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #E47474;");
    }

    /**
     * Button 'delete' mouse leave's color change.
     *
     * @param event the mouse event.
     */
    @FXML
    protected void handleDelMouseLeave(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #F09898;");
    }
}
