package com.ruoyi.biz.domain;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单词标签对象 word_flag
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordFlag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @NotBlank(message = "用户id不能为空")
    private Long userId;

    /** 名称 */
    @NotBlank(message = "标签名称不能为空")
    private String name;

    /** 删除标志（N未删除 Y删除 NONE未指定） */
    private String delFlag;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("name", getName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
