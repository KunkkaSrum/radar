package com.yixing.core.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yixing.core.entity.Role;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.service.IRoleService;
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
@RequestMapping("/core/role")
public class RoleController  {

    private static Logger logger = LogManager.getLogger(RoleController.class);
    
    @Autowired
    private IRoleService iRoleService;
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultData listRole(@RequestBody(required = false) Role role,
                               @RequestParam("page") int page,
                               @RequestParam("limit") int size) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(role);
        Page<Role> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(size);
        IPage<Role> roleIPage = iRoleService.page(page1,queryWrapper);
        return new ResultData(roleIPage.getTotal(), 0, "查询成功！", roleIPage.getRecords());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultData addRole(@RequestBody Role role) {
        try{
            role.setInsertTime(LocalDateTime.now());
            iRoleService.save(role);
            return new ResultData(1, StatusCode.OK, "添加成功！", null);
        } catch(Exception e) {
            logger.error("RoleController->addRole"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "添加失败！", null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultData updateRole(@RequestBody(required = false) Role role) {
        try{
            role.setUpdateTime(LocalDateTime.now());
            iRoleService.updateById(role);
            return new ResultData(1, StatusCode.OK, "更新成功！", null);
        } catch(Exception e) {
            logger.error("RoleController->updateRole"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "更新失败！", e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultData deleteRole(@RequestParam("RoleNo") Long roleNo ) {
        return new ResultData(1, StatusCode.OK, "删除成功！", iRoleService.removeById(roleNo));
    }

}
