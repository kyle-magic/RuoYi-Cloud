package com.ruoyi.biz.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单词对象 word
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class Word extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 单词含义冗余 */
    @Excel(name = "单词含义冗余")
    private String wordMeanRedundancy;
}
