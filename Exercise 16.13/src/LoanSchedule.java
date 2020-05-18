import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;

/**
 *  Developer:  Nick Schneider
 *  Program:    Exercise 16.13
 *  Purpose:    Take user input from TextFields to print out loan info
 */
public class LoanSchedule extends Application
{    
    private TextField tfLoanAmount = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextArea textArea = new TextArea();
    
    @Override
    public void start(Stage primaryStage)
    {

        
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        
        tfLoanAmount.setPrefColumnCount(8);
        tfNumberOfYears.setPrefColumnCount(2);
        textArea.setPrefColumnCount(30);
        
        Button btShowTable = new Button("Show Table");
        btShowTable.setOnAction(e ->{
            printLoanInfo();
        });
                
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Loan Amount"), tfLoanAmount,
                new Label("Number of Years"), tfNumberOfYears, btShowTable);       

        ScrollPane scrollPane = new ScrollPane(textArea);
        
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setCenter(textArea);     
                
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Loan Schedule");
        primaryStage.setScene(scene);
        primaryStage.show();       
        
    }
    //prints loan info using info given by user
    public void printLoanInfo()
    {
        String print = "";
        double monthlyInterestRate;
        double monthlyRepayment;
        
        print += "Interest Rate\t Monthly Payment\t Total Payment\n";
        
        for(double i = 5.0; i <= 8; i += .125)
        {
            monthlyInterestRate = i / 1200;
            monthlyRepayment = Double.parseDouble(tfLoanAmount.getText()) * monthlyInterestRate /
                    1 - (Math.pow(1/(1 + monthlyInterestRate), Double.parseDouble(tfNumberOfYears.getText()) * 12));
            
            print += String.format("%-24.3f%-36.2f%-8.2f\n", i, monthlyRepayment, ((monthlyRepayment * Double.parseDouble(tfNumberOfYears.getText())) * 12));
        }
        
        textArea.setText(print);       
    }

    public static void main(String[] args) 
    {        
        launch(args);
    }
}
    

