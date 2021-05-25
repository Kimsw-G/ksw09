package com.example.ksw09.dao;

import com.example.ksw09.model.LoginInfo;
import com.example.ksw09.model.NormalTodoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("normalTodoDAO")
public interface NormalTodoDAO {
     List<NormalTodoVO> selectNormalTodoList(LoginInfo param);
     int insertNormalTodo(NormalTodoVO param);
     int deleteNormalTodo(NormalTodoVO param);
}
