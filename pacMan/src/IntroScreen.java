import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import javax.swing.*;

public class IntroScreen extends JFrame implements ActionListener
{
    private JButton play;
    private JButton quit;
    public static int topScore;
    public JPanel panel = new JPanel();
    //public JFrame window = new JFrame();
    public ArrayList<Integer> scores = new ArrayList<>();

    public IntroScreen()
    {
        setSize(700, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("APCSA Project");
        JLabel jtext = new JLabel("Made by Jack and David");
        jtext.setForeground(Color.yellow);
        play = new JButton("Play");
        play.setBounds(300, 200, 100, 70);
        quit = new JButton("Quit");
        quit.setBounds(470, 320, 100, 70);
        play.addActionListener(this);
        quit.addActionListener(this);
        panel.add(jtext);
        panel.add(play);
        panel.add(quit);
        this.getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public int getScores(ArrayList<Integer> scores) throws IOException
    {
        Scanner scanFile = new Scanner(new File("images//scores.io"));
        while(scanFile.hasNext())
        {
            scores.add(scanFile.nextInt());
        }
        Collections.sort(scores);
        int size = scores.size();
        topScore = scores.get(size-1);
        return topScore;
    }


    public void paint(Graphics graphics)
    {

        ImageIcon imageIcon = new ImageIcon("images//space.jpg");
        graphics.drawImage(imageIcon.getImage(), 0, 0, null);
        graphics.setColor(Color.yellow);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        graphics.drawString("Pacman made by Jack and David", 300,400);
        graphics.drawString("jackrrosetti.com", 300, 420);
        graphics.drawString("davidtsong.com",300, 440);
        try {
            graphics.drawString("Top score:" + Integer.toString(getScores(scores)), 300, 350);
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Something went wrong because Jack is an idiot");
    }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == quit)
        {
            JOptionPane.showMessageDialog(null, "See ya!");
            System.exit(0);
        }
        else if(e.getSource() == play)
        {
            Level1 level1 = new Level1();
            setVisible(false);
        }
    }
}
