package com.example.domains;

import lombok.Data;

@Data
public class ReplyVO {

    private int rno;          //댓글 고유번호\
    private int bno;          //이 댓글이 달린 원래 게시물의 번호
    private String reply;     //댓글 내용
    private String replier;   //댓글 단 사람
    private String rPassword; //댓글 비밀번호
    private String replydate; //댓글 작성일

}

