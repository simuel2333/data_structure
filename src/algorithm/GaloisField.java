package algorithm;

import java.util.Arrays;

public class GaloisField {

    public int n;//次数
    public int[][] addTable;
    public int[][] multiTable;
    public int[][] inverseElementTable;
    int js;

    public GaloisField(int n) {
        js = (int) Math.pow(2, n);
        addTable = new int[js][js];
        multiTable = new int[js][js];
        inverseElementTable = new int[2][js];
        initAddTable(this.addTable);
        initMultiTable(this.multiTable);
    }

    public void initAddTable(int[][] addTable) {
        for (int i = 0; i < js; i++) {
            for (int j = 0; j < js; j++) {
                addTable[i][j] = i ^ j;
            }
        }
    }

    public void initMultiTable(int[][] multiTable) {
        for (int i = 0; i < js; i++) {
            for (int j = 0; j < js; j++) {

            }
        }
    }

    public int rightShift(int num) {
        int flag = (int)Math.pow(2,n)-1;
        return num;
    }

    public static void main(String[] args) {
        GaloisField gf3 = new GaloisField(4);

        for (int i = 0; i < gf3.js; i++) {
            System.out.println(Arrays.toString(gf3.addTable[i]));
        }

    }


}
