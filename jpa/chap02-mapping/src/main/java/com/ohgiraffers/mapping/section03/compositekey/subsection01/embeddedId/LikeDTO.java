package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LikeDTO {
    private int likedMemberNo;
    private int likedBookNo;

}
