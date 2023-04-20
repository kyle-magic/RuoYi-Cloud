package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.WordMean;

/**
 * 单词意思Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface WordMeanMapper 
{
    /**
     * 查询单词意思
     * 
     * @param id 单词意思主键
     * @return 单词意思
     */
    public WordMean selectWordMeanById(Long id);

    /**
     * 查询单词意思列表
     * 
     * @param wordMean 单词意思
     * @return 单词意思集合
     */
    public List<WordMean> selectWordMeanList(WordMean wordMean);

    /**
     * 新增单词意思
     * 
     * @param wordMean 单词意思
     * @return 结果
     */
    public int insertWordMean(WordMean wordMean);

    /**
     * 修改单词意思
     * 
     * @param wordMean 单词意思
     * @return 结果
     */
    public int updateWordMean(WordMean wordMean);

    /**
     * 删除单词意思
     * 
     * @param id 单词意思主键
     * @return 结果
     */
    public int deleteWordMeanById(Long id);

    /**
     * 批量删除单词意思
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWordMeanByIds(Long[] ids);

    /**
     * 批量新增单词意思
     *
     * @param wordMeanList 单词意思列表
     * @return 结果
     */
    public int insertWordMeanBatch(List<WordMean> wordMeanList);
}
