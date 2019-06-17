package ChessEngine.Pieces;

import ChessEngine.Board.gameGrid;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(int location, Alliances alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g) {
        return null;
    }
}
