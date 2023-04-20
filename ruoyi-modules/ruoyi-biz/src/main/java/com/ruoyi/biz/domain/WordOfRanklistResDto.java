package com.ruoyi.biz.domain;


import lombok.Data;
import java.util.List;

/**
 * 排行榜中的单词对象 word_of_ranklist
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Data
public class WordOfRanklistResDto
{
    /** id */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 排行榜id */
    private Long rankListId;

    /** 单词id */
    private Long wordId;

    /** 排行序号 */
    private Integer rankNum;

    /** 单词 */
    private String word;

    /** remark */
    private String remark;

    private String wordMean;

}
