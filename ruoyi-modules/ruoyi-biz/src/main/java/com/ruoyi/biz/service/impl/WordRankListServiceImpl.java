package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordRankListMapper;
import com.ruoyi.biz.domain.WordRankList;
import com.ruoyi.biz.service.IWordRankListService;

/**
 * 排行榜Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordRankListServiceImpl implements IWordRankListService 
{
    @Autowired
    private WordRankListMapper wordRankListMapper;

    /**
     * 查询排行榜
     * 
     * @param id 排行榜主键
     * @return 排行榜
     */
    @Override
    public WordRankList selectWordRankListById(Long id)
    {
        return wordRankListMapper.selectWordRankListById(id);
    }

    /**
     * 查询排行榜列表
     * 
     * @param wordRankList 排行榜
     * @return 排行榜
     */
    @Override
    public List<WordRankList> selectWordRankListList(WordRankList wordRankList)
    {
        return wordRankListMapper.selectWordRankListList(wordRankList);
    }

    /**
     * 新增排行榜
     * 
     * @param wordRankList 排行榜
     * @return 结果
     */
    @Override
    public int insertWordRankList(WordRankList wordRankList)
    {
        wordRankList.setCreateTime(DateUtils.getNowDate());
        return wordRankListMapper.insertWordRankList(wordRankList);
    }

    /**
     * 修改排行榜
     * 
     * @param wordRankList 排行榜
     * @return 结果
     */
    @Override
    public int updateWordRankList(WordRankList wordRankList)
    {
        wordRankList.setUpdateTime(DateUtils.getNowDate());
        return wordRankListMapper.updateWordRankList(wordRankList);
    }

    /**
     * 批量删除排行榜
     * 
     * @param ids 需要删除的排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordRankListByIds(Long[] ids)
    {
        return wordRankListMapper.deleteWordRankListByIds(ids);
    }

    /**
     * 删除排行榜信息
     * 
     * @param id 排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordRankListById(Long id)
    {
        return wordRankListMapper.deleteWordRankListById(id);
    }
}
