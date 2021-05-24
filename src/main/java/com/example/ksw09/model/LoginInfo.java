package com.example.ksw09.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Getter
@Setter
@Component // ?
// 얜 또 뭐야? session 범위 탐색? 프록시-타겟클래스?
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int m_pk;
    private String m_id;
    private String m_name;
}
