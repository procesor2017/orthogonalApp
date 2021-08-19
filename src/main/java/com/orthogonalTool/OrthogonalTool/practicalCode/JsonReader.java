package com.orthogonalTool.OrthogonalTool.practicalCode;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

@Component
public class JsonReader {
    public OrthogonalTable getTableFromJson(JSONArray jsonArray, int column){
        System.out.println("================== Get Table from JSON =============");
        OrthogonalTable orthogonalTable = new OrthogonalTable();
        try {
            String[][] ints1 = new String[jsonArray.size()][column];
            for (int i = 0; i < jsonArray.size(); i++) {
                HashMap<String, String> hashMap = (HashMap<String, String>) jsonArray.get(i);
                for (int j = 0; j < column; j++) {
                    Integer f = j;
                    System.out.println("AAA === " + hashMap.get(f.toString()));
                    ints1[i][j] = hashMap.get(f.toString());
                    System.out.println("I get on coo: " + i + j + " this value: " + ints1[i][j]);
                }
            }
            orthogonalTable.setWithValueTable(ints1);
            System.out.println(ints1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=============== END Return JSON ==================");
        return orthogonalTable;
    }
}
