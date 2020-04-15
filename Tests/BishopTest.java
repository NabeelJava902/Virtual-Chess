import Board.gameGrid;
import Pieces.Bishop;
import Pieces.pieceTypes;

import java.util.List;

import static Pieces.Alliance.BLACK;

public class BishopTest {
    public static void main(String[] args){
        Bishop bishop = new Bishop(54, BLACK, pieceTypes.BISHOP);
        List<Integer> moves = bishop.getLegalMoves(new gameGrid());
        for(int move : moves){
            System.out.println(move + ", ");
        }
    }
}
