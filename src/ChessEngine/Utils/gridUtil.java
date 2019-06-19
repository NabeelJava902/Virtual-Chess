package ChessEngine.Utils;

import ChessEngine.Board.gameGrid;
import ChessEngine.Pieces.Alliances;
import ChessEngine.Pieces.Piece;
import ChessEngine.Pieces.pieceTypes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gridUtil {

    public static final int[] FIRST_COLUMN = {0, 8, 16, 24, 32, 40, 48, 56};
    public static final int[] SECOND_COLUMN = {1, 9, 17, 25, 33, 41, 49, 57};
    public static final int[] SEVENTH_COLUMN = {6, 14, 22, 30, 38, 46, 54, 62};
    public static final int[] EIGHTH_COLUMN = {7, 15, 23, 31, 39, 47, 55, 63};

    public static boolean contains(int target, int[] list){
        boolean contains = false;
        for(int listElement : list){
            if(listElement == target){
                contains = true;
            }
        }
        return contains;
    }

    public static boolean contains(int target, List<Integer> list){
        boolean contains = false;
        for(int listElement : list){
            if (listElement == target){
                contains = true;
            }
        }
        return  contains;
    }

    private gridUtil(){}

    public static boolean checkLocationValidity(int location, ArrayList<Piece> grid){
        boolean isValid = false;
        for(int i=0; i<grid.size(); i++){
            if(location == grid.get(i).location){isValid=true;}
        }
        return isValid;
    }

    public static Piece findPieceFromLocation(int location, gameGrid g){
        Piece piece = null;
        for(int i=0; i<g.emptyPiecesGrid.size(); i++){
            if(location == g.emptyPiecesGrid.get(i).location){
                piece = g.emptyPiecesGrid.get(i);
            }
        }
        return piece;
    }

    public static void printGrid(gameGrid g){
        for(int i=0; i<g.emptyPiecesGrid.size(); i++){
            System.out.println(g.emptyPiecesGrid.get(i).pieceType + ", " + g.emptyPiecesGrid.get(i).alliance +
                    ", " + g.emptyPiecesGrid.get(i).location);
        }
        System.out.println("\n\n\n");
    }

    public static final HashMap<Integer, Dimension> locationCoordinates = new HashMap<>();
    public static void initLocationCoordinates(){
        ArrayList<Dimension> dimensions = new ArrayList<>();
        int x = 50, y = 50;
        for(int i=0; i<8; i++){
            for(int z=0; z<8; z++){
                dimensions.add(new Dimension(x, y));
                x += 100;
            }
            x = 50;
            y += 100;
        }
        int xx=-1;
        int xxx=0;
        for(int i=0; i<64; i++){
            xx++;
            locationCoordinates.put(xxx, dimensions.get(xx));
            xxx++;
        }
    }

    public static boolean checkForKingInRange(Piece piece, gameGrid g){
        //TODO fix functionality in detecting king in legalMoves
        boolean kingInRange = false;
        for(int i : pieceUtil.getValidDestinations(piece, g)){
            if(g.emptyPiecesGrid.get(i).pieceType == pieceTypes.KING && g.emptyPiecesGrid.get(i).alliance != piece.alliance){
                kingInRange = true;
            }
        }
        return kingInRange;
    }

    public static Alliances findWinner(Piece piece, gameGrid g){
        Alliances winner = null;
        for(int i : pieceUtil.getValidDestinations(piece, g)){
            if(g.emptyPiecesGrid.get(i).pieceType == pieceTypes.KING && g.emptyPiecesGrid.get(i).alliance != piece.alliance){
                if(g.emptyPiecesGrid.get(i).alliance == Alliances.BLACK){
                    winner = Alliances.BLACK;
                }else if(g.emptyPiecesGrid.get(i).alliance == Alliances.WHITE){
                    winner = Alliances.WHITE;
                }
            }
        }
        return winner;
    }
}
