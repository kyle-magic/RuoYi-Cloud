package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordSortMapper;
import com.ruoyi.biz.domain.WordSort;
import com.ruoyi.biz.service.IWordSortService;

/**
 * 单词排行榜Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Service
public class WordSortServiceImpl implements IWordSortService 
{
    @Autowired
    private WordSortMapper wordSortMapper;

    /**
     * 查询单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 单词排行榜
     */
    @Override
    public WordSort selectWordSortById(Long id)
    {
        return wordSortMapper.selectWordSortById(id);
    }

    /**
     * 查询单词排行榜列表
     * 
     * @param wordSort 单词排行榜
     * @return 单词排行榜
     */
    @Override
    public List<WordSort> selectWordSortList(WordSort wordSort)
    {
        return wordSortMapper.selectWordSortList(wordSort);
    }

    /**
     * 新增单词排行榜
     * 
     * @param wordSort 单词排行榜
     * @return 结果
     */
    @Override
    public int insertWordSort(WordSort wordSort)
    {
        wordSort.setCreateTime(DateUtils.getNowDate());
        return wordSortMapper.insertWordSort(wordSort);
    }

    /**
     * 修改单词排行榜
     * 
     * @param wordSort 单词排行榜
     * @return 结果
     */
    @Override
    public int updateWordSort(WordSort wordSort)
    {
        wordSort.setUpdateTime(DateUtils.getNowDate());
        return wordSortMapper.updateWordSort(wordSort);
    }

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortByIds(Long[] ids)
    {
        return wordSortMapper.deleteWordSortByIds(ids);
    }

    /**
     * 删除单词排行榜信息
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortById(Long id)
    {
        return wordSortMapper.deleteWordSortById(id);
    }

    /**
     * 批量插入单词排行榜
     */
    @Override
    public int insertWordSortBatch(List<WordSort> wordSortList) {
        return wordSortMapper.insertWordSortBatch(wordSortList);
    }

    /**
     * 当前最大的sort
     *
     * @param sordId 单词排行榜
     * @return 结果
     */
    public int selectMaxSort(Long sordId) {
        return wordSortMapper.selectMaxSort(sordId);
    }
}
