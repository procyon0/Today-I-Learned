package com.springjsp.dao;


import com.springjsp.vo.MapleVO;

import java.util.List;

public interface MapleDao {
    // 주요 기능 함수
    Long insertMapleVO(MapleVO vo);

    List<MapleVO> selectMapleVO(Long id);

    MapleVO updateMapleVO(MapleVO vo);

    Long deleteMapleVO(MapleVO vo);

    // 부가적인 함수
    Long getMaxId(Long id);
}
