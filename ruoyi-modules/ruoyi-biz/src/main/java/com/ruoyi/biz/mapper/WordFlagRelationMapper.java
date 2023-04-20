package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.WordFlagRelation;

/**
 * 单词标签关系Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface WordFlagRelationMapper 
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
     * 删除单词标签关系
     * 
     * @param id 单词标签关系主键
     * @return 结果
     */
    public int deleteWordFlagRelationById(Long id);

    /**
     * 批量删除单词标签关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWordFlagRelationByIds(Long[] ids);

    /**
     * 根据 user_id、word_id、flag_id 删除单词标签关系信息
     *
     * @param wordFlagRelation 单词标签关系
     * @return 结果
     */
    public int deleteWordFlagRelationByUserIdAndWordIdAndFlagId(WordFlagRelation wordFlagRelation);
}
