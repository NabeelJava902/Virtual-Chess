package Pieces;

import Board.gameGrid;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    public int location;
    public Alliance alliance;
    public pieceTypes pieceType;
    public int[] MOVE_CANDIDATES;

    Piece(int location, Alliance alliance, pieceTypes pieceType){
        this.location = location;
        this.alliance = alliance;
        this.pieceType = pieceType;
    }
    public ArrayList<Piece> updateGrid(gameGrid g){
        g.emptyPiecesGrid.get(this.location).pieceType = this.pieceType;
        g.emptyPiecesGrid.get(this.location).alliance = this.alliance;
        return g.emptyPiecesGrid;
    }
    public abstract List<Integer> getLegalMoves(gameGrid g);
}
