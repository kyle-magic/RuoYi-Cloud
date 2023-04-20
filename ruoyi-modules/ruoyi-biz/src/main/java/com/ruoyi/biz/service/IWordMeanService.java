package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.WordMean;

/**
 * 单词意思Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IWordMeanService 
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
     * 批量删除单词意思
     * 
     * @param ids 需要删除的单词意思主键集合
     * @return 结果
     */
    public int deleteWordMeanByIds(Long[] ids);

    /**
     * 删除单词意思信息
     * 
     * @param id 单词意思主键
     * @return 结果
     */
    public int deleteWordMeanById(Long id);
}
