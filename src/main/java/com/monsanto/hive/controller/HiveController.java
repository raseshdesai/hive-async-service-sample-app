package com.monsanto.hive.controller;

import com.monsanto.hive.batch.HiveBatchProcessor;
import com.monsanto.hive.model.Cell;
import com.monsanto.hive.model.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 1:25 PM
 */
@Controller
public class HiveController {

    public static final String HIVE_QUERY_LAUNCHER_VIEW_NAME = "hivequerylauncher";

    @RequestMapping("/hive-query-launcher")
    public ModelAndView launchHiveQuery(@RequestParam("hiveQuery") String hiveQuery) throws Exception {
        try {
            System.out.println("controller invoked..");

            List<Row> rows = new HiveBatchProcessor().processQuery(hiveQuery);
            String fileName = System.getProperty("java.io.tmpdir") + "\\hive-query-results.txt";
            System.out.println("fileName = " + fileName);
            FileWriter writer = new FileWriter(fileName);

            for (Row row : rows) {
                for (Cell cell : row.getCells()) {
                    writer.append(cell.getValue());
                    writer.append(",");
                }
                writer.append("\r\n");
            }
            writer.flush();
            writer.close();
            System.out.println("file written.");

            return new ModelAndView(HIVE_QUERY_LAUNCHER_VIEW_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
