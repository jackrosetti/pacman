import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//THE PURPOSE OF THIS CLASS IS TO GET KEYBOARD INPUT
public class KeyEvents implements KeyListener{ //are you proud of us?

    private Pacman pacman;
    private int speed = 10;
    private Level1 level1;
    private String down = "images//nickCDown";
    private String up = "images//nickCUp";
    private String right = "images//nickCRight";
    private String left = "images//nickCLeft";
    private String lastMove = "";

    public KeyEvents(Pacman pacman, Level1 level1)
    {
        this.level1 = level1;
        this.pacman = pacman;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
        {
            pacman.setXAxis(pacman.getxAxis() - speed);
            //pacman.setImagePath(left);
            level1.repaint();
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            pacman.setXAxis(pacman.getxAxis() + speed);
            //pacman.setImagePath(right);
            level1.repaint();

        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
        {
            pacman.setYAxis(pacman.getyAxis() - speed);
            //pacman.setImagePath(up);
            level1.repaint();
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
        {
            pacman.setYAxis(pacman.getyAxis() + speed);
            //pacman.setImagePath(down);
            level1.repaint();
        }
        else
        {

        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
