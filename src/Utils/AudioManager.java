package Utils;

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
            clip.open(AudioSystem.getAudioInputStream(new File("res/"+fileName+".wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }

    public static void playMusic(Clip music, long delay){
        class runAudio implements Runnable{
            //TODO audio needs debugging
            @Override
            public void run() {
                Timer timer = new Timer();

                TimerTask startMusic = new TimerTask() {
                    @Override
                    public void run() {
                        if(dataUtil.SOUND_SETTING.equals("ON")) {
                            music.start();
                        }
                    }
                };
                music.start();
                timer.schedule(startMusic, delay);

                do {
                    if(dataUtil.SOUND_SETTING.equals("OFF")){
                        music.stop();
                    }
                }while (!dataUtil.SOUND_SETTING.equals("OFF"));
            }
        }
        Thread audioThread = new Thread(new runAudio());
        audioThread.start();
    }
}