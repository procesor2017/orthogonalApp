package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ThreeOnX {

    //TODO upravit vstupní parametry = poslední dva jsou zbytečné
    private OrthogonalTable returnTable(OrthogonalTable orthogonalTable, String pathToCsv, int rowStart, int rowEnd, int column){
        int realRowForValueTable = rowEnd - rowStart;

        CsvReader csvReader = new CsvReader();
        OrthogonalTable o = new OrthogonalTable();
        ComponentsForMatrix componentsForMatrix = new ComponentsForMatrix();
        try {
            o = csvReader.returnCsvTable(pathToCsv, rowStart, rowEnd, column);
        } catch (IOException e) {
            e.printStackTrace();
        }

        OrthogonalTable returnTable = componentsForMatrix.getTableWithValue(o.getPoorTable(), orthogonalTable.getWithValueTable(),realRowForValueTable, column);

        return returnTable;
    }

    public OrthogonalTable ThreeOnFour(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/3onX.csv", 1, 10, 4);
    }

    public OrthogonalTable ThreeOnSixAndSixOnOne(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/3onX.csv", 12, 30, 7);
    }

    public OrthogonalTable ThreeOnNinexAndNineOnOne(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/3onX.csv", 32, 59, 10);
    }
}
