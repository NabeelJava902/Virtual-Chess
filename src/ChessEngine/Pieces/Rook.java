package ChessEngine.Pieces;

import ChessEngine.Board.gameGrid;
import ChessEngine.Utils.gridUtil;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    private static int[] MOVE_VECTOR_CANDIDATES = {-8, -1, 1, 8};

    public Rook(int location, Alliances alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g) {
        List<Integer> validCandidates = new ArrayList<>();
        for(int currentMove : MOVE_VECTOR_CANDIDATES) {
            int nextMove = currentMove;
            if(firstColumnExclusion(this.location, nextMove) || eighthColumnExclusion(this.location, nextMove)){
                continue;
            }
            int destination = this.location + nextMove;
            while(gridUtil.checkLocationValidity(destination, g.emptyPiecesGrid)) {
                if (g.emptyPiecesGrid.get(destination).pieceType == pieceTypes.EMPTY) {
                    validCandidates.add(nextMove);
                } else if (g.emptyPiecesGrid.get(destination).alliance != this.alliance) {
                    validCandidates.add(nextMove);
                    break;
                }if (gridUtil.contains(destination, gridUtil.FIRST_COLUMN) && !gridUtil.contains(this.location, gridUtil.FIRST_COLUMN)){
                    break;
                }else if(gridUtil.contains(destination, gridUtil.EIGHTH_COLUMN) && !gridUtil.contains(this.location, gridUtil.EIGHTH_COLUMN)){
                    break;
                }
                nextMove += currentMove;
                destination = this.location + nextMove;
            }
        }
        return validCandidates;
    }
    private static boolean eighthColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.EIGHTH_COLUMN) && (moveCandidate == 1)){
            exclude = true;
        }
        return  exclude;
    }

    private static boolean firstColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.FIRST_COLUMN) && (moveCandidate == -1)){
            exclude = true;
        }
        return  exclude;
    }
}
