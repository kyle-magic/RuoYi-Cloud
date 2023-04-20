package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.WordFlag;

/**
 * 单词标签Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface WordFlagMapper 
{
    /**
     * 查询单词标签
     * 
     * @param id 单词标签主键
     * @return 单词标签
     */
    public WordFlag selectWordFlagById(Long id);

    /**
     * 查询单词标签列表
     * 
     * @param wordFlag 单词标签
     * @return 单词标签集合
     */
    public List<WordFlag> selectWordFlagList(WordFlag wordFlag);

    /**
     * 新增单词标签
     * 
     * @param wordFlag 单词标签
     * @return 结果
     */
    public int insertWordFlag(WordFlag wordFlag);

    /**
     * 修改单词标签
     * 
     * @param wordFlag 单词标签
     * @return 结果
     */
    public int updateWordFlag(WordFlag wordFlag);

    /**
     * 删除单词标签
     * 
     * @param id 单词标签主键
     * @return 结果
     */
    public int deleteWordFlagById(Long id);

    /**
     * 批量删除单词标签
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWordFlagByIds(Long[] ids);
}
