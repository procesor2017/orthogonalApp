package com.orthogonalTool.OrthogonalTool.model;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Integer> getTableType(){
        int numbersOfRows = withValueTable.length;
        int numbersOfCol = withValueTable[0].length;
        List<Integer> valuesInRows = new ArrayList<>();
        List<Integer> finalValues = new ArrayList<>();
        int valueNumber = 0;


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
                    finalValues.add(v.size());
                    finalValues.add(k);
                });//System.out.println(k+" "+v.size()));
        System.out.println(finalValues);
        return finalValues;
    }


}

