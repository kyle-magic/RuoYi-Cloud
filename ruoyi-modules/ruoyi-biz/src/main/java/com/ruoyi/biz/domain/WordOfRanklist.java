package com.ruoyi.biz.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 排行榜中的单词对象 word_of_ranklist
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordOfRanklist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 排行榜id */
    @Excel(name = "排行榜id")
    private Long rankListId;

    /** 单词id */
    @Excel(name = "单词id")
    private String wordId;

    /** 排行序号 */
    @Excel(name = "排行序号")
    private Integer rankNum;

    /** 删除标志（N未删除 Y删除 NONE未指定） */
    private String delFlag;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("rankListId", getRankListId())
            .append("wordId", getWordId())
            .append("rankNum", getRankNum())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
