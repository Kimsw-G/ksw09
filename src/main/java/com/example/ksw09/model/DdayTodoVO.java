package com.example.ksw09.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class DdayTodoVO {
    private int dday_pk;
    private int m_pk;
    private String content;
    private Date dday;
    private int nowDday;

}
