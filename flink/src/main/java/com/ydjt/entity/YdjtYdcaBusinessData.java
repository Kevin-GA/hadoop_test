package com.ydjt.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 长安
 * </p>
 *
 * @author niujiaxin
 * @since 2021-07-28
 */

@TableName("YDJT_YDCA_BUSINESS_DATA")
public class YdjtYdcaBusinessData implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "BUSINESS_DATA_ID", type = IdType.UUID)
    private String businessDataId;
    /**
     * 渠道标识  YDCA:英大长安
     */
    @TableField("CHANNEL_SOURCE")
    private String channelSource;
    /**
     * 业务记录标识 01：代收保费 02：佣金收入 03：退保
     */
    @TableField("BUSINESS_RECORD_TYPE")
    private String businessRecordType;
    /**
     * 业务大类 01 融资 02：理财 03：保险 04：其他
     */
    @TableField("PRODUCT_TYPE")
    private String productType;
    /**
     * 保单合同号
     */
    @TableField("BUSINESS_NO")
    private String businessNo;
    /**
     * 对于同一份保单，当发生合同内容变更时，需要传不同的批次号
     */
    @TableField("BUSINESS_VERSION")
    private String businessVersion;
    /**
     * 业务日期 ： 根据业务记录标识 传对应的业务日期 
     */
    @TableField("BUSINESS_DATE")
    private String businessDate;
    /**
     * 产品编码 按照集团提供的产品码值表推送，新增产品需提供唯一标识
     */
    @TableField("PRODUCT_OPERATION_NO")
    private String productOperationNo;
    /**
     * 产品编码 产品名称（与产品上下架接口中的产品名称一致）
     */
    @TableField("PRODUCT_OPERATION_NAME")
    private String productOperationName;
    /**
     * 金融机构编码 固定值 JRJG1583911709323
     */
    @TableField("FINANCE_ORG_CODES")
    private String financeOrgCodes;
    /**
     * 内外网标识 
     */
    @TableField("INNER_OUTER_MAPI_TYPE")
    private String innerOuterMapiType;
    /**
     * 客户Id   传国网统一账户用户ID，没有就传本系统的
     */
    @TableField("CUSTOMER_ID")
    private String customerId;
    /**
     * 客户名称
     */
    @TableField("CUSTOMER_NAME")
    private String customerName;
    /**
     * 统一社会信用代码 个人传身份证号码
     */
    @TableField("CREDIT_NO")
    private String creditNo;
    /**
     * 属地单位编码  
     */
    @TableField("COMPANY_CODE")
    private String companyCode;
    /**
     * 属地单位名称 
     */
    @TableField("COMPANY_NAME")
    private String companyName;
    /**
     * 用户性质  1：个人用户 2：企业用户
     */
    @TableField("CUSTOMER_TYPE")
    private String customerType;
    /**
     * 用户范围  1：系统内   2:系统外
     */
    @TableField("CUSTOMER_SCOPE")
    private String customerScope;
    /**
     * 业务规模（分） 可为负数，小数点最多3位，也可为0
     */
    @TableField("BUSINESS_SCALE")
    private Double businessScale;
    /**
     * 业务收入（分） 可为负数，小数点最多3位，也可为0
     */
    @TableField("BUSINESS_INCOME")
    private Double businessIncome;
    /**
     * 利率(%) 
     */
    @TableField("RATE")
    private String rate;
    /**
     * 客户所属区域编码 参见区域表
     */
    @TableField("ADDRESS_CODE")
    private String addressCode;
    /**
     * 客户所属区域名称 参见区域表
     */
    @TableField("ADDRESS_NAME")
    private String addressName;
    /**
     * 客户信用级别
     */
    @TableField("CREDIT_LEVEL")
    private String creditLevel;
    /**
     * 保费(分）
     */
    @TableField("INSURED_AMOUNT")
    private Double insuredAmount;
    /**
     * 被保险人,可为多个
     */
    @TableField("INSURANT_PERSON")
    private String insurantPerson;
    /**
     * 保额（分）
     */
    @TableField("GUARANTEE_AMOUNT")
    private Double guaranteeAmount;
    /**
     * 投保期限
     */
    @TableField("INSURED_PERIOD")
    private String insuredPeriod;
    /**
     * 费率
     */
    @TableField("INSURED_RATE")
    private String insuredRate;
    /**
     * 保费收入（分）
     */
    @TableField("INSURED_INCOME")
    private Double insuredIncome;
    /**
     * 佣金收入（分）
     */
    @TableField("COMMISSION")
    private Double commission;
    /**
     *  格式：yyyy-MM-dd 
     */
    @TableField("UPDATE_TIME")
    private String updateTime;
    /**
     * 企业类型   1、大型企业
2、中型企业
3、小型企业
4、微型企业
企业用户必填
     */
    @TableField("ENTERPRISE_TYPE")
    private String enterpriseType;
    /**
     *  格式：yyyy-MM-dd
     */
    @TableField("CREATE_TIME")
    private String createTime;
    @TableField("SIGN_STR")
    private String signStr;
    /**
     * 大区名称  参见大区表
     */
    @TableField("REGION_NAME")
    private String regionName;
    /**
     * 保单开始生效日期yyyy-mm-dd
     */
    @TableField("INSURED_PERIOD_START")
    private String insuredPeriodStart;
    /**
     * 保单结束日期 yyyy-mm-dd
     */
    @TableField("INSURED_PERIOD_END")
    private String insuredPeriodEnd;
    /**
     * 保单批改日期yyyy-mm-dd
     */
    @TableField("INSURANCE_CORRECTING_DATE")
    private String insuranceCorrectingDate;
    /**
     * 保险类型 1：统括险种 2、保证金 3、互联网 4、线下产品
     */
    @TableField("INSURANCE_TYPE")
    private String insuranceType;
    @TableField("CALIBER_TYPE")
    private String caliberType;
    /**
     * 保险人
     */
    @TableField("INSURANCE_PERSON")
    private String insurancePerson;
    @TableField("BID_OPEN_FLAG")
    private String bidOpenFlag;
    /**
     * 保单建立部门
     */
    @TableField("BUSINESS_COMPANY")
    private String businessCompany;
    /**
     * 一级产品名称
     */
    @TableField("PRODUCT_NAME_TOP")
    private String productNameTop;
    @TableField("PRODUCT_NAME_SEC")
    private String productNameSec;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Double getBusinessScale() {
        return businessScale;
    }

    public void setBusinessScale(Double businessScale) {
        this.businessScale = businessScale;
    }

    public Double getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Double businessIncome) {
        this.businessIncome = businessIncome;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Double getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(Double insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public String getInsurantPerson() {
        return insurantPerson;
    }

    public void setInsurantPerson(String insurantPerson) {
        this.insurantPerson = insurantPerson;
    }

    public Double getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(Double guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public String getInsuredPeriod() {
        return insuredPeriod;
    }

    public void setInsuredPeriod(String insuredPeriod) {
        this.insuredPeriod = insuredPeriod;
    }

    public String getInsuredRate() {
        return insuredRate;
    }

    public void setInsuredRate(String insuredRate) {
        this.insuredRate = insuredRate;
    }

    public Double getInsuredIncome() {
        return insuredIncome;
    }

    public void setInsuredIncome(Double insuredIncome) {
        this.insuredIncome = insuredIncome;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSignStr() {
        return signStr;
    }

    public void setSignStr(String signStr) {
        this.signStr = signStr;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getInsuredPeriodStart() {
        return insuredPeriodStart;
    }

    public void setInsuredPeriodStart(String insuredPeriodStart) {
        this.insuredPeriodStart = insuredPeriodStart;
    }

    public String getInsuredPeriodEnd() {
        return insuredPeriodEnd;
    }

    public void setInsuredPeriodEnd(String insuredPeriodEnd) {
        this.insuredPeriodEnd = insuredPeriodEnd;
    }

    public String getInsuranceCorrectingDate() {
        return insuranceCorrectingDate;
    }

    public void setInsuranceCorrectingDate(String insuranceCorrectingDate) {
        this.insuranceCorrectingDate = insuranceCorrectingDate;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getCaliberType() {
        return caliberType;
    }

    public void setCaliberType(String caliberType) {
        this.caliberType = caliberType;
    }

    public String getInsurancePerson() {
        return insurancePerson;
    }

    public void setInsurancePerson(String insurancePerson) {
        this.insurancePerson = insurancePerson;
    }

    public String getBidOpenFlag() {
        return bidOpenFlag;
    }

    public void setBidOpenFlag(String bidOpenFlag) {
        this.bidOpenFlag = bidOpenFlag;
    }

    public String getBusinessCompany() {
        return businessCompany;
    }

    public void setBusinessCompany(String businessCompany) {
        this.businessCompany = businessCompany;
    }

    public String getProductNameTop() {
        return productNameTop;
    }

    public void setProductNameTop(String productNameTop) {
        this.productNameTop = productNameTop;
    }

    public String getProductNameSec() {
        return productNameSec;
    }

    public void setProductNameSec(String productNameSec) {
        this.productNameSec = productNameSec;
    }

    @Override
    public String toString() {
        return "YdjtYdcaBusinessData{" +
                "businessDataId='" + businessDataId + '\'' +
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
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", creditNo='" + creditNo + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerScope='" + customerScope + '\'' +
                ", businessScale=" + businessScale +
                ", businessIncome=" + businessIncome +
                ", rate='" + rate + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", addressName='" + addressName + '\'' +
                ", creditLevel='" + creditLevel + '\'' +
                ", insuredAmount=" + insuredAmount +
                ", insurantPerson='" + insurantPerson + '\'' +
                ", guaranteeAmount=" + guaranteeAmount +
                ", insuredPeriod='" + insuredPeriod + '\'' +
                ", insuredRate='" + insuredRate + '\'' +
                ", insuredIncome=" + insuredIncome +
                ", commission=" + commission +
                ", updateTime='" + updateTime + '\'' +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", signStr='" + signStr + '\'' +
                ", regionName='" + regionName + '\'' +
                ", insuredPeriodStart='" + insuredPeriodStart + '\'' +
                ", insuredPeriodEnd='" + insuredPeriodEnd + '\'' +
                ", insuranceCorrectingDate='" + insuranceCorrectingDate + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", caliberType='" + caliberType + '\'' +
                ", insurancePerson='" + insurancePerson + '\'' +
                ", bidOpenFlag='" + bidOpenFlag + '\'' +
                ", businessCompany='" + businessCompany + '\'' +
                ", productNameTop='" + productNameTop + '\'' +
                ", productNameSec='" + productNameSec + '\'' +
                '}';
    }
}
