package Pieces;

import Board.gameGrid;
import Utils.gridUtil;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    private static final int[] MOVE_VECTOR_CANDIDATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public Queen(int location, Alliance alliance, pieceTypes pieceType) {
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
                }else if(g.emptyPiecesGrid.get(destination).alliance == this.alliance){
                    break;
                }
                if (gridUtil.contains(destination, gridUtil.FIRST_COLUMN) || gridUtil.contains(destination, gridUtil.EIGHTH_COLUMN)) {
                    break;
                }
                nextMove += currentMove;
                destination = this.location + nextMove;
            }
        }

        return validCandidates;
    }

    private static boolean firstColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.FIRST_COLUMN) && (moveCandidate == -9 ||
                moveCandidate == 7 || moveCandidate == -1)){
            exclude = true;
        }
        return  exclude;
    }

    private static boolean eighthColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.EIGHTH_COLUMN) && (moveCandidate == -7 ||
                moveCandidate == 9 || moveCandidate == 1)){
            exclude = true;
        }
        return  exclude;
    }
}
