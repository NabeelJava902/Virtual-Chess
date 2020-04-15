package GUI;

import Pieces.Alliance;
import Pieces.Piece;
import Pieces.pieceTypes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static Pieces.Alliance.BLACK;
import static Pieces.Alliance.WHITE;

public class sidePanel extends JPanel {
    private static int whiteKnightCount, whitePawnCount, whiteRookCount, whiteBishopCount, whiteQueenCount, whiteKingCount;
    private static int blackKnightCount, blackPawnCount, blackRookCount, blackBishopCount, blackQueenCount, blackKingCount;
    private static JLabel whiteKnightText, whitePawnText, whiteRookText, whiteBishopText, whiteQueenText, whiteKingText;
    private static JLabel blackKnightText, blackPawnText, blackRookText, blackBishopText, blackQueenText, blackKingText;
    private static JButton button = new JButton("Piece Graveyard");

    protected sidePanel(){
        setBorder(new LineBorder(Color.BLACK, 4));
        setBackground(Color.CYAN);
        setLayout(new GridLayout(13, 1));
        button.setSize(100, 50);

        blackBishopCount = blackKnightCount = blackPawnCount = blackRookCount = blackKingCount = blackQueenCount =
                whiteRookCount = whiteQueenCount = whiteKingCount = whitePawnCount = whiteRookCount = whiteBishopCount = 0;

        whiteKnightText = new JLabel();
        whitePawnText = new JLabel();
        whiteRookText = new JLabel();
        whiteBishopText = new JLabel();
        whiteQueenText = new JLabel();
        whiteKingText = new JLabel();
        blackKnightText = new JLabel();
        blackPawnText = new JLabel();
        blackRookText = new JLabel();
        blackBishopText = new JLabel();
        blackQueenText = new JLabel();
        blackKingText = new JLabel();

        add(button);
        add(blackKnightText);
        add(blackPawnText);
        add(blackRookText);
        add(blackBishopText);
        add(blackQueenText);
        add(blackKingText);
        add(whiteKnightText);
        add(whitePawnText);
        add(whiteRookText);
        add(whiteBishopText);
        add(whiteQueenText);
        add(whiteKingText);

        updateGraveyard();
    }

    protected static void updateText(){
        Piece deadPiece = GamePanel.pieceAtDestination;
        Piece movingPiece = GamePanel.pieceTile.piece;
        Alliance alliance = deadPiece.alliance;
        pieceTypes type = deadPiece.pieceType;

        if(deadPiece.pieceType != pieceTypes.EMPTY) {
            if(type == pieceTypes.KNIGHT && alliance == BLACK && movingPiece.alliance != BLACK){
                blackKnightCount++;
            }else if(type == pieceTypes.KNIGHT && alliance == WHITE && movingPiece.alliance != WHITE){
                whiteKnightCount++;
            }else if(type == pieceTypes.BISHOP && alliance == BLACK && movingPiece.alliance != BLACK){
                blackBishopCount++;
            }else if(type == pieceTypes.BISHOP && alliance == WHITE && movingPiece.alliance != WHITE){
                whiteBishopCount++;
            }else if(type == pieceTypes.ROOK && alliance == BLACK && movingPiece.alliance != BLACK){
                blackRookCount++;
            }else if(type == pieceTypes.ROOK && alliance == WHITE && movingPiece.alliance != WHITE){
                whiteRookCount++;
            }else if(type == pieceTypes.PAWN && alliance == BLACK && movingPiece.alliance != BLACK){
                blackPawnCount++;
            }else if(type == pieceTypes.PAWN && alliance == WHITE && movingPiece.alliance != WHITE){
                whitePawnCount++;
            }else if(type == pieceTypes.KING && alliance == BLACK && movingPiece.alliance != BLACK){
                blackKingCount++;
            }else if(type == pieceTypes.KING && alliance == WHITE && movingPiece.alliance != WHITE){
                whiteKingCount++;
            }else if(type == pieceTypes.QUEEN && alliance == BLACK && movingPiece.alliance != BLACK){
                blackQueenCount++;
            }else if(type == pieceTypes.QUEEN && alliance == WHITE && movingPiece.alliance != WHITE){
                whiteQueenCount++;
            }
            updateGraveyard();
        }
    }
    private static void updateGraveyard(){
        whiteKnightText.setText("W-KNIGHT - "+whiteKnightCount);
        whiteBishopText.setText("W-BISHOP - "+whiteBishopCount);
        whiteRookText.setText("W-ROOK - "+whiteRookCount);
        whiteKingText.setText("W-KING - "+whiteKingCount);
        whiteQueenText.setText("W-QUEEN - "+whiteQueenCount);
        whitePawnText.setText("W-PAWN - "+whitePawnCount);
        blackKnightText.setText("B-KNIGHT - "+blackKnightCount);
        blackBishopText.setText("B-BISHOP - "+blackBishopCount);
        blackRookText.setText("B-ROOK - "+blackRookCount);
        blackKingText.setText("B-KING - "+blackKingCount);
        blackQueenText.setText("B-QUEEN - "+blackQueenCount);
        blackPawnText.setText("B-PAWN - "+blackPawnCount);
    }
}