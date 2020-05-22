package GUI;

import Board.Move;
import Board.gameGrid;
import Pieces.Piece;
import Pieces.pieceTypes;
import Utils.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static Pieces.Alliance.BLACK;
import static Pieces.Alliance.WHITE;

public class GamePanel extends JFrame {

    private static final JButton[][] tiles = new JButton[8][8];
    public static clickedTile pieceTile;
    public static Piece pieceAtDestination = null;
    private final Color tileShade = new Color(139, 69, 19);
    private final gameGrid g = new gameGrid();
    protected static Clip pianoMusic;
    private static final int MUSIC_DELAY_TIME = 207000;

    public GamePanel() {
        super("Chess!");
        JPanel contents = new JPanel();
        contents.setLayout(new GridLayout(8, 8));
        ButtonHandler handler = new ButtonHandler();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new JButton();
                if ((i + j) % 2 != 0) {
                    tiles[i][j].setBackground(tileShade);
                }else{
                    tiles[i][j].setBackground(Color.WHITE);
                }
                contents.add(tiles[i][j]);
                tiles[i][j].addActionListener(handler);
            }
        }
        add(contents, BorderLayout.CENTER);
        setUpPieces();
        setDimensions();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        add(new sidePanel(), BorderLayout.EAST);
        add(new activeTurnPanel(), BorderLayout.PAGE_END);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pianoMusic = AudioManager.getLoadedClip("chess_background_music");
        AudioManager.playMusic(pianoMusic, MUSIC_DELAY_TIME);
    }

    private void setUpPieces() {
        setPiece(56, dataUtil.whiteRook);
        setPiece(48, dataUtil.whitePawn);
        setPiece(63, dataUtil.whiteRook);
        setPiece(55, dataUtil.whitePawn);
        setPiece(57, dataUtil.whiteKnight);
        setPiece(49, dataUtil.whitePawn);
        setPiece(62, dataUtil.whiteKnight);
        setPiece(54, dataUtil.whitePawn);
        setPiece(58, dataUtil.whiteBishop);
        setPiece(50, dataUtil.whitePawn);
        setPiece(61, dataUtil.whiteBishop);
        setPiece(53, dataUtil.whitePawn);
        setPiece(59, dataUtil.whiteKing);
        setPiece(51, dataUtil.whitePawn);
        setPiece(60, dataUtil.whiteQueen);
        setPiece(52, dataUtil.whitePawn);
        setPiece(0, dataUtil.blackRook);
        setPiece(8, dataUtil.blackPawn);
        setPiece(7, dataUtil.blackRook);
        setPiece(15, dataUtil.blackPawn);
        setPiece(1, dataUtil.blackKnight);
        setPiece(9, dataUtil.blackPawn);
        setPiece(6, dataUtil.blackKnight);
        setPiece(14, dataUtil.blackPawn);
        setPiece(2, dataUtil.blackBishop);
        setPiece(10, dataUtil.blackPawn);
        setPiece(5, dataUtil.blackBishop);
        setPiece(13, dataUtil.blackPawn);
        setPiece(3, dataUtil.blackKing);
        setPiece(11, dataUtil.blackPawn);
        setPiece(4, dataUtil.blackQueen);
        setPiece(12, dataUtil.blackPawn);
    }

    private void setPiece(int location, ImageIcon img) {
        ArrayList<Integer> loc = linkEngineToGui.arrayListToArray(location);
        int row = loc.get(0);
        int col = loc.get(1);
        tiles[row][col].setIcon(img);
        pieceUtil.addPiece(g, img, location);
    }

    private void gameOver(){
        String message = gridUtil.findWinner(pieceAtDestination)+" wins.";
        JOptionPane.showMessageDialog(this, message);
        System.exit(0);
    }

    private void setDimensions(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dimension.height -= 50;
        dimension.width -= 50;
        setSize(dimension);
    }

    private class ButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(pieceTile == null) {
                    Object source = e.getSource();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (source == tiles[i][j]) {
                                if(g.emptyPiecesGrid.get(linkEngineToGui.arrayToArrayList(i, j)).alliance == BLACK && activeTurnPanel.activeTurn.getText().equals("BLACK TURN")) {
                                    pieceTile = clickedTile.assignClickedTile(linkEngineToGui.arrayToArrayList(i, j), tiles[i][j]);
                                    try {
                                        highlightValidMove(pieceTile.piece);
                                    }catch (Exception ex) {}
                                }else if(g.emptyPiecesGrid.get(linkEngineToGui.arrayToArrayList(i, j)).alliance == WHITE && activeTurnPanel.activeTurn.getText().equals("WHITE TURN")){
                                    pieceTile = clickedTile.assignClickedTile(linkEngineToGui.arrayToArrayList(i, j), tiles[i][j]);
                                    try {
                                        highlightValidMove(pieceTile.piece);
                                    }catch (Exception ex) {}
                                }
                            }
                        }
                    }
                }else{
                    Object source = e.getSource();
                    int iLoc=0, jLoc=0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (source == tiles[i][j]) {
                                pieceAtDestination = gridUtil.findPieceFromLocation(linkEngineToGui.arrayToArrayList(i, j), g);
                                sidePanel.updateText();
                                processClick(i, j);
                                iLoc = i;
                                jLoc = j;
                                switchTurn(i, j);
                                removeHighlight();

                                try {
                                    if (pieceAtDestination.pieceType != pieceTypes.EMPTY && pieceAtDestination.alliance != pieceTile.piece.alliance
                                            && dataUtil.SOUND_SETTING.equals("ON")) {
                                        class runAudio implements Runnable {

                                            @Override
                                            public void run() {
                                                Clip audio = AudioManager.getLoadedClip("chess_destroy_sound");
                                                audio.start();
                                            }
                                        }
                                        Thread audioThread = new Thread(new runAudio());
                                        audioThread.start();
                                    }
                                }catch (NullPointerException el){}
                            }
                        }
                    }
                    try {
                        Move move = new Move(linkEngineToGui.arrayToArrayList(iLoc, jLoc), pieceTile.piece);
                        if(pieceAtDestination.pieceType == pieceTypes.KING){
                            gameOver();
                        }
                        g.emptyPiecesGrid = move.normalMove(g);
                    }catch(Exception exc){}
                    pieceTile = null;
                }
            }
        private boolean isValidMove(int i, int j) {
            int finalPos = linkEngineToGui.arrayToArrayList(i, j);
            int currentPos;
            try {
                currentPos = pieceTile.piece.location;
            }catch (NullPointerException e){
                currentPos = 0;
            }

            return pieceTile.piece.getLegalMoves(g).contains((currentPos - finalPos) * -1);
        }

        private void processClick(int i, int j) {
            if (!isValidMove(i, j)) {
                pieceTile = null;
                return;
            }
            tiles[pieceTile.row][pieceTile.col].setIcon(null);
            tiles[i][j].setIcon(pieceTile.img);
        }

        private void switchTurn(int i, int j){
            if (tiles[i][j].getBackground() == Color.GREEN) {
                String turn = (activeTurnPanel.activeTurn.getText().equals("WHITE TURN")) ? "BLACK TURN" : "WHITE TURN";
                activeTurnPanel.activeTurn.setText(turn);
            }
        }

        private void highlightValidMove(Piece piece){
            for(int currentLegalMove : piece.getLegalMoves(g)){
                int currentLoc = piece.location + currentLegalMove;
                int row = linkEngineToGui.arrayListToArray(currentLoc).get(0);
                int col = linkEngineToGui.arrayListToArray(currentLoc).get(1);
                tiles[row][col].setBackground(Color.GREEN);
            }
        }
        private void removeHighlight(){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 != 0) {
                        tiles[i][j].setBackground(tileShade);
                    }else{
                        tiles[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }
    }
}