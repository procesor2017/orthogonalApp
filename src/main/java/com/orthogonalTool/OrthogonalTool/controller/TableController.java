package com.orthogonalTool.OrthogonalTool.controller;


import com.orthogonalTool.OrthogonalTool.matrix.TwoOnX;
import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import com.orthogonalTool.OrthogonalTool.practicalCode.JsonReader;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TableController {

    @Autowired
    CsvReader csvReader;

    @Autowired
    TwoOnX twoOnX;

    @Autowired
    JsonReader jsonReader;


    //http://localhost:8080/table/0&4&3
    @GetMapping("/table/{rowStart}&{rowEnd}&{column}")
    OrthogonalTable getTable(@PathVariable int rowStart, @PathVariable int rowEnd,@PathVariable int column) throws IOException {
        return csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", rowStart,rowEnd, column);
    }

    @PostMapping("/table/tryReact")
    public OrthogonalTable get2onXTable(@RequestBody JSONArray myArr) throws Exception {
        return twoOnX.twoOnThree(jsonReader.getTableFromJson(myArr));
        //return twoOnX.twoOnThree(myArr);
    }

    //http://localhost:8080/table/tryNewTable
    @GetMapping("/table/tryNewTable")
    public OrthogonalTable getNewTable() throws IOException {
        String myArr[][] = new String[4][5];
        myArr[0][0] = "Oracle";
        myArr[1][0] = "MySqlite";

        myArr[0][1] = "Hybernate";
        myArr[1][1] = "JPA";

        myArr[0][2] = "Rest";
        myArr[1][2] = "rwi";

        myArr[0][3] = "Rest1";
        myArr[1][3] = "rwi1";

        myArr[0][4] = "a";
        myArr[1][4] = "b";
        myArr[2][4] = "c";
        myArr[3][4] = "d";

        OrthogonalTable orthogonalTable = new OrthogonalTable();
        orthogonalTable.setWithValueTable(myArr);

        return twoOnX.twoOnFourAndOneOnFour(orthogonalTable);

    }

}
