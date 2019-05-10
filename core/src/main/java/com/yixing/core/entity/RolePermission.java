package com.yixing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@Data
//@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("role_permission")
public class RolePermission  extends Permission{

    private static final long serialVersionUID = 1L;

    @TableId(value = "permit_id", type = IdType.AUTO)
    private Integer permitId;

    private Integer roleId;

    public RolePermission() {
    }

    public RolePermission(Integer permitId, Integer roleId) {
        this.permitId = permitId;
        this.roleId = roleId;
    }


    public Integer getPermitId() {
        return permitId;
    }

    public void setPermitId(Integer permitId) {
        this.permitId = permitId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
