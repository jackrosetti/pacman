import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class fruits extends Pacman implements Runnable{

    Random r;
    private Pacman pacman;
    private Level1 level1;

    public fruits(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie, Level1 level1, Pacman pacman)
    {
        super(xAxis, yAxis, isAlive, imgPath, canDie);
        this.level1 = level1;
        this.pacman = pacman;

    }

    public void checkForCollision()
    {
        Rectangle pac = new Rectangle(pacman.getxAxis(),pacman.getyAxis(),60, 60);
        Rectangle fruit = new Rectangle(getxAxis(), getyAxis(),60, 60);

        if(pac.intersects(fruit))
        {
            canDie = false;
            System.out.println("SUCCESS");
        }
    }

    @Override
    public void run(){
        while(true)
        {
            checkForCollision();
        }
    }

}
