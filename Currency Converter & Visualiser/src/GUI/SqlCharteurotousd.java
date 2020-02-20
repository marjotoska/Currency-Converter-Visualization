/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;

public class SqlCharteurotousd extends javax.swing.JFrame {      
    
    public SqlCharteurotousd(){

 JFrame frame = new JFrame("Bar Chart");
 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 

 JFreeChart barChart = euroToUSDBarChart(PlotOrientation.VERTICAL);
 
    BufferedImage image = barChart.createBufferedImage(750,450);
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon(image));
    frame.getContentPane().add(label);
 
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private static JDBCCategoryDataset dataset;

    public static JFreeChart euroToUSDBarChart(PlotOrientation aOrientation){
        JFreeChart barChart = null;
               
        String url = "jdbc:mysql://localhost:3306/currencyRates";
        String user = "root";
        String password = "";

        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
            dataset = new JDBCCategoryDataset(con);     //declare data from DB
            dataset.executeQuery("SELECT date, rate FROM eurotousd");
                   
              barChart = ChartFactory.createBarChart(
                "Exchange Rate EUR -> USD",
                "",
                "rate",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        
        // Set the background color of the chart       
        barChart.setBackgroundPaint(Color.white);  
        
        // Adjust the color of the title
        barChart.getTitle().setPaint(Color.DARK_GRAY);
        barChart.setBorderVisible(true);

        CategoryPlot plot = barChart.getCategoryPlot();
        Double l = 1.0795;
        Double u = 1.0869;
        plot.getRangeAxis().setLowerBound(l);
        
        // Get the Plot object for a bar graph
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLowerMargin(l);
        rangeAxis.setUpperBound(u);
        
        plot.setBackgroundPaint(Color.white);     
        plot.setRangeGridlinePaint(Color.blue);
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.decode("#00008B"));
        //renderer.setSeriesPaint(0, Color.decode("#149414")); emerald green
       
        }catch(ClassNotFoundException | SQLException ex){  
          ex.printStackTrace();
        } 
 return barChart;
 //end euroToUSD chart generation method
 }  
        public SqlCharteurotousd(String saveAsPNG) throws IOException{

    JFreeChart barChart = euroToUSDBarChart(PlotOrientation.VERTICAL);

        ChartUtils.saveChartAsPNG(new File("euroToUSDBarChart.png"), barChart, 750,450);
    }
    
}
