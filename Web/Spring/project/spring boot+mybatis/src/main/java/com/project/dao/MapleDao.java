package com.project.dao;

import com.project.vo.Maple;

import java.util.Map;

public interface MapleDao {
    // create
    Long insertCharacter();

    // read
    Map<Long, Maple> selectMaple();

    // update
    Long updateMaple(Maple maple);

    // delete
    void deleteMaple(Long id);
}
