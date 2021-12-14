package com.orthogonalTool.OrthogonalTool.controller;


import com.orthogonalTool.OrthogonalTool.matrix.TwoOnX;
import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import com.orthogonalTool.OrthogonalTool.practicalCode.JsonReader;
import com.orthogonalTool.OrthogonalTool.practicalCode.Orthogonal;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TableController {

    @Autowired
    CsvReader csvReader;

    @Autowired
    TwoOnX twoOnX;

    @Autowired
    JsonReader jsonReader;

    @Autowired
    Orthogonal orthogonal;


    //http://localhost:8080/table/0&4&3
    @GetMapping("/table/{rowStart}&{rowEnd}&{column}")
    OrthogonalTable getTable(@PathVariable int rowStart, @PathVariable int rowEnd,@PathVariable int column) throws IOException {
        return csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", rowStart,rowEnd, column);
    }

    @PostMapping("/table/tryToFind")
    public OrthogonalTable tryToFindBestTable(@RequestBody JSONArray myArr) {
        List<Integer> list = jsonReader.getTableFromJson(myArr, 10).getTableType();
        System.out.println("Jdeme na výběr OT");
        return orthogonal.chooseOrthogonalTable(list, myArr);
    }
}
