package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.WordSort;

/**
 * 单词排行榜Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public interface WordSortMapper 
{
    /**
     * 查询单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 单词排行榜
     */
    public WordSort selectWordSortById(Long id);

    /**
     * 查询单词排行榜列表
     * 
     * @param wordSort 单词排行榜
     * @return 单词排行榜集合
     */
    public List<WordSort> selectWordSortList(WordSort wordSort);

    /**
     * 新增单词排行榜
     * 
     * @param wordSort 单词排行榜
     * @return 结果
     */
    public int insertWordSort(WordSort wordSort);

    /**
     * 修改单词排行榜
     * 
     * @param wordSort 单词排行榜
     * @return 结果
     */
    public int updateWordSort(WordSort wordSort);

    /**
     * 删除单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    public int deleteWordSortById(Long id);

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWordSortByIds(Long[] ids);

    /**
     * 批量插入单词排行榜
     *
     * @param wordSorts 单词排行榜
     * @return 结果
     *
     */
    public int insertWordSortBatch(List<WordSort> wordSorts);

    /**
     * 当前最大的sort
     *
     * @param sordId 单词排行榜
     * @return 结果
     */
    public int selectMaxSort(Long sordId);
}
