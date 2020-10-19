package com.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class MmsMerchant implements Serializable {
    /**
     * 商家id
     */
    @ApiModelProperty(value = "商家id")
    private String id;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 行业代码
     */
    @ApiModelProperty(value = "行业代码")
    private String industryId;

    /**
     * 页面上的logo
     */
    @ApiModelProperty(value = "页面上的logo")
    private String logo;

    /**
     * 手机版选择商家图标
     */
    @ApiModelProperty(value = "手机版选择商家图标")
    private String phoneIcon;

    /**
     * 电脑版选择商家图标
     */
    @ApiModelProperty(value = "电脑版选择商家图标")
    private String pcIcon;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhoneIcon() {
        return phoneIcon;
    }

    public void setPhoneIcon(String phoneIcon) {
        this.phoneIcon = phoneIcon;
    }

    public String getPcIcon() {
        return pcIcon;
    }

    public void setPcIcon(String pcIcon) {
        this.pcIcon = pcIcon;
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", industryId=").append(industryId);
        sb.append(", logo=").append(logo);
        sb.append(", phoneIcon=").append(phoneIcon);
        sb.append(", pcIcon=").append(pcIcon);
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
        MmsMerchant other = (MmsMerchant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId()))
                && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
                && (this.getPhoneIcon() == null ? other.getPhoneIcon() == null : this.getPhoneIcon().equals(other.getPhoneIcon()))
                && (this.getPcIcon() == null ? other.getPcIcon() == null : this.getPcIcon().equals(other.getPcIcon()))
                && (this.getAppUser() == null ? other.getAppUser() == null : this.getAppUser().equals(other.getAppUser()))
                && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getPhoneIcon() == null) ? 0 : getPhoneIcon().hashCode());
        result = prime * result + ((getPcIcon() == null) ? 0 : getPcIcon().hashCode());
        result = prime * result + ((getAppUser() == null) ? 0 : getAppUser().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}