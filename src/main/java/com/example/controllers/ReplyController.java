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

    @GetMapping("/reply/{bno}")
    public List<ReplyVO> findByBno(@PathVariable("bno") int bno) throws Exception {
        System.out.println("reply controller 에서 getmapping 으로 댓글긁어오기");

        return replyService.findByBno(bno);

    }

    @PostMapping("/delete")
    public void deleteReply(int rno) {
        System.out.println(rno + " 번 댓글지우자,,컨트롤러");
        replyService.deletereply(rno);
    }

    /*@PostMapping("/reply")
    public List<ReplyVO> insertReply(ReplyVO reply) {
        logger.info("aaa : "  + reply.toString());
        return replyService.insert(reply);
    }

    @PutMapping("/reply")
    public List<ReplyVO> updateReply(ReplyVO reply) {
        return replyService.update(reply);
    }



    @GetMapping("/reply/all")
    public List<ReplyVO> findAll(){
        return replyService.findAll();
    }

    @GetMapping("/reply/condition")
    public List<ReplyVO> findByCondition(){
        return replyService.findByCondition();
    }*/
}
