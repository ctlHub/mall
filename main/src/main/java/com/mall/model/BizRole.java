package com.mall.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@TableName("u_biz_role")
@Data
@ApiModel(value = "BizRole对象", description = "角色表")
public class BizRole implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "角色ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @ApiModelProperty(value = "角色名称（前缀为ROLE_）")
  private String name;

  @ApiModelProperty(value = "自定义角色名称")
  private String nameZh;

  @ApiModelProperty(value = "描述")
  private String description;

  @ApiModelProperty(value = "状态(0停用,1启用)")
  private Integer status;

  @ApiModelProperty(value = "角色所属商家id")
  private Long bizId;

  @ApiModelProperty(value = "创建人员")
  private Long createUserid;

  @ApiModelProperty(value = "创建时间")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime createTime;

  @ApiModelProperty(value = "更新人员")
  private Long updateUserid;

  @ApiModelProperty(value = "更新时间")
  @TableField(fill = FieldFill.UPDATE)
  private LocalDateTime updateTime;

  @ApiModelProperty(value = "是否删除")
  @TableLogic
  private Integer deleted;

  @ApiModelProperty(value = "版本")
  @Version
  private Integer version;

  @Override
  public String toString() {
    return "BizRole{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", status=" + status +
        ", bizId=" + bizId +
        ", createUserid=" + createUserid +
        ", createTime=" + createTime +
        ", updateUserid=" + updateUserid +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        ", version=" + version +
        "}";
  }
}
