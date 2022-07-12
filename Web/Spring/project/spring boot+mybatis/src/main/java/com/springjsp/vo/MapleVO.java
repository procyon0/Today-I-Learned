package com.springjsp.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MapleVO {
    private Long id;    // 아이디
    private String name;    // 이름
    private Long lev;     // 레벨
}
