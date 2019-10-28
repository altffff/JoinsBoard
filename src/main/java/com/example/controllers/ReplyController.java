package com.example.controllers;

import com.example.domains.ReplyVO;
import com.example.services.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyController {

    private static Logger logger = LoggerFactory.getLogger(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    //해당 게시글의 전체 댓글 리스트 가져오기
    @GetMapping("/reply/{bno}")
    public List<ReplyVO> findByBno(@PathVariable("bno") int bno) {
        return replyService.findByBno(bno);
    }

    //고유 rno 로 댓글 삭제하기
    @PostMapping("/delete")
    public void deleteReply(int rno) {
        replyService.deletereply(rno);
    }

    //댓글등록하기
    @PostMapping("/reply")
    public void create(ReplyVO rep) {
        logger.info("POST reply : " + rep);
        replyService.insert(rep);
    }

}