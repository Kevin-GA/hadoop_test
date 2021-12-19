package com.ydjt.entity;

import com.google.common.base.Objects;
import com.test.hadoop.model.TEST_OGG;

import java.io.Serializable;

public class KafkaOggJsonTableObject implements Serializable {
    private String table;
    private String opType;
    private String before;
    private String after;

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

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "YdjtYdcaBusinessDataOgg{" +
                "table='" + table + '\'' +
                ", opType='" + opType + '\'' +
                ", before=" + before +
                ", after=" + after +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KafkaOggJsonTableObject that = (KafkaOggJsonTableObject) o;

        if (table != null ? !table.equals(that.table) : that.table != null) return false;
        if (opType != null ? !opType.equals(that.opType) : that.opType != null) return false;
        if (before != null ? !before.equals(that.before) : that.before != null) return false;
        return after != null ? after.equals(that.after) : that.after == null;
    }

    @Override
    public int hashCode() {
        int result = table != null ? table.hashCode() : 0;
        result = 31 * result + (opType != null ? opType.hashCode() : 0);
        result = 31 * result + (before != null ? before.hashCode() : 0);
        result = 31 * result + (after != null ? after.hashCode() : 0);
        return result;
    }
}
