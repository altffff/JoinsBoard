package com.example.domain;

import lombok.Data;

@Data
public class ReplyVO {
    private Long rno;
    private Long bno;

    private String reply;
    private String replyer;
    private String replyDate;
}
