package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordFlagMapper;
import com.ruoyi.biz.domain.WordFlag;
import com.ruoyi.biz.service.IWordFlagService;

/**
 * 单词标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordFlagServiceImpl implements IWordFlagService 
{
    @Autowired
    private WordFlagMapper wordFlagMapper;

    /**
     * 查询单词标签
     * 
     * @param id 单词标签主键
     * @return 单词标签
     */
    @Override
    public WordFlag selectWordFlagById(Long id)
    {
        return wordFlagMapper.selectWordFlagById(id);
    }

    /**
     * 查询单词标签列表
     * 
     * @param wordFlag 单词标签
     * @return 单词标签
     */
    @Override
    public List<WordFlag> selectWordFlagList(WordFlag wordFlag)
    {
        return wordFlagMapper.selectWordFlagList(wordFlag);
    }

    /**
     * 新增单词标签
     * 
     * @param wordFlag 单词标签
     * @return 结果
     */
    @Override
    public int insertWordFlag(WordFlag wordFlag)
    {
        wordFlag.setCreateTime(DateUtils.getNowDate());
        return wordFlagMapper.insertWordFlag(wordFlag);
    }

    /**
     * 修改单词标签
     * 
     * @param wordFlag 单词标签
     * @return 结果
     */
    @Override
    public int updateWordFlag(WordFlag wordFlag)
    {
        if (Objects.isNull(wordFlag.getId())) {
            throw new IllegalArgumentException("id is null");
        }
        wordFlag.setUpdateTime(DateUtils.getNowDate());
        return wordFlagMapper.updateWordFlag(wordFlag);
    }

    /**
     * 批量删除单词标签
     * 
     * @param ids 需要删除的单词标签主键
     * @return 结果
     */
    @Override
    public int deleteWordFlagByIds(Long[] ids)
    {
        throw new UnsupportedOperationException("not support");
        /*return wordFlagMapper.deleteWordFlagByIds(ids);*/
    }

    /**
     * 删除单词标签信息
     * 
     * @param id 单词标签主键
     * @return 结果
     */
    @Override
    public int deleteWordFlagById(Long id)
    {
        WordFlag flag = wordFlagMapper.selectWordFlagById(id);
        if (flag.getCreateBy().equals("system")) {
            throw new IllegalArgumentException("不能删除系统标签");
        }
        return wordFlagMapper.deleteWordFlagById(id);
    }
}
