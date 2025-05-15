package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.SysInfo;
import com.ruoyi.project.system.service.ISysInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 系统配置信息Controller
 *
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/system/info")
public class SysInfoController extends BaseController
{
    @Autowired
    private ISysInfoService sysInfoService;

    /**
     * 查询系统配置信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysInfo sysInfo)
    {
        startPage();
        List<SysInfo> list = sysInfoService.selectSysInfoList(sysInfo);
        return getDataTable(list);
    }

    /**
     * 导出系统配置信息列表
     */
    @Log(title = "系统配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInfo sysInfo)
    {
        List<SysInfo> list = sysInfoService.selectSysInfoList(sysInfo);
        ExcelUtil<SysInfo> util = new ExcelUtil<SysInfo>(SysInfo.class);
        util.exportExcel(response, list, "系统配置信息数据");
    }

    /**
     * 获取系统配置信息详细信息
     */
    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysInfoService.selectSysInfoById(id));
    }

    /**
     * 新增系统配置信息
     */
    @Log(title = "系统配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInfo sysInfo)
    {
        return toAjax(sysInfoService.insertSysInfo(sysInfo));
    }

    /**
     * 修改系统配置信息
     */
    @Log(title = "系统配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInfo sysInfo)
    {
        return toAjax(sysInfoService.updateSysInfo(sysInfo));
    }

    /**
     * 删除系统配置信息
     */
    @Log(title = "系统配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInfoService.deleteSysInfoByIds(ids));
    }
}
