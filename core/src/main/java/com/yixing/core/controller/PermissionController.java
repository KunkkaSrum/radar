package com.yixing.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yixing.core.entity.Permission;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.service.IPermissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@RestController
@RequestMapping("/core/permission")
public class PermissionController  {
    private static Logger logger = LogManager.getLogger(PermissionController.class);

    @Autowired
    private IPermissionService iPermissionService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultData listPermission(@RequestBody(required = false) Permission permission,
                               @RequestParam("page") int page,
                               @RequestParam("limit") int size) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>(permission);
        Page<Permission> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(size);
        IPage<Permission> permissionIPage = iPermissionService.page(page1,queryWrapper);
        return new ResultData(permissionIPage.getTotal(), 0, "查询成功！", permissionIPage.getRecords());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultData addPermission(@RequestBody Permission permission) {
        try{
            permission.setInsertTime(LocalDateTime.now());
            iPermissionService.save(permission);
            return new ResultData(1, StatusCode.OK, "添加成功！", null);
        } catch(Exception e) {
            logger.error("PermissionController->addPermission"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "添加失败！", null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultData updatePermission(@RequestBody(required = false) Permission permission) {
        try{
            permission.setUpdateTime(LocalDateTime.now());
            iPermissionService.updateById(permission);
            return new ResultData(1, StatusCode.OK, "更新成功！", null);
        } catch(Exception e) {
            logger.error("PermissionController->updatePermission"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "更新失败！", e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultData deletePermission(@RequestParam("permissionNo") Long permissionNo ) {
        return new ResultData(1, StatusCode.OK, "删除成功！", iPermissionService.removeById(permissionNo));
    }
}
