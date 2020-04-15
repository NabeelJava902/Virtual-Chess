import Board.Move;
import Board.gameGrid;
import Pieces.Knight;
import Pieces.pieceTypes;

import static Pieces.Alliance.BLACK;

public class movePieceTest {
    public static void main(String[] args){
        gameGrid g = new gameGrid();
        Knight knight = new Knight(20, BLACK, pieceTypes.KNIGHT);
        knight.updateGrid(g);
        Move move = new Move(knight.getLegalMoves(g).get(0), knight);
        g.emptyPiecesGrid = move.normalMove(g);
        for(int i=0; i<g.emptyPiecesGrid.size(); i++){
            System.out.println(g.emptyPiecesGrid.get(i).pieceType + ", " + g.emptyPiecesGrid.get(i).alliance +
                    ", " + g.emptyPiecesGrid.get(i).location);
        }
    }
}
