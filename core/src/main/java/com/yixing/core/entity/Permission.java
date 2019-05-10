package com.yixing.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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
@TableName("permission")
public class Permission {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 菜单排序
     */
    private Integer zindex;

    /**
     * 权限分类（0 菜单；1 功能）
     */
    private Integer istype;

    /**
     * 描述
     */
    private String descpt;

    /**
     * 菜单编号
     */
    private String code;

    private String title;

    /**
     * 菜单图标名称
     */
    private String icon;

    /**
     * 菜单url
     */
    private String href;

    /**
     * 添加时间
     */
    private LocalDateTime insertTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Permission() {
    }

    public Permission(Integer id, String name, Integer pid, Integer zindex, Integer istype, String descpt, String code, String icon, String href, LocalDateTime insertTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.zindex = zindex;
        this.istype = istype;
        this.descpt = descpt;
        this.code = code;
        this.icon = icon;
        this.href = href;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getZindex() {
        return zindex;
    }

    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    public Integer getIstype() {
        return istype;
    }

    public void setIstype(Integer istype) {
        this.istype = istype;
    }

    public String getDesc() {
        return descpt;
    }

    public void setDesc(String descpt) {
        this.descpt = descpt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
