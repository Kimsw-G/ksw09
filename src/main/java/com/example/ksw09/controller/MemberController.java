package com.example.ksw09.controller;

import com.example.ksw09.dao.MemberDAO;
import com.example.ksw09.model.MemberVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String pageLogin(){
        return "/public/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String tryLogin(MemberVO memberVO, HttpSession session){
        System.out.println(memberVO.getM_id());
        MemberVO mv = memberDAO.selectMemberVOById(memberVO.getM_id());
        // pw 검사!
        if(BCrypt.checkpw(memberVO.getM_pw(),mv.getM_pw())){
            System.out.println("로그인 성공");
            memberVO.setM_pw(null);
            session.setAttribute("memberVO",memberVO);
            return "redirect:/todo/normal";
        }else {
            return "redirect:login";
        }

    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String pageRegist(){
        return "/public/regist";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String tryRegist(MemberVO memberVO){
        changTel(memberVO);
        memberDAO.insertMember(memberVO);
        return "/public/main";
    }

    private void changTel(MemberVO vo){
        vo.setM_tel(vo.getM_tel().replace(",",""));
    }

}
