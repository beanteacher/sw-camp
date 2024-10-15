package com.ohgiraffers.mapping.section01.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberRegistService {

    private final MemberRepository memberRepository;

    @Transactional
    public void service(MemberRegistDTO newMember) {
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus());

        memberRepository.save(member);
    }

    /* Spring 트랜잭션 전파 방식(default : PROPPAGATION_REQUIRED)에 따라
    * @Transactional이 붙은 메소드가 다른 @Transactional이 붙은 메소드를 호출하면
    * 호출 된 메소드는 호출한 메소드와 동일한 트랜잭션 컨텍스트를 사용한다. */
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        service(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }
}
