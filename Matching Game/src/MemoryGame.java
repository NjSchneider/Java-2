import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *  Developers: Nick Schneider
 *  Program:    Group Project: Matching Game
 *  Purpose:    Create a Matching Game using JavaFX
 * 
 *  This Class creates the Pane, Scene, Stage, and fills the Cells
 *  of the Matching Game
 */

public class MemoryGame extends Application
{
    // total number of matches in the game
    protected static int numOfMatches = 8;
    // number of Rows
    protected static int numOfRows = 4;
    
    private Cell selected = null;
    private int numOfClicks = 2;
    
    // creates pane for matching game
    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(400,400);
        
        // fills the matching game with Cells
        char c = 'A';        
        ArrayList<Cell> cells = new ArrayList<>();
        
        for(int i = 0; i < numOfMatches; i++)
        {
            cells.add(new Cell(String.valueOf(c)));
            cells.add(new Cell(String.valueOf(c)));
            c++;
        }
        // randomizes where the Cells are located  
        Collections.shuffle(cells);
        
        // sets the size of the position and size of the cells within the pane
        for(int i = 0; i < cells.size(); i++)
        {
            Cell cell = cells.get(i);
            cell.setTranslateX(100 * (i % numOfRows));
            cell.setTranslateY(100 * (i / numOfRows));
            root.getChildren().add(cell);            
        }
        
        return root;
    }
    
    @Override // sets the Stage for the Application
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Matching Game");
        primaryStage.show();
    } 
private class Cell extends StackPane
{
    protected Text text = new Text();
        
    public Cell(String value)
    {
        Rectangle border = new Rectangle(100,100);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        
        text.setText(value);
        text.setFont(Font.font(50));
        
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
        
        // sets an action to perform when the mouse is clicked
        setOnMouseClicked(e ->{
            // checks to see if the selected Cell is already Open
            if(isOpen() || numOfClicks == 0)
            {
                return; // returns if the Cell is Open    
            }
            numOfClicks--;
            /** 
             *  if the Cell was not open already, the program opens it and sets
             *  the first clicked Cell to the selected and opens it.                         
             */
            if(selected == null)
            {
                selected = this;
                open(() -> {});
            }
            /**
             *  if a cell is already open, it checks to see if values of the 
             *  first and second opened Cell are equal. If not it closes the
             *  Cells and resets the selected. 
             */
            else
            {
                open(() -> {
                    if(!checkMatch(selected))
                    {
                        selected.close();
                        this.close();
                    }
                    selected = null;
                    numOfClicks = 2;
                });
            }
        });
        close();
    }
    // opens the Cell
    public boolean isOpen()            
    {
        return text.getOpacity() == 1;
    }
    // checks to see if the Cells are the same
    public boolean checkMatch(Cell other)
    {
        return text.getText().equals(other.text.getText());
    }
    // opens the Cell with a FadeTransition animation (Fades in)
    public void open(Runnable action)
    {
        FadeTransition ftAnimation = new FadeTransition(Duration.seconds(.5), text);
        ftAnimation.setToValue(1);
        ftAnimation.setOnFinished(e -> action.run());
        ftAnimation.play();
    }
    /** 
     *  closes the cell with a FadeTransition animation (Fades out)
     *  Game begins with the close() method 
     */
    public void close()
    {
        FadeTransition ftAnimation = new FadeTransition(Duration.seconds(.25), text);
        ftAnimation.setToValue(0);
        ftAnimation.play();
    }
}
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
