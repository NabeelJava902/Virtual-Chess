package Utils;

import java.util.ArrayList;

/*
    For the record, I am very embarrassed at this file
    since I did not choose to use similar lists
    and now I have to deal with get similar values,
    this file is how I did it
*/

public class linkEngineToGui {
    private linkEngineToGui(){}

    public static ArrayList<Integer> arrayListToArray(int num){
        ArrayList<Integer> position = new ArrayList<>();
        int row=0, col=0;
        switch(num){
            case 0: row = col = 0;
                break;
            case 1: row = 0;
                col = 1;
                break;
            case 2: row = 0;
                col = 2;
                break;
            case 3:  row = 0;
                col = 3;
                break;
            case 4: row = 0;
                col = 4;
                break;
            case 5: row = 0;
                col = 5;
                break;
            case 6: row = 0;
                col = 6;
                break;
            case 7: row = 0;
                col = 7;
                break;
            case 8: row = 1;
                col = 0;
                break;
            case 9: row = 1;
                col = 1;
                break;
            case 10: row = 1;
                col = 2;
                break;
            case 11: row = 1;
                col = 3;
                break;
            case 12: row = 1;
                col = 4;
                break;
            case 13: row = 1;
                col = 5;
                break;
            case 14: row = 1;
                col = 6;
                break;
            case 15: row = 1;
                col = 7;
                break;
            case 16: row = 2;
                col = 0;
                break;
            case 17: row = 2;
                col = 1;
                break;
            case 18: row = 2;
                col = 2;
                break;
            case 19: row = 2;
                col = 3;
                break;
            case 20: row = 2;
                col = 4;
                break;
            case 21: row = 2;
                col = 5;
                break;
            case 22: row = 2;
                col = 6;
                break;
            case 23: row = 2;
                col = 7;
                break;
            case 24: row = 3;
                col = 0;
                break;
            case 25: row = 3;
                col = 1;
                break;
            case 26: row = 3;
                col = 2;
                break;
            case 27: row = 3;
                col = 3;
                break;
            case 28: row = 3;
                col = 4;
                break;
            case 29: row = 3;
                col = 5;
                break;
            case 30: row = 3;
                col = 6;
                break;
            case 31: row = 3;
                col = 7;
                break;
            case 32: row = 4;
                col = 0;
                break;
            case 33: row = 4;
                col = 1;
                break;
            case 34: row = 4;
                col = 2;
                break;
            case 35: row = 4;
                col = 3;
                break;
            case 36: row = 4;
                col = 4;
                break;
            case 37: row = 4;
                col = 5;
                break;
            case 38: row = 4;
                col = 6;
                break;
            case 39: row = 4;
                col = 7;
                break;
            case 40: row = 5;
                col = 0;
                break;
            case 41: row = 5;
                col = 1;
                break;
            case 42: row = 5;
                col = 2;
                break;
            case 43: row = 5;
                col = 3;
                break;
            case 44: row = 5;
                col = 4;
                break;
            case 45: row = 5;
                col = 5;
                break;
            case 46: row = 5;
                col = 6;
                break;
            case 47: row = 5;
                col = 7;
                break;
            case 48: row = 6;
                col = 0;
                break;
            case 49: row = 6;
                col = 1;
                break;
            case 50: row = 6;
                col = 2;
                break;
            case 51: row = 6;
                col = 3;
                break;
            case 52: row = 6;
                col = 4;
                break;
            case 53: row = 6;
                col = 5;
                break;
            case 54: row = 6;
                col = 6;
                break;
            case 55: row = 6;
                col = 7;
                break;
            case 56: row = 7;
                col = 0;
                break;
            case 57: row = 7;
                col = 1;
                break;
            case 58: row = 7;
                col = 2;
                break;
            case 59: row = 7;
                col = 3;
                break;
            case 60: row = 7;
                col = 4;
                break;
            case 61: row = 7;
                col = 5;
                break;
            case 62: row = 7;
                col = 6;
                break;
            case 63: row = 7;
                col = 7;
                break;

        }
        position.add(row);
        position.add(col);
        return position;
    }

