package com.example.ksw09.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NormalTodoVO {
    private int normal_pk;
    private int m_pk;
    private String regDate;
    private String ctnt;
    private boolean doCheck;
}
