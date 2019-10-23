package com.example.service;

import java.util.List;

import com.example.domain.BoardDomain;
import org.springframework.stereotype.Service;


public interface BoardService {

    List<BoardDomain> findAll();
    List<BoardDomain> findByBno(int bno);
    List<BoardDomain> findByBno2(int bno);
    void insert(BoardDomain board);
    void update(BoardDomain board);
    void delete(int bno);

}
