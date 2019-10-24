package com.example.domains;

import lombok.Data;

@Data
public class BoardVO {
    /*고유 글번호 */
    private int bno;

    /*글제목*/
    private String title;

    /*글본문*/
    private String content;

    /*글작성자 - 패스워드로 사용*/
    private String writer;

    /*글작성날짜*/
    private String regdate;

    /*글수정날짜*/
    private String updatedate;
}
