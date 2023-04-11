package com.ruoyi.biz.controller;

import java.util.List;
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
import com.ruoyi.biz.domain.WordSort;
import com.ruoyi.biz.service.IWordSortService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单词排行榜Controller
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/sort")
public class WordSortController extends BaseController
{
    @Autowired
    private IWordSortService wordSortService;

    /**
     * 查询单词排行榜列表
     */
    @RequiresPermissions("system:sort:list")
    @GetMapping("/list")
    public TableDataInfo list(WordSort wordSort)
    {
        startPage();
        List<WordSort> list = wordSortService.selectWordSortList(wordSort);
        return getDataTable(list);
    }

    /**
     * 导出单词排行榜列表
     */
    @RequiresPermissions("system:sort:export")
    @Log(title = "单词排行榜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WordSort wordSort)
    {
        List<WordSort> list = wordSortService.selectWordSortList(wordSort);
        ExcelUtil<WordSort> util = new ExcelUtil<WordSort>(WordSort.class);
        util.exportExcel(response, list, "单词排行榜数据");
    }

    /**
     * 导入单词排行榜列表
     */
    @RequiresPermissions("system:sort:import")
    @Log(title = "单词排行榜", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<WordSort> util = new ExcelUtil<WordSort>(WordSort.class);
        List<WordSort> wordSortList = util.importExcel(file.getInputStream());
        int count = wordSortService.insertWordSortBatch(wordSortList);
        return AjaxResult.success(count);
    }

    /**
     * 获取单词排行榜详细信息
     */
    @RequiresPermissions("system:sort:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wordSortService.selectWordSortById(id));
    }

    /**
     * 新增单词排行榜
     */
    @RequiresPermissions("system:sort:add")
    @Log(title = "单词排行榜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordSort wordSort)
    {
        return toAjax(wordSortService.insertWordSort(wordSort));
    }

    /**
     * 修改单词排行榜
     */
    @RequiresPermissions("system:sort:edit")
    @Log(title = "单词排行榜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordSort wordSort)
    {
        return toAjax(wordSortService.updateWordSort(wordSort));
    }

    /**
     * 删除单词排行榜
     */
    @RequiresPermissions("system:sort:remove")
    @Log(title = "单词排行榜", businessType = BusinessType.DELETE)
	  @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordSortService.deleteWordSortByIds(ids));
    }
}
