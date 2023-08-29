package com.bluemine.controller;

import com.bluemine.security.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("/all")
    public void exAll(
            /* 로그인된 사용자의 정보 확인 */
            @AuthenticationPrincipal MemberDTO memberDTO) {
        log.info("exAll");
        log.info("-------------------");
        log.info(memberDTO);

    }

    @GetMapping("/member")
    public void exMember() {
        log.info("exMember");
    }

    @GetMapping("/admin")
    public void exadmin() {
        log.info("exAdmin");
    }
}
