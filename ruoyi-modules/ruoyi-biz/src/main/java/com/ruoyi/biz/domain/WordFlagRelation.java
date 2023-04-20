package com.ruoyi.biz.domain;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单词标签关系对象 word_flag_relation
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordFlagRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /** 用户id */
    @NotNull(message = "用户wordId不能为空")
    private Long wordId;

    /** 标签id */
    @NotNull(message = "标签id不能为空")
    private Long flagId;

    /** 删除标志（N未删除 Y删除 NONE未指定） */
    private String delFlag;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("flagId", getFlagId())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
