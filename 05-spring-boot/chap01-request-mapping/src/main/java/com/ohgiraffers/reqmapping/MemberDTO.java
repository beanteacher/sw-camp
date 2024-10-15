package com.ohgiraffers.reqmapping;

import lombok.ToString;

@ToString
public class MemberDTO {
    public String memberId;
    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
