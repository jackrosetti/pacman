import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghosts extends Pacman implements Runnable //runnable allows us to use the run method
{
    private Level1 level1;
    Random r = new Random();
    private int direction = 1; // 1 is right; -1 is left
    private Pacman pacman;

    public Ghosts(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie, Level1 level1, Pacman pacman)
    {
        super(xAxis, yAxis, isAlive, imgPath, canDie);
        this.level1 = level1;
        this.pacman = pacman;
    }

    //restart game

    public void kill()
    {
        Rectangle pacmanRectangle = new Rectangle(pacman.getxAxis(), pacman.getyAxis(), 60, 60);
        Rectangle ghostRectangle = new Rectangle(this.getxAxis(), this.getyAxis(), 60, 60);
        if(pacman.isAlive() && pacman.canDie)
        {
            if(pacmanRectangle.contains(ghostRectangle))
            {
                JOptionPane.showMessageDialog(null, "You died!");
                System.exit(0);
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
            setXAxis(getxAxis()+3 * direction);
            level1.repaint();
        }
    }
}
