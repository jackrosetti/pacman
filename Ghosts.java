import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Ghosts extends Pacman implements Runnable //runnable allows us to use the run method
{
    private Level1 level1;
    private Random r = new Random();
    private int direction = 1; // 1 is right; -1 is left
    private Pacman pacman;
    private int speed = 3;

    public Ghosts(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie, Level1 level1, Pacman pacman)
    {
        super(xAxis, yAxis, isAlive, imgPath, canDie);
        this.level1 = level1;
        this.pacman = pacman;
    }

    //restart game

    public void kill()
    {
        if(pacman.isAlive())
        {
            if(level1.score != 0)
                speed = level1.score / 2; //will always be multiple of two
            //System.out.println("Ghost X: " + getxAxis() +"Y: "+ getyAxis());
            //System.out.println("Pac X: " + pacman.getxAxis() +"Pac Y: "+ pacman.getyAxis());
            if(getHitbox().intersects(pacman.getHitbox()))
            {
                JOptionPane.showMessageDialog(null, "You died!");
                System.exit(0);

            }
            else
            {

            }
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(r.nextInt(100));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thread interrupted ");
                System.exit(1);
            }
            if(getxAxis() <= new Random().nextInt(20)){
                direction = 1;
            }
            else if(getxAxis()>= new Random().nextInt(level1.SCREEN_WIDTH-60))
            {
                direction = -1;
            }
            kill();

            setXAxis(getxAxis()+speed * direction);
            level1.repaint();
        }
    }
}