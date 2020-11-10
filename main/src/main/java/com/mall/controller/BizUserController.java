package com.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.api.CommonResult;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.model.BizUser;
import com.mall.service.BizUserService;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@RestController
@RequestMapping("/bizUser")
public class BizUserController {
  private final BizUserService service;

  public BizUserController(BizUserService service) {
    this.service = service;
  }

  @GetMapping("/list/{bizId}")
  public CommonResult<List<BizUser>> list(@PathVariable String bizId) {
    QueryWrapper<BizUser> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("biz_id", bizId);
    return CommonResult.success(service.list(queryWrapper));
  }

  @GetMapping("/{id}")
  public CommonResult<BizUser> get(@PathVariable String id) {
    return CommonResult.success(service.getById(id));
  }

  @PostMapping
  public CommonResult<Boolean> create(@RequestBody BizUser param) {
    param.setId(SnowflakeIdGenerator.genLongId());
    return CommonResult.success(service.save(param));
  }

  @PutMapping
  public CommonResult<Boolean> update(@RequestBody BizUser param) {
    return CommonResult.success(service.saveOrUpdate(param));
  }

  @DeleteMapping("/{id}")
  public CommonResult<Boolean> delete(@PathVariable String id) {
    return CommonResult.success(service.removeById(id));
  }
}

