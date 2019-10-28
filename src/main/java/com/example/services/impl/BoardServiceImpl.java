package com.example.services.impl;

import com.example.domains.BoardVO;
import com.example.mappers.BoardMapper;
import com.example.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan()
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    /* 전체글 보기 */
    @Override
    public List<BoardVO> findAll() {
        return boardMapper.findAll();
    }

    /* 글번호(bno)로 특정게시물 찾기 */
    @Override
    public List<BoardVO> findByBno(int bno) {
        return boardMapper.findByBno(bno);
    }

    /* 글 추가 */
    @Override
    public int insert(BoardVO board) { return boardMapper.insert(board); }

    /* 글 수정 */
    @Override
    public int update(BoardVO board) { return boardMapper.update(board); }

    /* 글 삭제 */
    @Override
    public int delete(int bno) {
        return boardMapper.delete(bno);
    }
}