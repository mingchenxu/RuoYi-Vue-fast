package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SysInfoMapper;
import com.ruoyi.project.system.domain.SysInfo;
import com.ruoyi.project.system.service.ISysInfoService;

/**
 * 系统配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class SysInfoServiceImpl implements ISysInfoService 
{
    @Autowired
    private SysInfoMapper sysInfoMapper;

    /**
     * 查询系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 系统配置信息
     */
    @Override
    public SysInfo selectSysInfoById(Long id)
    {
        return sysInfoMapper.selectSysInfoById(id);
    }

    /**
     * 查询系统配置信息列表
     * 
     * @param sysInfo 系统配置信息
     * @return 系统配置信息
     */
    @Override
    public List<SysInfo> selectSysInfoList(SysInfo sysInfo)
    {
        return sysInfoMapper.selectSysInfoList(sysInfo);
    }

    /**
     * 新增系统配置信息
     * 
     * @param sysInfo 系统配置信息
     * @return 结果
     */
    @Override
    public int insertSysInfo(SysInfo sysInfo)
    {
        sysInfo.setCreateTime(DateUtils.getNowDate());
        return sysInfoMapper.insertSysInfo(sysInfo);
    }

    /**
     * 修改系统配置信息
     * 
     * @param sysInfo 系统配置信息
     * @return 结果
     */
    @Override
    public int updateSysInfo(SysInfo sysInfo)
    {
        sysInfo.setUpdateTime(DateUtils.getNowDate());
        return sysInfoMapper.updateSysInfo(sysInfo);
    }

    /**
     * 批量删除系统配置信息
     * 
     * @param ids 需要删除的系统配置信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInfoByIds(Long[] ids)
    {
        return sysInfoMapper.deleteSysInfoByIds(ids);
    }

    /**
     * 删除系统配置信息信息
     * 
     * @param id 系统配置信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInfoById(Long id)
    {
        return sysInfoMapper.deleteSysInfoById(id);
    }
}
