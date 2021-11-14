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

    @PostMapping("/table/2on3")
    public OrthogonalTable get2onXTable(@RequestBody JSONArray myArr){
        return twoOnX.twoOnThree(jsonReader.getTableFromJson(myArr, 3));
    }

    //http://localhost:8080/table/tryNewTable
    @GetMapping("/table/2on3&1on4")
    public OrthogonalTable getNewTable(@RequestBody JSONArray myArr) {
        return twoOnX.twoOnFourAndOneOnFour(jsonReader.getTableFromJson(myArr, 5));
    }

    @PostMapping("/table/tryToFind")
    public OrthogonalTable tryToFindBestTable(@RequestBody JSONArray myArr) {
        List<Integer> list = jsonReader.getTableFromJson(myArr, 10).getTableType();
        System.out.println("Jdeme na výběr OT");
        return orthogonal.chooseOrthogonalTable(list, myArr);
    }



    //http://localhost:8080/table/tryNewTable
    @GetMapping("/table/MoltenCore")
    public String getMoltenCore() {
        String myArr[][] = new String[10][10];
        myArr[0][0] = "Oracle";
        myArr[1][0] = "MySqlite";

        myArr[0][1] = "Hybernate";
        myArr[1][1] = "JPA";

        myArr[0][2] = "Rest";
        myArr[1][2] = "rwi";
        myArr[2][2] = "rwi";

        OrthogonalTable orthogonalTable = new OrthogonalTable();
        orthogonalTable.setWithValueTable(myArr);

        orthogonalTable.getTableType();

        return "index";
    }

}
