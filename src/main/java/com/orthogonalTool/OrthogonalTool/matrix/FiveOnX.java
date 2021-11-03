package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FiveOnX {

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

    public OrthogonalTable FiveOnSix(OrthogonalTable orthogonalTable) {
        return returnTable(orthogonalTable, "src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/5onX.csv", 1,26,6, 25,6);
    }
}
