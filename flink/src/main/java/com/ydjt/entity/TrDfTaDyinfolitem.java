package com.ydjt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金动态信息数据项
 * @TableName TR_DF_TA_DYINFOLITEM
 */
@TableName(value ="TR_DF_TA_DYINFOLITEM")
public class TrDfTaDyinfolitem implements Serializable {
    /**
     * 基金总份数                  /                                                                                                                      
     */
    private BigDecimal totalfundvol;

    /**
     * 基金代码                    /                                                                                                                      
     */
    private String fundcode;

    /**
     * 基金状态                    /0-可申购赎回，1-发行 4-停止申购赎回  5-停止申购，6-停止赎回 8-基金终止，9-基金封闭                                    
     */
    private String fundstatus;

    /**
     * 基金净值日期                /格式为：YYYYMMDD 对ETF、QDII基金的申购或赎回净值，此字段的含义为该申购或赎回净值适用的交易申请的日期。                
     */
    private String updatedate;

    /**
     * 净值类型                    /0-普通净值1-申购净值 2-赎回净值 对ETF、QDII基金可同时下发3条净值记录，通过此字段区分基金单位净值及基金净值日期的含义。
     */
    private String netvaluetype;

    /**
     * 累计基金单位净值            /                                                                                                                      
     */
    private BigDecimal accumulativenav;

    /**
     * 基金规模                    /基金的金额规模                                                                                                        
     */
    private BigDecimal fundsize;

    /**
     * 公告标志                    /0-公告  1-不公告                                                                                                      
     */
    private String announcflag;

    /**
     * 交易价格                    /                                                                                                                      
     */
    private BigDecimal tradingprice;

    /**
     * 货币基金万份收益            /货币基金必填                                                                                                          
     */
    private BigDecimal fundincome;

    /**
     * 货币基金万份收益正负        /0-正  1-负  货币基金必填                                                                                              
     */
    private String fundincomeflag;

    /**
     * 货币基金七日年化收益率      /货币基金必填                                                                                                          
     */
    private BigDecimal yield;

    /**
     * 货币基金七日年化收益率正负  /0-正  1-负  货币基金必填                                                                                              
     */
    private String yieldflag;

    /**
     * 保本净值                    /　                                                                                                                    
     */
    private BigDecimal guaranteednav;

    /**
     * 货币基金年收益率            /最近一年来的收益率                                                                                                    
     */
    private BigDecimal fundyearincomerate;

    /**
     * 货币基金年收益率正负        /　                                                                                                                    
     */
    private String fundyearincomerateflag;

    /**
     * 基金当日总收益正负          /　货币基金必填                                                                                                        
     */
    private String funddayincomeflag;

    /**
     * 基金当日总收益              /　货币基金必填                                                                                                        
     */
    private BigDecimal funddayincome;

    /**
     * 
     */
    private String fmapping;

    /**
     * 
     */
    private Date etlTime;

    /**
     * 系统角色
     */
    private String taType;

    /**
     * 系统来源
     */
    private String pfType;

    /**
     * 交易确认日期
     */
    private String transactioncfmdate;

    /**
     * 结算币种
     */
    private String currencytype;

    /**
     * 基金单位净值
     */
    private BigDecimal nav;

    /**
     * 今日增加份额

     */
    private BigDecimal fAsucceed;

    /**
     * 今日减少份额

     */
    private BigDecimal fRsucceed;

    /**
     * 基金总份数——自建排除SS备份
     */
    private BigDecimal totalfundvolTa;

    /**
     * 基金总份数——SS备份
     */
    private BigDecimal navTa;

    /**
     * 基金总金额——自建排除SS备份
     */
    private BigDecimal fundsizeTa;

    /**
     * 基金总金额——SS备份
     */
    private BigDecimal fundsizeSs;

    /**
     * 
     */
    private String id;

    /**
     * 创建人
     */
    private String createPrsn;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String mdfyPrson;

    /**
     * 修改时间
     */
    private Date mdfyTime;

    /**
     * 审核状态
     */
    private String approvalStatus;

    /**
     * 审核人
     */
    private String approvalName;

    /**
     * 审核时间
     */
    private Date approvalTime;

    /**
     * 驳回原因
     */
    private String rejectReason;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 基金总份数                  /                                                                                                                      
     */
    public BigDecimal getTotalfundvol() {
        return totalfundvol;
    }

