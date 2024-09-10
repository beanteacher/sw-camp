package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_like")
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @EmbeddedId
    private LikeCompositeKey likeInfo;
}
