package com.orthogonalTool.OrthogonalTool.matrixCSV;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReader {
    public OrthogonalTable returnCsvTable(String pathToCsv, int rowStart, int rowEnd, int column) throws IOException {
        int[][] myTable = new int[rowEnd][column];
        OrthogonalTable orthogonalTable = new OrthogonalTable();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        for (int i = rowStart; i<rowEnd; i++) {
            String row = csvReader.readLine();
            String[] data = row.split(",");
            for(int j=0; j< data.length; j++){
                myTable[i][j] = Integer.parseInt(data[j]);
            }
        }
        csvReader.close();
        orthogonalTable.setPoorTable(myTable);
        orthogonalTable.showPoorTableInConsole();
        return orthogonalTable;
    }
}
