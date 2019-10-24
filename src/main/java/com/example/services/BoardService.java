package com.example.services;

import java.util.List;

import com.example.domains.BoardVO;


public interface BoardService {

    List<BoardVO> findAll();
    List<BoardVO> findByBno(int bno);
    void insert(BoardVO board);
    void update(BoardVO board);
    void delete(int bno);

}
