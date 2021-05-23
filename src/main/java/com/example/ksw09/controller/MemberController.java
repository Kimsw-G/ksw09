package com.example.ksw09.controller;

import com.example.ksw09.dao.MemberDAO;
import com.example.ksw09.model.MemberVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            memberVO = memberDAO.selectMemberVOById(memberVO.getM_id());
            memberVO.setM_pw(null);
            session.setAttribute("loginInfo",memberVO);
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

        if (checkRegiPassword(memberVO)){
            memberVO.setM_pw(BCrypt.hashpw(memberVO.getM_pw(),BCrypt.gensalt()));
            memberDAO.insertMember(memberVO);
            return "/public/main";
        }
        // ajax를 통해 검사하는게 더 좋지 않을까?
        // ajax로 검사 후, true return 시 "/public/main" 또는 회원가입 축하 페이지로 보내자
        // ajax로 검사 후, flase return 시 특정 js 또는 메소드로 경고창을 띄운 후, password 창으로 focus를 준다

        return "/public/regist";
    }

    private void changTel(MemberVO vo){
        vo.setM_tel(vo.getM_tel().replace(",",""));
    }

    private boolean checkRegiPassword(MemberVO vo){
        return vo.getM_pw().equals(vo.getM_pwck());
    }
}
