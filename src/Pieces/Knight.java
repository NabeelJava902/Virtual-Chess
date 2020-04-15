package Pieces;

import Board.gameGrid;
import Utils.gridUtil;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    private static int[] MOVE_CANDIDATES = {-10, -17, -15, -6, 6, 15, 17, 10};

    public Knight(int location, Alliance alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g){
        List<Integer> validCandidates = new ArrayList<>();
        for(int currentMove : MOVE_CANDIDATES) {
            if(firstColumnExclusion(this.location, currentMove) || secondColumnExclusion(this.location, currentMove) ||
            seventhColumnExclusion(this.location, currentMove) || eighthColumnExclusion(this.location, currentMove)){
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
        if(gridUtil.contains(pos, gridUtil.FIRST_COLUMN) && (moveCandidate == -10 ||
                moveCandidate == -17 || moveCandidate == 6 || moveCandidate == 15)){
            exclude = true;
        }
        return  exclude;
    }

    private static boolean secondColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.SECOND_COLUMN) && (moveCandidate == -10 || moveCandidate == 6)){
            exclude = true;
        }
        return  exclude;
    }

    private static boolean seventhColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.SEVENTH_COLUMN) && (moveCandidate == -6 || moveCandidate == 10)){
            exclude = true;
        }
        return  exclude;
    }

    private static boolean eighthColumnExclusion(final int pos, final int moveCandidate){
        boolean exclude = false;
        if(gridUtil.contains(pos, gridUtil.EIGHTH_COLUMN) && (moveCandidate == 10 ||
                moveCandidate == 17 || moveCandidate == -6 || moveCandidate == -15)){
            exclude = true;
        }
        return  exclude;
    }
}
