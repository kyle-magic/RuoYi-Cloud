package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.WordRankList;

/**
 * 排行榜Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IWordRankListService 
{
    /**
     * 查询排行榜
     * 
     * @param id 排行榜主键
     * @return 排行榜
     */
    public WordRankList selectWordRankListById(Long id);

    /**
     * 查询排行榜列表
     * 
     * @param wordRankList 排行榜
     * @return 排行榜集合
     */
    public List<WordRankList> selectWordRankListList(WordRankList wordRankList);

    /**
     * 新增排行榜
     * 
     * @param wordRankList 排行榜
     * @return 结果
     */
    public int insertWordRankList(WordRankList wordRankList);

    /**
     * 修改排行榜
     * 
     * @param wordRankList 排行榜
     * @return 结果
     */
    public int updateWordRankList(WordRankList wordRankList);

    /**
     * 批量删除排行榜
     * 
     * @param ids 需要删除的排行榜主键集合
     * @return 结果
     */
    public int deleteWordRankListByIds(Long[] ids);

    /**
     * 删除排行榜信息
     * 
     * @param id 排行榜主键
     * @return 结果
     */
    public int deleteWordRankListById(Long id);
}
