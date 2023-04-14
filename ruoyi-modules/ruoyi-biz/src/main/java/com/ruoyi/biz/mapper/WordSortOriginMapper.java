package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.WordSortOrigin;

/**
 * 单词排行榜Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public interface WordSortOriginMapper 
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

    public List<WordSortOrigin> selectWordSortEmpty(WordSortOrigin wordSortOrigin);


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
     * 删除单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    public int deleteWordSortOriginById(Long id);

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWordSortOriginByIds(Long[] ids);

    /**
     * 批量插入
     * @param wordSortOriginList
     * @return
     */
    public int insertWordSortOriginBatch(List<WordSortOrigin> wordSortOriginList);

/**
     * 批量更新
     * @param wordSortOriginList
     * @return
     */
    public int updateWordSortOriginBatch(List<WordSortOrigin> wordSortOriginList);

}
