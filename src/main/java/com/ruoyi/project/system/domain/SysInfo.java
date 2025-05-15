package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 系统配置信息对象 sys_info
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class SysInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long id;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 系统logo */
    @Excel(name = "系统logo")
    private String systemLogo;

    /** 是否显示侧边栏logo */
    @Excel(name = "是否显示侧边栏logo")
    private String sidebarLogo;

    /** 动态标题 */
    @Excel(name = "动态标题")
    private String dynamicTitle;

    /** 侧边栏宽度 */
    @Excel(name = "侧边栏宽度")
    private Long sidebarWidth;

    /** 侧边栏背景 */
    @Excel(name = "侧边栏背景")
    private String sidebarBg;

    /** 登录页背景 */
    @Excel(name = "登录页背景")
    private String loginBg;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setSystemLogo(String systemLogo) 
    {
        this.systemLogo = systemLogo;
    }

    public String getSystemLogo() 
    {
        return systemLogo;
    }
    public void setSidebarLogo(String sidebarLogo) 
    {
        this.sidebarLogo = sidebarLogo;
    }

    public String getSidebarLogo() 
    {
        return sidebarLogo;
    }
    public void setDynamicTitle(String dynamicTitle) 
    {
        this.dynamicTitle = dynamicTitle;
    }

    public String getDynamicTitle() 
    {
        return dynamicTitle;
    }
    public void setSidebarWidth(Long sidebarWidth) 
    {
        this.sidebarWidth = sidebarWidth;
    }

    public Long getSidebarWidth() 
    {
        return sidebarWidth;
    }
    public void setSidebarBg(String sidebarBg) 
    {
        this.sidebarBg = sidebarBg;
    }

    public String getSidebarBg() 
    {
        return sidebarBg;
    }
    public void setLoginBg(String loginBg) 
    {
        this.loginBg = loginBg;
    }

    public String getLoginBg() 
    {
        return loginBg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("systemName", getSystemName())
            .append("systemLogo", getSystemLogo())
            .append("sidebarLogo", getSidebarLogo())
            .append("dynamicTitle", getDynamicTitle())
            .append("sidebarWidth", getSidebarWidth())
            .append("sidebarBg", getSidebarBg())
            .append("loginBg", getLoginBg())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
