package com.example.services.impl;

import com.example.mappers.BoardMapper;
import com.example.domains.BoardVO;
import com.example.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<BoardVO> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public List<BoardVO> findByBno(int bno) {
        return boardMapper.findByBno(bno);
    }

    @Override
    public void insert(BoardVO board) {
        boardMapper.insert(board);
    }

    @Override
    public void update(BoardVO board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(int bno) {
        boardMapper.delete(bno);
    }

}

