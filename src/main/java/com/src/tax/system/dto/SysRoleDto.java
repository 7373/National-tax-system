/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.tax.system.dto;

import com.icinfo.tax.system.model.SysRole;

/**
 * 描述:  系统角色DTO.<br>
 *
 * @author xiajunwei
 * @date 2016年05月16日
 */
public class SysRoleDto extends SysRole {
    /**
     * 权限列表
     */
    private String[] permisions;

    public String[] getPermisions() {
        return permisions;
    }

    public void setPermisions(String[] permisions) {
        this.permisions = permisions;
    }
}
