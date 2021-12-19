package com.ydjt.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * <p>
 *  电财表
 * </p>
 *
 * @author niujiaxin
 * @since 2021-07-28
 */

@TableName("YDJT_ZGDC_BUSINESS_DATAENT")
public class YdjtZgdcBusinessDataent{

    private static final long serialVersionUID = 1L;

    @TableId(value = "BUSINESS_ID", type = IdType.UUID)
    private String businessId;
    @TableField("INTERFACE_CODE")
    private String interfaceCode;
    @TableField("CHANNEL_SOURCE")
    private String channelSource;
    @TableField("BUSINESS_RECORD_TYPE")
    private String businessRecordType;
    @TableField("PRODUCT_TYPE")
    private String productType;
    @TableField("BUSINESS_NO")
    private String businessNo;
    @TableField("BUSINESS_VERSION")
    private String businessVersion;
    @TableField("BUSINESS_DATE")
    private String businessDate;
    @TableField("PRODUCT_OPERATION_NO")
    private String productOperationNo;
    @TableField("PRODUCT_OPERATION_NAME")
    private String productOperationName;
    @TableField("FINANCE_ORG_CODES")
    private String financeOrgCodes;
    @TableField("INNER_OUTER_MAPI_TYPE")
    private String innerOuterMapiType;
    @TableField("CUSTOMER_CODE")
    private String customerCode;
    @TableField("CUSTOMER_NAME")
    private String customerName;
    @TableField("CREDIT_NO")
    private String creditNo;
    @TableField("COMPANY_CODE")
    private String companyCode;
    @TableField("COMPANY_NAME")
    private String companyName;
    @TableField("CUSTOMER_TYPE")
    private String customerType;
    @TableField("CUSTOMER_SCOPE")
    private String customerScope;
    @TableField("BUSINESS_SCALE")
    private Long businessScale;
    @TableField("BUSINESS_INCOME")
    private Long businessIncome;
    @TableField("RATE")
    private Double rate;
    @TableField("BUSINESS_STATE")
    private String businessState;
    @TableField("REPAYMENT_TIME")
    private String repaymentTime;
    @TableField("REPAYMENT_STATE")
    private String repaymentState;
    @TableField("ADDRESS_CODE")
    private String addressCode;
    @TableField("ADDRESS_NAME")
    private String addressName;
    @TableField("CREDIT_LEVER")
    private String creditLever;
    @TableField("ORD_NAME")
    private String ordName;
    @TableField("DRAWER_NAME")
    private String drawerName;
    @TableField("PAYEE_NAME")
    private String payeeName;
    @TableField("CREATE_TIME")
    private String createTime;
    @TableField("UPDATE_TIME")
    private String updateTime;
    @TableField("ENTERPRISE_TYPE")
    private String enterpriseType;
    @TableField("VALIDATE_COMPLETE")
    private String validateComplete;
    @TableField("ORG_NO")
    private String orgNo;
    @TableField("ORG_NAME")
    private String orgName;
    @TableField("ORG_ADDRESS")
    private String orgAddress;
    @TableField("CONDITION")
    private String condition;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public Long getBusinessScale() {
        return businessScale;
    }

    public void setBusinessScale(Long businessScale) {
        this.businessScale = businessScale;
    }

    public Long getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Long businessIncome) {
        this.businessIncome = businessIncome;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCreditLever() {
        return creditLever;
    }

    public void setCreditLever(String creditLever) {
        this.creditLever = creditLever;
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName;
    }

    public String getDrawerName() {
        return drawerName;
    }

    public void setDrawerName(String drawerName) {
        this.drawerName = drawerName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
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

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getValidateComplete() {
        return validateComplete;
    }

    public void setValidateComplete(String validateComplete) {
        this.validateComplete = validateComplete;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "YdjtZgdcBusinessDataent{" +
                "businessId='" + businessId + '\'' +
                ", interfaceCode='" + interfaceCode + '\'' +
                ", channelSource='" + channelSource + '\'' +
                ", businessRecordType='" + businessRecordType + '\'' +
                ", productType='" + productType + '\'' +
                ", businessNo='" + businessNo + '\'' +
                ", businessVersion='" + businessVersion + '\'' +
                ", businessDate='" + businessDate + '\'' +
                ", productOperationNo='" + productOperationNo + '\'' +
                ", productOperationName='" + productOperationName + '\'' +
                ", financeOrgCodes='" + financeOrgCodes + '\'' +
                ", innerOuterMapiType='" + innerOuterMapiType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", creditNo='" + creditNo + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerScope='" + customerScope + '\'' +
                ", businessScale=" + businessScale +
                ", businessIncome=" + businessIncome +
                ", rate=" + rate +
                ", businessState='" + businessState + '\'' +
                ", repaymentTime='" + repaymentTime + '\'' +
                ", repaymentState='" + repaymentState + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", addressName='" + addressName + '\'' +
                ", creditLever='" + creditLever + '\'' +
                ", ordName='" + ordName + '\'' +
                ", drawerName='" + drawerName + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", validateComplete='" + validateComplete + '\'' +
                ", orgNo='" + orgNo + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgAddress='" + orgAddress + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
