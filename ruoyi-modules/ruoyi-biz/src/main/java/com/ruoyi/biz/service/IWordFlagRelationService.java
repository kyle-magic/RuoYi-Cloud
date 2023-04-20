package com.ruoyi.biz.service;

import com.ruoyi.biz.domain.WordOfRanklistReqDto;
import com.ruoyi.biz.domain.WordOfRanklistResDto;
import java.util.List;
import com.ruoyi.biz.domain.WordFlagRelation;

/**
 * 单词标签关系Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IWordFlagRelationService 
{
    /**
     * 查询单词标签关系
     * 
     * @param id 单词标签关系主键
     * @return 单词标签关系
     */
    public WordFlagRelation selectWordFlagRelationById(Long id);

    /**
     * 查询单词标签关系列表
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 单词标签关系集合
     */
    public List<WordFlagRelation> selectWordFlagRelationList(WordFlagRelation wordFlagRelation);

    /**
     * 新增单词标签关系
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 结果
     */
    public int insertWordFlagRelation(WordFlagRelation wordFlagRelation);

    /**
     * 修改单词标签关系
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 结果
     */
    public int updateWordFlagRelation(WordFlagRelation wordFlagRelation);

    /**
     * 批量删除单词标签关系
     * 
     * @param ids 需要删除的单词标签关系主键集合
     * @return 结果
     */
    public int deleteWordFlagRelationByIds(Long[] ids);

    /**
     * 删除单词标签关系信息
     * 
     * @param id 单词标签关系主键
     * @return 结果
     */
    public int deleteWordFlagRelationById(Long id);

    /**
     * 根据 user_id、word_id、flag_id 删除单词标签关系信息
     *
     * @return 结果
     */
    public int deleteWordFlagRelationByUserIdAndWordIdAndFlagId(Long id, Long userId,Long  wordId,Long  flagId);


}
