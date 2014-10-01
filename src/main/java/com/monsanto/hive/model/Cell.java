package com.monsanto.hive.model;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 3:24 PM
 */
public class Cell {

    private Integer seqId;
    private String name;
    private String value;

    public Cell(Integer seqId, String name, String value) {
        this.seqId = seqId;
        this.name = name;
        this.value = value;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
