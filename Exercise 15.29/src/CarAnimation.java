import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;


/**
 *  Program: Exercise 15.29
 *  Developer: Nick Schneider
 *  Purpose: Create a program to control an animation of a car using mouse and keyboard commands
 */
public class CarAnimation extends Application
{    
    @Override
    public void start(Stage primaryStage)
    {
        CarPane carPane = new CarPane();
       
        // Starts the animation on release of mouse button 1     
        carPane.setOnMousePressed(e -> carPane.pause());
        
        // Pauses the animation when mouse button 1 is press/held
        carPane.setOnMouseReleased(e -> carPane.play());
        
        carPane.setOnKeyPressed(e -> {
            // Calls the speedUp method in the CarPane Class when the up arrow key is press
            if(e.getCode() == KeyCode.UP)
                carPane.speedUp();
            // Calls the slowDown method in the CarPane Class when the down arrpw key is pressed
            else if(e.getCode() == KeyCode.DOWN)
                carPane.slowDown();
        });
        
        Scene scene = new Scene(carPane, 250, 150);

        primaryStage.setTitle("Car Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        carPane.requestFocus();
        
    }   
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

