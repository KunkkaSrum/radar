package com.yixing.core.vo;


import java.util.List;

public class AuthVo {
    private Integer id;
    private String title;
    private String href;
    private String checkArr;
    private Integer parentId;
    private String iconClass;
    private Long permissionNo;
    private Integer isType;
    private String icon;
    private List<AuthVo> children;

    public AuthVo() {
    }

    public AuthVo(Integer id, String title, String checkArr, Integer parentId, String iconClass, String href, Long permissionNo, Integer isType, String icon, List<AuthVo> authVos) {
        this.id = id;
        this.title = title;
        this.checkArr = checkArr;
        this.parentId = parentId;
        this.iconClass = iconClass;
        this.href = href;
        this.permissionNo = permissionNo;
        this.isType = isType;
        this.icon = icon;
        this.children = authVos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getPermissionNo() {
        return permissionNo;
    }

    public void setPermissionNo(Long permissionNo) {
        this.permissionNo = permissionNo;
    }

    public Integer getIsType() {
        return isType;
    }

    public void setIsType(Integer isType) {
        this.isType = isType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<AuthVo> getChildren() {
        return children;
    }

    public void setChildren(List<AuthVo> children) {
        this.children = children;
    }
}
