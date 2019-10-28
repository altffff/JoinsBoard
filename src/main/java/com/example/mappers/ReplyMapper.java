package com.example.mappers;

import com.example.domains.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyMapper {

    /* bno로 댓글검색 */
    List<ReplyVO> findByBno(@Param("bno") int bno);

    /* 댓글삭제 */
    void deletereply(int rno);

    /* 댓글등록 */
    void insert(ReplyVO rep);
}
