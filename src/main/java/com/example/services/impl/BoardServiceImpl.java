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
    public int insert(BoardVO board) {
        return boardMapper.insert(board);

    }

    @Override
    public int update(BoardVO board) {
        return boardMapper.update(board);

    }

    @Override
    public int delete(int bno) {
        return boardMapper.delete(bno);
    }

}

