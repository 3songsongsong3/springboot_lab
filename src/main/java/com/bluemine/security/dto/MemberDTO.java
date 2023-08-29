package com.bluemine.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
@Log4j2
public class MemberDTO extends User {

    private String email;

    private String name;

    private boolean fromSocial;

    public MemberDTO(
            String username,
            String password,
            boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }
}
