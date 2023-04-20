package com.ruoyi.biz.controller;

import com.ruoyi.biz.service.IWordFlagRelationService;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.biz.domain.WordFlag;
import com.ruoyi.biz.service.IWordFlagService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 单词标签Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/word_flag")
public class WordFlagController extends BaseController
{
    @Autowired
    private IWordFlagService wordFlagService;

    @Autowired
    private IWordFlagRelationService wordFlagRelationService;

    /**
     * 查询单词标签列表
     */
    @RequiresPermissions("system:flag:list")
    @GetMapping("/list")
    public TableDataInfo list(WordFlag wordFlag)
    {
        startPage();
        List<WordFlag> list = wordFlagService.selectWordFlagList(wordFlag);
        return getDataTable(list);
    }

    /**
     * 导出单词标签列表
     */
    @RequiresPermissions("system:flag:export")
    @Log(title = "单词标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordFlag wordFlag)
    {
        List<WordFlag> list = wordFlagService.selectWordFlagList(wordFlag);
        ExcelUtil<WordFlag> util = new ExcelUtil<WordFlag>(WordFlag.class);
        util.exportExcel(response, list, "单词标签数据");
    }

    /**
     * 获取单词标签详细信息
     */
    @RequiresPermissions("system:flag:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordFlagService.selectWordFlagById(id));
    }

    /**
     * 新增单词标签
     */
    @RequiresPermissions("system:flag:add")
    @Log(title = "单词标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WordFlag wordFlag)
    {
        return toAjax(wordFlagService.insertWordFlag(wordFlag));
    }

    /**
     * 修改单词标签
     */
    @RequiresPermissions("system:flag:edit")
    @Log(title = "单词标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody WordFlag wordFlag)
    {
        return toAjax(wordFlagService.updateWordFlag(wordFlag));
    }

    /**
     * 删除单词标签
     */
    @RequiresPermissions("system:flag:remove")
    @Log(title = "单词标签", businessType = BusinessType.DELETE)
	  @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordFlagService.deleteWordFlagByIds(ids));
    }

    /**
     * 根据 user_id、word_id、flag_id 删除单词标签关系信息
     */
    @RequiresPermissions("system:flag:remove")
    @Log(title = "单词标签", businessType = BusinessType.DELETE)
    @DeleteMapping("/word_flag_rela")
    public AjaxResult removeByUserIdAndWordIdAndFlagId(@RequestParam Long id,
      @RequestParam Long userId, @RequestParam Long wordId, @RequestParam Long flagId)
    {
        return toAjax(wordFlagRelationService.deleteWordFlagRelationByUserIdAndWordIdAndFlagId(id,userId, wordId, flagId));
    }


}
