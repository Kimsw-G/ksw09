package com.example.ksw09.dao;

import com.example.ksw09.model.DailyTodoVO;
import com.example.ksw09.model.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dailyTodoDAO")
public interface DailyTodoDAO {

    public List<DailyTodoVO> selectDailyTodoList(MemberVO param);
    public int insertDailyTodoList(DailyTodoVO param);

}
