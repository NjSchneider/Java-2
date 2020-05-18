package exam_unit1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author Nick Schneider
 *         CIS171 Exam Unit 1 
 *         Hangman Image
 */
public class Exam_Unit1 extends Application
{
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        // creates arc for bottom of gallows
        Arc arc = new Arc(200, 425, 90, 90, 90, 90);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(2);
        arc.setRotate(45);
        arc.setFill(null);
        pane.getChildren().add(arc);
        
        // creates main pole of gallows
        Line gallow1 = new Line(155, 50, 155, 355);
        gallow1.setStroke(Color.BLACK);
        gallow1.setStrokeWidth(2);
        pane.getChildren().add(gallow1);    
        
        // creates post for gallows
        Line gallow2 = new Line(155, 50, 310, 50);
        gallow2.setStroke(Color.BLACK);
        gallow2.setStrokeWidth(2);
        pane.getChildren().add(gallow2);
        
        // creates line that connects hangman to gallows 
        Line rope = new Line(310, 50, 310, 100);
        rope.setStroke(Color.BLACK);
        rope.setStrokeWidth(2);
        pane.getChildren().add(rope);
        
        // creates head of hangman figure
        Circle head = new Circle();
        head.setRadius(30);
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(1);
        head.setFill(Color.WHITE);
        head.setCenterX(310);
        head.setCenterY(130);
        pane.getChildren().add(head); 
        
        // creates body of hangman figure
        Line body = new Line(310, 160, 310, 240);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(2);
        pane.getChildren().add(body);
        
        // creates left arm of hangman figure
        Line leftArm = new Line(310, 160, 270, 210);
        leftArm.setStroke(Color.BLACK);
        leftArm.setStrokeWidth(1);
        pane.getChildren().add(leftArm);
        
        // creates right arm of hangman figure
        Line rightArm = new Line(310, 160, 350, 210);
        rightArm.setStroke(Color.BLACK);
        rightArm.setStrokeWidth(1);
        pane.getChildren().add(rightArm);        

        // creates left leg of hangman figure
        Line leftLeg = new Line(310, 240, 280, 310);
        leftLeg.setStroke(Color.BLACK);
        leftLeg.setStrokeWidth(1);
        pane.getChildren().add(leftLeg);
        
        // creates right leg of figure
        Line rightLeg = new Line(310, 240, 340, 310);
        rightLeg.setStroke(Color.BLACK);
        rightLeg.setStrokeWidth(1);
        pane.getChildren().add(rightLeg);
        
        // instantiates the size of the pane and sets primaryStage
        Scene scene = new Scene(pane, 600, 450);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
       launch(args);
    }
    
}
