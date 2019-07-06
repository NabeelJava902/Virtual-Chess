package Pieces;

import Board.gameGrid;
import Utils.gridUtil;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private static final int[] MOVE_CANDIDATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(int location, Alliances alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g){
        List<Integer> validCandidates = new ArrayList<>();
        for(int currentMove : MOVE_CANDIDATES) {
            if(firstColumnExclusion(this.location, currentMove) || eighthColumnExclusion(this.location, currentMove)){
                continue;
            }
            int destination = this.location + currentMove;
            if(gridUtil.checkLocationValidity(destination, g.emptyPiecesGrid)){
                if(g.emptyPiecesGrid.get(destination).pieceType == pieceTypes.EMPTY){
                    validCandidates.add(currentMove);
                }else if(g.emptyPiecesGrid.get(destination).alliance != this.alliance){
                    validCandidates.add(currentMove);
                }
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
