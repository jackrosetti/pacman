import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.*;
import java.io.*;

public class Executable {
    //TO DO: Fix kill code, add fruits
    public static void main(String[] args)
    {
        Level1 level1 = new Level1();
//        play();
    }

    public static void play()
    {
        try {
            File file = new File("sounds//tetris.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
