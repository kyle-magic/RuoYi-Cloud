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
import com.ruoyi.biz.domain.WordRankList;
import com.ruoyi.biz.service.IWordRankListService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 排行榜Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/list")
public class WordRankListController extends BaseController
{
    @Autowired
    private IWordRankListService wordRankListService;

    /**
     * 查询排行榜列表
     */
    @RequiresPermissions("system:list:list")
    @GetMapping("/list")
    public TableDataInfo list(WordRankList wordRankList)
    {
        startPage();
        List<WordRankList> list = wordRankListService.selectWordRankListList(wordRankList);
        return getDataTable(list);
    }

    /**
     * 导出排行榜列表
     */
    @RequiresPermissions("system:list:export")
    @Log(title = "排行榜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordRankList wordRankList)
    {
        List<WordRankList> list = wordRankListService.selectWordRankListList(wordRankList);
        ExcelUtil<WordRankList> util = new ExcelUtil<WordRankList>(WordRankList.class);
        util.exportExcel(response, list, "排行榜数据");
    }

    /**
     * 获取排行榜详细信息
     */
    @RequiresPermissions("system:list:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordRankListService.selectWordRankListById(id));
    }

    /**
     * 新增排行榜
     */
    @RequiresPermissions("system:list:add")
    @Log(title = "排行榜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordRankList wordRankList)
    {
        return toAjax(wordRankListService.insertWordRankList(wordRankList));
    }

    /**
     * 修改排行榜
     */
    @RequiresPermissions("system:list:edit")
    @Log(title = "排行榜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordRankList wordRankList)
    {
        return toAjax(wordRankListService.updateWordRankList(wordRankList));
    }

    /**
     * 删除排行榜
     */
    @RequiresPermissions("system:list:remove")
    @Log(title = "排行榜", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordRankListService.deleteWordRankListByIds(ids));
    }
}
