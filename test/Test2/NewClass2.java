package Test2;

import com.orsoncharts.*;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.data.function.Function3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.Offset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.label.ItemLabelPositioning;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.label.StandardXYZLabelGenerator;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.GradientColorScale;
import com.orsoncharts.renderer.RainbowScale;
import com.orsoncharts.renderer.category.LineRenderer3D;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.SurfaceRenderer;
import com.orsoncharts.style.ChartStyles;
import com.orsoncharts.table.RectanglePainter;
import com.orsoncharts.util.Orientation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.chartthemes.simple.ChartThemeSettings;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Nuwantha
 */
public class NewClass2 extends JFrame {

    public NewClass2() {
        initUI();
    }
    Chart3D c = Chart3DFactory.createLineChart("Nuwantha", "Kumara", createDataset(), "Date", "Count", "Value");
    Chart3DPanel p = new Chart3DPanel(c);
    public static void main(String[] args) {
        NewClass2 ex = new NewClass2();
        ex.setVisible(true);
    }

    private void initUI() {
        Chart3D c = Chart3DFactory.createScatterChart("", "", ScatterPlot3D2.createDataset(), "", "", "");
        Chart3DPanel p = new Chart3DPanel(c);
        add(p);
        pack();
        setTitle("Nuwantha");
        setSize(800, 700);
        setLocation(50, 50);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
    Function3D function = new Function3D() {

        @Override
        public double getValue(double x, double z) {
            return Math.cos(x) * Math.sin(z);
        }
    };

    private static Chart3D create() {
        CategoryDataset3D dataset = createDataset12();
        Chart3D chart = Chart3DFactory.createAreaChart("AxisRangeDemo1",
                "A test for rendering with a restricted value range", dataset,
                "Row", "Category", "Value");
        chart.setChartBoxColor(new Color(255, 255, 255, 128));
        chart.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40));
        chart.setStyle(ChartStyles.createLogicalFontStyle());
        chart.setChartBoxColor(new Color(0, 255, 200));
        CategoryPlot3D plot = (CategoryPlot3D) chart.getPlot();
        plot.getValueAxis().setRange(-500, 500);
        plot.getRowAxis().setVisible(false);
        return chart;
    }

    private static CategoryDataset3D createDataset12() {

        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();

        DefaultKeyedValues s0 = new DefaultKeyedValues();
        s0.put("A", -500);
        s0.put("B", -200);
        s0.put("C", -400);
        s0.put("D", -150);
        dataset.addSeriesAsRow("All Negative", s0);

        DefaultKeyedValues s1 = new DefaultKeyedValues();
        s1.put("A", -500);
        s1.put("B", 500);
        s1.put("C", 0);
        s1.put("D", -150);
        dataset.addSeriesAsRow("Alternating 1", s1);

        DefaultKeyedValues s2 = new DefaultKeyedValues();
        s2.put("A", 500);
        s2.put("B", -500);
        s2.put("C", 0);
        s2.put("D", 150);
        dataset.addSeriesAsRow("Alternating 2", s2);

        DefaultKeyedValues s3 = new DefaultKeyedValues();
        s3.put("A", 500);
        s3.put("B", 200);
        s3.put("C", 400);
        s3.put("D", 150);
        dataset.addSeriesAsRow("All Positive", s3);

        return dataset;
    }

    public static Chart3D createChart1(XYZDataset dataset) {
        Chart3D chart = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",
                "Chart created with Orson Charts", dataset, "X", "Y", "Z");
        XYZPlot plot = (XYZPlot) chart.getPlot();
        plot.setDimensions(new Dimension3D(10.0, 4.0, 4.0));
        plot.setLegendLabelGenerator(new StandardXYZLabelGenerator(
                StandardXYZLabelGenerator.COUNT_TEMPLATE));
        ScatterXYZRenderer renderer = (ScatterXYZRenderer) plot.getRenderer();
        renderer.setSize(0.15);
        renderer.setColors(Colors.createIceCubeColors());
        chart.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40));
        return chart;
    }

    public static XYZDataset createDataset0() {
        XYZSeries s1 = createRandomSeries("S1", 10);
        XYZSeries s2 = createRandomSeries("S2", 105);
        XYZSeries s3 = createRandomSeries("S3", 119);
        XYZSeries s4 = createRandomSeries("S4", 35);
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        dataset.add(s1);
        dataset.add(s2);
        dataset.add(s3);
        dataset.add(s4);
        return dataset;
    }

    private static XYZSeries createRandomSeries(String name, int count) {
        XYZSeries s = new XYZSeries(name);
        for (int i = 0; i < count; i++) {
            s.add(Math.random() * 100, Math.random() / 100, Math.random() * 100);
        }
        return s;
    }

    public static Chart3D createChart1() {
        Function3D function = new Function3D() {

            @Override
            public double getValue(double x, double z) {
                return Math.tan(x);
            }
        };

        Chart3D chart = Chart3DFactory.createSurfaceChart(
                "SurfaceRendererDemo2",
                "y = sin(x^2 + z^2)",
                function, "X", "Y", "Z");
        XYZPlot plot = (XYZPlot) chart.getPlot();
        plot.setDimensions(new Dimension3D(10, 5, 10));
        ValueAxis3D xAxis = plot.getXAxis();
        xAxis.setRange(-2, 2);
        ValueAxis3D zAxis = plot.getZAxis();
        zAxis.setRange(-2, 2);
        SurfaceRenderer renderer = (SurfaceRenderer) plot.getRenderer();
        renderer.setColorScale(new RainbowScale(new Range(-1.0, 1.0)));
        renderer.setDrawFaceOutlines(false);
        chart.setLegendPosition(LegendAnchor.BOTTOM_RIGHT,
                Orientation.VERTICAL);
        return chart;
    }

    public static Chart3D pie() {
        StandardPieDataset3D dataset = new StandardPieDataset3D();
        dataset.add("Milk Products", 11625);
        dataset.add("Meat", 5114);
        dataset.add("Wood/Logs", 3060);
        dataset.add("Crude Oil", 2023);
        dataset.add("Machinery", 1865);
        dataset.add("Fruit", 1587);
        dataset.add("Fish", 1367);
        dataset.add("Wine", 1177);
        dataset.add("Nuwantha", 5646);
        dataset.add("Other", 18870);

        return Chart3DFactory.createPieChart("", "", dataset);
    }

    public static Chart3D createChart() {
        Function3D function = new Function3D() {

            @Override
            public double getValue(double x, double z) {
                return Math.cos(x) * Math.sin(z);
            }
        };


        Chart3D chart = Chart3DFactory.createSurfaceChart(
                "SurfaceRendererDemo1",
                "y = cos(x) * sin(z)",
                function, "X", "Y", "Z");
        XYZPlot plot = (XYZPlot) chart.getPlot();

        plot.setDimensions(
                new Dimension3D(150, 100, 150));
        ValueAxis3D xAxis = plot.getXAxis();

        xAxis.setRange(
                -5, 5);
        ValueAxis3D zAxis = plot.getZAxis();

        zAxis.setRange(
                -5, 5);
        SurfaceRenderer renderer = (SurfaceRenderer) plot.getRenderer();

        renderer.setDrawFaceOutlines(
                false);
        renderer.setColorScale(
                new GradientColorScale(new Range(-1.0, 1.0),
                Color.BLUE, Color.GREEN));
        return chart;
    }

    public static XYZDataset createDataset1() {
        XYZSeries series1 = new XYZSeries("Series 1");
        series1.add(1.0, 5.0, 1.0);
        XYZSeries series2 = new XYZSeries("Series 2");
        series2.add(2.0, 8.0, 2.0);
        XYZSeries series3 = new XYZSeries("Series 3");
        series3.add(1.0, 10.0, 2.0);
        XYZSeries series4 = new XYZSeries("Series 4");
        series3.add(1.0, 10.0, 2.0);
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        dataset.add(series1);
        dataset.add(series2);
        dataset.add(series3);
        dataset.add(series4);
        return dataset;
    }

    public static CategoryDataset3D createDataset() {

        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();

        DefaultKeyedValues s1 = new DefaultKeyedValues();
        s1.put("A", 4.0);
        s1.put("B", 2.0);
        s1.put("C", 3.0);
        s1.put("D", 5.0);
        s1.put("E", 2.0);
        s1.put("F", 1.0);
        DefaultKeyedValues s2 = new DefaultKeyedValues();
        s2.put("A", 1.0);
        s2.put("B", 2.0);
        s2.put("C", 3.0);
        s2.put("D", 2.0);
        s2.put("E", 3.0);
        s2.put("F", 1.0);
        DefaultKeyedValues s3 = new DefaultKeyedValues();
        s3.put("A", 6.0);
        s3.put("B", 6.0);
        s3.put("C", 6.0);
        s3.put("D", 4.0);
        s3.put("E", 4.0);
        s3.put("F", 4.0);
        
        dataset.addSeriesAsRow("Series 1", "Row 1", s1);
        dataset.addSeriesAsRow("Series 2", "Row 2", s2);
        dataset.addSeriesAsRow("Series 3", "Row 2", s3);
        return dataset;
    }
}