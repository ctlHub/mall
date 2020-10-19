package com.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GmsGoods implements Serializable {
    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String id;

    /**
     * 帐套代码
     */
    @ApiModelProperty(value = "帐套代码")
    private String merchantId;

    /**
     * 旧料号
     */
    @ApiModelProperty(value = "旧料号")
    private String oldId;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 大类
     */
    @ApiModelProperty(value = "大类")
    private String class1;

    /**
     * 中类
     */
    @ApiModelProperty(value = "中类")
    private String class2;

    /**
     * 系列
     */
    @ApiModelProperty(value = "系列")
    private String class3;

    /**
     * 品名
     */
    @ApiModelProperty(value = "品名")
    private String description;

    /**
     * 商品类型
     */
    @ApiModelProperty(value = "商品类型")
    private String partType;

    /**
     * 拼音速查码
     */
    @ApiModelProperty(value = "拼音速查码")
    private String pyId;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private String spec;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 存放位置
     */
    @ApiModelProperty(value = "存放位置")
    private String cwId;

    /**
     * 默认储位
     */
    @ApiModelProperty(value = "默认储位")
    private String defaultCw;

    /**
     * 进货价
     */
    @ApiModelProperty(value = "进货价")
    private BigDecimal inUp;

    /**
     * 出厂价
     */
    @ApiModelProperty(value = "出厂价")
    private BigDecimal outUp;

    /**
     * 批发价
     */
    @ApiModelProperty(value = "批发价")
    private BigDecimal outUp2;

    /**
     * 零售价
     */
    @ApiModelProperty(value = "零售价")
    private BigDecimal listUp;

    /**
     * 成本单价
     */
    @ApiModelProperty(value = "成本单价")
    private BigDecimal costUp;

    /**
     * 会员价
     */
    @ApiModelProperty(value = "会员价")
    private BigDecimal vipUp;

    /**
     * 会员折扣率
     */
    @ApiModelProperty(value = "会员折扣率")
    private BigDecimal vipDiscount;

    /**
     * 单价控制
     */
    @ApiModelProperty(value = "单价控制")
    private Integer upControl;

    /**
     * 使用状态
     */
    @ApiModelProperty(value = "使用状态")
    private Integer used;

    /**
     * 资源类别码
     */
    @ApiModelProperty(value = "资源类别码")
    private String objType;

    /**
     * 库存分享量
     */
    @ApiModelProperty(value = "库存分享量")
    private BigDecimal shareRate;

    /**
     * 内部条码
     */
    @ApiModelProperty(value = "内部条码")
    private String idId;

    /**
     * 外箱条码
     */
    @ApiModelProperty(value = "外箱条码")
    private String boxId;

    /**
     * 包装单位
     */
    @ApiModelProperty(value = "包装单位")
    private String boxUnit;

    /**
     * 单位包装量
     */
    @ApiModelProperty(value = "单位包装量")
    private BigDecimal boxNum;

    /**
     * 商品条码
     */
    @ApiModelProperty(value = "商品条码")
    private String barid;

    /**
     * 旧(料号)条码
     */
    @ApiModelProperty(value = "旧(料号)条码")
    private String oldBarid;

    /**
     * 上市年月
     */
    @ApiModelProperty(value = "上市年月")
    private Integer pushMonth;

    /**
     * 简介网址
     */
    @ApiModelProperty(value = "简介网址")
    private String readmeUrl;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 供应商代码
     */
    @ApiModelProperty(value = "供应商代码")
    private String supId;

    /**
     * 生效状态
     */
    @ApiModelProperty(value = "生效状态")
    private Integer status;

    /**
     * 文件数目
     */
    @ApiModelProperty(value = "文件数目")
    private Integer fileNum;

    /**
     * 最近采购厂商
     */
    @ApiModelProperty(value = "最近采购厂商")
    private String lastSupId;

    /**
     * 更新人员
     */
    @ApiModelProperty(value = "更新人员")
    private String updateUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    /**
     * 建档人员
     */
    @ApiModelProperty(value = "建档人员")
    private String appUser;

    /**
     * 建档时间
     */
    @ApiModelProperty(value = "建档时间")
    private Date appDate;

    /**
     * 更新ID
     */
    @ApiModelProperty(value = "更新ID")
    private String updateKey;

    /**
     * 是否允许打折
     */
    @ApiModelProperty(value = "是否允许打折")
    private Integer allowDiscount;

    /**
     * 商品型号
     */
    @ApiModelProperty(value = "商品型号")
    private String modelId;

    /**
     * 材料类别
     */
    @ApiModelProperty(value = "材料类别")
    private Integer bomLevel;

    /**
     * 置顶显示
     */
    @ApiModelProperty(value = "置顶显示")
    private Integer partViewTop;

    /**
     * 单位体积
     */
    @ApiModelProperty(value = "单位体积")
    private BigDecimal volume;

    /**
     * 重量
     */
    @ApiModelProperty(value = "重量")
    private BigDecimal weight;

    /**
     * 促销类别
     */
    @ApiModelProperty(value = "促销类别")
    private Integer salesStatus;

    /**
     * 整包销售
     */
    @ApiModelProperty(value = "整包销售")
    private Boolean boxSales;

    /**
     * 整包采购
     */
    @ApiModelProperty(value = "整包采购")
    private Boolean boxPurchase;

    /**
     * 商品下架
     */
    @ApiModelProperty(value = "商品下架")
    private Boolean lowerShelf;

    /**
     * 采购前置天数
     */
    @ApiModelProperty(value = "采购前置天数")
    private Integer purFrontDay;

    /**
     * 禁止采购
     */
    @ApiModelProperty(value = "禁止采购")
    private Boolean forbidPur;

    /**
     * 商品分类（0、普通商品；1、型号商品；2、子项商品）
     */
    @ApiModelProperty(value = "商品分类（0、普通商品；1、型号商品；2、子项商品）")
    private Integer classify;

    /**
     * 商品型号
     */
    @ApiModelProperty(value = "商品型号")
    private String marque;

    /**
     * 总预售量参与MRP计算
     */
    @ApiModelProperty(value = "总预售量参与MRP计算")
    private Boolean forecastCountMrp;

    /**
     * 总预售量计算月份(0.当月1.当月和下月2.当月和下两月3.当月和下三月)
     */
    @ApiModelProperty(value = "总预售量计算月份(0.当月1.当月和下月2.当月和下两月3.当月和下三月)")
    private Integer forecastCountMonth;

    /**
     * 样品单号
     */
    @ApiModelProperty(value = "样品单号")
    private String seNo;

    /**
     * 是否同步到钓友汇
     */
    @ApiModelProperty(value = "是否同步到钓友汇")
    private Boolean isSync;

    /**
     * 材料属性(0.外购1.自制)
     */
    @ApiModelProperty(value = "材料属性(0.外购1.自制)")
    private Boolean bomProperty;

    /**
     * 生产单位
     */
    @ApiModelProperty(value = "生产单位")
    private String deptId;

    /**
     * 成本金额
     */
    @ApiModelProperty(value = "成本金额")
    private BigDecimal costAmount;

    /**
     * 发货周期（天）
     */
    @ApiModelProperty(value = "发货周期（天）")
    private Integer deliveryCycle;

    /**
     * 虚拟库存
     */
    @ApiModelProperty(value = "虚拟库存")
    private BigDecimal virtualStock;

    /**
     * 商品属性选项
     */
    @ApiModelProperty(value = "商品属性选项")
    private String optional;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getPyId() {
        return pyId;
    }

    public void setPyId(String pyId) {
        this.pyId = pyId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCwId() {
        return cwId;
    }

    public void setCwId(String cwId) {
        this.cwId = cwId;
    }

    public String getDefaultCw() {
        return defaultCw;
    }

    public void setDefaultCw(String defaultCw) {
        this.defaultCw = defaultCw;
    }

    public BigDecimal getInUp() {
        return inUp;
    }

    public void setInUp(BigDecimal inUp) {
        this.inUp = inUp;
    }

    public BigDecimal getOutUp() {
        return outUp;
    }

    public void setOutUp(BigDecimal outUp) {
        this.outUp = outUp;
    }

    public BigDecimal getOutUp2() {
        return outUp2;
    }

    public void setOutUp2(BigDecimal outUp2) {
        this.outUp2 = outUp2;
    }

    public BigDecimal getListUp() {
        return listUp;
    }

    public void setListUp(BigDecimal listUp) {
        this.listUp = listUp;
    }

    public BigDecimal getCostUp() {
        return costUp;
    }

    public void setCostUp(BigDecimal costUp) {
        this.costUp = costUp;
    }

    public BigDecimal getVipUp() {
        return vipUp;
    }

    public void setVipUp(BigDecimal vipUp) {
        this.vipUp = vipUp;
    }

    public BigDecimal getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(BigDecimal vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public Integer getUpControl() {
        return upControl;
    }

    public void setUpControl(Integer upControl) {
        this.upControl = upControl;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public BigDecimal getShareRate() {
        return shareRate;
    }

    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    public String getIdId() {
        return idId;
    }

    public void setIdId(String idId) {
        this.idId = idId;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getBoxUnit() {
        return boxUnit;
    }

    public void setBoxUnit(String boxUnit) {
        this.boxUnit = boxUnit;
    }

    public BigDecimal getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(BigDecimal boxNum) {
        this.boxNum = boxNum;
    }

    public String getBarid() {
        return barid;
    }

    public void setBarid(String barid) {
        this.barid = barid;
    }

    public String getOldBarid() {
        return oldBarid;
    }

    public void setOldBarid(String oldBarid) {
        this.oldBarid = oldBarid;
    }

    public Integer getPushMonth() {
        return pushMonth;
    }

    public void setPushMonth(Integer pushMonth) {
        this.pushMonth = pushMonth;
    }

    public String getReadmeUrl() {
        return readmeUrl;
    }

    public void setReadmeUrl(String readmeUrl) {
        this.readmeUrl = readmeUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }

    public String getLastSupId() {
        return lastSupId;
    }

    public void setLastSupId(String lastSupId) {
        this.lastSupId = lastSupId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public Integer getAllowDiscount() {
        return allowDiscount;
    }

    public void setAllowDiscount(Integer allowDiscount) {
        this.allowDiscount = allowDiscount;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getBomLevel() {
        return bomLevel;
    }

    public void setBomLevel(Integer bomLevel) {
        this.bomLevel = bomLevel;
    }

    public Integer getPartViewTop() {
        return partViewTop;
    }

    public void setPartViewTop(Integer partViewTop) {
        this.partViewTop = partViewTop;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
    }

    public Boolean getBoxSales() {
        return boxSales;
    }

    public void setBoxSales(Boolean boxSales) {
        this.boxSales = boxSales;
    }

    public Boolean getBoxPurchase() {
        return boxPurchase;
    }

    public void setBoxPurchase(Boolean boxPurchase) {
        this.boxPurchase = boxPurchase;
    }

    public Boolean getLowerShelf() {
        return lowerShelf;
    }

    public void setLowerShelf(Boolean lowerShelf) {
        this.lowerShelf = lowerShelf;
    }

    public Integer getPurFrontDay() {
        return purFrontDay;
    }

    public void setPurFrontDay(Integer purFrontDay) {
        this.purFrontDay = purFrontDay;
    }

    public Boolean getForbidPur() {
        return forbidPur;
    }

    public void setForbidPur(Boolean forbidPur) {
        this.forbidPur = forbidPur;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Boolean getForecastCountMrp() {
        return forecastCountMrp;
    }

    public void setForecastCountMrp(Boolean forecastCountMrp) {
        this.forecastCountMrp = forecastCountMrp;
    }

    public Integer getForecastCountMonth() {
        return forecastCountMonth;
    }

    public void setForecastCountMonth(Integer forecastCountMonth) {
        this.forecastCountMonth = forecastCountMonth;
    }

    public String getSeNo() {
        return seNo;
    }

    public void setSeNo(String seNo) {
        this.seNo = seNo;
    }

    public Boolean getIsSync() {
        return isSync;
    }

    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }

    public Boolean getBomProperty() {
        return bomProperty;
    }

    public void setBomProperty(Boolean bomProperty) {
        this.bomProperty = bomProperty;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Integer getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(Integer deliveryCycle) {
        this.deliveryCycle = deliveryCycle;
    }

    public BigDecimal getVirtualStock() {
        return virtualStock;
    }

    public void setVirtualStock(BigDecimal virtualStock) {
        this.virtualStock = virtualStock;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", oldId=").append(oldId);
        sb.append(", brand=").append(brand);
        sb.append(", class1=").append(class1);
        sb.append(", class2=").append(class2);
        sb.append(", class3=").append(class3);
        sb.append(", description=").append(description);
        sb.append(", partType=").append(partType);
        sb.append(", pyId=").append(pyId);
        sb.append(", spec=").append(spec);
        sb.append(", unit=").append(unit);
        sb.append(", cwId=").append(cwId);
        sb.append(", defaultCw=").append(defaultCw);
        sb.append(", inUp=").append(inUp);
        sb.append(", outUp=").append(outUp);
        sb.append(", outUp2=").append(outUp2);
        sb.append(", listUp=").append(listUp);
        sb.append(", costUp=").append(costUp);
        sb.append(", vipUp=").append(vipUp);
        sb.append(", vipDiscount=").append(vipDiscount);
        sb.append(", upControl=").append(upControl);
        sb.append(", used=").append(used);
        sb.append(", objType=").append(objType);
        sb.append(", shareRate=").append(shareRate);
        sb.append(", idId=").append(idId);
        sb.append(", boxId=").append(boxId);
        sb.append(", boxUnit=").append(boxUnit);
        sb.append(", boxNum=").append(boxNum);
        sb.append(", barid=").append(barid);
        sb.append(", oldBarid=").append(oldBarid);
        sb.append(", pushMonth=").append(pushMonth);
        sb.append(", readmeUrl=").append(readmeUrl);
        sb.append(", remark=").append(remark);
        sb.append(", supId=").append(supId);
        sb.append(", status=").append(status);
        sb.append(", fileNum=").append(fileNum);
        sb.append(", lastSupId=").append(lastSupId);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", appUser=").append(appUser);
        sb.append(", appDate=").append(appDate);
        sb.append(", updateKey=").append(updateKey);
        sb.append(", allowDiscount=").append(allowDiscount);
        sb.append(", modelId=").append(modelId);
        sb.append(", bomLevel=").append(bomLevel);
        sb.append(", partViewTop=").append(partViewTop);
        sb.append(", volume=").append(volume);
        sb.append(", weight=").append(weight);
        sb.append(", salesStatus=").append(salesStatus);
        sb.append(", boxSales=").append(boxSales);
        sb.append(", boxPurchase=").append(boxPurchase);
        sb.append(", lowerShelf=").append(lowerShelf);
        sb.append(", purFrontDay=").append(purFrontDay);
        sb.append(", forbidPur=").append(forbidPur);
        sb.append(", classify=").append(classify);
        sb.append(", marque=").append(marque);
        sb.append(", forecastCountMrp=").append(forecastCountMrp);
        sb.append(", forecastCountMonth=").append(forecastCountMonth);
        sb.append(", seNo=").append(seNo);
        sb.append(", isSync=").append(isSync);
        sb.append(", bomProperty=").append(bomProperty);
        sb.append(", deptId=").append(deptId);
        sb.append(", costAmount=").append(costAmount);
        sb.append(", deliveryCycle=").append(deliveryCycle);
        sb.append(", virtualStock=").append(virtualStock);
        sb.append(", optional=").append(optional);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
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
        GmsGoods other = (GmsGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
                && (this.getOldId() == null ? other.getOldId() == null : this.getOldId().equals(other.getOldId()))
                && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
                && (this.getClass1() == null ? other.getClass1() == null : this.getClass1().equals(other.getClass1()))
                && (this.getClass2() == null ? other.getClass2() == null : this.getClass2().equals(other.getClass2()))
                && (this.getClass3() == null ? other.getClass3() == null : this.getClass3().equals(other.getClass3()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getPartType() == null ? other.getPartType() == null : this.getPartType().equals(other.getPartType()))
                && (this.getPyId() == null ? other.getPyId() == null : this.getPyId().equals(other.getPyId()))
                && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
                && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
                && (this.getCwId() == null ? other.getCwId() == null : this.getCwId().equals(other.getCwId()))
                && (this.getDefaultCw() == null ? other.getDefaultCw() == null : this.getDefaultCw().equals(other.getDefaultCw()))
                && (this.getInUp() == null ? other.getInUp() == null : this.getInUp().equals(other.getInUp()))
                && (this.getOutUp() == null ? other.getOutUp() == null : this.getOutUp().equals(other.getOutUp()))
                && (this.getOutUp2() == null ? other.getOutUp2() == null : this.getOutUp2().equals(other.getOutUp2()))
                && (this.getListUp() == null ? other.getListUp() == null : this.getListUp().equals(other.getListUp()))
                && (this.getCostUp() == null ? other.getCostUp() == null : this.getCostUp().equals(other.getCostUp()))
                && (this.getVipUp() == null ? other.getVipUp() == null : this.getVipUp().equals(other.getVipUp()))
                && (this.getVipDiscount() == null ? other.getVipDiscount() == null : this.getVipDiscount().equals(other.getVipDiscount()))
                && (this.getUpControl() == null ? other.getUpControl() == null : this.getUpControl().equals(other.getUpControl()))
                && (this.getUsed() == null ? other.getUsed() == null : this.getUsed().equals(other.getUsed()))
                && (this.getObjType() == null ? other.getObjType() == null : this.getObjType().equals(other.getObjType()))
                && (this.getShareRate() == null ? other.getShareRate() == null : this.getShareRate().equals(other.getShareRate()))
                && (this.getIdId() == null ? other.getIdId() == null : this.getIdId().equals(other.getIdId()))
                && (this.getBoxId() == null ? other.getBoxId() == null : this.getBoxId().equals(other.getBoxId()))
                && (this.getBoxUnit() == null ? other.getBoxUnit() == null : this.getBoxUnit().equals(other.getBoxUnit()))
                && (this.getBoxNum() == null ? other.getBoxNum() == null : this.getBoxNum().equals(other.getBoxNum()))
                && (this.getBarid() == null ? other.getBarid() == null : this.getBarid().equals(other.getBarid()))
                && (this.getOldBarid() == null ? other.getOldBarid() == null : this.getOldBarid().equals(other.getOldBarid()))
                && (this.getPushMonth() == null ? other.getPushMonth() == null : this.getPushMonth().equals(other.getPushMonth()))
                && (this.getReadmeUrl() == null ? other.getReadmeUrl() == null : this.getReadmeUrl().equals(other.getReadmeUrl()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getSupId() == null ? other.getSupId() == null : this.getSupId().equals(other.getSupId()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getFileNum() == null ? other.getFileNum() == null : this.getFileNum().equals(other.getFileNum()))
                && (this.getLastSupId() == null ? other.getLastSupId() == null : this.getLastSupId().equals(other.getLastSupId()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
                && (this.getAppUser() == null ? other.getAppUser() == null : this.getAppUser().equals(other.getAppUser()))
                && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
                && (this.getUpdateKey() == null ? other.getUpdateKey() == null : this.getUpdateKey().equals(other.getUpdateKey()))
                && (this.getAllowDiscount() == null ? other.getAllowDiscount() == null : this.getAllowDiscount().equals(other.getAllowDiscount()))
                && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
                && (this.getBomLevel() == null ? other.getBomLevel() == null : this.getBomLevel().equals(other.getBomLevel()))
                && (this.getPartViewTop() == null ? other.getPartViewTop() == null : this.getPartViewTop().equals(other.getPartViewTop()))
                && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
                && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
                && (this.getSalesStatus() == null ? other.getSalesStatus() == null : this.getSalesStatus().equals(other.getSalesStatus()))
                && (this.getBoxSales() == null ? other.getBoxSales() == null : this.getBoxSales().equals(other.getBoxSales()))
                && (this.getBoxPurchase() == null ? other.getBoxPurchase() == null : this.getBoxPurchase().equals(other.getBoxPurchase()))
                && (this.getLowerShelf() == null ? other.getLowerShelf() == null : this.getLowerShelf().equals(other.getLowerShelf()))
                && (this.getPurFrontDay() == null ? other.getPurFrontDay() == null : this.getPurFrontDay().equals(other.getPurFrontDay()))
                && (this.getForbidPur() == null ? other.getForbidPur() == null : this.getForbidPur().equals(other.getForbidPur()))
                && (this.getClassify() == null ? other.getClassify() == null : this.getClassify().equals(other.getClassify()))
                && (this.getMarque() == null ? other.getMarque() == null : this.getMarque().equals(other.getMarque()))
                && (this.getForecastCountMrp() == null ? other.getForecastCountMrp() == null : this.getForecastCountMrp().equals(other.getForecastCountMrp()))
                && (this.getForecastCountMonth() == null ? other.getForecastCountMonth() == null : this.getForecastCountMonth().equals(other.getForecastCountMonth()))
                && (this.getSeNo() == null ? other.getSeNo() == null : this.getSeNo().equals(other.getSeNo()))
                && (this.getIsSync() == null ? other.getIsSync() == null : this.getIsSync().equals(other.getIsSync()))
                && (this.getBomProperty() == null ? other.getBomProperty() == null : this.getBomProperty().equals(other.getBomProperty()))
                && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
                && (this.getCostAmount() == null ? other.getCostAmount() == null : this.getCostAmount().equals(other.getCostAmount()))
                && (this.getDeliveryCycle() == null ? other.getDeliveryCycle() == null : this.getDeliveryCycle().equals(other.getDeliveryCycle()))
                && (this.getVirtualStock() == null ? other.getVirtualStock() == null : this.getVirtualStock().equals(other.getVirtualStock()))
                && (this.getOptional() == null ? other.getOptional() == null : this.getOptional().equals(other.getOptional()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getOldId() == null) ? 0 : getOldId().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getClass1() == null) ? 0 : getClass1().hashCode());
        result = prime * result + ((getClass2() == null) ? 0 : getClass2().hashCode());
        result = prime * result + ((getClass3() == null) ? 0 : getClass3().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPartType() == null) ? 0 : getPartType().hashCode());
        result = prime * result + ((getPyId() == null) ? 0 : getPyId().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getCwId() == null) ? 0 : getCwId().hashCode());
        result = prime * result + ((getDefaultCw() == null) ? 0 : getDefaultCw().hashCode());
        result = prime * result + ((getInUp() == null) ? 0 : getInUp().hashCode());
        result = prime * result + ((getOutUp() == null) ? 0 : getOutUp().hashCode());
        result = prime * result + ((getOutUp2() == null) ? 0 : getOutUp2().hashCode());
        result = prime * result + ((getListUp() == null) ? 0 : getListUp().hashCode());
        result = prime * result + ((getCostUp() == null) ? 0 : getCostUp().hashCode());
        result = prime * result + ((getVipUp() == null) ? 0 : getVipUp().hashCode());
        result = prime * result + ((getVipDiscount() == null) ? 0 : getVipDiscount().hashCode());
        result = prime * result + ((getUpControl() == null) ? 0 : getUpControl().hashCode());
        result = prime * result + ((getUsed() == null) ? 0 : getUsed().hashCode());
        result = prime * result + ((getObjType() == null) ? 0 : getObjType().hashCode());
        result = prime * result + ((getShareRate() == null) ? 0 : getShareRate().hashCode());
        result = prime * result + ((getIdId() == null) ? 0 : getIdId().hashCode());
        result = prime * result + ((getBoxId() == null) ? 0 : getBoxId().hashCode());
        result = prime * result + ((getBoxUnit() == null) ? 0 : getBoxUnit().hashCode());
        result = prime * result + ((getBoxNum() == null) ? 0 : getBoxNum().hashCode());
        result = prime * result + ((getBarid() == null) ? 0 : getBarid().hashCode());
        result = prime * result + ((getOldBarid() == null) ? 0 : getOldBarid().hashCode());
        result = prime * result + ((getPushMonth() == null) ? 0 : getPushMonth().hashCode());
        result = prime * result + ((getReadmeUrl() == null) ? 0 : getReadmeUrl().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSupId() == null) ? 0 : getSupId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFileNum() == null) ? 0 : getFileNum().hashCode());
        result = prime * result + ((getLastSupId() == null) ? 0 : getLastSupId().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getAppUser() == null) ? 0 : getAppUser().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getUpdateKey() == null) ? 0 : getUpdateKey().hashCode());
        result = prime * result + ((getAllowDiscount() == null) ? 0 : getAllowDiscount().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getBomLevel() == null) ? 0 : getBomLevel().hashCode());
        result = prime * result + ((getPartViewTop() == null) ? 0 : getPartViewTop().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getSalesStatus() == null) ? 0 : getSalesStatus().hashCode());
        result = prime * result + ((getBoxSales() == null) ? 0 : getBoxSales().hashCode());
        result = prime * result + ((getBoxPurchase() == null) ? 0 : getBoxPurchase().hashCode());
        result = prime * result + ((getLowerShelf() == null) ? 0 : getLowerShelf().hashCode());
        result = prime * result + ((getPurFrontDay() == null) ? 0 : getPurFrontDay().hashCode());
        result = prime * result + ((getForbidPur() == null) ? 0 : getForbidPur().hashCode());
        result = prime * result + ((getClassify() == null) ? 0 : getClassify().hashCode());
        result = prime * result + ((getMarque() == null) ? 0 : getMarque().hashCode());
        result = prime * result + ((getForecastCountMrp() == null) ? 0 : getForecastCountMrp().hashCode());
        result = prime * result + ((getForecastCountMonth() == null) ? 0 : getForecastCountMonth().hashCode());
        result = prime * result + ((getSeNo() == null) ? 0 : getSeNo().hashCode());
        result = prime * result + ((getIsSync() == null) ? 0 : getIsSync().hashCode());
        result = prime * result + ((getBomProperty() == null) ? 0 : getBomProperty().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getCostAmount() == null) ? 0 : getCostAmount().hashCode());
        result = prime * result + ((getDeliveryCycle() == null) ? 0 : getDeliveryCycle().hashCode());
        result = prime * result + ((getVirtualStock() == null) ? 0 : getVirtualStock().hashCode());
        result = prime * result + ((getOptional() == null) ? 0 : getOptional().hashCode());
        return result;
    }
}