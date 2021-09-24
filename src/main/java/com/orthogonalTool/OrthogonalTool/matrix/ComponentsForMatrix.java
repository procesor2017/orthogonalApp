package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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

    public OrthogonalTable iterDatatableFromUser(OrthogonalTable orthogonalTable){
        /*
        Každý sloupeček bude mít ID 0-n a hodnotu size() pak se mi iterizací budou řadit podle velikosti
        */

        OrthogonalTable tableForBack = new OrthogonalTable();
        String[][] otDataTable= orthogonalTable.getWithValueTable();
        HashMap<Integer, Integer> my_dict = new HashMap<Integer, Integer>;

        for (int i = 0; i < otDataTable[0].length; i++){
            int countRow = 0;
            for(int j = 0; j<otDataTable.length; j++){
                if(otDataTable[j][i] != null){
                    countRow++;
                }
            }
            my_dict.put(i, countRow);
        }

        

        return tableForBack;
    }
}
