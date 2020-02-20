/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.SqlCharteurotousd.euroToUSDBarChart;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author marjo
 */
public class SqlChartusdtoeuro {

    private static JDBCCategoryDataset dataset;
    
           public static JFreeChart usdToEUROBarChart(PlotOrientation aOrientation){
        JFreeChart barChart1 = null;
               
        String url = "jdbc:mysql://localhost:3306/currencyRates";
        String user = "root";
        String password = "";

        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
            dataset = new JDBCCategoryDataset(con);     //declare data from DB
            dataset.executeQuery("SELECT date, rate FROM usdtoeuro");
                   
              barChart1 = ChartFactory.createBarChart(
                "Exchange Rate USD -> EURO",
                "",
                "rate",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        
        // Set the background color of the chart       
        barChart1.setBackgroundPaint(Color.white);  
        
        // Adjust the color of the title
        barChart1.getTitle().setPaint(Color.DARK_GRAY);
        barChart1.setBorderVisible(true);

        
        //Sets lower and upper boundaries of graph
        CategoryPlot plot = barChart1.getCategoryPlot();
        Double l = 0.9222;
        Double u = 0.9269;
        plot.getRangeAxis().setLowerBound(l);

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLowerMargin(l);
        rangeAxis.setUpperBound(u);
        
        plot.setBackgroundPaint(Color.white);     
        plot.setRangeGridlinePaint(Color.decode("#FF2400"));
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.decode("#FF2400")); //SCARLET RED
       
        }catch(ClassNotFoundException | SQLException ex){  
          ex.printStackTrace();
        } 
 return barChart1;
 //end euroToALL chart generation method
 }
           
            public SqlChartusdtoeuro(){

 JFrame frame = new JFrame("Bar Chart");
 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 

 JFreeChart barChart = usdToEUROBarChart(PlotOrientation.VERTICAL);
 
    BufferedImage image = barChart.createBufferedImage(750,450);
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon(image));
    frame.getContentPane().add(label);
 
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
