package com.monsanto.hive.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 3:33 PM
 */
public class Row {

    private int segId;
    private List<Cell> cells;

    public Row(int segId) {
        this.segId = segId;
    }

    public void addCell(Cell cell){
        if(null == cells){
            cells = new ArrayList<Cell>();
        }
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getSegId() {
        return segId;
    }
}
