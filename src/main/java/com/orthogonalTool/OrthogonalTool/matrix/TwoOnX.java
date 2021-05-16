package com.orthogonalTool.OrthogonalTool.matrix;

import com.orthogonalTool.OrthogonalTool.math.Orthogonal;
import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TwoOnX {
    public OrthogonalTable twoOnThree(String myArr[][]) {
        CsvReader csvReader = new CsvReader();
        OrthogonalTable o = new OrthogonalTable();
        String tableWithValue[][] = new String[4][3];
        OrthogonalTable backTable = new OrthogonalTable();


        String row0col0 =myArr[0][0]; // 0
        String row1col0 =myArr[1][0]; // 1

        String row0col1 =myArr[0][1]; // 0
        String row1col1 =myArr[1][1]; // 1

        String row0col2 =myArr[0][2]; // 0
        String row1col2 =myArr[1][2]; // 1

        try {
            o = csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", 0,4, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int oArray[][] = o.getPoorTable();
        for(int i=0; i<oArray.length; i++) {
            for(int j=0; j<oArray[i].length; j++) {
                if(j == 0){
                    if(oArray[i][j] == 0){
                        tableWithValue[i][j] = myArr[0][0];
                    }else{
                        tableWithValue[i][j] = myArr[1][0];
                    }
                }else if(j == 1){
                    if(oArray[i][j] == 0){
                        tableWithValue[i][j] = myArr[0][1];
                    }else{
                        tableWithValue[i][j] = myArr[1][1];
                    }
                }else if(j == 2){
                    if(oArray[i][j] == 0){
                        tableWithValue[i][j] = myArr[0][2];
                    }else{
                        tableWithValue[i][j] = myArr[1][2];
                    }
                }
            }
        }
        backTable.setWithValueTable(tableWithValue);
        backTable.setPoorTable(o.getPoorTable());
        return backTable;
    }
}
