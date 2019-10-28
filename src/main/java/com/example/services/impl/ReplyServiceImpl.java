package com.example.services.impl;

import com.example.domains.ReplyVO;
import com.example.mappers.ReplyMapper;
import com.example.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    ReplyMapper replyMapper;

    /*글번호(bno)로 특정 글에 달린 모든 댓글 찾기*/
    @Override
    public List<ReplyVO> findByBno(int bno) { return replyMapper.findByBno(bno); }

   /* 댓글 고유번호(rno) 로 댓글 삭제하기*/
    @Override
    public void deletereply(int rno) { replyMapper.deletereply(rno); }

   /* 댓글 등록하기*/
    @Override
    public void insert(ReplyVO rep) { replyMapper.insert(rep);}
}

