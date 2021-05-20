package com.example.ksw09.dao;

import com.example.ksw09.model.MemberVO;
import com.example.ksw09.model.NormalTodoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("normalTodoDAO")
public interface NormalTodoDAO {
    public List<NormalTodoVO> selectNormalTodoList(MemberVO param);
    public int insertNormalTodo(NormalTodoVO param);
}
