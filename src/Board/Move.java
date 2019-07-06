package Board;

import Pieces.Alliances;
import Pieces.Piece;
import Pieces.pieceTypes;

import java.util.ArrayList;

public class Move {
    private int validDestination, loc;
    private final Piece movingPiece;

    public Move(int validDestination, Piece movingPiece){
        loc = movingPiece.location;
        this.validDestination = validDestination;
        this.movingPiece = movingPiece;
    }
    public ArrayList<Piece> normalMove(gameGrid g) {
        g.emptyPiecesGrid.get(validDestination).MOVE_CANDIDATES = movingPiece.MOVE_CANDIDATES;
        g.emptyPiecesGrid.get(validDestination).pieceType = movingPiece.pieceType;
        g.emptyPiecesGrid.get((validDestination)).alliance = movingPiece.alliance;
        movingPiece.location = validDestination;
        g.emptyPiecesGrid.get(loc).alliance = Alliances.EMPTY;
        g.emptyPiecesGrid.get(loc).pieceType = pieceTypes.EMPTY;
        g.emptyPiecesGrid.get(loc).MOVE_CANDIDATES = null;

        return g.emptyPiecesGrid;
    }
}
