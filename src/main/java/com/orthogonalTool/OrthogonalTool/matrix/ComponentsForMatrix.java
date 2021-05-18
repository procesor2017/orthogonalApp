package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

@Component
public class ComponentsForMatrix {
    public OrthogonalTable getTableWithValue(int[][] poorTable, String[][] dataTable, int rowForValueTable, int columnForValueTable){
        String tableWithValue[][] = new String[rowForValueTable][columnForValueTable];
        OrthogonalTable backTable = new OrthogonalTable();

        int oArray[][] = poorTable;
        for(int i=0; i<oArray.length; i++) {
            for(int j=0; j<oArray[i].length; j++) {
                System.out.println(dataTable[oArray[i][j]][j]);
                tableWithValue[i][j] = dataTable[oArray[i][j]][j];
            }
        }
        backTable.setWithValueTable(tableWithValue);
        backTable.setPoorTable(poorTable);
        return backTable;
    }
}
