package com.mall.controller;

import com.mall.common.api.CommonResult;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.model.BizRole;
import com.mall.service.BizRoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@RestController
@RequestMapping("/bizRole")
public class BizRoleController {
  private final BizRoleService service;

  public BizRoleController(BizRoleService service) {
    this.service = service;
  }

  @GetMapping("/list")
  public CommonResult<List<BizRole>> list() {
    return CommonResult.success(service.list());
  }

  @GetMapping("/{id}")
  public CommonResult<BizRole> get(@PathVariable String id) {
    return CommonResult.success(service.getById(id));
  }

  @PostMapping
  public CommonResult<Boolean> create(@RequestBody BizRole param) {
    param.setId(SnowflakeIdGenerator.genLongId());
    return CommonResult.success(service.save(param));
  }

  @PutMapping
  public CommonResult<Boolean> update(@RequestBody BizRole param) {
    return CommonResult.success(service.saveOrUpdate(param));
  }

  @DeleteMapping("/{id}")
  public CommonResult<Boolean> delete(@PathVariable String id) {
    return CommonResult.success(service.removeById(id));
  }
}

