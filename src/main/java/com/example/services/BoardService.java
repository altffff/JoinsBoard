package com.example.services;

import java.util.List;

import com.example.domains.BoardDomain;


public interface BoardService {

    List<BoardDomain> findAll();
    List<BoardDomain> findByBno(int bno);
    List<BoardDomain> findByBno2(int bno);
    void insert(BoardDomain board);
    void update(BoardDomain board);
    void delete(int bno);

}
