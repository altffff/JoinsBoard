package com.example.services;

import com.example.domains.BoardVO;

import java.util.List;


public interface BoardService {

    List<BoardVO> findAll();           //전체 글 보기
    List<BoardVO> findByBno(int bno);  //특정 글 찾기
    int insert(BoardVO board);         //글추가
    int update(BoardVO board);         //글삽입
    int delete(int bno);               //글삭제

}
