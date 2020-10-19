package com.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class CmsNotice implements Serializable {
  /**
   * 公告主键id
   */
  @ApiModelProperty(value = "公告主键id")
  private String id;

  /**
   * 公司别
   */
  @ApiModelProperty(value = "公司别")
  private String merchantId;

  /**
   * 公告标题
   */
  @ApiModelProperty(value = "公告标题")
  private String title;

  /**
   * 公告状态（0正常、1下架、2置顶）
   */
  @ApiModelProperty(value = "公告状态（0正常、1下架、2置顶）")
  private Integer status;

  /**
   * 公告图片
   */
  @ApiModelProperty(value = "公告图片")
  private String newsUrl;

  /**
   * 阅读数
   */
  @ApiModelProperty(value = "阅读数")
  private Integer readSum;

  /**
   * 备注
   */
  @ApiModelProperty(value = "备注")
  private String remark;

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

  /**
   * 公告内容
   */
  @ApiModelProperty(value = "公告内容")
  private String value;

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getNewsUrl() {
    return newsUrl;
  }

  public void setNewsUrl(String newsUrl) {
    this.newsUrl = newsUrl;
  }

  public Integer getReadSum() {
    return readSum;
  }

  public void setReadSum(Integer readSum) {
    this.readSum = readSum;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", merchantId=").append(merchantId);
    sb.append(", title=").append(title);
    sb.append(", status=").append(status);
    sb.append(", newsUrl=").append(newsUrl);
    sb.append(", readSum=").append(readSum);
    sb.append(", remark=").append(remark);
    sb.append(", appUser=").append(appUser);
    sb.append(", appDate=").append(appDate);
    sb.append(", updateUser=").append(updateUser);
    sb.append(", updateDate=").append(updateDate);
    sb.append(", value=").append(value);
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
    CmsNotice other = (CmsNotice) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
        && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
        && (this.getNewsUrl() == null ? other.getNewsUrl() == null : this.getNewsUrl().equals(other.getNewsUrl()))
        && (this.getReadSum() == null ? other.getReadSum() == null : this.getReadSum().equals(other.getReadSum()))
        && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        && (this.getAppUser() == null ? other.getAppUser() == null : this.getAppUser().equals(other.getAppUser()))
        && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
        && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
    result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getNewsUrl() == null) ? 0 : getNewsUrl().hashCode());
    result = prime * result + ((getReadSum() == null) ? 0 : getReadSum().hashCode());
    result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
    result = prime * result + ((getAppUser() == null) ? 0 : getAppUser().hashCode());
    result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
    result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
    return result;
  }
}