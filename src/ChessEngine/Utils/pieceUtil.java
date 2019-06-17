package ChessEngine.Utils;

import ChessEngine.Board.gameGrid;
import ChessEngine.Pieces.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class pieceUtil {
    public static gameGrid addPiece(gameGrid g, ImageIcon img, int location){
        Piece piece = null;
        if(img == dataUtil.blackKnight){
            piece = new Knight(location, Alliances.BLACK, pieceTypes.KNIGHT);
        }else if(img == dataUtil.whiteKnight){
            piece = new Knight(location, Alliances.WHITE, pieceTypes.KNIGHT);
        }else if(img == dataUtil.blackBishop){
            piece = new Bishop(location, Alliances.BLACK, pieceTypes.BISHOP);
        }else if(img == dataUtil.whiteBishop){
            piece = new Bishop(location, Alliances.WHITE, pieceTypes.BISHOP);
        }else if(img == dataUtil.blackRook){
            piece = new Rook(location, Alliances.BLACK, pieceTypes.ROOK);
        }else if(img == dataUtil.whiteRook){
            piece = new Rook(location, Alliances.WHITE, pieceTypes.ROOK);
        }else if(img == dataUtil.blackKing){
            piece = new King(location, Alliances.BLACK, pieceTypes.KING);
        }else if(img == dataUtil.whiteKing){
            piece = new King(location, Alliances.WHITE, pieceTypes.KING);
        }else if(img == dataUtil.blackQueen){
            piece = new Queen(location, Alliances.BLACK, pieceTypes.QUEEN);
        }else if(img == dataUtil.whiteQueen){
            piece = new Queen(location, Alliances.WHITE, pieceTypes.QUEEN);
        }else if(img == dataUtil.blackPawn){
            piece = new Pawn(location, Alliances.BLACK, pieceTypes.PAWN);
        }else if(img == dataUtil.whitePawn){
            piece = new Pawn(location, Alliances.WHITE, pieceTypes.PAWN);
        }
        g.add(piece);
        return g;
    }

    public static boolean canMove(Piece piece, gameGrid g) {
        boolean canMove = false;
        for(int i=0; i<piece.getLegalMoves(g).size(); i++){
            if(gridUtil.findPieceFromLocation(getValidDestinations(piece, g).get(i), g).pieceType == pieceTypes.EMPTY){
                canMove = true;
                break;
            }
        }
        return canMove;
    }

    public static List<Integer> getValidDestinations(Piece piece, gameGrid g){
        int currentLoc;
        List<Integer> validnewLocs = new ArrayList<>();
        for(int currentValidCandidate : piece.getLegalMoves(g)){
            currentLoc = piece.location;
            currentLoc += currentValidCandidate;
            validnewLocs.add(currentLoc);
        }
        return validnewLocs;
    }
}