    /**
     * 基金总份数                  /                                                                                                                      
     */
    public void setTotalfundvol(BigDecimal totalfundvol) {
        this.totalfundvol = totalfundvol;
    }

    /**
     * 基金代码                    /                                                                                                                      
     */
    public String getFundcode() {
        return fundcode;
    }

    /**
     * 基金代码                    /                                                                                                                      
     */
    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    /**
     * 基金状态                    /0-可申购赎回，1-发行 4-停止申购赎回  5-停止申购，6-停止赎回 8-基金终止，9-基金封闭                                    
     */
    public String getFundstatus() {
        return fundstatus;
    }

    /**
     * 基金状态                    /0-可申购赎回，1-发行 4-停止申购赎回  5-停止申购，6-停止赎回 8-基金终止，9-基金封闭                                    
     */
    public void setFundstatus(String fundstatus) {
        this.fundstatus = fundstatus;
    }

    /**
     * 基金净值日期                /格式为：YYYYMMDD 对ETF、QDII基金的申购或赎回净值，此字段的含义为该申购或赎回净值适用的交易申请的日期。                
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * 基金净值日期                /格式为：YYYYMMDD 对ETF、QDII基金的申购或赎回净值，此字段的含义为该申购或赎回净值适用的交易申请的日期。                
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 净值类型                    /0-普通净值1-申购净值 2-赎回净值 对ETF、QDII基金可同时下发3条净值记录，通过此字段区分基金单位净值及基金净值日期的含义。
     */
    public String getNetvaluetype() {
        return netvaluetype;
    }

    /**
     * 净值类型                    /0-普通净值1-申购净值 2-赎回净值 对ETF、QDII基金可同时下发3条净值记录，通过此字段区分基金单位净值及基金净值日期的含义。
     */
    public void setNetvaluetype(String netvaluetype) {
        this.netvaluetype = netvaluetype;
    }

    /**
     * 累计基金单位净值            /                                                                                                                      
     */
    public BigDecimal getAccumulativenav() {
        return accumulativenav;
    }

    /**
     * 累计基金单位净值            /                                                                                                                      
     */
    public void setAccumulativenav(BigDecimal accumulativenav) {
        this.accumulativenav = accumulativenav;
    }

    /**
     * 基金规模                    /基金的金额规模                                                                                                        
     */
    public BigDecimal getFundsize() {
        return fundsize;
    }

    /**
     * 基金规模                    /基金的金额规模                                                                                                        
     */
    public void setFundsize(BigDecimal fundsize) {
        this.fundsize = fundsize;
    }

    /**
     * 公告标志                    /0-公告  1-不公告                                                                                                      
     */
    public String getAnnouncflag() {
        return announcflag;
    }

    /**
     * 公告标志                    /0-公告  1-不公告                                                                                                      
     */
    public void setAnnouncflag(String announcflag) {
        this.announcflag = announcflag;
    }

    /**
     * 交易价格                    /                                                                                                                      
     */
    public BigDecimal getTradingprice() {
        return tradingprice;
    }

    /**
     * 交易价格                    /                                                                                                                      
     */
    public void setTradingprice(BigDecimal tradingprice) {
        this.tradingprice = tradingprice;
    }

    /**
     * 货币基金万份收益            /货币基金必填                                                                                                          
     */
    public BigDecimal getFundincome() {
        return fundincome;
    }

    /**
     * 货币基金万份收益            /货币基金必填                                                                                                          
     */
    public void setFundincome(BigDecimal fundincome) {
        this.fundincome = fundincome;
    }

    /**
     * 货币基金万份收益正负        /0-正  1-负  货币基金必填                                                                                              
     */
    public String getFundincomeflag() {
        return fundincomeflag;
    }

    /**
     * 货币基金万份收益正负        /0-正  1-负  货币基金必填                                                                                              
     */
    public void setFundincomeflag(String fundincomeflag) {
        this.fundincomeflag = fundincomeflag;
    }

    /**
     * 货币基金七日年化收益率      /货币基金必填                                                                                                          
     */
    public BigDecimal getYield() {
        return yield;
    }

