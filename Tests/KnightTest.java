import ChessEngine.Board.gameGrid;
import ChessEngine.Pieces.Alliances;
import ChessEngine.Pieces.Knight;
import ChessEngine.Pieces.pieceTypes;
import ChessEngine.Utils.pieceUtil;

import java.util.List;

public class KnightTest {
    public static void main(String[] args){
        canMoveTest();
    }

    private static void newLocTest(){
        final Knight knight = new Knight(32, Alliances.WHITE, pieceTypes.KNIGHT);
        List<Integer> newLocs = knight.getLegalMoves(new gameGrid());
        for (int newLoc : newLocs){
            System.out.print(newLoc + ", ");
        }
    }

    private static void canMoveTest(){
        //test by make result false
        gameGrid g = new gameGrid();
        g.emptyPiecesGrid.get(22).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(15).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(17).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(26).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(38).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(47).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(49).pieceType = pieceTypes.KNIGHT;
        g.emptyPiecesGrid.get(42).pieceType = pieceTypes.KNIGHT;
        final Knight knight = new Knight(32, Alliances.WHITE, pieceTypes.KNIGHT);
        System.out.println(pieceUtil.canMove(knight, g));
    }
}
