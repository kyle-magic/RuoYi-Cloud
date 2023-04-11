package com.ruoyi.biz.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 单词排行榜对象 word_sort
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Data
public class WordSort extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    private Long id;

    /** 单词顺序 */
    @Excel(name = "单词顺序")
    private Long sort;

    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 单词类型 */
    @Excel(name = "单词类型")
    private String wordType;

    /** 排行榜id */
    @Excel(name = "排行榜id")
    private Integer sortId;
}
