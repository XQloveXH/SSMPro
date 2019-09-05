package com.zxq.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class QueryVo {
    private Integer page;
    private Integer rows;
    private String keyword;
}
