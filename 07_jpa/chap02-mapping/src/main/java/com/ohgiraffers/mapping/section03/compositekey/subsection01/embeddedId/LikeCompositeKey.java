package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LikeCompositeKey implements Serializable {

    @Column(name = "liked_member_no")
    private int likedMemberNo;
    @Column(name = "liked_book_no")
    private int likedBookNo;
}
