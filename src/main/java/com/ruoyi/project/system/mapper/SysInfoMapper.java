package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.SysInfo;

/**
 * 系统配置信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public interface SysInfoMapper 
{
    /**
     * 查询系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 系统配置信息
     */
    public SysInfo selectSysInfoById(Long id);

    /**
     * 查询系统配置信息列表
     * 
     * @param sysInfo 系统配置信息
     * @return 系统配置信息集合
     */
    public List<SysInfo> selectSysInfoList(SysInfo sysInfo);

    /**
     * 新增系统配置信息
     * 
     * @param sysInfo 系统配置信息
     * @return 结果
     */
    public int insertSysInfo(SysInfo sysInfo);

    /**
     * 修改系统配置信息
     * 
     * @param sysInfo 系统配置信息
     * @return 结果
     */
    public int updateSysInfo(SysInfo sysInfo);

    /**
     * 删除系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 结果
     */
    public int deleteSysInfoById(Long id);

    /**
     * 批量删除系统配置信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInfoByIds(Long[] ids);
}
