package com.bluemine.security.service;

import com.bluemine.entity.Member;
import com.bluemine.repository.MemberRepository;
import com.bluemine.security.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("MemberDetailsService : " + username);
        Optional<Member> result = memberRepository.findByEmail(username, false);

        if(result.isEmpty()) {
            throw new UsernameNotFoundException("Check Email or Social");
        }

        Member member = result.get();

        log.info("---------------------------------");
        log.info(member);

        MemberDTO memberDTO = new MemberDTO(
                member.getEmail(),
                member.getPassword(),
                member.isFromSocial(),
                member.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                                .collect(Collectors.toSet())
        );

        memberDTO.setName(member.getName());
        memberDTO.setFromSocial(member.isFromSocial());
        log.info("---------MEMBER DTO---------------");
        log.info(memberDTO);
        return memberDTO;
    }

}
