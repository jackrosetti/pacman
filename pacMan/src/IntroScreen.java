import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IntroScreen extends JFrame implements ActionListener
{
    private JButton play;
    private JButton quit;
    public JPanel panel = new JPanel();
    public JFrame window = new JFrame("APCSA Project");

    public IntroScreen()
    {
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void paint(Graphics graphics)
    {
        ImageIcon imageIcon = new ImageIcon("images//space.jpg");
        graphics.drawImage(imageIcon.getImage(), 0, 0, null);
        graphics.setColor(Color.yellow);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        graphics.drawString("Made by Jack and David", 250,50);
        play = new JButton("Play");
        play.setBounds(200, 100, 10, 20);
        quit = new JButton("Quit");
        quit.setBounds(350, 200, 100, 70);
        play.addActionListener(this);
        quit.addActionListener(this);
        panel.add(play);
        panel.add(quit);
        window.add(panel);
        window.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quit)
        {
            JOptionPane.showMessageDialog(null, "You died!");
            System.exit(0);
        }
        else if(e.getSource() == play)
        {
            Level1 level1 = new Level1();
        }
    }
}