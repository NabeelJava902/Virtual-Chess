import GUI.GamePanel;
import GUI.testingBoard;

import javax.swing.*;

public class guiTest {
    private static JFrame choosePanel = new JFrame("Tester");
    public static void main(String[] args){
        choosePanel = new JFrame("Tester");
        choosePanel.setVisible(true);
        choosePanel.setSize(300, 300);
        choosePanel.setLocationRelativeTo(null);
        choosePanel.setResizable(false);
        choosePanel.setLayout(new BoxLayout(choosePanel.getContentPane(), BoxLayout.PAGE_AXIS));

        JButton gameButton = new JButton("Start Game");
        JButton testGameButton = new JButton("Test Game");

        choosePanel.getContentPane().add(gameButton);
        choosePanel.getContentPane().add(testGameButton);

        gameButton.addActionListener(e -> runGamePanel());
        testGameButton.addActionListener(e -> runTestingBoard());
    }
    private static void runGamePanel(){
        new GamePanel();
        choosePanel.dispose();
    }
    private static void runTestingBoard(){
        new testingBoard();
        choosePanel.dispose();
    }
}
