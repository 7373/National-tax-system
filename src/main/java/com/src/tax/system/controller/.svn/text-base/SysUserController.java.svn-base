/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.tax.system.controller;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.tax.system.dto.SysUserDto;
import com.icinfo.tax.system.model.SysUser;
import com.icinfo.tax.system.model.SysUserRole;
import com.icinfo.tax.system.service.ISysRoleService;
import com.icinfo.tax.system.service.ISysUserRoleService;
import com.icinfo.tax.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  系统用户管理控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
@Controller
@RequestMapping("/admin/system/sysuser")
public class SysUserController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 进入系统用户列表页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list() throws Exception {
        return "system/sysuser/list";
    }

    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<SysUser> listJSON(PageRequest request) throws Exception {
        List<SysUser> data = sysUserService.queryPage(request);
        return new PageResponse<SysUser>(data);
    }

    /**
     * 显示编辑对话框
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(String id) throws Exception {
        ModelAndView view = new ModelAndView("system/sysuser/edit");
        //所有角色信息
        view.addObject("allRoles", sysRoleService.selectAll());
        if (StringUtils.isNotEmpty(id)) {
            //获取用户信息
            SysUser sysUser = sysUserService.select(id);
            if (sysUser != null) {
                view.addObject("sysUser", sysUser);
                //获取用户角色信息
                List<SysUserRole> rolesList = sysUserRoleService.selectByUserId(id);

                Map<String, SysUserRole> rolesMap = new HashMap<String, SysUserRole>();
                for (SysUserRole userRole : rolesList) {
                    rolesMap.put(userRole.getRoleId(), userRole);
                }
                view.addObject("userRoles", rolesMap);
            }
        }
        return view;
    }

    /**
     * 用户信息保存
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@Valid @RequestBody SysUserDto sysUser, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }

        if (StringUtils.isNotEmpty(sysUser.getId())) {
            if (sysUserService.update(sysUser, sysUser.getRoles()) > 0) {
                return AjaxResult.success("更新用户信息成功");
            }
            return AjaxResult.error("更新用户信息失败!");
        }
        if (sysUserService.insert(sysUser, sysUser.getRoles()) > 0) {
            return AjaxResult.success("创建新用户成功.");
        }
        return AjaxResult.error("创建新用户失败!");
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public AjaxResult delete(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("未选择删除用户!");
        }
        if (sysUserService.deleteByPrimaryKey(id) > 0) {
            return AjaxResult.success("删除用户成功.");
        }
        return AjaxResult.error("删除用户失败!");
    }
}
