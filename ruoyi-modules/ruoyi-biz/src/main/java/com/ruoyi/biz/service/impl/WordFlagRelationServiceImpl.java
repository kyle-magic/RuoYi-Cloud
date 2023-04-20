package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordFlagRelationMapper;
import com.ruoyi.biz.domain.WordFlagRelation;
import com.ruoyi.biz.service.IWordFlagRelationService;

/**
 * 单词标签关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordFlagRelationServiceImpl implements IWordFlagRelationService 
{
    @Autowired
    private WordFlagRelationMapper wordFlagRelationMapper;

    /**
     * 查询单词标签关系
     * 
     * @param id 单词标签关系主键
     * @return 单词标签关系
     */
    @Override
    public WordFlagRelation selectWordFlagRelationById(Long id)
    {
        return wordFlagRelationMapper.selectWordFlagRelationById(id);
    }

    /**
     * 查询单词标签关系列表
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 单词标签关系
     */
    @Override
    public List<WordFlagRelation> selectWordFlagRelationList(WordFlagRelation wordFlagRelation)
    {
        return wordFlagRelationMapper.selectWordFlagRelationList(wordFlagRelation);
    }

    /**
     * 新增单词标签关系
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 结果
     */
    @Override
    public int insertWordFlagRelation(WordFlagRelation wordFlagRelation)
    {
        wordFlagRelation.setCreateTime(DateUtils.getNowDate());
        return wordFlagRelationMapper.insertWordFlagRelation(wordFlagRelation);
    }

    /**
     * 修改单词标签关系
     * 
     * @param wordFlagRelation 单词标签关系
     * @return 结果
     */
    @Override
    public int updateWordFlagRelation(WordFlagRelation wordFlagRelation)
    {
        wordFlagRelation.setUpdateTime(DateUtils.getNowDate());
        return wordFlagRelationMapper.updateWordFlagRelation(wordFlagRelation);
    }

    /**
     * 批量删除单词标签关系
     * 
     * @param ids 需要删除的单词标签关系主键
     * @return 结果
     */
    @Override
    public int deleteWordFlagRelationByIds(Long[] ids)
    {
        return wordFlagRelationMapper.deleteWordFlagRelationByIds(ids);
    }

    /**
     * 删除单词标签关系信息
     * 
     * @param id 单词标签关系主键
     * @return 结果
     */
    @Override
    public int deleteWordFlagRelationById(Long id)
    {
        return wordFlagRelationMapper.deleteWordFlagRelationById(id);
    }

    /**
     * 根据 user_id、word_id、flag_id 删除单词标签关系信息
     *
     * @return 结果
     */
    @Override
    public int deleteWordFlagRelationByUserIdAndWordIdAndFlagId(Long id, Long userId,Long  wordId,Long  flagId)
    {
        WordFlagRelation rela = wordFlagRelationMapper.selectWordFlagRelationById(id);
        if (rela.getCreateBy().equals("system")) {
            throw new RuntimeException("系统标签不可删除");
        }

        WordFlagRelation wordFlagRelation = new WordFlagRelation();
        wordFlagRelation.setUserId(userId);
        wordFlagRelation.setWordId(wordId);
        wordFlagRelation.setFlagId(flagId);
        return wordFlagRelationMapper.deleteWordFlagRelationByUserIdAndWordIdAndFlagId(wordFlagRelation);
    }
}
