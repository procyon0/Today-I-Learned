package com.springjsp.service;

import com.springjsp.vo.MapleVO;

import java.util.List;

public interface MapleService {
    Long makeMapleVO(MapleVO vo);

    List<MapleVO> getMapleVO(Long id);

    MapleVO updateMapleVO(MapleVO vo);

    Long MapleVO(MapleVO vo);
}
