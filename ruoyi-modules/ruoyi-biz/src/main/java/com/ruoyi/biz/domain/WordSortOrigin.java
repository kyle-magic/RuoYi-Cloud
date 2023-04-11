package com.ruoyi.biz.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单词排行榜对象 word_sort_origin
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Data
public class WordSortOrigin extends BaseEntity
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

    /** 单词获取结果 */
    @Excel(name = "单词获取结果")
    private String wordInfo;

    /** 排行榜id */
    @Excel(name = "排行榜id")
    private Integer sortId;

}
