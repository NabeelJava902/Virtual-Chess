package Utils;

import Pieces.*;

import javax.swing.*;

import static Pieces.Alliance.BLACK;
import static Pieces.Alliance.WHITE;

public class clickedTile {
    public final Piece piece;
    public final Icon img;
    public final int row, col;

    private clickedTile(Piece piece, Icon img, int i, int j){
        this.piece = piece;
        this.img = img;
        row = i;
        col = j;
    }

    public static clickedTile assignClickedTile(int clickedTileLocation, JButton button){
        clickedTile clickedTile = null;
        Icon buttonImg = button.getIcon();
        int i = linkEngineToGui.arrayListToArray(clickedTileLocation).get(0);
        int j = linkEngineToGui.arrayListToArray(clickedTileLocation).get(1);

        if(buttonImg == dataUtil.blackKnight){
            clickedTile = new clickedTile(new Knight(clickedTileLocation, BLACK, pieceTypes.KNIGHT),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whiteKnight){
            clickedTile = new clickedTile(new Knight(clickedTileLocation, WHITE, pieceTypes.KNIGHT),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.blackBishop){
            clickedTile = new clickedTile(new Bishop(clickedTileLocation, BLACK, pieceTypes.BISHOP),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whiteBishop){
            clickedTile = new clickedTile(new Bishop(clickedTileLocation, WHITE, pieceTypes.BISHOP),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.blackRook){
            clickedTile = new clickedTile(new Rook(clickedTileLocation, BLACK, pieceTypes.ROOK),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whiteRook){
            clickedTile = new clickedTile(new Rook(clickedTileLocation, WHITE, pieceTypes.ROOK),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.blackKing){
            clickedTile = new clickedTile(new King(clickedTileLocation, BLACK, pieceTypes.KING),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whiteKing){
            clickedTile = new clickedTile(new King(clickedTileLocation, WHITE, pieceTypes.KING),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.blackQueen){
            clickedTile = new clickedTile(new Queen(clickedTileLocation, BLACK, pieceTypes.QUEEN),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whiteQueen){
            clickedTile = new clickedTile(new Queen(clickedTileLocation, WHITE, pieceTypes.QUEEN),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.blackPawn){
            clickedTile = new clickedTile(new Pawn(clickedTileLocation, BLACK, pieceTypes.PAWN),
                    buttonImg, i, j);
        }else if(buttonImg == dataUtil.whitePawn){
            clickedTile = new clickedTile(new Pawn(clickedTileLocation, WHITE, pieceTypes.PAWN),
                    buttonImg, i, j);
        }
        return clickedTile;
    }
}
