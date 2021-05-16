package com.orthogonalTool.OrthogonalTool.controller;

import com.orthogonalTool.OrthogonalTool.matrixCSV.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CsvReader csvReader;

    @GetMapping("")
    public String home(){
        return "index";
    }

}
