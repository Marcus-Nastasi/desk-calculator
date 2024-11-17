package org.desk.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcController {
    @FXML
    private TextField calculatorInput;
    @FXML
    private Button enter;

    @FXML
    protected void enter() {
        System.out.println(calculatorInput.getText());
    }

    @FXML
    protected void handleInputText(MouseEvent event) {
        calculatorInput.setText(
            calculatorInput.getText()
            + Arrays.stream(event.getTarget().toString().split("'")).toList().getLast()
        );
    }

    @FXML
    protected void handleKeyPress(KeyEvent event) {
        calculatorInput.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9+\\-/*]*")) return change;
            return null;
        }));
    }
}
