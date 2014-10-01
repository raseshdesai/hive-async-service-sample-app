package com.monsanto.hive.batch;

import com.monsanto.hive.model.Row;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BatchProcessor {

    /*
    Executes hqlQuery and returns rows based on execution
     */
    List<Row> processQuery(String hqlQuery) throws Exception;
}
