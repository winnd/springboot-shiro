package com.bishe.demo.model;

public class Permission {
    private Integer id;

    private Integer parentId;

    private String resName;

    private String resType;

    private String permission;

    private String url;

    public Permission(Integer id, Integer parentId, String resName, String resType, String permission, String url) {
        this.id = id;
        this.parentId = parentId;
        this.resName = resName;
        this.resType = resType;
        this.permission = permission;
        this.url = url;
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}