package GUI;

import Utils.dataUtil;

import javax.swing.*;
import java.awt.*;

public class activeTurnPanel extends JPanel {
    public static JLabel activeTurn;
    public static JButton resetButton;
    public static JButton soundButton;

    protected activeTurnPanel(){
        activeTurn = new JLabel();
        resetButton = new JButton("RESET");
        soundButton = new JButton("AUDIO: " + dataUtil.SOUND_SETTTING);
        activeTurn.setText(dataUtil.ACTIVE_TURN);
        setLayout(new FlowLayout());

        add(activeTurn);
        add(resetButton);
        add(soundButton);

        resetButton.addActionListener(e -> resetGame());
        soundButton.addActionListener(e -> switchSoundSetting());
    }

    private void resetGame(){
        SwingUtilities.getWindowAncestor(this).dispose();
        GamePanel.pianoMusic.stop();
        new GamePanel();
    }

    private void switchSoundSetting(){
        dataUtil.SOUND_SETTTING = (dataUtil.SOUND_SETTTING.equals("ON")) ? "OFF" : "ON";
        soundButton.setText("AUDIO: " + dataUtil.SOUND_SETTTING);
        if(dataUtil.SOUND_SETTTING.equals("OFF")){
            GamePanel.pianoMusic.stop();
        }else {
            GamePanel.pianoMusic.start();
        }
    }
}
