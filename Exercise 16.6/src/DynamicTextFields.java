import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;


/**
 *  Program:    Exercise 16.6
 *  Developer:  Nick Schneider
 *  Purpose:    Write a program that sets the horizontal-alignment
 *              and column-size properties of a text field dynamically
 */
public class DynamicTextFields extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TextField tfTextField = new TextField();
        TextField tfPrefColumnSize = new TextField();
        
        tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        
        tfTextField.setPrefColumnCount(13);
        tfPrefColumnSize.setPrefColumnCount(3);
        
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Text Field"), tfTextField);       
                
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbRight = new RadioButton("Right");
        RadioButton rbCenter = new RadioButton("Center");
        
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        
        rbLeft.setOnAction( e -> tfTextField.setAlignment(Pos.BASELINE_LEFT)); 
        rbRight.setOnAction( e -> tfTextField.setAlignment(Pos.BASELINE_RIGHT));
        rbCenter.setOnAction( e -> tfTextField.setAlignment(Pos.BASELINE_CENTER));
        
        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(rbLeft, rbRight, rbCenter);
                
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Column Size"), tfPrefColumnSize);
                        
        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(hBox2, hBox3);
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox1, hBox4);
        
        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setTitle("Radio Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        tfPrefColumnSize.setOnAction(e -> {
            tfTextField.setPrefColumnCount(
                    Integer.parseInt(tfPrefColumnSize.getText()));
        });       
        
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
