package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordMapper;
import com.ruoyi.biz.domain.Word;
import com.ruoyi.biz.service.IWordService;

/**
 * 单词Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class WordServiceImpl implements IWordService 
{
    @Autowired
    private WordMapper wordMapper;

    /**
     * 查询单词
     * 
     * @param id 单词主键
     * @return 单词
     */
    @Override
    public Word selectWordById(Long id)
    {
        return wordMapper.selectWordById(id);
    }

    /**
     * 查询单词列表
     * 
     * @param word 单词
     * @return 单词
     */
    @Override
    public List<Word> selectWordList(Word word)
    {
        return wordMapper.selectWordList(word);
    }

    /**
     * 新增单词
     * 
     * @param word 单词
     * @return 结果
     */
    @Override
    public int insertWord(Word word)
    {
        word.setCreateTime(DateUtils.getNowDate());
        return wordMapper.insertWord(word);
    }

    /**
     * 修改单词
     * 
     * @param word 单词
     * @return 结果
     */
    @Override
    public int updateWord(Word word)
    {
        word.setUpdateTime(DateUtils.getNowDate());
        return wordMapper.updateWord(word);
    }

    /**
     * 批量删除单词
     * 
     * @param ids 需要删除的单词主键
     * @return 结果
     */
    @Override
    public int deleteWordByIds(Long[] ids)
    {
        return wordMapper.deleteWordByIds(ids);
    }

    /**
     * 删除单词信息
     * 
     * @param id 单词主键
     * @return 结果
     */
    @Override
    public int deleteWordById(Long id)
    {
        return wordMapper.deleteWordById(id);
    }
}
