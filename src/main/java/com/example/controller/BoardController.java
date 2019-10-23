package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.BoardDomain;
import com.example.service.BoardService;

@Controller
public class BoardController {

    private static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

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
        ModelAndView popupPage = new ModelAndView("board/read");
        System.out.println(bno);
        popupPage.addObject("board", boardService.findByBno(bno).get(0));
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
