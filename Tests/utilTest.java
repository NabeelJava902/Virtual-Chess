import ChessEngine.Pieces.Piece;
import ChessEngine.Pieces.emptyPiece;
import ChessEngine.Pieces.pieceTypes;
import ChessEngine.Utils.gridUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class utilTest {
    public static void main(String[] args){
        locationCoordinateTest();
    }

    private static void checkLocationValidityTest(){
        ArrayList<Piece> emptyPieceGrid = new ArrayList<>();
        int testLoc = 65;
        for(int i=0; i<65; i++){
            emptyPieceGrid.add(new emptyPiece(0, null, pieceTypes.EMPTY));
        }
        int pos = 0;
        for(int i=0; i<65; i++){
            emptyPieceGrid.get(i).location = pos;
            pos++;
        }
        System.out.println(gridUtil.checkLocationValidity(testLoc, emptyPieceGrid));
    }

    private static void locationCoordinateTest(){
        gridUtil.initLocationCoordinates();
        for(Map.Entry<Integer, Dimension> map : gridUtil.locationCoordinates.entrySet()){
            System.out.println(map.getKey() + " " + map.getValue().width + "-" + map.getValue().height);
        }
    }
}
