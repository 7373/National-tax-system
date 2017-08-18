/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.tax.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.tax.system.mapper.SysRoleMapper;
import com.icinfo.tax.system.mapper.SysRolePermisionMapper;
import com.icinfo.tax.system.model.SysRole;
import com.icinfo.tax.system.model.SysRolePermision;
import com.icinfo.tax.system.service.ISysRolePermisionService;
import com.icinfo.tax.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:  系统角色业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysRoleServiceImpl extends MyBatisServiceSupport implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private ISysRolePermisionService sysRolePermisionService;

    /**
     * 数据转换
     *
     * @param roleId
     * @param permisions
     * @return
     */
    private List<SysRolePermision> convert(String roleId, String[] permisions) throws Exception {
        List<SysRolePermision> rolePermisionList = new ArrayList<SysRolePermision>();
        for (String permision : permisions) {
            SysRolePermision rolePermision = new SysRolePermision();
            rolePermision.setRoleId(roleId);
            rolePermision.setPermisionId(permision);
            rolePermisionList.add(rolePermision);
        }
        return rolePermisionList;
    }

    /**
     * 添加用户角色
     *
     * @param sysRole
     * @param permisions
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysRole sysRole, String[] permisions) throws Exception {
        if (permisions == null || permisions.length == 0) {
            throw new BusinessException("至少选择一项权限");
        }

        if (sysRoleMapper.insert(sysRole) <= 0) {
            throw new BusinessException("创建角色失败");
        }
        sysRolePermisionService.insert(convert(sysRole.getId(), permisions));
        return 1;
    }

    /**
     * 更新用户角色
     *
     * @param sysRole
     * @param permisions
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(SysRole sysRole, String[] permisions) throws Exception {
        if (StringUtils.isBlank(sysRole.getId())) {
            throw new BusinessException("角色不存在");
        }
        if (permisions == null || permisions.length == 0) {
            throw new BusinessException("至少选择一项权限");
        }
        //删除旧权限
        sysRolePermisionService.deleteByRoleId(sysRole.getId());
        //保存新权限
        sysRolePermisionService.insert(convert(sysRole.getId(), permisions));
        //更新角色信息
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * 删除用户角色
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String roleId) throws Exception {
        //删除角色权限
        sysRolePermisionService.deleteByRoleId(roleId);
        //删除角色
        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    /**
     * 通过主键查询用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysRole selectByPrimaryKey(String id) throws Exception {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有角色信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<SysRole> selectAll() throws Exception {
        return sysRoleMapper.selectAll();
    }

    /**
     * 查询角色列表
     *
     * @param request
     * @return
     */
    @Override
    public List<SysRole> queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return sysRoleMapper.selectAll();
    }
}
