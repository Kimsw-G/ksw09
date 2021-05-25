package com.example.ksw09.controller;

import com.example.ksw09.MyUtils;
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
import java.util.Iterator;
import java.util.List;

@RequestMapping(value = "/todo/*")
@Controller
public class TodoController extends ControllerPath {

    @Autowired
    NormalTodoDAO normalTodoDAO;
    @Autowired
    DdayTodoDAO ddayTodoDAO;
    @Autowired
    DailyTodoDAO dailyTodoDAO;
    @Autowired
    private MyUtils myUtils;

    @Resource
    LoginInfo loginInfo;


    // normal
    @GetMapping("/normal")
    public String showNormal(Model model){
        List<NormalTodoVO> list = normalTodoDAO.selectNormalTodoList(loginInfo);
        model.addAttribute("todoList",list);

        return DIR_PATH+NORMAL;
    }
    // TODO : 이건 AJAX를 통해서 설정해주기!
    @ResponseBody
    @PostMapping("/normal")
    public List<NormalTodoVO> insertNormal(@RequestBody NormalTodoVO param,
                                 Model model){
        param.setM_pk(loginInfo.getM_pk());
        normalTodoDAO.insertNormalTodo(param);
        return normalTodoDAO.selectNormalTodoList(loginInfo);
    }
    @GetMapping("/normalDelete")
    public String deleteNormal(NormalTodoVO vo){
        vo.setM_pk(loginInfo.getM_pk());
        normalTodoDAO.deleteNormalTodo(vo);
        return REDIRECT+NORMAL;
    }

    //daily
    @GetMapping("/daily")
    public String showDaily(Model model){
        List<DailyTodoVO> list_ = dailyTodoDAO.selectDailyTodoList(loginInfo);
        List<DailyTodoVO> list = new ArrayList<>();
        Iterator<DailyTodoVO> var = list_.iterator();

        while (var.hasNext()){
            DailyTodoVO dv = var.next();
            if(myUtils.checkDate(dv.getTodoDate())){
                list.add(dv);
            }
        }
        for (DailyTodoVO vo : list) {
            myUtils.getDateInfo(vo);
        }
        model.addAttribute("todoList",list);
        return DIR_PATH+DAILY;
    }
    @PostMapping("/daily") // 요일 상관없이 전부 보이게 하기
    public String showAllDaily(Model model){
        List<DailyTodoVO> list = dailyTodoDAO.selectDailyTodoList(loginInfo);

        for (DailyTodoVO vo : list) {
            myUtils.getDateInfo(vo);
        }
        model.addAttribute("todoList",list);
        return DIR_PATH+DAILY;
    }
    @GetMapping("/dailyWrite")
    public String showDailyWrite(Model model){
        model.addAttribute("date",myUtils.dates);
        return DIR_PATH+DAILYW;
    }
    @PostMapping("/dailyWrite")
    public String insertDaily(DailyTodoVO vo,
                                  @RequestParam(name = "todoDates") List<Double> todoDates){
        vo.setM_pk(loginInfo.getM_pk());
        vo.setTodoDate(myUtils.calcDate(todoDates));
        dailyTodoDAO.insertDailyTodoList(vo);
        return REDIRECT+DAILY;
    }
    @GetMapping("/dailyDelete")
    public String deleteDaily(DailyTodoVO vo){
        vo.setM_pk(loginInfo.getM_pk());
        dailyTodoDAO.deleteDailyTodo(vo);
        return REDIRECT+DAILY;
    }

    //dday
    @GetMapping("dday")
    public String showDday(Model model){
        List<DdayTodoVO> list = ddayTodoDAO.selectDdayTodoList(loginInfo);
        model.addAttribute("todoList",list);

        return DIR_PATH+DDAY;
    }
    @GetMapping("ddayWrite")
    public String showDdayWrite(){

        return DIR_PATH+DDAYW;
    }
    @PostMapping("ddayWrite")
    public String insertDdayWrite(DdayTodoVO vo){
        vo.setM_pk(loginInfo.getM_pk());
        ddayTodoDAO.insertDdayTodo(vo);
        return REDIRECT+DDAY;
    }
    @GetMapping("ddayDelete")
    public String deleteDday(DdayTodoVO vo){
        vo.setM_pk(loginInfo.getM_pk());
        ddayTodoDAO.deleteDdayTodo(vo);
        return REDIRECT+DDAY;
    }

}
