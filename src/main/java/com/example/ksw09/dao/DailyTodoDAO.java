package com.example.ksw09.dao;

import com.example.ksw09.model.DailyTodoVO;
import com.example.ksw09.model.LoginInfo;
import com.example.ksw09.model.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dailyTodoDAO")
public interface DailyTodoDAO {

    List<DailyTodoVO> selectDailyTodoList(LoginInfo param);
    int insertDailyTodoList(DailyTodoVO param);

}
