package com.example.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jfree.chart.ChartUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class JfreechartApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfreechartApplication.class, args);

		System.out.println("maxx is ready for jFreeChart");



		String headlessProperty = System.getProperty("java.awt.headless");
		if (headlessProperty == null) {
			System.out.println("java.awt.headless is not set.");
		} else if (headlessProperty.equals("true")) {
			System.out.println("java.awt.headless is set to true.");
		} else if (headlessProperty.equals("false")) {
			System.out.println("java.awt.headless is set to false.");
		} else {
			System.out.println("java.awt.headless is set to: " + headlessProperty);
		}

		/*
		this property will allow the system to create the graphics
		by default the system won't alloq it
		 */
		System.setProperty("java.awt.headless", "false");

		String afterHeadlessProperty = System.getProperty("java.awt.headless");
		System.out.println("java.awt.headless is set :: "+ afterHeadlessProperty);


//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.addValue(200, "Sales", "January");
//		dataset.addValue(150, "Sales", "February");
//		dataset.addValue(180, "Sales", "March");
//		dataset.addValue(260, "Sales", "April");
//		dataset.addValue(300, "Sales", "May");
//
//
//		JFreeChart chart = ChartFactory.createLineChart("Monthly sales","Month","sales",dataset);
//		ChartPanel chartPanel = new ChartPanel(chart);
//		JFrame frame = new JFrame();
//		frame.setSize(800, 600);
//		frame.setContentPane(chartPanel);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);


	}

}
