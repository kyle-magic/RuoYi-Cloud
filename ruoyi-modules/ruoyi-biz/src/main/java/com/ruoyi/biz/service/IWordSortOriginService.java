package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.WordSortOrigin;

/**
 * 单词排行榜Service接口
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public interface IWordSortOriginService 
{
    /**
     * 查询单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 单词排行榜
     */
    public WordSortOrigin selectWordSortOriginById(Long id);

    /**
     * 查询单词排行榜列表
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 单词排行榜集合
     */
    public List<WordSortOrigin> selectWordSortOriginList(WordSortOrigin wordSortOrigin);

    /**
     * 新增单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    public int insertWordSortOrigin(WordSortOrigin wordSortOrigin);

    /**
     * 修改单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    public int updateWordSortOrigin(WordSortOrigin wordSortOrigin);

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的单词排行榜主键集合
     * @return 结果
     */
    public int deleteWordSortOriginByIds(Long[] ids);

    /**
     * 删除单词排行榜信息
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    public int deleteWordSortOriginById(Long id);

    /**
     * 根据index开始爬取数据
     *
     * @param index
     * @return 结果
     */
    public int startCrawl(int index);

    /**
     * 解析wordMean
     */
    public Integer parseWordMean(Integer index);

    public Integer redundancyWordMean(Integer index);
}
