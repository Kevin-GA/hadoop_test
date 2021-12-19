package com.test.hadoop.model;

import java.io.Serializable;

public class TableObject implements Serializable {
    private String table;
    private String opType;
    private TEST_OGG before;
    private TEST_OGG after;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public TEST_OGG getBefore() {
        return before;
    }

    public void setBefore(TEST_OGG before) {
        this.before = before;
    }

    public TEST_OGG getAfter() {
        return after;
    }

    public void setAfter(TEST_OGG after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "TableObject{" +
                "table='" + table + '\'' +
                ", opType='" + opType + '\'' +
                ", before=" + before +
                ", after=" + after +
                '}';
    }
}
