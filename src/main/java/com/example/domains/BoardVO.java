package com.example.domains;

import lombok.Data;

@Data
public class BoardVO {

    private int bno;             //글 번호
    private String title;        //글 제목
    private String content;      //글 본문
    private String writer;       //글 비밀번호
    private String regdate;      //글 작성날짜
    private String updatedate;   //글 수정날짜

}
