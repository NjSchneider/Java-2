import java.util.*;
/**
 * 
 * @author Nick Schneider
 *         CIS171 Project_2 
 *         EX-13_5
 *         Takes user input in sets of GeometricObjects to compare Area sizes
 *         and then displays which object is LARGER, SMALLER, or if they are 
 *         the SAME SIZE. Any of the given Child-Classes of the GeometricObject
 *         Super-Class can be compared (Rectangle, Circle, Hexagon).
 */

public class TestGeometricObject
{    
  /** Scanner to take user input */  
  protected static Scanner input = new Scanner(System.in);
  
  /** Array of GeometricObjects */
  protected static GeometricObject shapes[] = new GeometricObject[2];
  
  /** Initializes the control for statements within the while loop*/        
  protected static int counter = 0;
  
  /** Main method */
  public static void main(String[] args) 
  {   
    // Initializes the control for while loop
    String answer = "0";                      
    /** Takes user input for GeometricObjects to compare areas */
    while(!answer.equals("N"))
    {
        /** Initial statement when receiving GeometricObject 1 from user */
        if(counter == 0)
        {
            System.out.println("Hello please enter a set of GeometricObjects to be Compared");
        }
        else if(counter >= 1)
        {
            System.out.println();
            System.out.println("Please enter another GeometricObject");
        }
        System.out.println();
        System.out.println("What kind of GeometricObject would you like to enter?");
        System.out.println("(R)ectangle, (C)ircle, (H)exagon");
        answer = input.nextLine();
        
        if(answer.equals("R"))
        {
            initiateRectangle();
        }
        else if(answer.equals("C"))
        {
            initiateCircle();
        }
        else if(answer.equals("H"))
        {
            initiateHexagon();
        }                
        /** Prints GeometricObject information and compares Areas once two GeometricObjects have been entered */
        if(counter == 1)
        {
            for(int i = 0; i < shapes.length; i++)
            {
                System.out.println();
                System.out.println("GeometricObject " + (i + 1));
                displayGeometricObject(shapes[i]);
            }
            int compare = shapes[0].compareTo(shapes[1]);
            System.out.println();
            
            if(compare == 1)
            {
                System.out.println("Geometric Object 1 is LARGER than Geometric Object 2");
            }
            else if(compare == -1)
            {
                System.out.println("Geometric Object 1 is SMALLER than Geometric Object 2");
            }
            else
            {
                System.out.println("Geometric Object 1 is the SAME SIZE as Geometric Object 2");
            }
        }
        if(counter >= 1)
        {
            System.out.println();
            System.out.println("Would you like to enter another set of GeometricObject to Compare?");
            System.out.println("(Y)es or (N)o");
            answer = input.nextLine();
        }
        counter += 1;
        /** Resets the counter to refill the shapes Array */
        if(answer.equals("Y"))
        {
            counter = 0;
            System.out.println();
        }
    }
    
  }

  /** A method for comparing the areas of two geometric objects */
  public static boolean equalArea(GeometricObject object1,GeometricObject object2) 
  {
    return object1.getArea() == object2.getArea();
  }

  /** A method for displaying a geometric object */
  public static void displayGeometricObject(GeometricObject object) 
  {    
    System.out.println("The area is " + object.getArea());
    System.out.println("The perimeter is " + object.getPerimeter());
  }
  /** A method for initializing a Rectangle GeometricObject */
  public static void initiateRectangle()
  {
    System.out.print("Width: ");
    int width = input.nextInt();
    System.out.print("Height: ");
    int height = input.nextInt();
    input.nextLine();        
    shapes[counter] = new Rectangle(width, height);
  }
  /** A method for initializing a Circle GeometricObject */
  public static void initiateCircle()
  {
    System.out.print("Radius: ");
    int radius = input.nextInt();
    input.nextLine();
    shapes[counter] = new Circle(radius);
  }
  /** A method for initializing a Hexagon GeometricObject */
  public static void initiateHexagon()
  {
    System.out.print("Side Size: ");
    int sideSize = input.nextInt();
    input.nextLine();        
    shapes[counter] = new Hexagon(sideSize);    
  }
  
}