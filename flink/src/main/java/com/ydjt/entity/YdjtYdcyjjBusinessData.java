package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName YDJT_YDCYJJ_BUSINESS_DATA
 */
@TableName(value ="YDJT_YDCYJJ_BUSINESS_DATA")
public class YdjtYdcyjjBusinessData implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 基金成立日期
     */
    private String fundCreateDate;

    /**
     * 
     */
    private String fundCurmngEndDate;

    /**
     * 基金业务规模
     */
    private Long fundScale;

    /**
     * 
     */
    private String createTime;

    /**
     * 
     */
    private String updateTime;

    /**
     * 
     */
    private String signData;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 基金名称
     */
    public String getFundName() {
        return fundName;
    }

    /**
     * 基金名称
     */
    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    /**
     * 基金成立日期
     */
    public String getFundCreateDate() {
        return fundCreateDate;
    }

    /**
     * 基金成立日期
     */
    public void setFundCreateDate(String fundCreateDate) {
        this.fundCreateDate = fundCreateDate;
    }

    /**
     * 
     */
    public String getFundCurmngEndDate() {
        return fundCurmngEndDate;
    }

    /**
     * 
     */
    public void setFundCurmngEndDate(String fundCurmngEndDate) {
        this.fundCurmngEndDate = fundCurmngEndDate;
    }

    /**
     * 基金业务规模
     */
    public Long getFundScale() {
        return fundScale;
    }

    /**
     * 基金业务规模
     */
    public void setFundScale(Long fundScale) {
        this.fundScale = fundScale;
    }

    /**
     * 
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     */
    public String getSignData() {
        return signData;
    }

    /**
     * 
     */
    public void setSignData(String signData) {
        this.signData = signData;
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
        YdjtYdcyjjBusinessData other = (YdjtYdcyjjBusinessData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFundName() == null ? other.getFundName() == null : this.getFundName().equals(other.getFundName()))
            && (this.getFundCreateDate() == null ? other.getFundCreateDate() == null : this.getFundCreateDate().equals(other.getFundCreateDate()))
            && (this.getFundCurmngEndDate() == null ? other.getFundCurmngEndDate() == null : this.getFundCurmngEndDate().equals(other.getFundCurmngEndDate()))
            && (this.getFundScale() == null ? other.getFundScale() == null : this.getFundScale().equals(other.getFundScale()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSignData() == null ? other.getSignData() == null : this.getSignData().equals(other.getSignData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFundName() == null) ? 0 : getFundName().hashCode());
        result = prime * result + ((getFundCreateDate() == null) ? 0 : getFundCreateDate().hashCode());
        result = prime * result + ((getFundCurmngEndDate() == null) ? 0 : getFundCurmngEndDate().hashCode());
        result = prime * result + ((getFundScale() == null) ? 0 : getFundScale().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSignData() == null) ? 0 : getSignData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fundName=").append(fundName);
        sb.append(", fundCreateDate=").append(fundCreateDate);
        sb.append(", fundCurmngEndDate=").append(fundCurmngEndDate);
        sb.append(", fundScale=").append(fundScale);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", signData=").append(signData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}