package org.desk.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Marcus V. R. Nastasi
 * @version 1.0.1
 * @since 2024
 */
public class CalcApplication extends Application {

    /**
     *
     * The start method, create Scene, Stage and FXML Loader.
     *
     * @param stage the Stage received by params.
     * @throws IOException throws IOException if fails to build.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalcApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
