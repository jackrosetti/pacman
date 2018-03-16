import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class fruits extends Pacman implements Runnable{

    Random r;
    private Pacman pacman;
    private Level1 level1;
    public boolean collide = false;
    ArrayList<Integer> fruitTrail = new ArrayList<Integer>();
    ArrayList<Integer> pacTrail = new ArrayList<Integer>();

    public fruits(int xAxis, int yAxis, boolean isAlive, String imgPath, boolean canDie, Level1 level1, Pacman pacman)
    {
        super(xAxis, yAxis, isAlive, imgPath, canDie);
        this.level1 = level1;
        this.pacman = pacman;
        r = new Random();
    }


    public void checkForCollision()
    {
        if(pacman.isAlive())
        {
            if(pacman.getHitbox().intersects(getHitbox()))
            {
                level1.score += 10;
                this.setXAxis(r.nextInt(690));
                this.setYAxis(r.nextInt(490));

            }
        }
//        fruitTrail.add(this.getxAxis());
//        fruitTrail.add(this.getyAxis());
//        pacTrail.add(pacman.getxAxis());
//        pacTrail.add(pacman.getyAxis());
//
//        System.out.println(fruitTrail.get(fruitTrail.size()-1));
//        System.out.println(pacTrail.get(fruitTrail.size()-1));
//
//        if(pacTrail.size() == fruitTrail.size())
//        {
//            if((pacTrail.get(pacTrail.size()-1) == fruitTrail.get(fruitTrail.size()-1)) &&
//                    fruitTrail.get(fruitTrail.size()-2) == pacTrail.get(pacTrail.size()-2)){
//                JOptionPane.showMessageDialog(null, "You collided!");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Something went wrong!");
//
//        }
    }


    @Override
    public void run(){
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thread interrupted ");
                System.exit(1);
            }
            checkForCollision();
        }
    }

}