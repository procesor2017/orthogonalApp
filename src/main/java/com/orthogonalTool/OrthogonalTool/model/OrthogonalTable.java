package com.orthogonalTool.OrthogonalTool.model;

import java.util.*;
import java.util.stream.Collectors;

public class OrthogonalTable {
    private int row;
    private int column;

    private int poorTable[][];
    private String withValueTable[][];  //Table with values from user


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

    public List<Integer> getTableType(){
        System.out.println("========== Get table type ===============");
        // Vrací počet řádků 
        int numbersOfRows = withValueTable.length;
        int numbersOfCol = withValueTable[0].length;
        List<Integer> valuesInRows = new ArrayList<>();
        List<Integer> finalValues = new ArrayList<>();

        System.out.println(withValueTable.length);
        System.out.println(withValueTable[0].length);


        for(int i = 0; i<numbersOfCol; i++){
            int countRow = 0;
            for(int j = 0; j<numbersOfRows; j++){
                if(withValueTable[j][i] != null){
                    countRow++;
                }
            }
            if (countRow != 0){
                valuesInRows.add(countRow);
            }
        }

        Integer[] arr = new Integer[valuesInRows.size()];
        valuesInRows.toArray(arr);

        Collections.sort(valuesInRows);

        Arrays.stream(arr)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> {
                    finalValues.add(k);
                    finalValues.add(v.size());
                });//System.out.println(k+" "+v.size()));
        System.out.println("Final values: "+ finalValues);
        System.out.println("=========================== End of Get table type ========================");
        return finalValues;
    }


}

