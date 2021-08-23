package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class TwoOnX {

    //TODO upravit vstupní parametry = poslední dva jsou zbytečné
    private OrthogonalTable returnTable(OrthogonalTable orthogonalTable, String pathToCsv, int rowStart, int rowEnd, int column, int rowForValueTable, int columnForValueTable){
        CsvReader csvReader = new CsvReader();
        OrthogonalTable o = new OrthogonalTable();
        ComponentsForMatrix componentsForMatrix = new ComponentsForMatrix();
        try {
            o = csvReader.returnCsvTable(pathToCsv, rowStart, rowEnd, column);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return componentsForMatrix.getTableWithValue(o.getPoorTable(), orthogonalTable.getWithValueTable(),rowForValueTable,columnForValueTable);
    }

    public OrthogonalTable twoOnThree(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 0,4,3, 4,3);
    }

    public OrthogonalTable twoOnFourAndOneOnFour(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 5,13,5, 8,5);
    }

    public OrthogonalTable twoOnEleven(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 14,26,11, 12,11);
    }

    public OrthogonalTable twoOnFourAndOneOnThree(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 27,40,5, 12,5);
    }

    public OrthogonalTable twoOnTwoAndOneOnSix(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 41,54,3, 12,3);
    }

    public OrthogonalTable twoOnEightAndOneOnEight(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 55,72,9, 16,9);
    }
}
