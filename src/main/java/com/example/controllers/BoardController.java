package com.example.controllers;

import com.example.domains.BoardVO;
import com.example.domains.ReplyVO;
import com.example.services.BoardService;
import com.example.services.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.List;

@Controller
public class BoardController {
    private static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    // 전체 보기
    @GetMapping("/board")
    public ModelAndView list() {
        List<BoardVO> boardList = boardService.findAll();
        ModelAndView nextPage = new ModelAndView("board/home");
        nextPage.addObject("boardList", boardList);
        return nextPage;
    }

    // 글 상세보기+댓글까지
    @GetMapping("/board/{bno}")
    public ModelAndView readOne(@PathVariable("bno") int bno) {
        System.out.println(bno + " 번 게시물");
        ModelAndView popupPage = new ModelAndView("board/read");
       // List<ReplyVO> replyVOList = replyService.getList(bno);
        popupPage.addObject("board", boardService.findByBno(bno).get(0));
       // popupPage.addObject("result", replyVOList);
       // System.out.println("달린 댓글갯수" + replyVOList.size() + " 개");
        return popupPage;
    }

    // 글 올리기
    @PostMapping("/board")
    public void create(BoardVO board) {
        logger.info("POST board : " + board.toString());
        boardService.insert(board);
    }


    // 글 수정
    @PutMapping("/board")
    public void modify(BoardVO board) {
        logger.info("PUT data : " + board.toString());
        boardService.update(board);

    }

    //글 삭제
    @DeleteMapping("/board/{bno}")
    public String delete(@PathVariable("bno") int bno) {
        logger.info("DELETE bno : " + bno);
        System.out.print(bno);
        if(boardService.delete(bno)==0){
            //지워진게없으면
        };

        return "home";
    }

}
