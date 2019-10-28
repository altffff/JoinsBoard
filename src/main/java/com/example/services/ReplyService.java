package com.example.services;

import com.example.domains.ReplyVO;

import java.util.List;

public interface ReplyService {
    List<ReplyVO> findByBno(int bno);  //특정 게시글에 달린 전체 댓글 보기
    void deletereply(int rno);         //특정 댓글 삭제하기
    void insert(ReplyVO rep);          //댓글 등록하기
}
