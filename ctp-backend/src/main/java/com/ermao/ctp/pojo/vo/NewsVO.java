package com.ermao.ctp.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/14 16:45
 */
@Data
public class NewsVO {
    private Long id;

    private String title;

    private String content;

    private Integer sort;

    private LocalDateTime createTime;
}
