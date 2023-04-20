package com.ruoyi.biz.service.impl;

import com.ruoyi.biz.domain.WordOfRanklistReqDto;
import com.ruoyi.biz.domain.WordOfRanklistResDto;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordOfRanklistMapper;
import com.ruoyi.biz.domain.WordOfRanklist;
import com.ruoyi.biz.service.IWordOfRanklistService;

/**
 * 排行榜中的单词Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordOfRanklistServiceImpl implements IWordOfRanklistService 
{
    @Autowired
    private WordOfRanklistMapper wordOfRanklistMapper;

    /**
     * 查询排行榜中的单词
     * 
     * @param id 排行榜中的单词主键
     * @return 排行榜中的单词
     */
    @Override
    public WordOfRanklist selectWordOfRanklistById(Long id)
    {
        return wordOfRanklistMapper.selectWordOfRanklistById(id);
    }

    /**
     * 查询排行榜中的单词列表
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 排行榜中的单词
     */
    @Override
    public List<WordOfRanklist> selectWordOfRanklistList(WordOfRanklist wordOfRanklist)
    {
        return wordOfRanklistMapper.selectWordOfRanklistList(wordOfRanklist);
    }

    /**
     * 新增排行榜中的单词
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 结果
     */
    @Override
    public int insertWordOfRanklist(WordOfRanklist wordOfRanklist)
    {
        wordOfRanklist.setCreateTime(DateUtils.getNowDate());
        return wordOfRanklistMapper.insertWordOfRanklist(wordOfRanklist);
    }

    /**
     * 修改排行榜中的单词
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 结果
     */
    @Override
    public int updateWordOfRanklist(WordOfRanklist wordOfRanklist)
    {
        wordOfRanklist.setUpdateTime(DateUtils.getNowDate());
        return wordOfRanklistMapper.updateWordOfRanklist(wordOfRanklist);
    }

    /**
     * 批量删除排行榜中的单词
     * 
     * @param ids 需要删除的排行榜中的单词主键
     * @return 结果
     */
    @Override
    public int deleteWordOfRanklistByIds(Long[] ids)
    {
        return wordOfRanklistMapper.deleteWordOfRanklistByIds(ids);
    }

    /**
     * 删除排行榜中的单词信息
     * 
     * @param id 排行榜中的单词主键
     * @return 结果
     */
    @Override
    public int deleteWordOfRanklistById(Long id)
    {
        return wordOfRanklistMapper.deleteWordOfRanklistById(id);
    }

    public List<WordOfRanklistResDto> selectWordOfRanklist(
      WordOfRanklistReqDto wordOfRanklistReqDto){
        return wordOfRanklistMapper.selectWordOfRanklist(wordOfRanklistReqDto);
    }
}
