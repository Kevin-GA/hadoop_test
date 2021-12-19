package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName T_TR_REPORTITEMDATA2020
 */
@TableName(value ="T_TR_REPORTITEMDATA2020")
public class TTrReportitemdata2020 implements Serializable {
    /**
     * 填报单位编号
     */
    private Integer fdepartid;

    /**
     * 填报单位名称
     */
    private String fname;

    /**
     * 基础组织编号
     */
    private String fcompid;

    /**
     * 报表编号
     */
    private Integer frepid;

    /**
     * 报表名称
     */
    private String freptitle;

    /**
     * 报表格式编号
     */
    private Integer frepformatid;

    /**
     * 年份
     */
    private Integer fyear;

    /**
     * 月份
     */
    private Integer fmonth;

    /**
     * 日
     */
    private Integer fday;

    /**
     * 单元格编号
     */
    private String fcellid;

    /**
     * 行号
     */
    private Long frow;

    /**
     * 行名称
     */
    private String fitemvalue;

    /**
     * 列编号
     */
    private Long fcolid;

    /**
     * 列名称
     */
    private String fcoltitle;

    /**
     * 值
     */
    private String fvalue;

    /**
     * 预算版本
     */
    private String dim;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 填报单位编号
     */
    public Integer getFdepartid() {
        return fdepartid;
    }

    /**
     * 填报单位编号
     */
    public void setFdepartid(Integer fdepartid) {
        this.fdepartid = fdepartid;
    }

    /**
     * 填报单位名称
     */
    public String getFname() {
        return fname;
    }

    /**
     * 填报单位名称
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * 基础组织编号
     */
    public String getFcompid() {
        return fcompid;
    }

    /**
     * 基础组织编号
     */
    public void setFcompid(String fcompid) {
        this.fcompid = fcompid;
    }

    /**
     * 报表编号
     */
    public Integer getFrepid() {
        return frepid;
    }

    /**
     * 报表编号
     */
    public void setFrepid(Integer frepid) {
        this.frepid = frepid;
    }

    /**
     * 报表名称
     */
    public String getFreptitle() {
        return freptitle;
    }

    /**
     * 报表名称
     */
    public void setFreptitle(String freptitle) {
        this.freptitle = freptitle;
    }

    /**
     * 报表格式编号
     */
    public Integer getFrepformatid() {
        return frepformatid;
    }

    /**
     * 报表格式编号
     */
    public void setFrepformatid(Integer frepformatid) {
        this.frepformatid = frepformatid;
    }

    /**
     * 年份
     */
    public Integer getFyear() {
        return fyear;
    }

    /**
     * 年份
     */
    public void setFyear(Integer fyear) {
        this.fyear = fyear;
    }

    /**
     * 月份
     */
    public Integer getFmonth() {
        return fmonth;
    }

    /**
     * 月份
     */
    public void setFmonth(Integer fmonth) {
        this.fmonth = fmonth;
    }

    /**
     * 日
     */
    public Integer getFday() {
        return fday;
    }

    /**
     * 日
     */
    public void setFday(Integer fday) {
        this.fday = fday;
    }

    /**
     * 单元格编号
     */
    public String getFcellid() {
        return fcellid;
    }

    /**
     * 单元格编号
     */
    public void setFcellid(String fcellid) {
        this.fcellid = fcellid;
    }

    /**
     * 行号
     */
    public Long getFrow() {
        return frow;
    }

    /**
     * 行号
     */
    public void setFrow(Long frow) {
        this.frow = frow;
    }

    /**
     * 行名称
     */
    public String getFitemvalue() {
        return fitemvalue;
    }

    /**
     * 行名称
     */
    public void setFitemvalue(String fitemvalue) {
        this.fitemvalue = fitemvalue;
    }

    /**
     * 列编号
     */
    public Long getFcolid() {
        return fcolid;
    }

    /**
     * 列编号
     */
    public void setFcolid(Long fcolid) {
        this.fcolid = fcolid;
    }

    /**
     * 列名称
     */
    public String getFcoltitle() {
        return fcoltitle;
    }

    /**
     * 列名称
     */
    public void setFcoltitle(String fcoltitle) {
        this.fcoltitle = fcoltitle;
    }

    /**
     * 值
     */
    public String getFvalue() {
        return fvalue;
    }

    /**
     * 值
     */
    public void setFvalue(String fvalue) {
        this.fvalue = fvalue;
    }

