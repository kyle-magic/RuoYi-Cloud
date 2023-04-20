package com.ruoyi.biz.domain;

import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import java.util.List;

/**
 * 排行榜中的单词对象 word_of_ranklist
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordOfRanklistReqDto extends BaseEntity
{
    /** 用户id */
    private Long userId;

    /** 排行榜id */
    private Long rankListId;

    /** 排行序号 */
/*    private Integer rankNum;*/

    /** 单词标签 */
    private List<Integer> wordFlags;


}
