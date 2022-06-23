
/**
 * ACS-2947-002 W2021
 * As2
 * Game Class
 * @author nigel slaby 3064324
 */
public class Game{
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        
        Game MasterMind = new Game();
        MasterMind.initiateGame();
        
    }*/
    
    public List<Peg> systemCode; //list for the system

    /* Lots of defunct code before the game was moved to a GUI*/ 
    
    //public List<Peg> guessCode; //list for the guesser
    //Scanner input = new Scanner(System.in); //used for input 
    //String hint = "";  //used to display hint
    //String guess = ""; //used as guess temp string
    //String splitter[]; //used for .split functionality
    //int firstPass;     //used to count successful perfect matches
    //int secondPass;    //used to count colour match but not position
    //String skip = "";  //used to concat numbers that have hit to skip over them
    //String skip2 = ""; //used in a nested loop for the second pass
    //Peg temp;          //used for the current compared peg
    //int hintCount = 0; //used to display the hint by keeping track of concatenation
  
    //game constructor
    public Game() {
     systemCode = new ArrayList<>(); //list as arraylist
     //guessCode = new ArrayList<>();  //list as arraylist
    }
    
    /*method initiates game and handles all scenarios (assumes correct input)*/
    public void initiateGame(){
        //four random coloured pegs created for the system
        Peg first = new Peg();
        first.randomColour();
        Peg second = new Peg();
        second.randomColour();
        Peg third = new Peg();
        third.randomColour();
        Peg fourth = new Peg();
        fourth.randomColour();
        
        //add all generated pegs to the system code
        systemCode.add(0, first);
        systemCode.add(1, second);
        systemCode.add(2, third);
        systemCode.add(3, fourth);
        /* 
        //instantiation of the guess pegs
        Peg guessOne = new Peg();
        Peg guessTwo = new Peg();
        Peg guessThree = new Peg();
        Peg guessFour = new Peg();
        //added blank pegs to the guesscode to start
        guessCode.add(0, guessOne);
        guessCode.add(1, guessTwo);
        guessCode.add(2, guessThree);
        guessCode.add(3, guessFour);
      
        
        //Game starts here and continues for 10 rounds then lose
        for(int i = 0; i < 10; i++){
        System.out.println("Guess #" + (i+1) + ":");
        //user inputs their guess
        guess = input.nextLine();
        
        firstPass = 0; //resets firstPass for next iteration
        secondPass = 0; //resets secondPass for next iteration
        hint = ""; //resets hint for next iteration
        hintCount = 0; //resets hintcount for next iteration
        splitter = guess.split(" "); //split used to break up the guess
        skip = ""; //resets skip for next iteration
        skip2 = ""; //resets skip for next iteration
        
        //assign the split guess to relative pegs
        guess = splitter[0];
        //guessOne.setPegColour(guess.toLowerCase());
        guessCode.set(0, guessOne);
        
        guess = splitter[1];
        //guessTwo.setPegColour(guess.toLowerCase());
        guessCode.set(1, guessTwo);
        
        guess = splitter[2];
        //guessThree.setPegColour(guess.toLowerCase());
        guessCode.set(2, guessThree);
        
        guess = splitter[3];
        //guessFour.setPegColour(guess.toLowerCase());
        guessCode.set(3, guessFour);
        
        //win condition
        if (guessCode.toString().equals(systemCode.toString())){
            System.out.println("You cracked the code!");
            return;
        }
        //first pass for exact matches
        for(int j = 0; j < 4; j++){
        //also checks for invalid input/colours
        if(!guessCode.get(j).toString().equals("black") && !guessCode.get(j).toString().equals("red") && 
           !guessCode.get(j).toString().equals("white") && !guessCode.get(j).toString().equals("blue") &&      
           !guessCode.get(j).toString().equals("yellow") && !guessCode.get(j).toString().equals("green")){
            System.out.println("Incorrect input. Game will now end.");
            return;
        }
        
        if(guessCode.get(j).toString().equals(systemCode.get(j).toString())){
            firstPass++; //increment firstPass for the hint later
            skip = skip.concat(String.valueOf(j)); //add the array placement to skip in the secondPass
            skip2 = skip2.concat(String.valueOf(j)); //add the array placement to skip in the secondPass
            }
        }
       
        //second pass for partial matches
        for(int j = 0; j < 4; j++){
        if(skip.contains(String.valueOf(j))){
            continue; //skip if already accounted for in first pass
        } else {   
        temp = guessCode.get(j); 
        }
            for (int k = 0; k < 4; k++){
                //check each position of system code and also accounts for firstpass but also adds second pass skip
                if(temp.toString().equals(systemCode.get(k).toString()) && !skip2.contains(String.valueOf(k))){
                secondPass++; //increment secondPass for hints later
                skip2 = skip2.concat(String.valueOf(k)); //accounts for second pass skips
                break; //important to break out if we get a hit
                }                 
            }
        }    
        
        //used to construct the string for the hint 
        while(hintCount < 4){
            if(hintCount == 2){
                hint = hint.concat("\n"); //new line on 2
            }
            if(firstPass > 0){
                hint = hint.concat("x "); //x if a good hit
                firstPass--;              //decrease firstpass
                hintCount++;
                continue;
            }
            if(secondPass > 0){
                hint = hint.concat("o "); //o on a good colour hit
                secondPass--;             //decrease secondpass
                hintCount++;
                continue;
            }
            //once both first and second pass are at 0 we add hyphens
            if(firstPass == 0 && secondPass == 0){
                hint = hint.concat("- "); 
                hintCount++;
            }
        }
        //display the hint
            System.out.println(hint + "\n");
        }
        //lose scenario after 10 incorrect guesses
        System.out.println("Sorry, you've lost the game.");
        */
    }
}