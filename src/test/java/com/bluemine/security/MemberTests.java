package com.bluemine.security;

import com.bluemine.entity.Member;
import com.bluemine.entity.MemberRole;
import com.bluemine.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    @Test
    public void insertDummies() {

        // 1 - 80   USER
        // 81- 90   USER, MANAGER
        // 91- 100  USER, MANAGER, ADMIN
        IntStream.rangeClosed(1,100).forEach(i ->{
            Member member = Member.builder()
                    .email("user" + i + "@test.co.kr")
                    .name("사용자" + i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1111"))
                    .build();

            // default ROLE
            member.addMemberRole(MemberRole.USER);

            if (i > 80) {
                member.addMemberRole(MemberRole.MANAGER);
            }

            if (i > 90) {
                member.addMemberRole(MemberRole.ADMIN);
            }

            repository.save(member);
        });
    }*/
    @Test
    public void testRead() {

        Optional<Member> result = repository.findByEmail("user95@test.co.kr", false);
        Member member = result.get();

        System.out.println(member);
    }
}
