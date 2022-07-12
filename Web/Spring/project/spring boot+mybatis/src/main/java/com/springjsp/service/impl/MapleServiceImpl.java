package com.springjsp.service.impl;

import com.springjsp.service.MapleService;
import com.springjsp.vo.MapleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MapleServiceImpl implements MapleService {

    @Resource(name = "mapleServiceImpl")
    private MapleServiceImpl mapleService;

    @Override
    public Long makeMapleVO(MapleVO vo) {
        return null;
    }

    @Override
    public MapleVO updateMapleVO(MapleVO vo) {
        return null;
    }

    @Override
    public Long MapleVO(MapleVO vo) {
        return null;
    }


    @Override
    public List<MapleVO> getMapleVO(Long id) {
        return null;
    }
}
