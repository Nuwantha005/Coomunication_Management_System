/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test2;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartToPNGEx {

    public static void main(String[] args) throws IOException {
        XYSeries series1 = new XYSeries("2014");
        series1.add(18, 530);
        series1.add(20, 580);
        series1.add(25, 740);
        series1.add(30, 901);
        series1.add(40, 1300);
        series1.add(50, 2219);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Average salary per age",
                "Age",
                "Salary (€)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        ChartUtilities.saveChartAsPNG(new File("C:\\Users\\nuwan\\Pictures\\845638.jpg"), chart, 450, 400);
    }
}
