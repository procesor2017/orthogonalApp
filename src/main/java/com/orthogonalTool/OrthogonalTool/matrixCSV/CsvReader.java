package com.orthogonalTool.OrthogonalTool.matrixCSV;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class CsvReader {
    public OrthogonalTable returnCsvTable(String pathToCsv, int rowStart, int rowEnd, int column) throws IOException {
        System.out.println("===== Start work with CSV ==========");
        int lengRow = rowEnd - rowStart;
        int[][] myTable = new int[lengRow][column];
        System.out.println("Velikost tabulky je: " + lengRow + " a " + column);
        OrthogonalTable orthogonalTable = new OrthogonalTable();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        String row;
        //TODO předělat aby nenačítal celý csv
        String[] tableWithRowFromCSV = new String[200]; //Načítá tupě celé csv
        int x = 0;
        while((row = csvReader.readLine()) != null){
            tableWithRowFromCSV[x] = row;
            System.out.println(tableWithRowFromCSV[x]);
            x++;
        }
        System.out.println(tableWithRowFromCSV);

        for (int i = 0; i<lengRow; i++) {
            for(int j=0; j< column; j++){
                String[] data = tableWithRowFromCSV[rowStart].split(",");
                System.out.println("Na souřadnicích: " + i + " : " + j + "je value: " + data[j]);
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
