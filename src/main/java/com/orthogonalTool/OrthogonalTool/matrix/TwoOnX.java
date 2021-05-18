package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TwoOnX {
    public OrthogonalTable twoOnThree(OrthogonalTable orthogonalTable) {
        CsvReader csvReader = new CsvReader();
        OrthogonalTable o = new OrthogonalTable();
        ComponentsForMatrix componentsForMatrix = new ComponentsForMatrix();

        try {
            o = csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 0,4, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return componentsForMatrix.getTableWithValue(o.getPoorTable(), orthogonalTable.getWithValueTable(),4,3);
    }

    public OrthogonalTable twoOnFourAndOneOnFour(OrthogonalTable orthogonalTable) {
        CsvReader csvReader = new CsvReader();
        OrthogonalTable o = new OrthogonalTable();
        ComponentsForMatrix componentsForMatrix = new ComponentsForMatrix();

        try {
            o = csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 5,13, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return componentsForMatrix.getTableWithValue(o.getPoorTable(), orthogonalTable.getWithValueTable(),8,5);

    }
}
