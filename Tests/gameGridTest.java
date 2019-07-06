import Board.gameGrid;

public class gameGridTest {
    public static void main(String[] args){
        gameGrid gg = new gameGrid();
        for(int i=0; i<gg.emptyPiecesGrid.size(); i++){
            System.out.println(gg.emptyPiecesGrid.get(i).location);
        }
    }
}
