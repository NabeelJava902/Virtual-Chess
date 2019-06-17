package ChessEngine.Utils;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class AudioManager {

    public static Clip getLoadedClip(String fileName){
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("data/"+fileName+".wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }

    public static void playMusic(Clip music, long delay){
        class runAudio implements Runnable{

            @Override
            public void run() {
                Timer timer = new Timer();

                TimerTask startMusic = new TimerTask() {
                    @Override
                    public void run() {
                       music.start();
                    }
                };

                TimerTask possiblyStopMusic = new TimerTask() {
                    //TODO use of audio button needs to be fixed
                    @Override
                    public void run() {
                        if(dataUtil.SOUND_SETTTING.equals("OFF") && !music.isActive()){
                            music.stop();
                        }
                    }
                };
                music.start();
                timer.schedule(startMusic, delay);
                timer.schedule(possiblyStopMusic, 1000);
            }
        }
        Thread audioThread = new Thread(new runAudio());
        audioThread.start();
    }
}