    /**
     * 预算版本
     */
    public String getDim() {
        return dim;
    }

    /**
     * 预算版本
     */
    public void setDim(String dim) {
        this.dim = dim;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TTrReportitemdata2020 other = (TTrReportitemdata2020) that;
        return (this.getFdepartid() == null ? other.getFdepartid() == null : this.getFdepartid().equals(other.getFdepartid()))
            && (this.getFname() == null ? other.getFname() == null : this.getFname().equals(other.getFname()))
            && (this.getFcompid() == null ? other.getFcompid() == null : this.getFcompid().equals(other.getFcompid()))
            && (this.getFrepid() == null ? other.getFrepid() == null : this.getFrepid().equals(other.getFrepid()))
            && (this.getFreptitle() == null ? other.getFreptitle() == null : this.getFreptitle().equals(other.getFreptitle()))
            && (this.getFrepformatid() == null ? other.getFrepformatid() == null : this.getFrepformatid().equals(other.getFrepformatid()))
            && (this.getFyear() == null ? other.getFyear() == null : this.getFyear().equals(other.getFyear()))
            && (this.getFmonth() == null ? other.getFmonth() == null : this.getFmonth().equals(other.getFmonth()))
            && (this.getFday() == null ? other.getFday() == null : this.getFday().equals(other.getFday()))
            && (this.getFcellid() == null ? other.getFcellid() == null : this.getFcellid().equals(other.getFcellid()))
            && (this.getFrow() == null ? other.getFrow() == null : this.getFrow().equals(other.getFrow()))
            && (this.getFitemvalue() == null ? other.getFitemvalue() == null : this.getFitemvalue().equals(other.getFitemvalue()))
            && (this.getFcolid() == null ? other.getFcolid() == null : this.getFcolid().equals(other.getFcolid()))
            && (this.getFcoltitle() == null ? other.getFcoltitle() == null : this.getFcoltitle().equals(other.getFcoltitle()))
            && (this.getFvalue() == null ? other.getFvalue() == null : this.getFvalue().equals(other.getFvalue()))
            && (this.getDim() == null ? other.getDim() == null : this.getDim().equals(other.getDim()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFdepartid() == null) ? 0 : getFdepartid().hashCode());
        result = prime * result + ((getFname() == null) ? 0 : getFname().hashCode());
        result = prime * result + ((getFcompid() == null) ? 0 : getFcompid().hashCode());
        result = prime * result + ((getFrepid() == null) ? 0 : getFrepid().hashCode());
        result = prime * result + ((getFreptitle() == null) ? 0 : getFreptitle().hashCode());
        result = prime * result + ((getFrepformatid() == null) ? 0 : getFrepformatid().hashCode());
        result = prime * result + ((getFyear() == null) ? 0 : getFyear().hashCode());
        result = prime * result + ((getFmonth() == null) ? 0 : getFmonth().hashCode());
        result = prime * result + ((getFday() == null) ? 0 : getFday().hashCode());
        result = prime * result + ((getFcellid() == null) ? 0 : getFcellid().hashCode());
        result = prime * result + ((getFrow() == null) ? 0 : getFrow().hashCode());
        result = prime * result + ((getFitemvalue() == null) ? 0 : getFitemvalue().hashCode());
        result = prime * result + ((getFcolid() == null) ? 0 : getFcolid().hashCode());
        result = prime * result + ((getFcoltitle() == null) ? 0 : getFcoltitle().hashCode());
        result = prime * result + ((getFvalue() == null) ? 0 : getFvalue().hashCode());
        result = prime * result + ((getDim() == null) ? 0 : getDim().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fdepartid=").append(fdepartid);
        sb.append(", fname=").append(fname);
        sb.append(", fcompid=").append(fcompid);
        sb.append(", frepid=").append(frepid);
        sb.append(", freptitle=").append(freptitle);
        sb.append(", frepformatid=").append(frepformatid);
        sb.append(", fyear=").append(fyear);
        sb.append(", fmonth=").append(fmonth);
        sb.append(", fday=").append(fday);
        sb.append(", fcellid=").append(fcellid);
        sb.append(", frow=").append(frow);
        sb.append(", fitemvalue=").append(fitemvalue);
        sb.append(", fcolid=").append(fcolid);
        sb.append(", fcoltitle=").append(fcoltitle);
        sb.append(", fvalue=").append(fvalue);
        sb.append(", dim=").append(dim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}