import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.*;
import java.io.*;

public class Executable {
    //TO DO: Fix AI, add leaderboard
    public static void main(String[] args)
    {
        IntroScreen intro = new IntroScreen();
        intro.setVisible(true);
        play();
    }

    private static void play()
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
