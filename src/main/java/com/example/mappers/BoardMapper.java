package com.example.mappers;

import com.example.domains.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    /* 전체 글 */
    List<BoardVO> findAll();

    /*bno로 글검색*/
    List<BoardVO> findByBno(@Param("bno") int bno);

    /* writer 로 글검색 - 수정및 삭제시 사용자 맞는지 체크하는용*/
    List<BoardVO> findByWriter(@Param("writer") String writer);

    /* 글 추가 */
    void insert(BoardVO board);

    /* 글 수정 */
    void update(BoardVO board);

    /* 글삭제 */
    void delete(@Param("bno") int bno);

}
