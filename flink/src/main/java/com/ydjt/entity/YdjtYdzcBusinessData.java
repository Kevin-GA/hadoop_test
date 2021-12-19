package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName YDJT_YDZC_BUSINESS_DATA
 */
@TableName(value ="YDJT_YDZC_BUSINESS_DATA")
public class YdjtYdzcBusinessData implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String channelSource;

    /**
     * 
     */
    private String businessRecordType;

    /**
     * 
     */
    private String productType;

    /**
     * 
     */
    private String businessNo;

    /**
     * 
     */
    private String businessVersion;

    /**
     * 
     */
    private String businessDate;

    /**
     * 
     */
    private String businessCurmngEndDate;

    /**
     * 
     */
    private String productOperationNo;

    /**
     * 
     */
    private String productOperationName;

    /**
     * 
     */
    private String financeOrgCodes;

    /**
     * 
     */
    private String innerOuterMapiType;

    /**
     * 
     */
    private String customerId;

    /**
     * 
     */
    private String customerName;

    /**
     * 
     */
    private String creditNo;

    /**
     * 
     */
    private String companyCode;

    /**
     * 
     */
    private String companyName;

    /**
     * 
     */
    private String customerType;

    /**
     * 
     */
    private String customerScope;

    /**
     * 
     */
    private String enterprisetype;

    /**
     * 
     */
    private Long businessScale;

    /**
     * 
     */
    private String businessIncome;

    /**
     * 
     */
    private String rate;

    /**
     * 
     */
    private String businessState;

    /**
     * 
     */
    private String addresscode;

    /**
     * 
     */
    private String addressname;

    /**
     * 
     */
    private String creditlevel;

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
     * 
     */
    public String getChannelSource() {
        return channelSource;
    }

    /**
     * 
     */
    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    /**
     * 
     */
    public String getBusinessRecordType() {
        return businessRecordType;
    }

    /**
     * 
     */
    public void setBusinessRecordType(String businessRecordType) {
        this.businessRecordType = businessRecordType;
    }

    /**
     * 
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * 
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    /**
     * 
     */
    public String getBusinessVersion() {
        return businessVersion;
    }

    /**
     * 
     */
    public void setBusinessVersion(String businessVersion) {
        this.businessVersion = businessVersion;
    }

    /**
     * 
     */
    public String getBusinessDate() {
        return businessDate;
    }

    /**
     * 
     */
    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    /**
     * 
     */
    public String getBusinessCurmngEndDate() {
        return businessCurmngEndDate;
    }

    /**
     * 
     */
    public void setBusinessCurmngEndDate(String businessCurmngEndDate) {
        this.businessCurmngEndDate = businessCurmngEndDate;
    }

    /**
     * 
     */
    public String getProductOperationNo() {
        return productOperationNo;
    }

    /**
     * 
     */
    public void setProductOperationNo(String productOperationNo) {
        this.productOperationNo = productOperationNo;
    }

    /**
     * 
     */
    public String getProductOperationName() {
        return productOperationName;
    }

    /**
     * 
     */
    public void setProductOperationName(String productOperationName) {
        this.productOperationName = productOperationName;
    }

    /**
     * 
     */
    public String getFinanceOrgCodes() {
        return financeOrgCodes;
    }

    /**
     * 
     */
    public void setFinanceOrgCodes(String financeOrgCodes) {
        this.financeOrgCodes = financeOrgCodes;
    }

    /**
     * 
     */
    public String getInnerOuterMapiType() {
        return innerOuterMapiType;
    }

    /**
     * 
     */
    public void setInnerOuterMapiType(String innerOuterMapiType) {
        this.innerOuterMapiType = innerOuterMapiType;
    }

    /**
     * 
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * 
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    /**
     * 
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * 
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * 
     */
    public String getCustomerScope() {
        return customerScope;
    }

    /**
     * 
     */
    public void setCustomerScope(String customerScope) {
        this.customerScope = customerScope;
    }

    /**
     * 
     */
    public String getEnterprisetype() {
        return enterprisetype;
    }

    /**
     * 
     */
    public void setEnterprisetype(String enterprisetype) {
        this.enterprisetype = enterprisetype;
    }

    /**
     * 
     */
    public Long getBusinessScale() {
        return businessScale;
    }

    /**
     * 
     */
    public void setBusinessScale(Long businessScale) {
        this.businessScale = businessScale;
    }

    /**
     * 
     */
    public String getBusinessIncome() {
        return businessIncome;
    }

    /**
     * 
     */
    public void setBusinessIncome(String businessIncome) {
        this.businessIncome = businessIncome;
    }

    /**
     * 
     */
    public String getRate() {
        return rate;
    }

    /**
     * 
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * 
     */
    public String getBusinessState() {
        return businessState;
    }

    /**
     * 
     */
    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    /**
     * 
     */
    public String getAddresscode() {
        return addresscode;
    }

    /**
     * 
     */
    public void setAddresscode(String addresscode) {
        this.addresscode = addresscode;
    }

    /**
     * 
     */
    public String getAddressname() {
        return addressname;
    }

    /**
     * 
     */
    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    /**
     * 
     */
    public String getCreditlevel() {
        return creditlevel;
    }

    /**
     * 
     */
    public void setCreditlevel(String creditlevel) {
        this.creditlevel = creditlevel;
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
        YdjtYdzcBusinessData other = (YdjtYdzcBusinessData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelSource() == null ? other.getChannelSource() == null : this.getChannelSource().equals(other.getChannelSource()))
            && (this.getBusinessRecordType() == null ? other.getBusinessRecordType() == null : this.getBusinessRecordType().equals(other.getBusinessRecordType()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getBusinessNo() == null ? other.getBusinessNo() == null : this.getBusinessNo().equals(other.getBusinessNo()))
            && (this.getBusinessVersion() == null ? other.getBusinessVersion() == null : this.getBusinessVersion().equals(other.getBusinessVersion()))
            && (this.getBusinessDate() == null ? other.getBusinessDate() == null : this.getBusinessDate().equals(other.getBusinessDate()))
            && (this.getBusinessCurmngEndDate() == null ? other.getBusinessCurmngEndDate() == null : this.getBusinessCurmngEndDate().equals(other.getBusinessCurmngEndDate()))
            && (this.getProductOperationNo() == null ? other.getProductOperationNo() == null : this.getProductOperationNo().equals(other.getProductOperationNo()))
            && (this.getProductOperationName() == null ? other.getProductOperationName() == null : this.getProductOperationName().equals(other.getProductOperationName()))
            && (this.getFinanceOrgCodes() == null ? other.getFinanceOrgCodes() == null : this.getFinanceOrgCodes().equals(other.getFinanceOrgCodes()))
            && (this.getInnerOuterMapiType() == null ? other.getInnerOuterMapiType() == null : this.getInnerOuterMapiType().equals(other.getInnerOuterMapiType()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCustomerType() == null ? other.getCustomerType() == null : this.getCustomerType().equals(other.getCustomerType()))
            && (this.getCustomerScope() == null ? other.getCustomerScope() == null : this.getCustomerScope().equals(other.getCustomerScope()))
            && (this.getEnterprisetype() == null ? other.getEnterprisetype() == null : this.getEnterprisetype().equals(other.getEnterprisetype()))
            && (this.getBusinessScale() == null ? other.getBusinessScale() == null : this.getBusinessScale().equals(other.getBusinessScale()))
            && (this.getBusinessIncome() == null ? other.getBusinessIncome() == null : this.getBusinessIncome().equals(other.getBusinessIncome()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getBusinessState() == null ? other.getBusinessState() == null : this.getBusinessState().equals(other.getBusinessState()))
            && (this.getAddresscode() == null ? other.getAddresscode() == null : this.getAddresscode().equals(other.getAddresscode()))
            && (this.getAddressname() == null ? other.getAddressname() == null : this.getAddressname().equals(other.getAddressname()))
            && (this.getCreditlevel() == null ? other.getCreditlevel() == null : this.getCreditlevel().equals(other.getCreditlevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelSource() == null) ? 0 : getChannelSource().hashCode());
        result = prime * result + ((getBusinessRecordType() == null) ? 0 : getBusinessRecordType().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getBusinessNo() == null) ? 0 : getBusinessNo().hashCode());
        result = prime * result + ((getBusinessVersion() == null) ? 0 : getBusinessVersion().hashCode());
        result = prime * result + ((getBusinessDate() == null) ? 0 : getBusinessDate().hashCode());
        result = prime * result + ((getBusinessCurmngEndDate() == null) ? 0 : getBusinessCurmngEndDate().hashCode());
        result = prime * result + ((getProductOperationNo() == null) ? 0 : getProductOperationNo().hashCode());
        result = prime * result + ((getProductOperationName() == null) ? 0 : getProductOperationName().hashCode());
        result = prime * result + ((getFinanceOrgCodes() == null) ? 0 : getFinanceOrgCodes().hashCode());
        result = prime * result + ((getInnerOuterMapiType() == null) ? 0 : getInnerOuterMapiType().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCustomerType() == null) ? 0 : getCustomerType().hashCode());
        result = prime * result + ((getCustomerScope() == null) ? 0 : getCustomerScope().hashCode());
        result = prime * result + ((getEnterprisetype() == null) ? 0 : getEnterprisetype().hashCode());
        result = prime * result + ((getBusinessScale() == null) ? 0 : getBusinessScale().hashCode());
        result = prime * result + ((getBusinessIncome() == null) ? 0 : getBusinessIncome().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getBusinessState() == null) ? 0 : getBusinessState().hashCode());
        result = prime * result + ((getAddresscode() == null) ? 0 : getAddresscode().hashCode());
        result = prime * result + ((getAddressname() == null) ? 0 : getAddressname().hashCode());
        result = prime * result + ((getCreditlevel() == null) ? 0 : getCreditlevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelSource=").append(channelSource);
        sb.append(", businessRecordType=").append(businessRecordType);
        sb.append(", productType=").append(productType);
        sb.append(", businessNo=").append(businessNo);
        sb.append(", businessVersion=").append(businessVersion);
        sb.append(", businessDate=").append(businessDate);
        sb.append(", businessCurmngEndDate=").append(businessCurmngEndDate);
        sb.append(", productOperationNo=").append(productOperationNo);
        sb.append(", productOperationName=").append(productOperationName);
        sb.append(", financeOrgCodes=").append(financeOrgCodes);
        sb.append(", innerOuterMapiType=").append(innerOuterMapiType);
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", companyName=").append(companyName);
        sb.append(", customerType=").append(customerType);
        sb.append(", customerScope=").append(customerScope);
        sb.append(", enterprisetype=").append(enterprisetype);
        sb.append(", businessScale=").append(businessScale);
        sb.append(", businessIncome=").append(businessIncome);
        sb.append(", rate=").append(rate);
        sb.append(", businessState=").append(businessState);
        sb.append(", addresscode=").append(addresscode);
        sb.append(", addressname=").append(addressname);
        sb.append(", creditlevel=").append(creditlevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}