package com.example.mappers;

import com.example.domains.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

   // public int insert(ReplyVO vo);
    List<ReplyVO> getList(int bno);
}
