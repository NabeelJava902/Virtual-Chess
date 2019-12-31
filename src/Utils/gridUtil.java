package Utils;

import Board.gameGrid;
import Pieces.Alliances;
import Pieces.Piece;
import Pieces.pieceTypes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Pieces.Alliances.BLACK;
import static Pieces.Alliances.WHITE;
import static Utils.pieceUtil.getValidDestinations;

public class gridUtil {

    public static final int[] FIRST_COLUMN = {0, 8, 16, 24, 32, 40, 48, 56};
    public static final int[] SECOND_COLUMN = {1, 9, 17, 25, 33, 41, 49, 57};
    public static final int[] SEVENTH_COLUMN = {6, 14, 22, 30, 38, 46, 54, 62};
    public static final int[] EIGHTH_COLUMN = {7, 15, 23, 31, 39, 47, 55, 63};
    public static final int[] FIRST_ROW = {0, 1, 2, 3, 4, 5, 6, 7};
    public static final int[] SECOND_ROW = {8, 9, 10, 11, 12, 13, 14, 15};
    public static final int[] SEVENTH_ROW = {48, 49, 50, 51, 52, 53, 54, 55};
    public static final int[] EIGHTH_ROW = {56, 57, 58, 59, 60, 61, 62, 63};


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
        for(Piece piece : grid){
            if(location == grid.get(piece.location).location){isValid=true;}
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

    public static boolean isCheckMate(Piece piece, gameGrid g){
        boolean checkMate = false;
        Piece kingPiece;

        for(int i : getValidDestinations(piece, g)){
            if(g.emptyPiecesGrid.get(i).pieceType == pieceTypes.KING){
                kingPiece = g.emptyPiecesGrid.get(i);
                if(isKingTrapped(kingPiece, g)){
                    checkMate = true;
                }
            }
        }
        return checkMate;
    }

    //TODO fix bug in method below
    private static boolean isKingTrapped(Piece kingPiece, gameGrid g){
        boolean kingTrapped = false;
        List<Integer> validDestinationCompilation = new ArrayList<>();

        switch(kingPiece.alliance){
            case WHITE:
                //for all black pieces on board
                for(Piece piece : g.emptyPiecesGrid){
                    if(piece.alliance == BLACK){
                        validDestinationCompilation.addAll(getValidDestinations(piece, g));
                    }
                }
                break;
            case BLACK:
                //for all white pieces on board
                for(Piece piece : g.emptyPiecesGrid){
                    if(piece.alliance == WHITE){
                        validDestinationCompilation.addAll(getValidDestinations(piece, g));
                    }
                }
                break;
        }

        if(containsAllElements(validDestinationCompilation, getValidDestinations(kingPiece, g))){
            kingTrapped = true;
        }

        return kingTrapped;
    }

    private static boolean containsAllElements(List<Integer> list, List<Integer> list2){
        boolean containsAllElements = true;

        for(int i : list2){
            if(!contains(i, list)){
                containsAllElements = false;
            }
        }
        return containsAllElements;
    }

    public static Alliances findWinner(Piece piece, gameGrid g){
        Alliances winner = null;
        for(int i : getValidDestinations(piece, g)){
            if(g.emptyPiecesGrid.get(i).pieceType == pieceTypes.KING && g.emptyPiecesGrid.get(i).alliance != piece.alliance){
                if(g.emptyPiecesGrid.get(i).alliance == BLACK){
                    winner = BLACK;
                }else if(g.emptyPiecesGrid.get(i).alliance == WHITE){
                    winner = WHITE;
                }
            }
        }
        return winner;
    }
}
