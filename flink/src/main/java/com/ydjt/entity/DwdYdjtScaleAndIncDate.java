package com.ydjt.entity;

public class DwdYdjtScaleAndIncDate {
    private String businessDataId;
    private String businessDate;
    private String businessIncome;
    private String businessScale;
    private String channelSource;

    public DwdYdjtScaleAndIncDate(String businessDataId, String businessDate, String businessIncome, String businessScale, String channelSource) {
        this.businessDataId = businessDataId;
        this.businessDate = businessDate;
        this.businessIncome = businessIncome;
        this.businessScale = businessScale;
        this.channelSource = channelSource;
    }

    public String getBusinessDataId() {
        return businessDataId;
    }

    public void setBusinessDataId(String businessDataId) {
        this.businessDataId = businessDataId;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(String businessIncome) {
        this.businessIncome = businessIncome;
    }

    public String getBusinessScale() {
        return businessScale;
    }

    public void setBusinessScale(String businessScale) {
        this.businessScale = businessScale;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    @Override
    public String toString() {
        return "DwdYdjtScaleAndIncDate{" +
                "businessDataId='" + businessDataId + '\'' +
                ", businessDate='" + businessDate + '\'' +
                ", businessIncome='" + businessIncome + '\'' +
                ", businessScale='" + businessScale + '\'' +
                ", channelSource='" + channelSource + '\'' +
                '}';
    }
}