    /**
     * 货币基金七日年化收益率      /货币基金必填                                                                                                          
     */
    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    /**
     * 货币基金七日年化收益率正负  /0-正  1-负  货币基金必填                                                                                              
     */
    public String getYieldflag() {
        return yieldflag;
    }

    /**
     * 货币基金七日年化收益率正负  /0-正  1-负  货币基金必填                                                                                              
     */
    public void setYieldflag(String yieldflag) {
        this.yieldflag = yieldflag;
    }

    /**
     * 保本净值                    /　                                                                                                                    
     */
    public BigDecimal getGuaranteednav() {
        return guaranteednav;
    }

    /**
     * 保本净值                    /　                                                                                                                    
     */
    public void setGuaranteednav(BigDecimal guaranteednav) {
        this.guaranteednav = guaranteednav;
    }

    /**
     * 货币基金年收益率            /最近一年来的收益率                                                                                                    
     */
    public BigDecimal getFundyearincomerate() {
        return fundyearincomerate;
    }

    /**
     * 货币基金年收益率            /最近一年来的收益率                                                                                                    
     */
    public void setFundyearincomerate(BigDecimal fundyearincomerate) {
        this.fundyearincomerate = fundyearincomerate;
    }

    /**
     * 货币基金年收益率正负        /　                                                                                                                    
     */
    public String getFundyearincomerateflag() {
        return fundyearincomerateflag;
    }

    /**
     * 货币基金年收益率正负        /　                                                                                                                    
     */
    public void setFundyearincomerateflag(String fundyearincomerateflag) {
        this.fundyearincomerateflag = fundyearincomerateflag;
    }

    /**
     * 基金当日总收益正负          /　货币基金必填                                                                                                        
     */
    public String getFunddayincomeflag() {
        return funddayincomeflag;
    }

    /**
     * 基金当日总收益正负          /　货币基金必填                                                                                                        
     */
    public void setFunddayincomeflag(String funddayincomeflag) {
        this.funddayincomeflag = funddayincomeflag;
    }

    /**
     * 基金当日总收益              /　货币基金必填                                                                                                        
     */
    public BigDecimal getFunddayincome() {
        return funddayincome;
    }

    /**
     * 基金当日总收益              /　货币基金必填                                                                                                        
     */
    public void setFunddayincome(BigDecimal funddayincome) {
        this.funddayincome = funddayincome;
    }

    /**
     * 
     */
    public String getFmapping() {
        return fmapping;
    }

    /**
     * 
     */
    public void setFmapping(String fmapping) {
        this.fmapping = fmapping;
    }

    /**
     * 
     */
    public Date getEtlTime() {
        return etlTime;
    }

