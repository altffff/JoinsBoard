package com.example.services;

import java.util.List;

import com.example.domains.BoardVO;


public interface BoardService {

    List<BoardVO> findAll();
    List<BoardVO> findByBno(int bno);
    int insert(BoardVO board);
    int update(BoardVO board);
    int delete(int bno);

}
