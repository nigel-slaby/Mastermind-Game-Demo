public class Game{   

    public List<Peg> systemCode; //list for the system

    //game constructor
    public Game() {
        systemCode = new ArrayList<>(); //list as arraylist
    }
    
    //method initiates game 
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
    }
}