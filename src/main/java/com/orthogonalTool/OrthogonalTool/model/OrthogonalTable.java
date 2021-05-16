package com.orthogonalTool.OrthogonalTool.model;

import java.util.Arrays;

public class OrthogonalTable {
    private int row;
    private int column;

    private int poorTable[][];
    private String withValueTable[][];






    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public OrthogonalTable() {
    }

    public int[][] getPoorTable() {
        return poorTable;
    }

    public void setPoorTable(int[][] poorTable) {
        this.poorTable = poorTable;
    }

    public String[][] getWithValueTable() {
        return withValueTable;
    }

    public void setWithValueTable(String[][] withValueTable) {
        this.withValueTable = withValueTable;
    }

    public String showWithValueTableInConsole(){
        System.out.println(Arrays.deepToString(withValueTable));
        return Arrays.deepToString(withValueTable);
    }

    public String showPoorTableInConsole(){
        System.out.println(Arrays.deepToString(poorTable));
        return Arrays.deepToString(poorTable);
    }

    @Override
    public String toString() {
        return "OrthogonalTable{" +
                "poorTable=" + Arrays.deepToString(poorTable) +
                '}';
    }
}
