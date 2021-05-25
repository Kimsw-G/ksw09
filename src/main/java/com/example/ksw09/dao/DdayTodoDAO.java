package com.example.ksw09.dao;

import com.example.ksw09.model.DdayTodoVO;
import com.example.ksw09.model.LoginInfo;
import com.example.ksw09.model.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ddayTodoDAO")
public interface DdayTodoDAO {

    List<DdayTodoVO> selectDdayTodoList(LoginInfo param);
    int insertDdayTodo(DdayTodoVO param);
    int deleteDdayTodo(DdayTodoVO param);
}
