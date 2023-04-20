package com.ruoyi.biz.service;

import com.ruoyi.biz.domain.WordOfRanklistReqDto;
import com.ruoyi.biz.domain.WordOfRanklistResDto;
import java.util.List;
import com.ruoyi.biz.domain.WordOfRanklist;

/**
 * 排行榜中的单词Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IWordOfRanklistService 
{
    /**
     * 查询排行榜中的单词
     * 
     * @param id 排行榜中的单词主键
     * @return 排行榜中的单词
     */
    public WordOfRanklist selectWordOfRanklistById(Long id);

    /**
     * 查询排行榜中的单词列表
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 排行榜中的单词集合
     */
    public List<WordOfRanklist> selectWordOfRanklistList(WordOfRanklist wordOfRanklist);

    /**
     * 新增排行榜中的单词
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 结果
     */
    public int insertWordOfRanklist(WordOfRanklist wordOfRanklist);

    /**
     * 修改排行榜中的单词
     * 
     * @param wordOfRanklist 排行榜中的单词
     * @return 结果
     */
    public int updateWordOfRanklist(WordOfRanklist wordOfRanklist);

    /**
     * 批量删除排行榜中的单词
     * 
     * @param ids 需要删除的排行榜中的单词主键集合
     * @return 结果
     */
    public int deleteWordOfRanklistByIds(Long[] ids);

    /**
     * 删除排行榜中的单词信息
     * 
     * @param id 排行榜中的单词主键
     * @return 结果
     */
    public int deleteWordOfRanklistById(Long id);

    public List<WordOfRanklistResDto> selectWordOfRanklist(
      WordOfRanklistReqDto wordOfRanklistReqDto);
}
