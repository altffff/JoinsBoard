package com.example.mappers;

import com.example.domains.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    /* 전체 글 보기*/
    List<BoardVO> findAll();

    /*bno로 글 검색*/
    List<BoardVO> findByBno(@Param("bno") int bno);

    /* writer 로 글검색 - 수정,삭제시 글쓴이 본인이 맞는지 체크용도*/
    List<BoardVO> findByWriter(@Param("writer") String writer);

    /* 글 추가 */
    int insert(BoardVO board);

    /* 글 수정 */
    int update(BoardVO board);

    /* 글삭제 */
    int delete(@Param("bno") int bno);

}
