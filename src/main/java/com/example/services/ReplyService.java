package com.example.services;

import com.example.domains.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {
    List<ReplyVO> getList(int bno);

}
