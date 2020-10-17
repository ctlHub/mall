package com.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class GmsGoodsBind implements Serializable {
    /**
     * 主键UID
     */
    @ApiModelProperty(value = "主键UID")
    private Integer uid;

    /**
     * 账套代码
     */
    @ApiModelProperty(value = "账套代码")
    private String corpNo;

    /**
     * 主商品料号
     */
    @ApiModelProperty(value = "主商品料号")
    private String primaryGoodsCode;

    /**
     * 次商品料号
     */
    @ApiModelProperty(value = "次商品料号")
    private String secondaryGoodsCode;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String appUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date appDate;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getPrimaryGoodsCode() {
        return primaryGoodsCode;
    }

    public void setPrimaryGoodsCode(String primaryGoodsCode) {
        this.primaryGoodsCode = primaryGoodsCode;
    }

    public String getSecondaryGoodsCode() {
        return secondaryGoodsCode;
    }

    public void setSecondaryGoodsCode(String secondaryGoodsCode) {
        this.secondaryGoodsCode = secondaryGoodsCode;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", corpNo=").append(corpNo);
        sb.append(", primaryGoodsCode=").append(primaryGoodsCode);
        sb.append(", secondaryGoodsCode=").append(secondaryGoodsCode);
        sb.append(", appUser=").append(appUser);
        sb.append(", appDate=").append(appDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
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
        GmsGoodsBind other = (GmsGoodsBind) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCorpNo() == null ? other.getCorpNo() == null : this.getCorpNo().equals(other.getCorpNo()))
            && (this.getPrimaryGoodsCode() == null ? other.getPrimaryGoodsCode() == null : this.getPrimaryGoodsCode().equals(other.getPrimaryGoodsCode()))
            && (this.getSecondaryGoodsCode() == null ? other.getSecondaryGoodsCode() == null : this.getSecondaryGoodsCode().equals(other.getSecondaryGoodsCode()))
            && (this.getAppUser() == null ? other.getAppUser() == null : this.getAppUser().equals(other.getAppUser()))
            && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCorpNo() == null) ? 0 : getCorpNo().hashCode());
        result = prime * result + ((getPrimaryGoodsCode() == null) ? 0 : getPrimaryGoodsCode().hashCode());
        result = prime * result + ((getSecondaryGoodsCode() == null) ? 0 : getSecondaryGoodsCode().hashCode());
        result = prime * result + ((getAppUser() == null) ? 0 : getAppUser().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}