/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.tax.system.dto;

import com.icinfo.framework.core.validator.Level;
import com.icinfo.framework.core.validator.Password;
import com.icinfo.tax.system.model.SysUser;
import org.hibernate.validator.constraints.Email;

/**
 * 描述:  系统用户DTO.<br>
 *
 * @author xiajunwei
 * @date 2016年04月25日
 */
public class SysUserDto extends SysUser {
    @Password(level = Level.WEAK)
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /**
     * 用户角色
     */
    private String[] roles;

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    @Email
    @Override
    public String getEmail() {
        return super.getEmail();
    }
}
