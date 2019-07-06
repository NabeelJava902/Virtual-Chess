package Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class dataUtil {
    public static final ImageIcon blackKnight = new ImageIcon("data/black-knight.png");
    public static final ImageIcon whiteKnight = new ImageIcon("data/white-knight.png");
    public static final ImageIcon blackBishop = new ImageIcon("data/black-bishop.png");
    public static final ImageIcon whiteBishop = new ImageIcon("data/white-bishop.png");
    public static final ImageIcon blackRook = new ImageIcon("data/black-rook.png");
    public static final ImageIcon whiteRook = new ImageIcon("data/white-rook.png");
    public static final ImageIcon blackPawn = new ImageIcon("data/black-pawn.png");
    public static final ImageIcon whitePawn = new ImageIcon("data/white-pawn.png");
    public static final ImageIcon blackQueen = new ImageIcon("data/black-queen.png");
    public static final ImageIcon whiteQueen = new ImageIcon("data/white-queen.png");
    public static final ImageIcon blackKing = new ImageIcon("data/black-king.png");
    public static final ImageIcon whiteKing = new ImageIcon("data/white-king.png");

    public static String SOUND_SETTTING = "ON";
    public static String ACTIVE_TURN = "WHITE TURN";
    public static boolean continueMusic = true;

    private dataUtil(){}

    public static List<Integer> copyFromArray(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int currentElement : arr){
            arrList.add(currentElement);
        }
        return arrList;
    }
}
