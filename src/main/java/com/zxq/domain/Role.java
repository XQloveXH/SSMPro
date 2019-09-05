package com.zxq.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
public class Role {
    private Long rid;

    private Integer rnum;

    private String rname;

    private List<Permission> permissions = new ArrayList<>();

}