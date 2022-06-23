import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{
    
    public static void main(String[] args){
        new GUI();
    }

    Game mm = new Game();
    
    JFrame frame;
    JPanel panel; 
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton hintButton1;
    JButton hintButton2;
    JButton hintButton3;
    JButton hintButton4;
    JButton submitButton;
    JButton rulesButton;
    JButton restartButton;
    JLabel title;
    JLabel subtitle;
    Font arialTitle = new Font("Arial", Font.BOLD, 50);
    Font arialSubtitle = new Font("Arial", Font.PLAIN, 20);
    int guessCount = 0;
    int redPegs;
    int whitePegs;
    JButton squarePainter;
    JLabel textPainter;
    public GUI(){    
        mm.initiateGame();  
        frame = new JFrame();
        panel = new JPanel();
        
        //title
        title = new JLabel();
        title.setBounds(75, 10, 500, 50);
        title.setFont(arialTitle);
        title.setText("MASTERMIND");
        title.setOpaque(true);
        title.setBackground(Color.darkGray);
        title.setForeground(Color.white);

        //subtitle
        subtitle = new JLabel();
        subtitle.setBounds(135, 50, 220, 50);
        subtitle.setFont(arialSubtitle);
        subtitle.setText("Crack the Secret Code!");
        subtitle.setOpaque(true);
        subtitle.setBackground(Color.darkGray);
        subtitle.setForeground(Color.white);

        //create button1
        button1 = new JButton();
        button1.setBounds(150,100,30, 30);
        button1.setBackground(Color.blue);
        button1.addActionListener(this);

        //create button2
        button2 = new JButton();
        button2.setBounds(200,100,30, 30);
        button2.setBackground(Color.green);
        button2.addActionListener(this);

        //create button3
        button3 = new JButton();
        button3.setBounds(250,100,30, 30);
        button3.setBackground(Color.red);
        button3.addActionListener(this);

        //create button4
        button4 = new JButton();
        button4.setBounds(300,100,30, 30);
        button4.setBackground(Color.yellow);
        button4.addActionListener(this);

        //create hintButton1
        hintButton1 = new JButton();
        hintButton1.setBounds(300,100,30, 30);
        hintButton1.setBackground(Color.yellow);

        //create hintButton1
        hintButton1 = new JButton();
        hintButton1.setBounds(300,100,30, 30);
        hintButton1.setBackground(Color.yellow);


        //create submit button
        submitButton = new JButton();
        submitButton.setBounds(180,600,120, 30);
        submitButton.addActionListener(this);
        submitButton.setText("Submit Guess");
        submitButton.setBackground(new Color(90,90,90));
        submitButton.setForeground(Color.white);
        

        //create rules button(opens new window)
        rulesButton = new JButton();
        rulesButton.setBounds(350,600,100, 30);
        rulesButton.addActionListener(this);
        rulesButton.setText("How to Play");
        rulesButton.setBackground(new Color(90,90,90));
        rulesButton.setForeground(Color.white);

        //panel handling
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.add(title);
        panel.add(subtitle);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(submitButton);
        panel.add(rulesButton);
        

        //frame handling
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mastermind Demo");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,700); 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
    }

    //changes square color for guessing
    public void changeColor(JButton b){
        if(b.getBackground() == Color.blue){           
            b.setBackground(Color.green);
            return;
        }
        if(b.getBackground() == Color.green){           
            b.setBackground(Color.red);
            return;
        }
        if(b.getBackground() == Color.red){           
            b.setBackground(Color.yellow);
            return;
        }
        if(b.getBackground() == Color.yellow){            
            b.setBackground(Color.white);
            return;
        }
        if(b.getBackground() == Color.white){    
            b.setBackground(Color.black);
            return;
        }
        if(b.getBackground() == Color.black){    
            b.setBackground(Color.blue);
            return;
        }
    }   

    //paints the guessed squares
    public void paintSquares(JButton a,JButton b,JButton c,JButton d){
        Rectangle positionA = a.getBounds();
        Rectangle positionB = b.getBounds();
        Rectangle positionC = c.getBounds();
        Rectangle positionD = d.getBounds();
        
        
        //paint square 1
        squarePainter = new JButton();
        squarePainter.setBounds(positionA);
        squarePainter.setBackground(a.getBackground());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint square 2
        squarePainter = new JButton();
        squarePainter.setBounds(positionB);
        squarePainter.setBackground(b.getBackground());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint square 3
        squarePainter = new JButton();
        squarePainter.setBounds(positionC);
        squarePainter.setBackground(c.getBackground());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint square 4
        squarePainter = new JButton();
        squarePainter.setBounds(positionD);
        squarePainter.setBackground(d.getBackground());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);               
        
        positionA.y += 50;
        positionB.y += 50;
        positionC.y += 50;
        positionD.y += 50;

        a.setBounds(positionA);
        b.setBounds(positionB);
        c.setBounds(positionC);
        d.setBounds(positionD);       
    }

    //places a new guess label each time a guess is made
    public void guessPosition(JButton a){
        Rectangle positionA = a.getBounds();

        textPainter = new JLabel();
        textPainter.setBounds(35, positionA.y-10, 100, 50);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("Guess " + guessCount + ":");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.white);
        panel.add(textPainter);
        panel.repaint();
    }

    public int hintDraw(JButton a, JButton b, JButton c, JButton d, List<Peg> p){
        //used for win condition
        int x = 0;

        //temps used to not change original
        List<Color> temp = new ArrayList<Color>();
        List<Color> systemTemp = new ArrayList<Color>();
        temp.add(0, a.getBackground());
        temp.add(1, b.getBackground());
        temp.add(2, c.getBackground());
        temp.add(3, d.getBackground());

        systemTemp.add(0, p.get(0).getPegColour());
        systemTemp.add(1, p.get(1).getPegColour());
        systemTemp.add(2, p.get(2).getPegColour());
        systemTemp.add(3, p.get(3).getPegColour());

        //first pass for exact matches
        for(int i = 0; i < 4; i++){
            if(temp.get(i) == systemTemp.get(i)){
                redPegs++;
                temp.set(i, null);
                systemTemp.set(i, null);
            }
        }
        //second pass for colour matches
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(temp.get(i)!=null){
                    if(temp.get(i) == systemTemp.get(j)){
                        whitePegs++;
                        temp.set(i, null);
                        systemTemp.set(j, null);
                    }
                }
            }
        }

        //win condition
        if(redPegs ==4){
            x = 1;
        }

        //reference position to place the hint squares
        Rectangle positionD = d.getBounds();

        //paint hint square top left
        squarePainter = new JButton();
        squarePainter.setBounds(400,positionD.y,10, 10);
        if(redPegs>0){
            squarePainter.setBackground(Color.RED);
            redPegs--;
        } else if(whitePegs>0) {
            squarePainter.setBackground(Color.WHITE);
            whitePegs--;
        } else {
            squarePainter.setBackground(new Color(90,90,90));
        }
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint hint square top right
        squarePainter = new JButton();
        squarePainter.setBounds(420,positionD.y,10, 10);
        if(redPegs>0){
            squarePainter.setBackground(Color.RED);
            redPegs--;
        } else if(whitePegs>0) {
            squarePainter.setBackground(Color.WHITE);
            whitePegs--;
        } else {
            squarePainter.setBackground(new Color(90,90,90));
        }
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint hint square bottom left
        squarePainter = new JButton();
        squarePainter.setBounds(400,positionD.y + 20,10, 10);
        if(redPegs>0){
            squarePainter.setBackground(Color.RED);
            redPegs--;
        } else if(whitePegs>0) {
            squarePainter.setBackground(Color.WHITE);
            whitePegs--;
        } else {
            squarePainter.setBackground(new Color(90,90,90));
        }
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //paint hint square bottom right
        squarePainter = new JButton();
        squarePainter.setBounds(420,positionD.y + 20,10, 10);
        if(redPegs>0){
            squarePainter.setBackground(Color.RED);
            redPegs--;
        } else if(whitePegs>0) {
            squarePainter.setBackground(Color.WHITE);
            whitePegs--;
        } else {
            squarePainter.setBackground(new Color(90,90,90));
        }
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        //add hint tag
        textPainter = new JLabel();
        textPainter.setBounds(398, 35, 100, 100);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("Hint");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.white);
        panel.add(textPainter);        

        panel.repaint();

        //if return 1 game has been one otherwise return 0
        return x;
    }

    public void winScenario(){
        //reveal code squares
        showAnswer(mm.systemCode.get(0), 
                   mm.systemCode.get(1), 
                   mm.systemCode.get(2), 
                   mm.systemCode.get(3));
        //disable coloured buttons
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        //adding 'you win' label
        textPainter = new JLabel();
        textPainter.setBounds(200, 635, 100, 20);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("You Win!");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.green);
        panel.add(textPainter);

        //adding answer label
        textPainter = new JLabel();
        textPainter.setBounds(46, 595, 100, 100);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("Answer");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.white);
        panel.add(textPainter);

        //replace submit button with restart button
        restartButton = new JButton();
        restartButton.setBounds(180,600,120, 30);
        restartButton.addActionListener(this);
        restartButton.setText("Play Again?");
        restartButton.setBackground(new Color(90,90,90));
        restartButton.setForeground(Color.white);
        panel.remove(submitButton);
        panel.add(restartButton);

        panel.repaint();
    }

    public void loseScenario(){
        //reveal code
        showAnswer(mm.systemCode.get(0), 
                   mm.systemCode.get(1), 
                   mm.systemCode.get(2), 
                   mm.systemCode.get(3));

        //disable coloured buttons
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        //adding you lose label
        textPainter = new JLabel();
        textPainter.setBounds(200, 635, 100, 20);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("You Lose.");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.red);
        panel.add(textPainter);

        //adding answer label
        textPainter = new JLabel();
        textPainter.setBounds(46, 595, 100, 100);
        textPainter.setFont(arialSubtitle);
        textPainter.setText("Answer");
        textPainter.setOpaque(true);
        textPainter.setBackground(Color.darkGray);
        textPainter.setForeground(Color.white);
        panel.add(textPainter);

        //replace submit button with restart button
        restartButton = new JButton();
        restartButton.setBounds(180,600,120, 30);
        restartButton.addActionListener(this);
        restartButton.setText("Play Again?");
        restartButton.setBackground(new Color(90,90,90));
        restartButton.setForeground(Color.white);
        restartButton.setVisible(true);
        panel.remove(submitButton);
        panel.add(restartButton);

        panel.repaint();
    }

    //used to reveal coloured code
    public void showAnswer(Peg a, Peg b, Peg c, Peg d){
        
        squarePainter = new JButton();
        squarePainter.setBounds(20,600,30, 30);
        squarePainter.setBackground(a.getPegColour());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        squarePainter = new JButton();
        squarePainter.setBounds(50,600,30, 30);
        squarePainter.setBackground(b.getPegColour());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        squarePainter = new JButton();
        squarePainter.setBounds(80,600,30, 30);
        squarePainter.setBackground(c.getPegColour());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        squarePainter = new JButton();
        squarePainter.setBounds(110,600,30, 30);
        squarePainter.setBackground(d.getPegColour());
        squarePainter.setEnabled(false);
        panel.add(squarePainter);

        panel.repaint();
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        
        //changes button colours
		if(e.getSource()==button1){
            changeColor(button1);
        }
		if(e.getSource()==button2){
            changeColor(button2);
        }
        if(e.getSource()==button3){
            changeColor(button3);
        }
        if(e.getSource()==button4){
            changeColor(button4);
        }

        //guess logic handling
        if(e.getSource()==submitButton){

            if(guessCount<9){
                guessCount++;
                guessPosition(button1);
                if(hintDraw(button1,button2,button3,button4,mm.systemCode)==1){
                    winScenario();
                }else{               
                paintSquares(button1, button2, button3, button4); 
                }                         
            } else {
                guessCount++;
                guessPosition(button1);
                if(hintDraw(button1,button2,button3,button4,mm.systemCode)==1){
                    winScenario();
                } else {
                    loseScenario();
                }
            }            
        }

        //closes frame and restarts program
        if(e.getSource()==restartButton){           
            main(new String[] {});
            frame.dispose();
        }

        //creates the rules frame
        if(e.getSource()==rulesButton){            
            new RulesFrame();
        }
	}
}