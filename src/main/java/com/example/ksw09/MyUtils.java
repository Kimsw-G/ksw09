package com.example.ksw09;

import com.example.ksw09.model.DailyTodoVO;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class MyUtils {
    public String[] dates = new String[]{"일", "월", "화", "수", "목", "금", "토"};
    public boolean checkDate(int dateBin){ // 오늘 요일을 포함하는지 확인
        int date = Calendar.getInstance().get(7)-1;
        return ((int)Math.pow(2.0D, (double)date) & dateBin) != 0;
    }
    public int calcDate(List<Double> todoDates){ // 들어온 데이터를 바탕으로 날짜 정보
        int cnt = 0;
        for(int i=0;i<todoDates.size();i++){
            cnt += (int)(Math.pow(2.0D, todoDates.get(i)));
        }
        return cnt;
    }
    public void getDateInfo(DailyTodoVO vo){
        String result = "";
        for(int i=0; i<7; i++){
            if(vo.getTodoDate() / (int)Math.pow(2,i) % 2 == 1) result += dates[i];
        }
        vo.setDate(result);
    }
}
