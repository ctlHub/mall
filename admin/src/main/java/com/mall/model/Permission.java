package com.mall.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@Data
@ApiModel(value = "Permission对象", description = "权限表")
public class Permission implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "权限ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @ApiModelProperty(value = "上级ID")
  private Long parentId;

  @ApiModelProperty(value = "权限名称")
  private String name;

  @ApiModelProperty(value = "权限层级")
  private String level;

  @ApiModelProperty(value = "图标")
  private String icon;

  @ApiModelProperty(value = "类型")
  private Integer type;

  @ApiModelProperty(value = "链接")
  private String url;

  @ApiModelProperty(value = "请求方法")
  private String method;

  @ApiModelProperty(value = "权限状态")
  private Integer status;

  @ApiModelProperty(value = "权限所属商家id")
  private Long merchantId;

  @ApiModelProperty(value = "创建人员")
  @TableField(fill = FieldFill.INSERT)
  private Long createUserId;

  @ApiModelProperty(value = "创建时间")
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  @ApiModelProperty(value = "更新人员")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUserId;

  @ApiModelProperty(value = "更新时间")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;

  @ApiModelProperty(value = "是否删除")
  @TableLogic
  private Integer deleted;

  @ApiModelProperty(value = "版本")
  @Version
  private Integer version;

  @TableField(exist = false)
  private List<Role> roleList;

  @Override
  public String toString() {
    return "Permission{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", name=" + name +
        ", level=" + level +
        ", icon=" + icon +
        ", type=" + type +
        ", url=" + url +
        ", method=" + method +
        ", status=" + status +
        ", merchantId=" + merchantId +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        ", version=" + version +
        ", roleList=" + roleList +
        "}";
  }
}
