import Board.gameGrid;
import Pieces.Knight;
import Pieces.pieceTypes;
import Utils.pieceUtil;

import java.util.List;

import static Pieces.Alliance.WHITE;

public class KnightTest {
    public static void main(String[] args){
        canMoveTest();
    }

    private static void newLocTest(){
        final Knight knight = new Knight(32, WHITE, pieceTypes.KNIGHT);
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
        final Knight knight = new Knight(32, WHITE, pieceTypes.KNIGHT);
        System.out.println(pieceUtil.canMove(knight, g));
    }
}
