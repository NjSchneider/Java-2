import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 *  Program:    Exercise 15.32
 *  Developer:  Nick Schneider
 *  Purpose:    Create Controls for the ClockPane Class
 */
public class ClockContoller extends Application
{
    @Override
    public void start(Stage primaryStage) 
    {
        ClockPane clock = new ClockPane();

        
        // Create a handler for animation
        EventHandler<ActionEvent> eventHandler = e -> 
        {
            clock.setCurrentTime(); // Set a new clock time
        };
    
        // Create an animation for a running clock
        Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.play(); // Start animation
    
                
        HBox hBox = new HBox(5);
        Button btStart = new Button("Start");
        Button btStop = new Button("Stop");
        hBox.getChildren().addAll(btStart, btStop);
        
        // Sets the "Start" Button to start the clock animation
        btStart.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    animation.play();
                }
            });
        
        // Sets the "Stop" Button to stop/pause the clock animation
        btStop.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    animation.stop();
                }
            });
                    
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
            
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("ClockAnimation"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    }

     public static void main(String[] args) 
    {
        launch(args);
    }
}
