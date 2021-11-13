package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FourOnX {

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

    public OrthogonalTable FourOnFive(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/4onX.csv", 1,17,5, 16,5);
    }

    public OrthogonalTable FourOnEightAndEightOnOne(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/4onX.csv", 19,51,9, 32, 9);
    }
}
