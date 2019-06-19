import ChessEngine.GUI.GamePanel;
import ChessEngine.GUI.testingBoard;

import javax.swing.*;

public class guiTest {
    public static void main(String[] args){
        JFrame choosePanel = new JFrame("Tester");
        choosePanel.setVisible(true);
        choosePanel.setSize(300, 300);
        choosePanel.setLocationRelativeTo(null);
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
    }
    private static void runTestingBoard(){
        new testingBoard();
    }
}
