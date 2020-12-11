package com.mall.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JWT认证用户类，用户登录成功后将用户信息保存在这个类中；也是JWT的负载信息
 * 当在资源服务中验证token后，将json反序列化为该类实例
 *
 * @author 李重辰
 * @date 2020/11/28 22:59
 */
@Data
public class JwtUserDetail implements UserDetail {
  private static final long serialVersionUID = 1751491811264717753L;

  @ApiModelProperty(value = "用户ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @ApiModelProperty(value = "用户名")
  private String username;

  /**
   * transient 序列化时不包含该字段
   */
  @ApiModelProperty(value = "密码")
  private transient String password;

  @ApiModelProperty(value = "账号状态")
  private Integer status;

  /**
   * 店铺账号有这个字段
   */
  @ApiModelProperty(value = "商家ID")
  private String merchantId;

  /**
   * 用户类型
   */
  private int userType;

  /**
   * 用户可访问资源
   */
  private List<String> resourceList;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return resourceList.stream()
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }

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
}
