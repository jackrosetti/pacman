import javax.swing.*;
import java.awt.*;

public class Pacman {

    private int xAxis;
    private int yAxis;
    private String imgPath;
    private boolean isAlive;
    public boolean canDie;

    public Pacman(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie)
    {
        setXAxis(xAxis);
        setYAxis(yAxis);
        setImagePath(imgPath);
        setIsAlive(isAlive);
        setCanDie(canDie);
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

    public void drawPacman(Graphics graphics)
    {
        ImageIcon img = new ImageIcon(imgPath);
        graphics.drawImage(img.getImage(), xAxis, yAxis, null );
    }


}
