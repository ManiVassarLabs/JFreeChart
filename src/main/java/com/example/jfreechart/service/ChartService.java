package com.example.jfreechart.service;

import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@Service
public class ChartService {

    public void prepareBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row 1", "Column 1");
        dataset.addValue(4.0, "Row 1", "Column 2");
        dataset.addValue(3.0, "Row 1", "Column 3");

        //by changing the rowkey we can create different set of bars in the same chart
        dataset.addValue(3.0, "Row 2", "Column 1");
        dataset.addValue(9.0, "Row 2", "Column 2");
        dataset.addValue(2.0, "Row 2", "Column 3");



        JFreeChart chart = ChartFactory.createBarChart(
                "Chart Title",  // Chart title
                "Category",     // Category axis label
                "Value",        // Value axis label
                dataset         // Dataset
        );

        /*
         * BY using the below code we can rotate the chart
         */
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL);

        /*

         */
        BarRenderer renderer =(BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0,Color.YELLOW);
        renderer.setSeriesPaint(1,Color.green);


        // Save the chart as a PNG file
        try {
            File file = new File("chart.png");
            ChartUtils.saveChartAsPNG(file, chart, 800, 600);
            System.out.println("Chart saved as chart.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void prepareLineChart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "Sales", "January");
        dataset.addValue(150, "Sales", "February");
        dataset.addValue(180, "Sales", "March");
        dataset.addValue(260, "Sales", "April");
        dataset.addValue(300, "Sales", "May");

        JFreeChart chart = ChartFactory.createLineChart(
                "Monthly Sales",
                "Month",
                "Sales",
                dataset);

//        ChartPanel chartPanel = new ChartPanel(chart);
//        JFrame frame = new JFrame();
//        frame.setSize(800, 600);
//        frame.setContentPane(chartPanel);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        try {
            File file = new File("lineChart.png");
            ChartUtils.saveChartAsPNG(file, chart, 800, 600);
            System.out.println("Chart saved as chart.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void preparePieChart(){

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("2018",100);
        dataset.setValue("2019",200);
        dataset.setValue("2020",140);
        dataset.setValue("2021",190);

        JFreeChart chart = ChartFactory.createPieChart("expenses",dataset);

        PiePlot plot = (PiePlot) chart.getPlot();

        //setting colour to a plot
        plot.setSectionPaint("2018", new Color(255, 0, 0));

        //setting outline is visible
        plot.setOutlineVisible(true);

        //set custom labels
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));

        //set explode using the explose we can see the section seperately
        plot.setExplodePercent("2018",0.5);
        try {
            File file = new File("piechart.png");
            ChartUtils.saveChartAsPNG(file, chart, 800, 600);
            System.out.println("Pie chart saved as piechart.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PieChart3d(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("2004-2005", 58);
        dataset.setValue("2005-2006", 41);
        dataset.setValue("2006-2007", 85.3);
        dataset.setValue("2007-2008", 81);

        /* create chart */
        JFreeChart chart = ChartFactory.createPieChart3D("Simple Piechart",
                dataset);

        /* Get PiePlot object */
        PiePlot3D plot = (PiePlot3D) chart.getPlot();

        /* Set custom labels for section */
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));

        plot.setDarkerSides(true);
        plot.setStartAngle(290D);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5F);
        plot.setNoDataMessage("No data to display");

        /* create and display chart on frame */
        ChartFrame frame = new ChartFrame("JFreeChart Demo", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
