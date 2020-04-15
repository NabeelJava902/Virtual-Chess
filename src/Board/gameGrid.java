package Board;

import Pieces.Alliance;
import Pieces.Piece;
import Pieces.emptyPiece;
import Pieces.pieceTypes;

import java.util.ArrayList;

public class gameGrid {
    public ArrayList<Piece> emptyPiecesGrid = new ArrayList<>();
    public gameGrid(){
        for(int i=0; i<64; i++){
            emptyPiecesGrid.add(new emptyPiece(0, Alliance.EMPTY, pieceTypes.EMPTY));
            emptyPiecesGrid.get(i).location = i;
        }
    }

    public void add(Piece piece){
        this.emptyPiecesGrid.get(piece.location).alliance = piece.alliance;
        this.emptyPiecesGrid.get(piece.location).pieceType = piece.pieceType;
    }
}
