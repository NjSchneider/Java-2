import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

/**
 *  Developer:  Nick Schneider
 *  Program:    Exam2 Hands-On
 *  Purpose:    Convert Us currency to Canadian Currency
 */
public class ConversionApp extends Application
{
    
    private TextField tfUSCurrency = new TextField();
    private TextField tfCACurrency = new TextField();    
    
    @Override
    public void start(Stage primaryStage)
    {
        // TextField for US Dollars
        tfUSCurrency.setAlignment(Pos.TOP_RIGHT);
        tfUSCurrency.setPrefColumnCount(20);
        
        // TextField for Canadian Dollars
        tfCACurrency.setAlignment(Pos.BOTTOM_RIGHT);
        tfCACurrency.setPrefColumnCount(20);
        tfCACurrency.setDisable(true);  // Makes the TextField uneditable
        
        // Button to Convert US Dollars to Canadian Dollars
        Button btConvert = new Button("Convert");
        btConvert.setOnAction(e ->{
            convertCurrency();
        });
        
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        hBox.getChildren().add(btConvert);
        
        GridPane pane = new GridPane();
        
        pane.add(new Label("US Dollars"), 0, 0);
        pane.add(tfUSCurrency, 1, 0);
        pane.add(new Label("Canadian Dollars"), 0, 1);
        pane.add(tfCACurrency, 1, 1);
        pane.add(hBox, 1,2);
        
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Convert US Dollars to Canadian Dollars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // Converts US Dollars to Canadian Dollars
    public void convertCurrency()
    {
        String print = "";
        double usCurrency = Double.parseDouble(tfUSCurrency.getText());
        double caCurrency = usCurrency * 1.34;
                
        print += caCurrency;
        tfCACurrency.setText(print);
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
