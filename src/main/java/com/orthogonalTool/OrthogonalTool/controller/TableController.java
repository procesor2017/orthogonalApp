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

    @PostMapping("/table/2on3")
    public OrthogonalTable get2onXTable(@RequestBody JSONArray myArr){
        return twoOnX.twoOnThree(jsonReader.getTableFromJson(myArr, 3));
    }

    //http://localhost:8080/table/tryNewTable
    @GetMapping("/table/2on3&1on4")
    public OrthogonalTable getNewTable(@RequestBody JSONArray myArr) {
        return twoOnX.twoOnFourAndOneOnFour(jsonReader.getTableFromJson(myArr, 5));

    }

}