    public static int arrayToArrayList(int row, int col){
        int pos = 0;

        if(row==0&&col==1){
            pos = 1;
        }else if(row==0&&col==2){
            pos = 2;
        }else if(row==0&&col==3){
            pos = 3;
        }else if(row==0&&col==4){
            pos = 4;
        }else if(row==0&&col==5){
            pos = 5;
        }else if(row==0&&col==6){
            pos = 6;
        }else if(row==0&&col==7){
            pos = 7;
        }else if(row==1&&col==0){
            pos = 8;
        }else if(row==1&&col==1){
            pos = 9;
        }else if(row==1&&col==2){
            pos = 10;
        }else if(row==1&&col==3){
            pos = 11;
        }else if(row==1&&col==4){
            pos = 12;
        }else if(row==1&&col==5){
            pos = 13;
        }else if(row==1&&col==6){
            pos = 14;
        }else if(row==1&&col==7){
            pos = 15;
        }else if(row==2&&col==0){
            pos = 16;
        }else if(row==2&&col==1){
            pos = 17;
        }else if(row==2&&col==2){
            pos = 18;
        }else if(row==2&&col==3){
            pos = 19;
        }else if(row==2&&col==4){
            pos = 20;
        }else if(row==2&&col==5){
            pos = 21;
        }else if(row==2&&col==6){
            pos = 22;
        }else if(row==2&&col==7){
            pos = 23;
        }else if(row==3&&col==0){
            pos = 24;
        }else if(row==3&&col==1){
            pos = 25;
        }else if(row==3&&col==2){
            pos = 26;
        }else if(row==3&&col==3){
            pos = 27;
        }else if(row==3&&col==4){
            pos = 28;
        }else if(row==3&&col==5){
            pos = 29;
        }else if(row==3&&col==6){
            pos = 30;
        }else if(row==3&&col==7){
            pos = 31;
        }else if(row==4&&col==0){
            pos = 32;
        }else if(row==4&&col==1){
            pos = 33;
        }else if(row==4&&col==2){
            pos = 34;
        }else if(row==4&&col==3){
            pos = 35;
        }else if(row==4&&col==4){
            pos = 36;
        }else if(row==4&&col==5){
            pos = 37;
        }else if(row==4&&col==6){
            pos = 38;
        }else if(row==4&&col==7){
            pos = 39;
        }else if(row==5&&col==0){
            pos = 40;
        }else if(row==5&&col==1){
            pos = 41;
        }else if(row==5&&col==2){
            pos = 42;
        }else if(row==5&&col==3){
            pos = 43;
        }else if(row==5&&col==4){
            pos = 44;
        }else if(row==5&&col==5){
            pos = 45;
        }else if(row==5&&col==6){
            pos = 46;
        }else if(row==5&&col==7){
            pos = 47;
        }else if(row==6&&col==0){
            pos = 48;
        }else if(row==6&&col==1){
            pos = 49;
        }else if(row==6&&col==2){
            pos = 50;
        }else if(row==6&&col==3){
            pos = 51;
        }else if(row==6&&col==4){
            pos = 52;
        }else if(row==6&&col==5){
            pos = 53;
        }else if(row==6&&col==6){
            pos = 54;
        }else if(row==6&&col==7){
            pos = 55;
        }else if(row==7&&col==0){
            pos = 56;
        }else if(row==7&&col==1){
            pos = 57;
        }else if(row==7&&col==2){
            pos = 58;
        }else if(row==7&&col==3){
            pos = 59;
        }else if(row==7&&col==4){
            pos = 60;
        }else if(row==7&&col==5){
            pos = 61;
        }else if(row==7&&col==6){
            pos = 62;
        }else if(row==7&&col==7){
            pos = 63;
        }
        return pos;
    }
}