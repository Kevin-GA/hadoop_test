package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName YDJT_YDTZ_BUSINESS_DATA
 */
@TableName(value ="YDJT_YDTZ_BUSINESS_DATA")
public class YdjtYdtzBusinessData implements Serializable {
    /**
     * 
     */
    private String businessDataId;

    /**
     * 渠道标识
     */
    private String channelSource;

    /**
     * 业务记录标识
     */
    private String businessRecordType;

    /**
     * 业务大类
     */
    private String productType;

    /**
     * 业务编码
     */
    private String businessNo;

    /**
     * 业务批次号
     */
    private String businessVersion;

    /**
     * 业务日期
     */
    private String businessDate;

    /**
     * 产品编码
     */
    private String productOperationNo;

    /**
     * 产品名称
     */
    private String productOperationName;

    /**
     * 金融机构编码
     */
    private String financeOrgCodes;

    /**
     * 内外网标识
     */
    private String innerOuterMapiType;

    /**
     * 客户Id
     */
    private String customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 统一社会信用代码
     */
    private String creditNo;

    /**
     * 属地单位编码
     */
    private String companyCode;

    /**
     * 属地单位名称
     */
    private String companyName;

    /**
     * 用户性质
     */
    private String customerType;

    /**
     * 用户范围
     */
    private String customerScope;

    /**
     * 业务规模（元）（持续规模）
     */
    private BigDecimal businessScale;

    /**
     * 业务收入（元）（累计佣金收入）
     */
    private BigDecimal businessIncome;

    /**
     * 利率(%)
     */
    private String rate;

    /**
     * 业务办理状态
     */
    private String businessState;

    /**
     * 还款日期
     */
    private String repaymentTime;

    /**
     * 是否逾期
     */
    private String repaymentState;

    /**
     * 客群所属区域编码
     */
    private String addressCode;

    /**
     * 客群所属区域名称
     */
    private String addressName;

    /**
     * 客户信用评级
     */
    private String creditLevel;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 
     */
    private String bussType;

    /**
     * 
     */
    private String enterpriseType;

    /**
     * 
     */
    private String signData;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getBusinessDataId() {
        return businessDataId;
    }

    /**
     * 
     */
    public void setBusinessDataId(String businessDataId) {
        this.businessDataId = businessDataId;
    }

    /**
     * 渠道标识
     */
    public String getChannelSource() {
        return channelSource;
    }

    /**
     * 渠道标识
     */
    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    /**
     * 业务记录标识
     */
    public String getBusinessRecordType() {
        return businessRecordType;
    }

    /**
     * 业务记录标识
     */
    public void setBusinessRecordType(String businessRecordType) {
        this.businessRecordType = businessRecordType;
    }

    /**
     * 业务大类
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 业务大类
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 业务编码
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * 业务编码
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    /**
     * 业务批次号
     */
    public String getBusinessVersion() {
        return businessVersion;
    }

    /**
     * 业务批次号
     */
    public void setBusinessVersion(String businessVersion) {
        this.businessVersion = businessVersion;
    }

    /**
     * 业务日期
     */
    public String getBusinessDate() {
        return businessDate;
    }

    /**
     * 业务日期
     */
    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    /**
     * 产品编码
     */
    public String getProductOperationNo() {
        return productOperationNo;
    }

    /**
     * 产品编码
     */
    public void setProductOperationNo(String productOperationNo) {
        this.productOperationNo = productOperationNo;
    }

    /**
     * 产品名称
     */
    public String getProductOperationName() {
        return productOperationName;
    }

    /**
     * 产品名称
     */
    public void setProductOperationName(String productOperationName) {
        this.productOperationName = productOperationName;
    }

    /**
     * 金融机构编码
     */
    public String getFinanceOrgCodes() {
        return financeOrgCodes;
    }

    /**
     * 金融机构编码
     */
    public void setFinanceOrgCodes(String financeOrgCodes) {
        this.financeOrgCodes = financeOrgCodes;
    }

