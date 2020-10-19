package com.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class GmsGoodsAndTag implements Serializable {
  private String id;

  /**
   * 账套代码
   */
  @ApiModelProperty(value = "账套代码")
  private String merchantId;

  /**
   * 商品料号
   */
  @ApiModelProperty(value = "商品料号")
  private String goodsId;

  /**
   * 标签代码
   */
  @ApiModelProperty(value = "标签代码")
  private String tagId;

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

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }

  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
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
    sb.append(", merchantId=").append(merchantId);
    sb.append(", goodsId=").append(goodsId);
    sb.append(", tagId=").append(tagId);
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
    GmsGoodsAndTag other = (GmsGoodsAndTag) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
        && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
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
    result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
    result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
    result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
    result = prime * result + ((getAppUser() == null) ? 0 : getAppUser().hashCode());
    result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
    result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    return result;
  }
}