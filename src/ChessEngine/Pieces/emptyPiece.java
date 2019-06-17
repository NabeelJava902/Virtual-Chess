package ChessEngine.Pieces;

import ChessEngine.Board.gameGrid;

import java.util.ArrayList;
import java.util.List;

public class emptyPiece extends Piece {

    public emptyPiece(int location, Alliances alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public ArrayList<Piece> updateGrid(gameGrid g) {
        return null;
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g) {
        return null;
    }
}
