package ChessEngine.Pieces;

import ChessEngine.Board.gameGrid;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean hasMoved = false;
    private static final ArrayList<Integer> WHITE_MOVE_CANDIDATES = new ArrayList<>();
    private static final ArrayList<Integer> BLACK_MOVE_CANDIDATES = new ArrayList<>();
    private static final int[] ATTACK_MOVE = {-9, 8, 7};

    public Pawn(int location, Alliances alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
        WHITE_MOVE_CANDIDATES.add(-8);
        WHITE_MOVE_CANDIDATES.add(-16);
        BLACK_MOVE_CANDIDATES.add(8);
        BLACK_MOVE_CANDIDATES.add(16);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g){
        return null;
    }
}
