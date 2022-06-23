import java.util.Random;
import java.awt.*;
/**
 * ACS-2947-002 W2021
 * As2
 * Peg Class
 * @author nigel slaby 3064324
 */
public class Peg {
    private Color col;
    Random rando = new Random(); //randomizer instantiation
    int randomPick = rando.nextInt(6); //random number used for random colour
    /**
     * Constructs a peg
     * @param col colour of peg
     */  
    public Peg(){
        //this.col = col;
    }
    //getter for peg colour
    public Color getPegColour(){
        return col;
    }
    //setter for peg colour
    public void setPegColour(Color c){
        this.col = c;
    }
    /** Creates a string representation of Peg
     *  @return string representation of Peg
     */
    //public String toString(){
    //    String s = colour;
    //    return s;
    //}
    //used to assign a peg a random colour
    public void randomColour(){
        switch(randomPick){
            case 0: this.col = Color.black;
                    break;
            case 1: this.col = Color.white;
                    break;
            case 2: this.col = Color.red;
                    break;
            case 3: this.col = Color.blue;
                    break;
            case 4: this.col = Color.green;
                    break;
            case 5: this.col = Color.yellow;
                    break;
            default: this.col = Color.magenta;
        }
    }
    
}