    /**
     * 内外网标识
     */
    public String getInnerOuterMapiType() {
        return innerOuterMapiType;
    }

    /**
     * 内外网标识
     */
    public void setInnerOuterMapiType(String innerOuterMapiType) {
        this.innerOuterMapiType = innerOuterMapiType;
    }

    /**
     * 客户Id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 客户Id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 统一社会信用代码
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * 统一社会信用代码
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    /**
     * 属地单位编码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 属地单位编码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 属地单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 属地单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 用户性质
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * 用户性质
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * 用户范围
     */
    public String getCustomerScope() {
        return customerScope;
    }

    /**
     * 用户范围
     */
    public void setCustomerScope(String customerScope) {
        this.customerScope = customerScope;
    }

    /**
     * 业务规模（元）（持续规模）
     */
    public BigDecimal getBusinessScale() {
        return businessScale;
    }

    /**
     * 业务规模（元）（持续规模）
     */
    public void setBusinessScale(BigDecimal businessScale) {
        this.businessScale = businessScale;
    }

    /**
     * 业务收入（元）（累计佣金收入）
     */
    public BigDecimal getBusinessIncome() {
        return businessIncome;
    }

    /**
     * 业务收入（元）（累计佣金收入）
     */
    public void setBusinessIncome(BigDecimal businessIncome) {
        this.businessIncome = businessIncome;
    }

    /**
     * 利率(%)
     */
    public String getRate() {
        return rate;
    }

    /**
     * 利率(%)
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * 业务办理状态
     */
    public String getBusinessState() {
        return businessState;
    }

    /**
     * 业务办理状态
     */
    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    /**
     * 还款日期
     */
    public String getRepaymentTime() {
        return repaymentTime;
    }

    /**
     * 还款日期
     */
    public void setRepaymentTime(String repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    /**
     * 是否逾期
     */
    public String getRepaymentState() {
        return repaymentState;
    }

    /**
     * 是否逾期
     */
    public void setRepaymentState(String repaymentState) {
        this.repaymentState = repaymentState;
    }

    /**
     * 客群所属区域编码
     */
    public String getAddressCode() {
        return addressCode;
    }

    /**
     * 客群所属区域编码
     */
    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    /**
     * 客群所属区域名称
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 客群所属区域名称
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * 客户信用评级
     */
    public String getCreditLevel() {
        return creditLevel;
    }

    /**
     * 客户信用评级
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    /**
     * 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * 
     */
    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    /**
     * 
     */
    public String getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * 
     */
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
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
        YdjtYdtzBusinessData other = (YdjtYdtzBusinessData) that;
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
            && (this.getAddressCode() == null ? other.getAddressCode() == null : this.getAddressCode().equals(other.getAddressCode()))
            && (this.getAddressName() == null ? other.getAddressName() == null : this.getAddressName().equals(other.getAddressName()))
            && (this.getCreditLevel() == null ? other.getCreditLevel() == null : this.getCreditLevel().equals(other.getCreditLevel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getEnterpriseType() == null ? other.getEnterpriseType() == null : this.getEnterpriseType().equals(other.getEnterpriseType()))
            && (this.getSignData() == null ? other.getSignData() == null : this.getSignData().equals(other.getSignData()));
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
        result = prime * result + ((getAddressCode() == null) ? 0 : getAddressCode().hashCode());
        result = prime * result + ((getAddressName() == null) ? 0 : getAddressName().hashCode());
        result = prime * result + ((getCreditLevel() == null) ? 0 : getCreditLevel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getEnterpriseType() == null) ? 0 : getEnterpriseType().hashCode());
        result = prime * result + ((getSignData() == null) ? 0 : getSignData().hashCode());
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
        sb.append(", addressCode=").append(addressCode);
        sb.append(", addressName=").append(addressName);
        sb.append(", creditLevel=").append(creditLevel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", bussType=").append(bussType);
        sb.append(", enterpriseType=").append(enterpriseType);
        sb.append(", signData=").append(signData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}