    /**
     * 
     */
    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }

    /**
     * 系统角色
     */
    public String getTaType() {
        return taType;
    }

    /**
     * 系统角色
     */
    public void setTaType(String taType) {
        this.taType = taType;
    }

    /**
     * 系统来源
     */
    public String getPfType() {
        return pfType;
    }

    /**
     * 系统来源
     */
    public void setPfType(String pfType) {
        this.pfType = pfType;
    }

    /**
     * 交易确认日期
     */
    public String getTransactioncfmdate() {
        return transactioncfmdate;
    }

    /**
     * 交易确认日期
     */
    public void setTransactioncfmdate(String transactioncfmdate) {
        this.transactioncfmdate = transactioncfmdate;
    }

    /**
     * 结算币种
     */
    public String getCurrencytype() {
        return currencytype;
    }

    /**
     * 结算币种
     */
    public void setCurrencytype(String currencytype) {
        this.currencytype = currencytype;
    }

    /**
     * 基金单位净值
     */
    public BigDecimal getNav() {
        return nav;
    }

    /**
     * 基金单位净值
     */
    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    /**
     * 今日增加份额

     */
    public BigDecimal getfAsucceed() {
        return fAsucceed;
    }

    /**
     * 今日增加份额

     */
    public void setfAsucceed(BigDecimal fAsucceed) {
        this.fAsucceed = fAsucceed;
    }

    /**
     * 今日减少份额

     */
    public BigDecimal getfRsucceed() {
        return fRsucceed;
    }

    /**
     * 今日减少份额

     */
    public void setfRsucceed(BigDecimal fRsucceed) {
        this.fRsucceed = fRsucceed;
    }

    /**
     * 基金总份数——自建排除SS备份
     */
    public BigDecimal getTotalfundvolTa() {
        return totalfundvolTa;
    }

    /**
     * 基金总份数——自建排除SS备份
     */
    public void setTotalfundvolTa(BigDecimal totalfundvolTa) {
        this.totalfundvolTa = totalfundvolTa;
    }

    /**
     * 基金总份数——SS备份
     */
    public BigDecimal getNavTa() {
        return navTa;
    }

    /**
     * 基金总份数——SS备份
     */
    public void setNavTa(BigDecimal navTa) {
        this.navTa = navTa;
    }

    /**
     * 基金总金额——自建排除SS备份
     */
    public BigDecimal getFundsizeTa() {
        return fundsizeTa;
    }

    /**
     * 基金总金额——自建排除SS备份
     */
    public void setFundsizeTa(BigDecimal fundsizeTa) {
        this.fundsizeTa = fundsizeTa;
    }

    /**
     * 基金总金额——SS备份
     */
    public BigDecimal getFundsizeSs() {
        return fundsizeSs;
    }

    /**
     * 基金总金额——SS备份
     */
    public void setFundsizeSs(BigDecimal fundsizeSs) {
        this.fundsizeSs = fundsizeSs;
    }

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
     * 创建人
     */
    public String getCreatePrsn() {
        return createPrsn;
    }

    /**
     * 创建人
     */
    public void setCreatePrsn(String createPrsn) {
        this.createPrsn = createPrsn;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     */
    public String getMdfyPrson() {
        return mdfyPrson;
    }

    /**
     * 修改人
     */
    public void setMdfyPrson(String mdfyPrson) {
        this.mdfyPrson = mdfyPrson;
    }

    /**
     * 修改时间
     */
    public Date getMdfyTime() {
        return mdfyTime;
    }

    /**
     * 修改时间
     */
    public void setMdfyTime(Date mdfyTime) {
        this.mdfyTime = mdfyTime;
    }

    /**
     * 审核状态
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 审核状态
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * 审核人
     */
    public String getApprovalName() {
        return approvalName;
    }

    /**
     * 审核人
     */
    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    /**
     * 审核时间
     */
    public Date getApprovalTime() {
        return approvalTime;
    }

    /**
     * 审核时间
     */
    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    /**
     * 驳回原因
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * 驳回原因
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
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
        TrDfTaDyinfolitem other = (TrDfTaDyinfolitem) that;
        return (this.getTotalfundvol() == null ? other.getTotalfundvol() == null : this.getTotalfundvol().equals(other.getTotalfundvol()))
            && (this.getFundcode() == null ? other.getFundcode() == null : this.getFundcode().equals(other.getFundcode()))
            && (this.getFundstatus() == null ? other.getFundstatus() == null : this.getFundstatus().equals(other.getFundstatus()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getNetvaluetype() == null ? other.getNetvaluetype() == null : this.getNetvaluetype().equals(other.getNetvaluetype()))
            && (this.getAccumulativenav() == null ? other.getAccumulativenav() == null : this.getAccumulativenav().equals(other.getAccumulativenav()))
            && (this.getFundsize() == null ? other.getFundsize() == null : this.getFundsize().equals(other.getFundsize()))
            && (this.getAnnouncflag() == null ? other.getAnnouncflag() == null : this.getAnnouncflag().equals(other.getAnnouncflag()))
            && (this.getTradingprice() == null ? other.getTradingprice() == null : this.getTradingprice().equals(other.getTradingprice()))
            && (this.getFundincome() == null ? other.getFundincome() == null : this.getFundincome().equals(other.getFundincome()))
            && (this.getFundincomeflag() == null ? other.getFundincomeflag() == null : this.getFundincomeflag().equals(other.getFundincomeflag()))
            && (this.getYield() == null ? other.getYield() == null : this.getYield().equals(other.getYield()))
            && (this.getYieldflag() == null ? other.getYieldflag() == null : this.getYieldflag().equals(other.getYieldflag()))
            && (this.getGuaranteednav() == null ? other.getGuaranteednav() == null : this.getGuaranteednav().equals(other.getGuaranteednav()))
            && (this.getFundyearincomerate() == null ? other.getFundyearincomerate() == null : this.getFundyearincomerate().equals(other.getFundyearincomerate()))
            && (this.getFundyearincomerateflag() == null ? other.getFundyearincomerateflag() == null : this.getFundyearincomerateflag().equals(other.getFundyearincomerateflag()))
            && (this.getFunddayincomeflag() == null ? other.getFunddayincomeflag() == null : this.getFunddayincomeflag().equals(other.getFunddayincomeflag()))
            && (this.getFunddayincome() == null ? other.getFunddayincome() == null : this.getFunddayincome().equals(other.getFunddayincome()))
            && (this.getFmapping() == null ? other.getFmapping() == null : this.getFmapping().equals(other.getFmapping()))
            && (this.getEtlTime() == null ? other.getEtlTime() == null : this.getEtlTime().equals(other.getEtlTime()))
            && (this.getTaType() == null ? other.getTaType() == null : this.getTaType().equals(other.getTaType()))
            && (this.getPfType() == null ? other.getPfType() == null : this.getPfType().equals(other.getPfType()))
            && (this.getTransactioncfmdate() == null ? other.getTransactioncfmdate() == null : this.getTransactioncfmdate().equals(other.getTransactioncfmdate()))
            && (this.getCurrencytype() == null ? other.getCurrencytype() == null : this.getCurrencytype().equals(other.getCurrencytype()))
            && (this.getNav() == null ? other.getNav() == null : this.getNav().equals(other.getNav()))
            && (this.getfAsucceed() == null ? other.getfAsucceed() == null : this.getfAsucceed().equals(other.getfAsucceed()))
            && (this.getfRsucceed() == null ? other.getfRsucceed() == null : this.getfRsucceed().equals(other.getfRsucceed()))
            && (this.getTotalfundvolTa() == null ? other.getTotalfundvolTa() == null : this.getTotalfundvolTa().equals(other.getTotalfundvolTa()))
            && (this.getNavTa() == null ? other.getNavTa() == null : this.getNavTa().equals(other.getNavTa()))
            && (this.getFundsizeTa() == null ? other.getFundsizeTa() == null : this.getFundsizeTa().equals(other.getFundsizeTa()))
            && (this.getFundsizeSs() == null ? other.getFundsizeSs() == null : this.getFundsizeSs().equals(other.getFundsizeSs()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatePrsn() == null ? other.getCreatePrsn() == null : this.getCreatePrsn().equals(other.getCreatePrsn()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMdfyPrson() == null ? other.getMdfyPrson() == null : this.getMdfyPrson().equals(other.getMdfyPrson()))
            && (this.getMdfyTime() == null ? other.getMdfyTime() == null : this.getMdfyTime().equals(other.getMdfyTime()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalName() == null ? other.getApprovalName() == null : this.getApprovalName().equals(other.getApprovalName()))
            && (this.getApprovalTime() == null ? other.getApprovalTime() == null : this.getApprovalTime().equals(other.getApprovalTime()))
            && (this.getRejectReason() == null ? other.getRejectReason() == null : this.getRejectReason().equals(other.getRejectReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTotalfundvol() == null) ? 0 : getTotalfundvol().hashCode());
        result = prime * result + ((getFundcode() == null) ? 0 : getFundcode().hashCode());
        result = prime * result + ((getFundstatus() == null) ? 0 : getFundstatus().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getNetvaluetype() == null) ? 0 : getNetvaluetype().hashCode());
        result = prime * result + ((getAccumulativenav() == null) ? 0 : getAccumulativenav().hashCode());
        result = prime * result + ((getFundsize() == null) ? 0 : getFundsize().hashCode());
        result = prime * result + ((getAnnouncflag() == null) ? 0 : getAnnouncflag().hashCode());
        result = prime * result + ((getTradingprice() == null) ? 0 : getTradingprice().hashCode());
        result = prime * result + ((getFundincome() == null) ? 0 : getFundincome().hashCode());
        result = prime * result + ((getFundincomeflag() == null) ? 0 : getFundincomeflag().hashCode());
        result = prime * result + ((getYield() == null) ? 0 : getYield().hashCode());
        result = prime * result + ((getYieldflag() == null) ? 0 : getYieldflag().hashCode());
        result = prime * result + ((getGuaranteednav() == null) ? 0 : getGuaranteednav().hashCode());
        result = prime * result + ((getFundyearincomerate() == null) ? 0 : getFundyearincomerate().hashCode());
        result = prime * result + ((getFundyearincomerateflag() == null) ? 0 : getFundyearincomerateflag().hashCode());
        result = prime * result + ((getFunddayincomeflag() == null) ? 0 : getFunddayincomeflag().hashCode());
        result = prime * result + ((getFunddayincome() == null) ? 0 : getFunddayincome().hashCode());
        result = prime * result + ((getFmapping() == null) ? 0 : getFmapping().hashCode());
        result = prime * result + ((getEtlTime() == null) ? 0 : getEtlTime().hashCode());
        result = prime * result + ((getTaType() == null) ? 0 : getTaType().hashCode());
        result = prime * result + ((getPfType() == null) ? 0 : getPfType().hashCode());
        result = prime * result + ((getTransactioncfmdate() == null) ? 0 : getTransactioncfmdate().hashCode());
        result = prime * result + ((getCurrencytype() == null) ? 0 : getCurrencytype().hashCode());
        result = prime * result + ((getNav() == null) ? 0 : getNav().hashCode());
        result = prime * result + ((getfAsucceed() == null) ? 0 : getfAsucceed().hashCode());
        result = prime * result + ((getfRsucceed() == null) ? 0 : getfRsucceed().hashCode());
        result = prime * result + ((getTotalfundvolTa() == null) ? 0 : getTotalfundvolTa().hashCode());
        result = prime * result + ((getNavTa() == null) ? 0 : getNavTa().hashCode());
        result = prime * result + ((getFundsizeTa() == null) ? 0 : getFundsizeTa().hashCode());
        result = prime * result + ((getFundsizeSs() == null) ? 0 : getFundsizeSs().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatePrsn() == null) ? 0 : getCreatePrsn().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMdfyPrson() == null) ? 0 : getMdfyPrson().hashCode());
        result = prime * result + ((getMdfyTime() == null) ? 0 : getMdfyTime().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalName() == null) ? 0 : getApprovalName().hashCode());
        result = prime * result + ((getApprovalTime() == null) ? 0 : getApprovalTime().hashCode());
        result = prime * result + ((getRejectReason() == null) ? 0 : getRejectReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", totalfundvol=").append(totalfundvol);
        sb.append(", fundcode=").append(fundcode);
        sb.append(", fundstatus=").append(fundstatus);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", netvaluetype=").append(netvaluetype);
        sb.append(", accumulativenav=").append(accumulativenav);
        sb.append(", fundsize=").append(fundsize);
        sb.append(", announcflag=").append(announcflag);
        sb.append(", tradingprice=").append(tradingprice);
        sb.append(", fundincome=").append(fundincome);
        sb.append(", fundincomeflag=").append(fundincomeflag);
        sb.append(", yield=").append(yield);
        sb.append(", yieldflag=").append(yieldflag);
        sb.append(", guaranteednav=").append(guaranteednav);
        sb.append(", fundyearincomerate=").append(fundyearincomerate);
        sb.append(", fundyearincomerateflag=").append(fundyearincomerateflag);
        sb.append(", funddayincomeflag=").append(funddayincomeflag);
        sb.append(", funddayincome=").append(funddayincome);
        sb.append(", fmapping=").append(fmapping);
        sb.append(", etlTime=").append(etlTime);
        sb.append(", taType=").append(taType);
        sb.append(", pfType=").append(pfType);
        sb.append(", transactioncfmdate=").append(transactioncfmdate);
        sb.append(", currencytype=").append(currencytype);
        sb.append(", nav=").append(nav);
        sb.append(", fAsucceed=").append(fAsucceed);
        sb.append(", fRsucceed=").append(fRsucceed);
        sb.append(", totalfundvolTa=").append(totalfundvolTa);
        sb.append(", navTa=").append(navTa);
        sb.append(", fundsizeTa=").append(fundsizeTa);
        sb.append(", fundsizeSs=").append(fundsizeSs);
        sb.append(", id=").append(id);
        sb.append(", createPrsn=").append(createPrsn);
        sb.append(", createTime=").append(createTime);
        sb.append(", mdfyPrson=").append(mdfyPrson);
        sb.append(", mdfyTime=").append(mdfyTime);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalName=").append(approvalName);
        sb.append(", approvalTime=").append(approvalTime);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}