import java.util.Random;
import java.awt.*;

//this class was created for a Data Structures and Algorithms course

 public class Peg {
    private Color col;
    Random rando = new Random(); //randomizer instantiation
    int randomPick = rando.nextInt(6); //random number used for random colour
     
    public Peg(){        
    }

    //getter for peg colour
    public Color getPegColour(){
        return col;
    }

    //setter for peg colour
    public void setPegColour(Color c){
        this.col = c;
    }

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