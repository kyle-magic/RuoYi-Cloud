package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordMeanMapper;
import com.ruoyi.biz.domain.WordMean;
import com.ruoyi.biz.service.IWordMeanService;

/**
 * 单词意思Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordMeanServiceImpl implements IWordMeanService 
{
    @Autowired
    private WordMeanMapper wordMeanMapper;

    /**
     * 查询单词意思
     * 
     * @param id 单词意思主键
     * @return 单词意思
     */
    @Override
    public WordMean selectWordMeanById(Long id)
    {
        return wordMeanMapper.selectWordMeanById(id);
    }

    /**
     * 查询单词意思列表
     * 
     * @param wordMean 单词意思
     * @return 单词意思
     */
    @Override
    public List<WordMean> selectWordMeanList(WordMean wordMean)
    {
        return wordMeanMapper.selectWordMeanList(wordMean);
    }

    /**
     * 新增单词意思
     * 
     * @param wordMean 单词意思
     * @return 结果
     */
    @Override
    public int insertWordMean(WordMean wordMean)
    {
        wordMean.setCreateTime(DateUtils.getNowDate());
        return wordMeanMapper.insertWordMean(wordMean);
    }

    /**
     * 修改单词意思
     * 
     * @param wordMean 单词意思
     * @return 结果
     */
    @Override
    public int updateWordMean(WordMean wordMean)
    {
        wordMean.setUpdateTime(DateUtils.getNowDate());
        return wordMeanMapper.updateWordMean(wordMean);
    }

    /**
     * 批量删除单词意思
     * 
     * @param ids 需要删除的单词意思主键
     * @return 结果
     */
    @Override
    public int deleteWordMeanByIds(Long[] ids)
    {
        return wordMeanMapper.deleteWordMeanByIds(ids);
    }

    /**
     * 删除单词意思信息
     * 
     * @param id 单词意思主键
     * @return 结果
     */
    @Override
    public int deleteWordMeanById(Long id)
    {
        return wordMeanMapper.deleteWordMeanById(id);
    }
}
