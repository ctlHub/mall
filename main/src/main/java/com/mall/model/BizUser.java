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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@TableName("u_biz_user")
@Data
@ApiModel(value = "BizUser对象", description = "用户表")
public class BizUser implements UserDetails, Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "用户ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "密码")
  private String password;

  @ApiModelProperty(value = "头像")
  private String icon;

  @ApiModelProperty(value = "手机号")
  private Long phone;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "昵称")
  private String nickName;

  @ApiModelProperty(value = "最后登录时间")
  private LocalDateTime loginTime;

  @ApiModelProperty(value = "账号状态")
  private Integer status;

  @ApiModelProperty(value = "用户所属商家id")
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

  @TableField(exist = false)
  private List<BizRole> roleList;

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roleList.stream()
        .map(ele -> new SimpleGrantedAuthority(ele.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "BizUser{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", icon=" + icon +
        ", phone=" + phone +
        ", email=" + email +
        ", nickName=" + nickName +
        ", loginTime=" + loginTime +
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
