package com.example.ksw09.dao;

import com.example.ksw09.model.MemberVO;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public interface MemberDAO {
    public int insertMember(MemberVO param);
//    public String selectPw(MemberVO param);
    public MemberVO selectMemberVOById(String id);
}
