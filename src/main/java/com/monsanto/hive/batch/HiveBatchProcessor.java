package com.monsanto.hive.batch;

import com.monsanto.hive.model.Cell;
import com.monsanto.hive.model.Row;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 1:17 PM
 */
public class HiveBatchProcessor implements BatchProcessor{

    public static String DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";
    public static final String URL = "jdbc:hive2://stluhdpedev01:10000/default";
    public static final String USER = "ssnall";
    public static final String PASSWORD = "Srini_987654321";

    @Override
    public List<Row> processQuery(String hqlQuery) throws Exception {
        Class.forName(DRIVER_NAME);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = con.createStatement();

        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(hqlQuery);
            System.out.println("hqlQuery executed successfully = '" + hqlQuery + "'");

            List<Row> rows = new ArrayList<Row>();

            int rowSeq = 1;
            while (resultSet.next()){
                int numberOfColumns = resultSet.getMetaData().getColumnCount();
                Row row = new Row(rowSeq);
                System.out.println("numberOfColumns = " + numberOfColumns);
                for (int i = 1; i <= numberOfColumns; i++){
                    Cell cell = new Cell(i, resultSet.getMetaData().getColumnName(i), resultSet.getString(i));
                    row.addCell(cell);
                }
                System.out.println("");
                rows.add(row);
                rowSeq++;
            }
            return rows;
        } catch (SQLException e) {
            throw new Exception("Error occurred while running hive query '"+ hqlQuery +"', message = " + e.getMessage(), e);
        } finally {
            con.close();
        }
    }
}
