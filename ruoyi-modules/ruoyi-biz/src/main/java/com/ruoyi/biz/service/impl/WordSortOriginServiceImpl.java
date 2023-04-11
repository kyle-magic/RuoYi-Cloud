package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordSortOriginMapper;
import com.ruoyi.biz.domain.WordSortOrigin;
import com.ruoyi.biz.service.IWordSortOriginService;

/**
 * 单词排行榜Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Service
public class WordSortOriginServiceImpl implements IWordSortOriginService 
{
    @Autowired
    private WordSortOriginMapper wordSortOriginMapper;

    /**
     * 查询单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 单词排行榜
     */
    @Override
    public WordSortOrigin selectWordSortOriginById(Long id)
    {
        return wordSortOriginMapper.selectWordSortOriginById(id);
    }

    /**
     * 查询单词排行榜列表
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 单词排行榜
     */
    @Override
    public List<WordSortOrigin> selectWordSortOriginList(WordSortOrigin wordSortOrigin)
    {
        return wordSortOriginMapper.selectWordSortOriginList(wordSortOrigin);
    }

    /**
     * 新增单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    @Override
    public int insertWordSortOrigin(WordSortOrigin wordSortOrigin)
    {
        wordSortOrigin.setCreateTime(DateUtils.getNowDate());
        return wordSortOriginMapper.insertWordSortOrigin(wordSortOrigin);
    }

    /**
     * 修改单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    @Override
    public int updateWordSortOrigin(WordSortOrigin wordSortOrigin)
    {
        wordSortOrigin.setUpdateTime(DateUtils.getNowDate());
        return wordSortOriginMapper.updateWordSortOrigin(wordSortOrigin);
    }

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortOriginByIds(Long[] ids)
    {
        return wordSortOriginMapper.deleteWordSortOriginByIds(ids);
    }

    /**
     * 删除单词排行榜信息
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortOriginById(Long id)
    {
        return wordSortOriginMapper.deleteWordSortOriginById(id);
    }
}
