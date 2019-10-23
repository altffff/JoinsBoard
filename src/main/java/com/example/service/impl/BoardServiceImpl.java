package com.example.service.impl;

import com.example.dao.BoardMapper;
import com.example.domain.BoardDomain;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<BoardDomain> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public List<BoardDomain> findByBno(int bno) {
        return boardMapper.findByBno(bno);
    }
    @Override
    public List<BoardDomain> findByBno2(int bno) {
        return boardMapper.findByBno2(bno);
    }

    @Override
    public void insert(BoardDomain board) {
        boardMapper.insert(board);
    }

    @Override
    public void update(BoardDomain board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(int bno) {
        boardMapper.delete(bno);
    }

}

