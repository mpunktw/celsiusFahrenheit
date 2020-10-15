package celsiusFahrenheit;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(5);
        root.setPadding(new Insets(5, 5, 5, 5));
        
        HBox hbCelsius = new HBox(5);
        root.getChildren().add(hbCelsius);
        
        Label lbCelsius = new Label("Grad Celsius:");
        hbCelsius.getChildren().add(lbCelsius);
        
        TextField tfCelsius = new TextField();
        hbCelsius.getChildren().add(tfCelsius);
    
        HBox hbFahrenheit = new HBox(5);
        root.getChildren().add(hbFahrenheit);
    
        Label lbFahrenheit = new Label("Grad Fahrenheit:");
        hbFahrenheit.getChildren().add(lbFahrenheit);
    
        TextField tfFahrenheit = new TextField();
        hbFahrenheit.getChildren().add(tfFahrenheit);
        
        HBox hbButton = new HBox(5);
        root.getChildren().add(hbButton);
        
        Button btCf = new Button("C->F");
        hbButton.getChildren().add(btCf);
        btCf.setOnAction((EventHandler) event -> {
            double c = Integer.parseInt(tfCelsius.getText());
            double f = c / (5.0/9.0) + 32;
            tfFahrenheit.setText(String.valueOf(f));
        });
        
        Button btFc = new Button("F->C");
        hbButton.getChildren().add(btFc);
        btFc.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                double f = Integer.parseInt(tfFahrenheit.getText());
                double c = (f - 32.0) * 5.0 / 9.0;
                tfCelsius.setText(String.valueOf(c));
            }
        });
        
        stage.setTitle("Celsius <> Fahrenheit");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
