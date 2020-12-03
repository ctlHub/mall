package com.mall.controller;

import com.mall.common.api.CommonResult;
import com.mall.model.Permission;
import com.mall.service.PermissionService;
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
 * 权限表 前端控制器
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@RestController
@RequestMapping("/bizPermission")
public class PermissionController {
  private final PermissionService service;

  public PermissionController(PermissionService service) {
    this.service = service;
  }

  @GetMapping("/list")
  public CommonResult<List<Permission>> list() {
    return CommonResult.success(service.list());
  }

  @GetMapping("/{id}")
  public CommonResult<Permission> get(@PathVariable String id) {
    return CommonResult.success(service.getById(id));
  }

  @PostMapping
  public CommonResult<Boolean> create(@RequestBody Permission param) {
    return CommonResult.success(service.save(param));
  }

  @PutMapping
  public CommonResult<Boolean> update(@RequestBody Permission param) {
    return CommonResult.success(service.saveOrUpdate(param));
  }

  @DeleteMapping("/{id}")
  public CommonResult<Boolean> delete(@PathVariable String id) {
    return CommonResult.success(service.removeById(id));
  }
}

