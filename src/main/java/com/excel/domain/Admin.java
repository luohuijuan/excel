package com.excel.domain;

/**
 * 登陆用户数据
 */
public class Admin {

    private int admin_id; //'编号'
    protected String avatar; //'管理员头像'
    private int groupId;//'组编号'
    protected String groupName;//'组名称'
    private int isSuper;//'是否超级管理员<br>      1-是 0-否'
    protected String name;//'用户名'
    private String password;//'密码'
    protected int  parent_group_id;//'上级组编号'

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(int isSuper) {
        this.isSuper = isSuper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getParent_group_id() {
        return parent_group_id;
    }

    public void setParent_group_id(int parent_group_id) {
        this.parent_group_id = parent_group_id;
    }
}
