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
import com.ruoyi.biz.domain.Word;
import com.ruoyi.biz.service.IWordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 单词Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/word")
public class WordController extends BaseController
{
    @Autowired
    private IWordService wordService;

    /**
     * 查询单词列表
     */
    @RequiresPermissions("system:word:list")
    @GetMapping("/list")
    public TableDataInfo list(Word word)
    {
        startPage();
        List<Word> list = wordService.selectWordList(word);
        return getDataTable(list);
    }

    /**
     * 导出单词列表
     */
    @RequiresPermissions("system:word:export")
    @Log(title = "单词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Word word)
    {
        List<Word> list = wordService.selectWordList(word);
        ExcelUtil<Word> util = new ExcelUtil<Word>(Word.class);
        util.exportExcel(response, list, "单词数据");
    }

    /**
     * 获取单词详细信息
     */
    @RequiresPermissions("system:word:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordService.selectWordById(id));
    }

    /**
     * 新增单词
     */
    @RequiresPermissions("system:word:add")
    @Log(title = "单词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Word word)
    {
        return toAjax(wordService.insertWord(word));
    }

    /**
     * 修改单词
     */
    @RequiresPermissions("system:word:edit")
    @Log(title = "单词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Word word)
    {
        return toAjax(wordService.updateWord(word));
    }

    /**
     * 删除单词
     */
    @RequiresPermissions("system:word:remove")
    @Log(title = "单词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordService.deleteWordByIds(ids));
    }
}
