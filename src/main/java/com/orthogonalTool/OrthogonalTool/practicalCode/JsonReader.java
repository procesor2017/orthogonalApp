package com.orthogonalTool.OrthogonalTool.practicalCode;

import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.HashMap;

@Component
public class JsonReader {
    public OrthogonalTable getTableFromJson(JSONArray jsonArray) throws Exception {
        OrthogonalTable orthogonalTable = new OrthogonalTable();
        try {
            String[][] ints1 = new String[jsonArray.size()][3];
            for (int i = 0; i < jsonArray.size(); i++) {
                HashMap<String, String> hashMap = (HashMap<String, String>) jsonArray.get(i);
                Object[] arr = hashMap.values().toArray();
                for (int j = 0; j < hashMap.size(); j++) {
                    ints1[i][j] = (String) arr[j];
                    System.out.println("New add: " + ints1[i][j]);
                }
            }
            orthogonalTable.setWithValueTable(ints1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orthogonalTable;
    }
}
