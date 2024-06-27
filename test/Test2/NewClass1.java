/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test2;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Offset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.label.ItemLabelPositioning;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.LineRenderer3D;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Nuwantha
 */
public class NewClass1 extends JFrame {

    public NewClass1() {
        initUI();
    }

    public static void main(String[] args) {
        NewClass1 ex = new NewClass1();
        ex.setVisible(true);
    }

    private void initUI() {
        XYZDataset set = createDataset() ;
       Chart3D c = Chart3DFactory.createXYZBarChart("", "", set, "", "", "");
        Chart3DPanel p = new Chart3DPanel(c);
        add(p);
        pack();
        setTitle("Nuwantha");
        setSize(500, 500);
        setLocation(50, 50);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

  

  public static XYZDataset createDataset() {
        XYZSeries series1 = new XYZSeries("Series 1");
        series1.add(1.0, 5.0, 1.0);
        XYZSeries series2 = new XYZSeries("Series 2");
        series2.add(2.0, 8.0, 2.0);
        XYZSeries series3 = new XYZSeries("Series 3");
        series3.add(1.0, 10.0, 2.0);
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        dataset.add(series1);
        dataset.add(series2);
        dataset.add(series3);
        return dataset;
    } 
  
}
