package com.example.services.impl;

import com.example.domains.ReplyVO;
import com.example.mappers.ReplyMapper;
import com.example.services.ReplyService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReplyServiceImpl implements ReplyService{


    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<ReplyVO> findByBno(int bno) { //bno를 주면 bno에 맞는 댓글들 조인해옴
        return replyMapper.findByBno(bno);
    }

    @Override
    public void deletereply(int bno) { replyMapper.deletereply(bno); }

/*    @Override
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

   */

}

