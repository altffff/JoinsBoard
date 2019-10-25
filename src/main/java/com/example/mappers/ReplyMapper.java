package com.example.mappers;

import com.example.domains.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    /*bno로 댓글검색*/
    List<ReplyVO> findByBno(@Param("bno") int bno);

    void deletereply(int bno);
}
