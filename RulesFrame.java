import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulesFrame {

    JFrame frame; 
    JPanel panel;
    JLabel label;
    JLabel title;
    String text = "\u2022 A random code has been generated\n\u2022 Click the coloured squares to change the colour for your guess.\n\u2022 Hints will be shown after your first guess.\n\u2022 Red hints indicate a perfect match for colour and location.\n\u2022 White hints indicate a match for colour, but not for position.\n\u2022 Grey hints indicates an incorrect match for colour and position.\n\nGood Luck!";
    RulesFrame(){
        frame = new JFrame();
        panel = new JPanel();
        String formatted = text.replace("\n", "<br>");
        formatted = "<html><font size='5'>" + formatted + "</font></html>";
        label = new JLabel(formatted);
        label.setBounds(8,10,380,400);
        label.setFont(new Font(null,Font.PLAIN,5));
        label.setForeground(Color.white);
        panel.add(label);

        title = new JLabel("How to Play Mastermind");
        title.setBounds(15,0,350,50);
        title.setFont(new Font(null,Font.BOLD,30));
        title.setForeground(Color.white);
        panel.add(title);

        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Mastermind Rules");
        //frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400); 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}