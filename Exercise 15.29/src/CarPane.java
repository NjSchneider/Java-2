import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

/**
 *  Program: Exercise 15.29
 *  Developer: Nick Schneider
 *  Purpose: create an extension of the Pane class to hold a Car animation
 */
public class CarPane extends Pane
{    
    protected double x;             // The starting point/ reference point for the car animation
    protected double y = 100;       // The reference point for the shapes that make up the car
    protected Rectangle rectangle; 
    protected Polygon polygon;
    protected Circle circle1, circle2;
    private Timeline animation;
     
    public CarPane()
    {
       	drawCar();
	animation = new Timeline(
            new KeyFrame(Duration.millis(50), e -> moveCar()));
	animation.setCycleCount(Timeline.INDEFINITE);  
    } 
    // Clears the CarPane of any previous cars and then creates a car using shapes
    private void drawCar() 
    {	
        getChildren().clear();
	rectangle = new Rectangle(x, y - 20, 50, 10);
        rectangle.setFill(Color.GREEN);
	polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        polygon.setFill(Color.RED);
	circle1 = new Circle(x + 15, y - 5, 5, Color.BLACK);
	circle2 = new Circle(x + 35, y - 5, 5, Color.BLACK);
	getChildren().addAll(rectangle, circle1, circle2, polygon);
    } 
    // pauses the animation
    public void pause()
    {
        animation.pause();
    }
    //starts the animation
    public void play()
    {
        animation.play();
    }
    // sets the initial speed
    public void setSpeed(double speed)
    {
        if (speed <= 100)
            animation.setRate(speed);
    }
    // increases the speed of the animation by increments of 1
    public void speedUp()
    {
        animation.setRate(animation.getRate() + 1);
    }
    // decreases the speed of the animation by increments of 1
    public void slowDown()
    {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() -1 : 0);
    }
    /** moves the car across the scene, from starting position to the end of the scene.
     *  After the position is changed the car is redrawn at new position.
     */
    protected void moveCar()
    {
        if(x <= getWidth())
        {
            x += 1;
        }
        else 
        {
            x = 0;
        }
        drawCar();
    }
     
}
