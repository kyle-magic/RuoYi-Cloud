package com.ruoyi.biz.controller;

import com.ruoyi.biz.domain.WordOfRanklistReqDto;
import com.ruoyi.biz.domain.WordOfRanklistResDto;
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
import com.ruoyi.biz.domain.WordOfRanklist;
import com.ruoyi.biz.service.IWordOfRanklistService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 排行榜中的单词Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/word_of_ranklist")
public class WordOfRanklistController extends BaseController
{
    @Autowired
    private IWordOfRanklistService wordOfRanklistService;

    /**
     * 查询排行榜中的单词列表
     */
    /*@RequiresPermissions("system:ranklist:list")*/
    @GetMapping("/list")
    public TableDataInfo list(WordOfRanklistReqDto wordOfRanklistReqDto)
    {
        startPage();
        List<WordOfRanklistResDto> list = wordOfRanklistService.selectWordOfRanklist(wordOfRanklistReqDto);
        return getDataTable(list);
    }

    /**
     * 导出排行榜中的单词列表
     */
    @RequiresPermissions("system:ranklist:export")
    @Log(title = "排行榜中的单词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordOfRanklist wordOfRanklist)
    {
        List<WordOfRanklist> list = wordOfRanklistService.selectWordOfRanklistList(wordOfRanklist);
        ExcelUtil<WordOfRanklist> util = new ExcelUtil<WordOfRanklist>(WordOfRanklist.class);
        util.exportExcel(response, list, "排行榜中的单词数据");
    }

    /**
     * 获取排行榜中的单词详细信息
     */
    @RequiresPermissions("system:ranklist:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordOfRanklistService.selectWordOfRanklistById(id));
    }

    /**
     * 新增排行榜中的单词
     */
    @RequiresPermissions("system:ranklist:add")
    @Log(title = "排行榜中的单词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordOfRanklist wordOfRanklist)
    {
        return toAjax(wordOfRanklistService.insertWordOfRanklist(wordOfRanklist));
    }

    /**
     * 修改排行榜中的单词
     */
    @RequiresPermissions("system:ranklist:edit")
    @Log(title = "排行榜中的单词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordOfRanklist wordOfRanklist)
    {
        return toAjax(wordOfRanklistService.updateWordOfRanklist(wordOfRanklist));
    }

    /**
     * 删除排行榜中的单词
     */
    @RequiresPermissions("system:ranklist:remove")
    @Log(title = "排行榜中的单词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordOfRanklistService.deleteWordOfRanklistByIds(ids));
    }
}
