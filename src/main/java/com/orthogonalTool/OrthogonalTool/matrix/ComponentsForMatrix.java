package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

@Component
public class ComponentsForMatrix {
    public OrthogonalTable getTableWithValue(int[][] poorTable, String[][] dataTable, int rowForValueTable, int columnForValueTable){
        String tableWithValue[][] = new String[rowForValueTable][columnForValueTable];
        OrthogonalTable backTable = new OrthogonalTable();

        dataTable = iterDatatableFromUser(dataTable);

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

    public String[][] iterDatatableFromUser(String[][] dataTable){
        HashMap<Integer, Integer> my_dict = new HashMap<Integer, Integer>();
        String[][] newTable = new String[dataTable.length][dataTable[0].length];
        //Maps for iterating
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (int i = 0; i < dataTable[0].length; i++){
            int countRow = 0;
            for(int j = 0; j< dataTable.length; j++){
                if(dataTable[j][i] != null){
                    countRow++;
                }
            }
            //column a kolik má řádku hodnot
            my_dict.put(i, countRow);
        }

        //Sorting
        my_dict.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Nesortnutej dict: " + my_dict);
        System.out.println("Sortnutej dict: " + sortedMap);

        Integer[] rowArrayValue = new Integer[sortedMap.size()];
        Integer[] colArrayValue = new Integer[sortedMap.size()];
        Set<Integer> keys = sortedMap.keySet();
        int k = 0;
        for (Integer key : keys) {
            colArrayValue[k] = key;
            rowArrayValue[k] = sortedMap.get(key);
            k++;
        }

        for (int i = 0; i < sortedMap.size(); i++){
            for(int j = 0; j < rowArrayValue[i]; j++){
                newTable[j][i] = dataTable[j][colArrayValue[i]];
            }
        }

        return newTable;
    }
}
