package com.example.ksw09.dao;

import com.example.ksw09.model.DailyTodoVO;
import com.example.ksw09.model.LoginInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dailyTodoDAO")
public interface DailyTodoDAO {

    List<DailyTodoVO> selectDailyTodoList(LoginInfo param);
    int insertDailyTodoList(DailyTodoVO param);
    int deleteDailyTodo(DailyTodoVO param);

}
