package com.yixing.core.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yixing.core.entity.OperateLog;
import com.yixing.core.model.ResultData;
import com.yixing.core.service.IOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core/log")
public class OperateLogController {
    @Autowired
    private IOperateLogService iOperateLogService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultData listOperateLog(@RequestBody(required = false) OperateLog OperateLog,
                               @RequestParam("page") int page,
                               @RequestParam("limit") int size) {
        QueryWrapper<OperateLog> queryWrapper = new QueryWrapper<>(OperateLog);
        Page<OperateLog> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(size);
        IPage<OperateLog> OperateLogIPage = iOperateLogService.page(page1,queryWrapper);
        return new ResultData(OperateLogIPage.getTotal(), 0, "查询成功！", OperateLogIPage.getRecords());
    }
}
