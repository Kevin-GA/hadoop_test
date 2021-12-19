//package com.ydjt.flink.entity;
//
//import java.math.BigDecimal;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableField;
//import java.io.Serializable;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
///**
// * <p>
// *
// * </p>
// *
// * @author niujiaxin
// * @since 2021-07-28
// */
//@Data
//@EqualsAndHashCode(callSuper = false)
//@TableName("YDJT_YDCA_BUSINESS_DATA")
//public class YdjtYdcaBusinessData implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * ����
//     */
//    @TableId(value = "BUSINESS_DATA_ID", type = IdType.AUTO)
//    private String businessDataId;
//
//    /**
//     * ��������  YDCA:��������
//     */
//    @TableField("CHANNEL_SOURCE")
//    private String channelSource;
//
//    /**
//     * ������������ 1�������������� 2��������������
//     */
//    @TableField("BUSINESS_RECORD_TYPE")
//    private String businessRecordType;
//
//    /**
//     * �������� 01 ���� 02������ 03������ 04������
//     */
//    @TableField("PRODUCT_TYPE")
//    private String productType;
//
//    /**
//     * �������� ��������������������������������������������������������������������������������������
//     */
//    @TableField("BUSINESS_NO")
//    private String businessNo;
//
//    /**
//     * ���������� ��������������������������������������������������������
//     */
//    @TableField("BUSINESS_VERSION")
//    private String businessVersion;
//
//    /**
//     * �������� ������ yyyyMMddHHmmssSSS
//     */
//    @TableField("BUSINESS_DATE")
//    private String businessDate;
//
//    /**
//     * �������� ����������������������������������������������������
//     */
//    @TableField("PRODUCT_OPERATION_NO")
//    private String productOperationNo;
//
//    /**
//     * �������� ��������������������������������������������
//     */
//    @TableField("PRODUCT_OPERATION_NAME")
//    private String productOperationName;
//
//    /**
//     * ������������ ������ JRJG1583911709323
//     */
//    @TableField("FINANCE_ORG_CODES")
//    private String financeOrgCodes;
//
//    /**
//     * ���������� ������
//     */
//    @TableField("INNER_OUTER_MAPI_TYPE")
//    private String innerOuterMapiType;
//
//    /**
//     * ����Id   ������������������������������������������������ID
//     */
//    @TableField("CUSTOMER_ID")
//    private String customerId;
//
//    /**
//     * ��������  ������������������������������������������userID
//     */
//    @TableField("CUSTOMER_NAME")
//    private String customerName;
//
//    /**
//     * ����������������  ������������������������ISC������ISCID
//     */
//    @TableField("CREDIT_NO")
//    private String creditNo;
//
//    /**
//     * ������������  ��������������������������������������������1��������������������2��������������
//     */
//    @TableField("COMPANY_CODE")
//    private String companyCode;
//
//    /**
//     * ������������  ������������������1����������2��������
//     */
//    @TableField("COMPANY_NAME")
//    private String companyName;
//
//    /**
//     * ��������  ������������������������2������������������1��1���������� 2����������
//     */
//    @TableField("CUSTOMER_TYPE")
//    private String customerType;
//
//    /**
//     * ��������  ��������������������������������������system_inner_user ����������
//system_outer_user������������
//������������������1����������2��������
//     */
//    @TableField("CUSTOMER_SCOPE")
//    private String customerScope;
//
//    /**
//     * �������������� ��������������������3����������0
//     */
//    @TableField("BUSINESS_SCALE")
//    private BigDecimal businessScale;
//
//    /**
//     * �������������� ��������������������3����������0
//     */
//    @TableField("BUSINESS_INCOME")
//    private BigDecimal businessIncome;
//
//    /**
//     * ����(%) ������������������1����������2��������
//     */
//    @TableField("RATE")
//    private String rate;
//
//    /**
//     * ������������1����������2��������
//     */
//    @TableField("BUSINESS_STATE")
//    private String businessState;
//
//    /**
//     * ��������    ������yyyyMMddHHmmssSSS
//     */
//    @TableField("REPAYMENT_TIME")
//    private String repaymentTime;
//
//    /**
//     * ��������   ��0 ������������ 1�� ����������
//��������������1����������������0��������������1����������������2��3��4����������
//     */
//    @TableField("REPAYMENT_STATE")
//    private String repaymentState;
//
//    /**
//     * ����������������
//     */
//    @TableField("ADDRESS_CODE")
//    private String addressCode;
//
//    /**
//     * ����������������
//     */
//    @TableField("ADDRESS_NAME")
//    private String addressName;
//
//    /**
//     * ������������
//     */
//    @TableField("CREDIT_LEVEL")
//    private String creditLevel;
//
//    /**
//     * ����(����
//     */
//    @TableField("INSURED_AMOUNT")
//    private BigDecimal insuredAmount;
//
//    /**
//     * ��������,��������
//     */
//    @TableField("INSURANT_PERSON")
//    private String insurantPerson;
//
//    /**
//     * ����������
//     */
//    @TableField("GUARANTEE_AMOUNT")
//    private BigDecimal guaranteeAmount;
//
//    /**
//     * ��������
//     */
//    @TableField("INSURED_PERIOD")
//    private String insuredPeriod;
//
//    /**
//     * ����
//     */
//    @TableField("INSURED_RATE")
//    private String insuredRate;
//
//    /**
//     * ��������������
//     */
//    @TableField("INSURED_INCOME")
//    private BigDecimal insuredIncome;
//
//    /**
//     * ��������������
//     */
//    @TableField("COMMISSION")
//    private BigDecimal commission;
//
//    /**
//     *  ������yyyyMMddHHmmssSSS
//     */
//    @TableField("UPDATE_TIME")
//    private String updateTime;
//
//    /**
//     * ��������   1����������
//2����������
//3����������
//4����������
//��������������2������
//     */
//    @TableField("ENTERPRISE_TYPE")
//    private String enterpriseType;
//
//    /**
//     *  ������yyyyMMddHHmmssSSS
//     */
//    @TableField("CREATE_TIME")
//    private String createTime;
//
//    @TableField("SIGN_STR")
//    private String signStr;
//
//    @TableField("REGION_NAME")
//    private String regionName;
//
//    @TableField("INSURED_PERIOD_START")
//    private String insuredPeriodStart;
//
//    @TableField("INSURED_PERIOD_END")
//    private String insuredPeriodEnd;
//
//    @TableField("INSURANCE_CORRECTING_DATE")
//    private String insuranceCorrectingDate;
//
//    @TableField("INSURANCE_TYPE")
//    private String insuranceType;
//
//    @TableField("CALIBER_TYPE")
//    private String caliberType;
//
//    @TableField("INSURANCE_PERSON")
//    private String insurancePerson;
//
//    @TableField("BID_OPEN_FLAG")
//    private String bidOpenFlag;
//
//    @TableField("BUSINESS_COMPANY")
//    private String businessCompany;
//
//    @TableField("PRODUCT_NAME_TOP")
//    private String productNameTop;
//
//    @TableField("PRODUCT_NAME_SEC")
//    private String productNameSec;
//
//
//}
