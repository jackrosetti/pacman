import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.logging.Level;

public class Level1 extends JPanel{
    private Random r = new Random();
    private int YAXIS_OF_GHOST = 10;
    private int XAXIS_OF_GHOST = 10;
    public int SCREEN_HEIGHT = 550;
    public int SCREEN_WIDTH = 700;

    private int fruitY = r.nextInt(500);
    private int fruitX = r.nextInt(700);

    JFrame window = new JFrame("APCSA Project");
    Pacman pacman = new Pacman(1, 1, true, "images//nickCUp.png", true);
    KeyEvents keyEvents = new KeyEvents(pacman, this);
    Ghosts ghost1 = new Ghosts(XAXIS_OF_GHOST+20, YAXIS_OF_GHOST+100, true, "images//DecOfInd.jpg", true,
            this, pacman);
    Ghosts ghost2 = new Ghosts(XAXIS_OF_GHOST+100, YAXIS_OF_GHOST+20, true, "images//DecOfInd.jpg",true,
            this, pacman);
    fruits fruit1 = new fruits(fruitX+1, fruitY+1,true, "images//fruit.png", true,
            this, pacman);


    public Level1()
    {
        window.addKeyListener(keyEvents);
        window.add(this); //just adds the JPanel
        Thread thread = new Thread(ghost1);
        thread.start(); //call the run method for the ghost
        Thread thread2 = new Thread(ghost2);
        thread2.start();
        Thread thread3 = new Thread(fruit1);
        thread3.start();
        window.setSize(700, 550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void paint(Graphics graphics)
    {
        ImageIcon imageIcon = new ImageIcon("images//space.jpg");
        graphics.drawImage(imageIcon.getImage(), 0, 0, null);
        pacman.drawPacman(graphics);
        ghost1.drawPacman(graphics);
        ghost2.drawPacman(graphics);
        fruit1.drawPacman(graphics);
    }

}
