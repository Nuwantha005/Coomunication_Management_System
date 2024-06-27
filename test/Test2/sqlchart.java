/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test2;

import MC.MyConn;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Painter;
import org.jdesktop.swingx.editors.PaintPicker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.PaintMap;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.Align;
import org.jfree.ui.PaintSample;
import org.jfree.util.PaintList;
import org.jfree.util.PaintUtilities;
import sun.swing.plaf.synth.Paint9Painter;

/**
 *
 * @author Nuwantha
 */
public class sqlchart extends JFrame {

    static Connection c;

    public sqlchart() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Communication_Software";
            c = DriverManager.getConnection(url, "root", "123");
            JDBCCategoryDataset set = new JDBCCategoryDataset(c);
            set.executeQuery("select date,total from sales");
            JFreeChart barChart = ChartFactory.createLineChart(
                    "Olympic Gold medals in London",
                    "",
                    "Gold medals",
                    set,
                    PlotOrientation.VERTICAL,
                    true, true, true);
            ChartPanel panel = new ChartPanel(barChart);
            add(panel);
            setSize(600, 600);
            setLocation(50, 50);
            setTitle("Bar Chart");
            setDefaultCloseOperation(1);
            barChart.setBorderVisible(false);
            barChart.setBackgroundImageAlignment(Align.CENTER);
            barChart.setBackgroundImageAlpha(1);
            barChart.setBackgroundImage(ImageIO.read(new File("C:\\Users\\nuwan\\Pictures\\My pictures\\leon-seierlein-45928-unsplash.jpg")));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        sqlchart c = new sqlchart();
        c.setVisible(true);
    }
}
