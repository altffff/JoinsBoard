package com.example.domains;

import lombok.Data;

@Data
public class ReplyVO {

    /*댓글 고유번호*/
    private int rno;

   /* 이 댓글이 달린 게시물의 번호*/
    private int bno;

    /*댓글내용*/
    private String reply;

    /*댓글단사람*/
    private String replier;

    private String rPassword;

    /*댓글단 날짜*/
    private String replydate;


}

