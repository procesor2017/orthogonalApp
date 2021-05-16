package com.orthogonalTool.OrthogonalTool;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Orthogonal o = new Orthogonal();
        o.createOrthogonal(3, 2);*/

        CsvReader csvReader = new CsvReader();
        csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 0,4, 3);
    }
}
