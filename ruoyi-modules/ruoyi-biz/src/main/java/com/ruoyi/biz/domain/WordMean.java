package com.ruoyi.biz.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单词意思对象 word_mean
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordMean extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 单词id */
    @Excel(name = "单词id")
    private Long wordId;

    /** 词性 */
    @Excel(name = "词性")
    private String wordType;

    /** 单词含义 */
    @Excel(name = "单词含义")
    private String wordMean;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("word", getWord())
            .append("wordId", getWordId())
            .append("wordType", getWordType())
            .append("wordMean", getWordMean())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
