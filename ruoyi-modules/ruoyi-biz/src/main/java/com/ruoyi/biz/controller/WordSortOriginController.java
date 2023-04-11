package com.ruoyi.biz.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.biz.domain.WordSortOrigin;
import com.ruoyi.biz.service.IWordSortOriginService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 单词排行榜Controller
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/origin")
public class WordSortOriginController extends BaseController
{
    @Autowired
    private IWordSortOriginService wordSortOriginService;

    /**
     * 查询单词排行榜列表
     */
    @RequiresPermissions("system:origin:list")
    @GetMapping("/list")
    public TableDataInfo list(WordSortOrigin wordSortOrigin)
    {
        startPage();
        List<WordSortOrigin> list = wordSortOriginService.selectWordSortOriginList(wordSortOrigin);
        return getDataTable(list);
    }

    /**
     * 导出单词排行榜列表
     */
    @RequiresPermissions("system:origin:export")
    @Log(title = "单词排行榜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordSortOrigin wordSortOrigin)
    {
        List<WordSortOrigin> list = wordSortOriginService.selectWordSortOriginList(wordSortOrigin);
        ExcelUtil<WordSortOrigin> util = new ExcelUtil<WordSortOrigin>(WordSortOrigin.class);
        util.exportExcel(response, list, "单词排行榜数据");
    }

    /**
     * 获取单词排行榜详细信息
     */
    @RequiresPermissions("system:origin:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordSortOriginService.selectWordSortOriginById(id));
    }

    /**
     * 新增单词排行榜
     */
    @RequiresPermissions("system:origin:add")
    @Log(title = "单词排行榜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordSortOrigin wordSortOrigin)
    {
        return toAjax(wordSortOriginService.insertWordSortOrigin(wordSortOrigin));
    }

    /**
     * 修改单词排行榜
     */
    @RequiresPermissions("system:origin:edit")
    @Log(title = "单词排行榜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordSortOrigin wordSortOrigin)
    {
        return toAjax(wordSortOriginService.updateWordSortOrigin(wordSortOrigin));
    }

    /**
     * 删除单词排行榜
     */
    @RequiresPermissions("system:origin:remove")
    @Log(title = "单词排行榜", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordSortOriginService.deleteWordSortOriginByIds(ids));
    }
}
