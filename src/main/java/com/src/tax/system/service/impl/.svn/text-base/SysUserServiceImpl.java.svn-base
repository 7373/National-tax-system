/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.tax.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.Md5Utils;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.tax.system.mapper.SysUserMapper;
import com.icinfo.tax.system.model.SysUser;
import com.icinfo.tax.system.model.SysUserRole;
import com.icinfo.tax.system.service.ISysUserRoleService;
import com.icinfo.tax.system.service.ISysUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.icinfo.framework.tools.utils.StringUtils.*;

/**
 * 描述:  系统用户业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service("sysUserService")
public class SysUserServiceImpl extends MyBatisServiceSupport implements ISysUserService {
    private final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Value("${spring.shiro.hash.iterations}")
    private int iterations;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 参数转换
     *
     * @param userId
     * @param roles
     * @return
     * @throws Exception
     */
    private List<SysUserRole> parseConvert(String userId, String[] roles) throws Exception {
        List<SysUserRole> rolesList = new ArrayList<SysUserRole>();
        for (String roleId : roles) {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            rolesList.add(userRole);
        }
        return rolesList;
    }

    /**
     * 增加系统用户
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysUser sysUser, String[] roles) throws Exception {
        sysUser.setCreateTime(DateUtils.getSysDate());
        if (exists(sysUser.getUsername())) {
            throw new BusinessException("用户名" + sysUser.getUsername() + "已经存在");
        }
        //密码MD5
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
            sysUser.setPassword(hash.toHex());
        }
        if (sysUserMapper.insert(sysUser) <= 0) {
            throw new BusinessException("创建系统用户失败!");
        }
        if (roles != null && roles.length > 0) {
            //保存用户角色
            sysUserRoleService.insert(parseConvert(sysUser.getId(), roles));
        }
        return 1;
    }

    /**
     * 验证用户名是否存在
     *
     * @param username
     * @return
     * @throws Exception
     */
    private boolean exists(String username) throws Exception {
        return selectByUserName(username) != null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(SysUser sysUser, String[] roles) throws Exception {
        if (sysUser == null || isEmpty(sysUser.getId())) {
            return 0;
        }
        sysUser.setUsername(null);
        sysUser.setLastLoginTime(DateUtils.getSysDate());
        //删除旧角色
        sysUserRoleService.deleteByUserId(sysUser.getId());

        if (roles != null && roles.length > 0) {
            //保存用户角色
            sysUserRoleService.insert(parseConvert(sysUser.getId(), roles));
        }
        //密码MD5(使用shiro默认MD5实现)
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
            sysUser.setPassword(hash.toHex());
        } else {
            sysUser.setPassword(null);
        }
        //更新用户信息
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 通过主键删除用户
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKey(String primaryKey) throws Exception {
        return sysUserMapper.deleteByPrimaryKey(primaryKey);
    }

    /**
     * 系统用户列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUser> queryPage(PageRequest request) throws Exception {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return sysUserMapper.selectAll();
    }

    /**
     * 通过ID加载指定的用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysUser select(String id) throws Exception {
        if (isEmpty(id)) {
            return null;
        }
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 加载指定用户名的用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public SysUser selectByUserName(String username) throws Exception {
        if (isEmpty(username)) {
            return null;
        }
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list.size() > 0 && StringUtils.isNotBlank(list.get(0).getId())) {
            return list.get(0);
        }
        return null;
    }
}
