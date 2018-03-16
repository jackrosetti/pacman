import javax.swing.*;
import java.awt.*;

public class Pacman {

    private int xAxis;
    private int yAxis;
    private String imgPath;
    private boolean isAlive;
    public boolean canDie;

    private Rectangle hitbox;

    public Pacman(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie)
    {
        setXAxis(xAxis);
        setYAxis(yAxis);
        setImagePath(imgPath);
        setIsAlive(isAlive);
        setCanDie(canDie);
        hitbox = new Rectangle(xAxis,yAxis, 90, 90);

    }


    public void setXAxis(int xAxis)
    {
        if(isAlive)
        {
            if(this.xAxis >= 670) //set bounds based on my screen
            {
                this.xAxis = 660;
            }
            else if(this.yAxis <= 0) //cannot go off screen
            {
                this.yAxis = 0;
            }
            else {

                this.xAxis = xAxis;
            }

        }
        else{
            this.xAxis = xAxis;
        }
    }

    public void setYAxis(int yAxis)
    {
        if(isAlive)
        {
            if(this.yAxis >= 520) //set bounds based on my screen
            {
                this.yAxis = 500;
            }
            else if(this.yAxis <= 0) //cannot go off screen
            {
                this.yAxis = 0;
            }
            else {

                this.yAxis = yAxis;
            }

        }
        else{
            this.yAxis = yAxis;
        }
    }

    public void setImagePath(String imgPath)
    {
        if(imgPath == null){
            JOptionPane.showMessageDialog(null, "String is null, dude!");
            System.exit(1);
        }
        else {
            this.imgPath = imgPath;
        }
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public void setCanDie(boolean canDie){
        this.canDie = canDie;
    }

    public boolean getCanDie(){
        return canDie;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public String getImgPath() {
        return imgPath;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public Rectangle getHitbox(){return hitbox;}

    public void drawPacman(Graphics graphics)
    {

        Graphics2D g = (Graphics2D) graphics;
        g.clearRect((int) hitbox.getX(),(int) hitbox.getY(),hitbox.width,hitbox.height);
        hitbox = new Rectangle(this.getxAxis(), this.getyAxis(), 55, 55);
//        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));

        g.drawRect((int) hitbox.getX(),(int) hitbox.getY(),hitbox.width,hitbox.height);

        ImageIcon img = new ImageIcon(imgPath);
        g.drawImage(img.getImage(), xAxis, yAxis, null );
    }


}