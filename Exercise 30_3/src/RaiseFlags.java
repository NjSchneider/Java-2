import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *  Developer:  Nick Schneider
 *  Program:    Exercise 30.3
 *  Purpose:    Create a flag raising animation using
 *              multi-threading.
 */

public class RaiseFlags extends Application 
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws InterruptedException 
    {
        // Create a pane 
        Pane pane = new Pane();

        // Add an image view and add it to pane
        ImageView imageView = new ImageView("Images/us.png");
        pane.getChildren().add(imageView);
        
        Runnable animation1 = new flagAnimation(imageView);
        Runnable animation2 = new flagAnimation(imageView);
        
        Thread thread1 = new Thread(animation1);
        Thread thread2 = new Thread(animation1);
        
        thread1.start();
        Platform.runLater(() -> thread2.start());
        Thread.sleep(1000);
        
         
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) 
    {
        launch(args);
    }    
}

class flagAnimation implements Runnable
{    
    ImageView imageView;
    
    public flagAnimation(ImageView imageView)
    {
        this.imageView = imageView;
    }
    
    @Override
    public void run()
    {
        
        // Create a path transition 
        PathTransition pt = new PathTransition(Duration.millis(10000),
          new Line(100, 200, 100, 0), imageView);
        pt.setCycleCount(1);
        pt.play(); // Start animation
    }
}
