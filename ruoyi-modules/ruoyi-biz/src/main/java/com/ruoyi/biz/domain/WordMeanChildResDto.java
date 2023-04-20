package com.ruoyi.biz.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 单词意思对象 word_mean
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordMeanChildResDto
{
    /** 词性 */
    private String wordType;

    /** 单词含义 */
    private String wordMean;
    
}
