import ChessEngine.Board.gameGrid;
import ChessEngine.Pieces.Alliances;
import ChessEngine.Pieces.Bishop;
import ChessEngine.Pieces.pieceTypes;

import java.util.List;

public class BishopTest {
    public static void main(String[] args){
        Bishop bishop = new Bishop(54, Alliances.BLACK, pieceTypes.BISHOP);
        List<Integer> moves = bishop.getLegalMoves(new gameGrid());
        for(int move : moves){
            System.out.println(move + ", ");
        }
    }
}
