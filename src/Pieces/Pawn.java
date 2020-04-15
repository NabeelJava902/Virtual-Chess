package Pieces;

import Board.gameGrid;
import Utils.gridUtil;

import java.util.ArrayList;
import java.util.List;

import static Pieces.Alliance.BLACK;
import static Pieces.Alliance.WHITE;

public class Pawn extends Piece {
    private static final int BLACK_MOVE_CANDIDATE1 = 8, BLACK_MOVE_CANDIDATE2 = 16;
    private static final int WHITE_MOVE_CANDIDATE1 = -8, WHITE_MOVE_CANDIDATE2 = -16;
    private static final int[] BLACK_ATTACK_MOVE = {9, 7}, WHITE_ATTACK_MOVE = {-9, -7};

    public Pawn(int location, Alliance alliance, pieceTypes pieceType) {
        super(location, alliance, pieceType);
    }

    @Override
    public List<Integer> getLegalMoves(gameGrid g){
        List<Integer> validCandidates = new ArrayList<>();
        if(this.alliance == WHITE && gridUtil.contains(this.location, gridUtil.FIRST_ROW)){
            return validCandidates;
        }else if(this.alliance == BLACK && gridUtil.contains(this.location, gridUtil.EIGHTH_ROW)){
            return validCandidates;
        }

        if(this.alliance == BLACK){
            validCandidates.add(BLACK_MOVE_CANDIDATE1);
            if(checkForDoubleMove(this.location, this.alliance)) {
                validCandidates.add(BLACK_MOVE_CANDIDATE2);
            }
            for(int currentAttack : BLACK_ATTACK_MOVE){
                int destination = this.location + currentAttack;
                Piece pieceAtDestination = g.emptyPiecesGrid.get(destination);
                if(pieceAtDestination.pieceType != pieceTypes.EMPTY && pieceAtDestination.alliance != this.alliance){
                    validCandidates.add(currentAttack);
                }
            }
        }else if(this.alliance == WHITE){
            validCandidates.add(WHITE_MOVE_CANDIDATE1);
            if(checkForDoubleMove(this.location, this.alliance)) {
                validCandidates.add(WHITE_MOVE_CANDIDATE2);
            }
            for(int currentAttack : WHITE_ATTACK_MOVE){
                int destination = this.location + currentAttack;
                Piece pieceAtDestination = g.emptyPiecesGrid.get(destination);
                if(pieceAtDestination.pieceType != pieceTypes.EMPTY && pieceAtDestination.alliance != this.alliance){
                    validCandidates.add(currentAttack);
                }
            }
        }

        int destination = this.location + validCandidates.get(0);
        int destination2 = 0;
        if(checkForDoubleMove(this.location, this.alliance)){
            destination2 = this.location + validCandidates.get(1);
        }
        if(g.emptyPiecesGrid.get(destination).pieceType != pieceTypes.EMPTY){
            if(this.alliance == WHITE){
                validCandidates.remove(Integer.valueOf(-8));
                validCandidates.remove(Integer.valueOf(-16));
            }else if(this.alliance == BLACK){
                validCandidates.remove(Integer.valueOf(8));
                validCandidates.remove(Integer.valueOf(16));
            }
        }else if(destination2 != 0){
            if(g.emptyPiecesGrid.get(destination2).pieceType != pieceTypes.EMPTY) {
                if (this.alliance == WHITE) {
                    validCandidates.remove(Integer.valueOf(-16));
                } else if (this.alliance == BLACK) {
                    validCandidates.remove(Integer.valueOf(16));
                }
            }
        }
        return validCandidates;
    }

    private boolean checkForDoubleMove(int location, Alliance alliance){
        if(alliance == WHITE){
            return gridUtil.contains(location, gridUtil.SEVENTH_ROW);
        }else if(alliance == BLACK){
            return gridUtil.contains(location, gridUtil.SECOND_ROW);
        }
        return false;
    }
}
