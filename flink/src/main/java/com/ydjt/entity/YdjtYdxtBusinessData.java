package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 信托
 * @TableName YDJT_YDXT_BUSINESS_DATA
 */
@TableName(value ="YDJT_YDXT_BUSINESS_DATA")
public class YdjtYdxtBusinessData implements Serializable {
    /**
     * 
     */
    private String businessDataId;

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
    private BigDecimal businessScale;

    /**
     * 
     */
    private BigDecimal businessIncome;

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
    private String repaymentTime;

    /**
     * 
     */
    private String repaymentState;

    /**
     * 
     */
    private String enterpriseType;

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
    private String signStr;

    /**
     * 
     */
    private String addressName;

    /**
     * 
     */
    private String addressCode;

    /**
     * 
     */
    private String projectNo;

    /**
     * 
     */
    private String projectName;

    /**
     * 
     */
    private String userContractNo;

    /**
     * 
     */
    private String commissionContractNo;

    /**
     * 
     */
    private String caliberType;

    /**
     * 
     */
    private String encryptFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public String getBusinessDataId() {
        return businessDataId;
    }

    public void setBusinessDataId(String businessDataId) {
        this.businessDataId = businessDataId;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public String getBusinessRecordType() {
        return businessRecordType;
    }

    public void setBusinessRecordType(String businessRecordType) {
        this.businessRecordType = businessRecordType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessVersion() {
        return businessVersion;
    }

    public void setBusinessVersion(String businessVersion) {
        this.businessVersion = businessVersion;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getProductOperationNo() {
        return productOperationNo;
    }

    public void setProductOperationNo(String productOperationNo) {
        this.productOperationNo = productOperationNo;
    }

    public String getProductOperationName() {
        return productOperationName;
    }

    public void setProductOperationName(String productOperationName) {
        this.productOperationName = productOperationName;
    }

    public String getFinanceOrgCodes() {
        return financeOrgCodes;
    }

    public void setFinanceOrgCodes(String financeOrgCodes) {
        this.financeOrgCodes = financeOrgCodes;
    }

    public String getInnerOuterMapiType() {
        return innerOuterMapiType;
    }

    public void setInnerOuterMapiType(String innerOuterMapiType) {
        this.innerOuterMapiType = innerOuterMapiType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerScope() {
        return customerScope;
    }

    public void setCustomerScope(String customerScope) {
        this.customerScope = customerScope;
    }

    public BigDecimal getBusinessScale() {
        return businessScale;
    }

    public void setBusinessScale(BigDecimal businessScale) {
        this.businessScale = businessScale;
    }

    public BigDecimal getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(BigDecimal businessIncome) {
        this.businessIncome = businessIncome;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBusinessState() {
        return businessState;
    }

    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    public String getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(String repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    public String getRepaymentState() {
        return repaymentState;
    }

    public void setRepaymentState(String repaymentState) {
        this.repaymentState = repaymentState;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSignStr() {
        return signStr;
    }

    public void setSignStr(String signStr) {
        this.signStr = signStr;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserContractNo() {
        return userContractNo;
    }

    public void setUserContractNo(String userContractNo) {
        this.userContractNo = userContractNo;
    }

    public String getCommissionContractNo() {
        return commissionContractNo;
    }

    public void setCommissionContractNo(String commissionContractNo) {
        this.commissionContractNo = commissionContractNo;
    }

    public String getCaliberType() {
        return caliberType;
    }

    public void setCaliberType(String caliberType) {
        this.caliberType = caliberType;
    }

    public String getEncryptFlag() {
        return encryptFlag;
    }

    public void setEncryptFlag(String encryptFlag) {
        this.encryptFlag = encryptFlag;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        YdjtYdxtBusinessData other = (YdjtYdxtBusinessData) that;
        return (this.getBusinessDataId() == null ? other.getBusinessDataId() == null : this.getBusinessDataId().equals(other.getBusinessDataId()))
            && (this.getChannelSource() == null ? other.getChannelSource() == null : this.getChannelSource().equals(other.getChannelSource()))
            && (this.getBusinessRecordType() == null ? other.getBusinessRecordType() == null : this.getBusinessRecordType().equals(other.getBusinessRecordType()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getBusinessNo() == null ? other.getBusinessNo() == null : this.getBusinessNo().equals(other.getBusinessNo()))
            && (this.getBusinessVersion() == null ? other.getBusinessVersion() == null : this.getBusinessVersion().equals(other.getBusinessVersion()))
            && (this.getBusinessDate() == null ? other.getBusinessDate() == null : this.getBusinessDate().equals(other.getBusinessDate()))
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
            && (this.getBusinessScale() == null ? other.getBusinessScale() == null : this.getBusinessScale().equals(other.getBusinessScale()))
            && (this.getBusinessIncome() == null ? other.getBusinessIncome() == null : this.getBusinessIncome().equals(other.getBusinessIncome()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getBusinessState() == null ? other.getBusinessState() == null : this.getBusinessState().equals(other.getBusinessState()))
            && (this.getRepaymentTime() == null ? other.getRepaymentTime() == null : this.getRepaymentTime().equals(other.getRepaymentTime()))
            && (this.getRepaymentState() == null ? other.getRepaymentState() == null : this.getRepaymentState().equals(other.getRepaymentState()))
            && (this.getEnterpriseType() == null ? other.getEnterpriseType() == null : this.getEnterpriseType().equals(other.getEnterpriseType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSignStr() == null ? other.getSignStr() == null : this.getSignStr().equals(other.getSignStr()))
            && (this.getAddressName() == null ? other.getAddressName() == null : this.getAddressName().equals(other.getAddressName()))
            && (this.getAddressCode() == null ? other.getAddressCode() == null : this.getAddressCode().equals(other.getAddressCode()))
            && (this.getProjectNo() == null ? other.getProjectNo() == null : this.getProjectNo().equals(other.getProjectNo()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getUserContractNo() == null ? other.getUserContractNo() == null : this.getUserContractNo().equals(other.getUserContractNo()))
            && (this.getCommissionContractNo() == null ? other.getCommissionContractNo() == null : this.getCommissionContractNo().equals(other.getCommissionContractNo()))
            && (this.getCaliberType() == null ? other.getCaliberType() == null : this.getCaliberType().equals(other.getCaliberType()))
            && (this.getEncryptFlag() == null ? other.getEncryptFlag() == null : this.getEncryptFlag().equals(other.getEncryptFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBusinessDataId() == null) ? 0 : getBusinessDataId().hashCode());
        result = prime * result + ((getChannelSource() == null) ? 0 : getChannelSource().hashCode());
        result = prime * result + ((getBusinessRecordType() == null) ? 0 : getBusinessRecordType().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getBusinessNo() == null) ? 0 : getBusinessNo().hashCode());
        result = prime * result + ((getBusinessVersion() == null) ? 0 : getBusinessVersion().hashCode());
        result = prime * result + ((getBusinessDate() == null) ? 0 : getBusinessDate().hashCode());
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
        result = prime * result + ((getBusinessScale() == null) ? 0 : getBusinessScale().hashCode());
        result = prime * result + ((getBusinessIncome() == null) ? 0 : getBusinessIncome().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getBusinessState() == null) ? 0 : getBusinessState().hashCode());
        result = prime * result + ((getRepaymentTime() == null) ? 0 : getRepaymentTime().hashCode());
        result = prime * result + ((getRepaymentState() == null) ? 0 : getRepaymentState().hashCode());
        result = prime * result + ((getEnterpriseType() == null) ? 0 : getEnterpriseType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSignStr() == null) ? 0 : getSignStr().hashCode());
        result = prime * result + ((getAddressName() == null) ? 0 : getAddressName().hashCode());
        result = prime * result + ((getAddressCode() == null) ? 0 : getAddressCode().hashCode());
        result = prime * result + ((getProjectNo() == null) ? 0 : getProjectNo().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getUserContractNo() == null) ? 0 : getUserContractNo().hashCode());
        result = prime * result + ((getCommissionContractNo() == null) ? 0 : getCommissionContractNo().hashCode());
        result = prime * result + ((getCaliberType() == null) ? 0 : getCaliberType().hashCode());
        result = prime * result + ((getEncryptFlag() == null) ? 0 : getEncryptFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", businessDataId=").append(businessDataId);
        sb.append(", channelSource=").append(channelSource);
        sb.append(", businessRecordType=").append(businessRecordType);
        sb.append(", productType=").append(productType);
        sb.append(", businessNo=").append(businessNo);
        sb.append(", businessVersion=").append(businessVersion);
        sb.append(", businessDate=").append(businessDate);
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
        sb.append(", businessScale=").append(businessScale);
        sb.append(", businessIncome=").append(businessIncome);
        sb.append(", rate=").append(rate);
        sb.append(", businessState=").append(businessState);
        sb.append(", repaymentTime=").append(repaymentTime);
        sb.append(", repaymentState=").append(repaymentState);
        sb.append(", enterpriseType=").append(enterpriseType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", signStr=").append(signStr);
        sb.append(", addressName=").append(addressName);
        sb.append(", addressCode=").append(addressCode);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", projectName=").append(projectName);
        sb.append(", userContractNo=").append(userContractNo);
        sb.append(", commissionContractNo=").append(commissionContractNo);
        sb.append(", caliberType=").append(caliberType);
        sb.append(", encryptFlag=").append(encryptFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}