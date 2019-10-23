package com.example.dao;

import com.example.domain.BoardDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    /* 전체 리스트 보기 */
    List<BoardDomain> findAll();

    /* userName 으로 검색 */
    //@Select("SELECT * FROM tbl_board WHERE userName=#{userName}")
    List<BoardDomain> findByUserName(@Param("userName") String userName);

    /* bno 로 검색 */
    List<BoardDomain> findByBno2(int bno);

    //@Select("SELECT * FROM tbl_board WHERE bno = #{bno}")
    List<BoardDomain> findByBno(@Param("bno") int bno);

    /* 게시물 추가 */
    //@Insert("INSERT INTO tbl_board(userName, content) VALUES(#{userName}, #{content})")
    void insert(BoardDomain board);

    /* 게시물 수정 */
    //@Update("UPDATE tbl_board SET content=#{content} ,userName=#{userName} where bno=#{bno}")
    void update(BoardDomain board);

    /* 게시물 삭제 */
    //@Delete("DELETE FROM tbl_board where bno=#{bno}")
    void delete(@Param("bno") int bno);


}
