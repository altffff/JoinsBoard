package com.example.controllers;

import com.example.domains.BoardVO;
import com.example.services.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    private static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    // 전체 보기
    @GetMapping("/board")
    public ModelAndView list() {
        List<BoardVO> boardList = boardService.findAll();
        ModelAndView nextPage = new ModelAndView("board/home");
        nextPage.addObject("boardList", boardList);
        return nextPage;
    }

    // 글 상세보기
    @GetMapping("/board/{bno}")
    public ModelAndView readOne(@PathVariable("bno") int bno, ModelAndView modelAndView) {
        ModelAndView popupPage = new ModelAndView("board/read");
        popupPage.addObject("board", boardService.findByBno(bno).get(0));
        return popupPage;
    }

    // 글 올리기
    @PostMapping("/board")
    public void create(BoardVO board) {
        logger.info("POST board : " + board);
        boardService.insert(board);
    }

    // 글 수정
    @PutMapping("/board")
    public void modify(BoardVO board) {
        logger.info("PUT data : " + board);
        boardService.update(board);

    }

    //글 삭제
    @DeleteMapping("/board/{bno}")
    public String delete(@PathVariable("bno") int bno) {
        logger.info("DELETE bno : " + bno);
        if (boardService.delete(bno) == 0) {
            //지워진게없으면 -> 삭제못함처리
        }
        return "home";
    }
}