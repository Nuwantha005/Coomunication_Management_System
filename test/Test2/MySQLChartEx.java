/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test2;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class MySQLChartEx {

    static Connection c;
    private static JDBCCategoryDataset dataset;

    public static void main(String[] args) throws IOException, SQLException {
        Connection con = null;
        String user = "testuser";
        String password = "test623";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLChartEx.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/Communication_Software";
            c = DriverManager.getConnection(url, "root", "123");
            dataset = new JDBCCategoryDataset(c);
            dataset.executeQuery("SELECT total,discount from sales ");
        } finally {
            if (con != null) {
                con.close();
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Olympic Gold medals in London",
                "",
                "Gold medals",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        ChartUtilities.saveChartAsPNG(new File("C:\\Users\\nuwan\\Pictures\\845638.jpg"), barChart, 450, 400);
    }
}
