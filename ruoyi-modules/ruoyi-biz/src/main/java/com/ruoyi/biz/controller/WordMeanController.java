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
import com.ruoyi.biz.domain.WordMean;
import com.ruoyi.biz.service.IWordMeanService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 单词意思Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/word_mean")
public class WordMeanController extends BaseController
{
    @Autowired
    private IWordMeanService wordMeanService;

    /**
     * 查询单词意思列表
     */
    @RequiresPermissions("system:mean:list")
    @GetMapping("/list")
    public TableDataInfo list(WordMean wordMean)
    {
        startPage();
        List<WordMean> list = wordMeanService.selectWordMeanList(wordMean);
        return getDataTable(list);
    }

    /**
     * 导出单词意思列表
     */
    @RequiresPermissions("system:mean:export")
    @Log(title = "单词意思", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordMean wordMean)
    {
        List<WordMean> list = wordMeanService.selectWordMeanList(wordMean);
        ExcelUtil<WordMean> util = new ExcelUtil<WordMean>(WordMean.class);
        util.exportExcel(response, list, "单词意思数据");
    }

    /**
     * 获取单词意思详细信息
     */
    @RequiresPermissions("system:mean:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordMeanService.selectWordMeanById(id));
    }

    /**
     * 新增单词意思
     */
    @RequiresPermissions("system:mean:add")
    @Log(title = "单词意思", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordMean wordMean)
    {
        return toAjax(wordMeanService.insertWordMean(wordMean));
    }

    /**
     * 修改单词意思
     */
    @RequiresPermissions("system:mean:edit")
    @Log(title = "单词意思", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordMean wordMean)
    {
        return toAjax(wordMeanService.updateWordMean(wordMean));
    }

    /**
     * 删除单词意思
     */
    @RequiresPermissions("system:mean:remove")
    @Log(title = "单词意思", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordMeanService.deleteWordMeanByIds(ids));
    }
}
