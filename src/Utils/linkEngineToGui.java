package Utils;

import java.util.ArrayList;

/*
    file is necessary since I mistakenly used different data structures
    for the engine and the gui
 */

public class linkEngineToGui {
    private linkEngineToGui(){}

    public static ArrayList<Integer> arrayListToArray(int num){
        ArrayList<Integer> position = new ArrayList<>();
        int row=0, col=0;

        for(int i=0; i<num; i++){
            if(col == 7){
                col = 0;
                row++;
            }else {
                col++;
            }
        }

        position.add(row);
        position.add(col);
        return position;
    }

    public static int arrayToArrayList(int row, int col){
        int pos = 0;

        for(int i=0; i<8; i++){
            for(int z=0; z<8; z++){
                if(i == row && z == col){
                    break;
                }
                pos++;
            }
        }

        return pos;
    }
}