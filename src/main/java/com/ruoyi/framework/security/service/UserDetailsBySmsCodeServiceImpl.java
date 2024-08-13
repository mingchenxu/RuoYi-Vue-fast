package com.ruoyi.framework.security.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户验证处理
 *
 * @author gmk
 */
@Service("userDetailsBySmsCodeServiceImpl")
public class UserDetailsBySmsCodeServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsBySmsCodeServiceImpl.class);

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByPhonenumber(phone);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", phone);
            throw new ServiceException("用户不存在/验证码错误");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user, permissionService.getMenuPermission(user));
    }
}
