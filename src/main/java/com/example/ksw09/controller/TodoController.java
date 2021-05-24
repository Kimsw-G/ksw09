package com.example.ksw09.controller;

import com.example.ksw09.dao.DailyTodoDAO;
import com.example.ksw09.dao.DdayTodoDAO;
import com.example.ksw09.dao.NormalTodoDAO;
import com.example.ksw09.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@RequestMapping(value = "/todo/*")
@Controller
public class TodoController {

    @Autowired
    NormalTodoDAO normalTodoDAO;
    @Autowired
    DdayTodoDAO ddayTodoDAO;
    @Autowired
    DailyTodoDAO dailyTodoDAO;

    @Resource
    LoginInfo loginInfo;

    // 무조건 얘를 거친다
    // true 면 게속 이행
    // false면 멈춤


    // normal 페이지 보여주기
    @RequestMapping(value = "/normal", method = RequestMethod.GET)
    public String showNormalTodo(Model model){
        List<NormalTodoVO> list = normalTodoDAO.selectNormalTodoList(loginInfo);
        model.addAttribute("todoList",list);

        return "/privacy/normal";
    }


    // 글을 등록하자
    // TODO : 이건 AJAX를 통해서 설정해주기!
    @ResponseBody
    @RequestMapping(value="/normal",method = RequestMethod.POST)
    public List<NormalTodoVO> insertNormalTodo(@RequestBody NormalTodoVO param,
                                 Model model){
        param.setM_pk(loginInfo.getM_pk());
        normalTodoDAO.insertNormalTodo(param);
        return normalTodoDAO.selectNormalTodoList(loginInfo);
    }

    @RequestMapping(value = "/daily",method = RequestMethod.GET)
    public String showDailyTodo(Model model){
        List<DailyTodoVO> list_ = dailyTodoDAO.selectDailyTodoList(loginInfo);
        List<DailyTodoVO> list = new ArrayList<>();
        Iterator<DailyTodoVO> var = list_.iterator();

        while (var.hasNext()){
            DailyTodoVO dv = var.next();
            if(this.checkDate(dv.getTodoDate())){
                list.add(dv);
            }
        }


        model.addAttribute("todoList",list);
        return "/privacy/daily";
    }
    private boolean checkDate(int dateBin){
        int date = Calendar.getInstance().get(7)-1;
        return ((int)Math.pow(2.0D, (double)date) & dateBin) != 0;
    }

    @RequestMapping(value = "/dailyWrite", method = RequestMethod.GET)
    public String showDailyWrite(Model model){
        String[] date = new String[]{"일", "월", "화", "수", "목", "금", "토"};
        model.addAttribute("date",date);
        return "/privacy/dailyWrite";
    }

    @RequestMapping(value = "/dailyWrite",method = RequestMethod.POST)
    public String insertDailyTodo(DailyTodoVO vo,
                                  @RequestParam(name = "todoDates") List<Double> todoDates){
        vo.setM_pk(loginInfo.getM_pk());
        vo.setTodoDate(calcDate(todoDates));
        dailyTodoDAO.insertDailyTodoList(vo);
        return "redirect:daily";
    }
    private int calcDate(List<Double> todoDates){
        int cnt = 0;
        for(int i=0;i<todoDates.size();i++){
            cnt += (int)(Math.pow(2.0D, todoDates.get(i)));
        }
        return cnt;
    }

    @GetMapping("dday")
    public String showDdayTodo(Model model){
        List<DdayTodoVO> list = ddayTodoDAO.selectDdayTodoList(loginInfo);
        model.addAttribute("todoList",list);

        return"/privacy/dday";
    }

    @GetMapping("ddayWrite")
    public String showDdayWrite(){

        return "/privacy/ddayWrite";
    }

    @PostMapping("ddayWrite")
    public String insertDdayWrite(Model model,DdayTodoVO vo){
        vo.setM_pk(loginInfo.getM_pk());
        ddayTodoDAO.insertDdayTodo(vo);
        return "redirect:dday";
    }
}
