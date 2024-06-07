package com.example.jfreechart.controller;

import com.example.jfreechart.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {

    @Autowired
    private ChartService chartService;

    @GetMapping("/chart/bar")
    public void barChartTest(){
        chartService.prepareBarChart();
    }

    @GetMapping("/chart/line")
    public void lineChartTest(){
        chartService.prepareLineChart();
    }

    @GetMapping("/chart/pie")
    public void pieChartTest(){
        chartService.preparePieChart();
    }

    @GetMapping("/chart/pie-3d")
    public void pie3dChartTest(){
        chartService.PieChart3d();
    }
}
