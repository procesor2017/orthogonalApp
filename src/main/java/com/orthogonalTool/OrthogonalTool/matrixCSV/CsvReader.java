package com.orthogonalTool.OrthogonalTool.matrixCSV;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReader {
    public OrthogonalTable returnCsvTable(String pathToCsv, int rowStart, int rowEnd, int column) throws IOException {
        System.out.println("===== Start work with CSV ==========");
        int lengRow = rowEnd - rowStart;
        int[][] myTable = new int[lengRow][column];
        OrthogonalTable orthogonalTable = new OrthogonalTable();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        String row;
        // TODO předělat aby nenačítal celý csv
        String[] tableWithRowFromCSV = new String[300]; //Načítá tupě celé csv
        int x = 0;
        while((row = csvReader.readLine()) != null){
            tableWithRowFromCSV[x] = row;
            x++;
        }

        for (int i = 0; i<lengRow; i++) {
            for(int j=0; j< column; j++){
                String[] data = tableWithRowFromCSV[rowStart].split(",");
                myTable[i][j] = Integer.parseInt(data[j]);
            }
            rowStart++;
        }
        csvReader.close();
        orthogonalTable.setPoorTable(myTable);
        orthogonalTable.showPoorTableInConsole();
        System.out.println("============ END Work with CSV =============");
        return orthogonalTable;
    }

}
