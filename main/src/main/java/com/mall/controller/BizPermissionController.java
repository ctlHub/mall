package com.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.api.CommonResult;
import com.mall.model.BizPermission;
import com.mall.service.BizPermissionService;
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
public class BizPermissionController {
  private final BizPermissionService service;

  public BizPermissionController(BizPermissionService service) {
    this.service = service;
  }

  @GetMapping("/list/{bizId}")
  public CommonResult<List<BizPermission>> list(@PathVariable String bizId) {
    QueryWrapper<BizPermission> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("biz_id", bizId);
    return CommonResult.success(service.list(queryWrapper));
  }

  @GetMapping("/{id}")
  public CommonResult<BizPermission> get(@PathVariable String id) {
    return CommonResult.success(service.getById(id));
  }

  @PostMapping
  public CommonResult<Boolean> create(@RequestBody BizPermission param) {
    return CommonResult.success(service.save(param));
  }

  @PutMapping
  public CommonResult<Boolean> update(@RequestBody BizPermission param) {
    return CommonResult.success(service.saveOrUpdate(param));
  }

  @DeleteMapping("/{id}")
  public CommonResult<Boolean> delete(@PathVariable String id) {
    return CommonResult.success(service.removeById(id));
  }
}

