package com.example.ksw09.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    // table column
    private int m_pk;
    private String m_id;
    private String m_pw;
    private String m_name;
    private String m_tel;
    //extra column
    private String m_pwck;
}
