package com.example.ksw09.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyTodoVO {
    private int daily_pk;
    private int m_pk;
    private String regDate;
    private int todoDate;
    private String ctnt;
    private int dday_pk;

}
