package com.orthogonalTool.OrthogonalTool.controller;


import com.orthogonalTool.OrthogonalTool.matrix.TwoOnX;
import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TableController {

    @Autowired
    CsvReader csvReader;

    @Autowired
    TwoOnX twoOnX;


    //http://localhost:8080/table/0&4&3
    @GetMapping("/table/{rowStart}&{rowEnd}&{column}")
    OrthogonalTable getTable(@PathVariable int rowStart, @PathVariable int rowEnd,@PathVariable int column) throws IOException {
        return csvReader.returnCsvTable("src/main/java/com/orthogonalTool/OrthogonalTool/matrixCSV/2onX.csv", rowStart,rowEnd, column);
    }

    //http://localhost:8080/table/try
    @GetMapping("/table/try")
    OrthogonalTable newTry() {
        String myArr[][] = new String[4][3];
        myArr[0][0] = "Oracle";
        myArr[1][0] = "MySqlite";

        myArr[0][1] = "Hybernate";
        myArr[1][1] = "JPA";

        myArr[0][2] = "Rest";
        myArr[1][2] = "rwi";

        return twoOnX.twoOnThree(myArr);
    }

    @PostMapping("/table/tryReact")
    public OrthogonalTable get2onXTable(@RequestParam(value = "myArr[][]") String [][] myArr){
        return twoOnX.twoOnThree(myArr);
    }
}
