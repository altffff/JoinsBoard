package com.example.controllers;

import java.util.*;

import com.example.domains.ReplyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.domains.BoardDomain;
import com.example.services.BoardService;
import com.example.services.ReplyService;

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
        List<BoardDomain> boardList = boardService.findAll();

        ModelAndView nextPage = new ModelAndView("board/home");
        nextPage.addObject("boardList", boardList);
        return nextPage;
    }

    // 글 상세보기
    @GetMapping("/board/{bno}")
    public ModelAndView readOne(@PathVariable("bno") int bno) {
        List<ReplyVO> replyVOList = replyService.getList(bno);

        ModelAndView popupPage = new ModelAndView("board/read");
        System.out.println(bno);
        popupPage.addObject("board", boardService.findByBno(bno).get(0));
        popupPage.addObject("result",replyVOList);
        System.out.println(replyVOList.size());
        //popupPage.addObject("result",replyService.getList(bno));

        /*List<BoardDomain> thisboard = new ArrayList<>();
        thisboard.add(boardService.findByBno(bno).get(0)); //해당 게시글 객체 하나
        List <ReplyVO> thisreply = new ArrayList<>();
        for(ReplyVO a: replyService.getList(bno)) thisreply.add(a);  //해당게시글의 모든 댓글리스트
        Map<String,List> map = new HashMap<>();
        map.put("thisboard",thisboard);
        map.put("thisreply",replyService.getList(bno));
        popupPage.addAllObjects(map);*/

        return popupPage;
    }

    // 글 올리기
    @PostMapping("/board")
    public void create(BoardDomain board){
        logger.info("POST board : " + board.toString());
        boardService.insert(board);
    }


    // 글 수정
    @PutMapping("/board")
    public void modify(BoardDomain board){
        logger.info("PUT data : " + board.toString());
        boardService.update(board);
    }

    //글 삭제
    @RequestMapping("/board/{bno}")
    public String delete(@PathVariable("bno") int bno){
        logger.info("DELETE bno : " + bno);
        boardService.delete(bno);
        return "home";
    }

}
