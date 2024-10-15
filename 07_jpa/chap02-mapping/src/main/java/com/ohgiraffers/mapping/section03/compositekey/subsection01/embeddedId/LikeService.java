package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    @Transactional
    public void generateLikeBook(LikeDTO likeDTO) {
        Like like = new Like(
                new LikeCompositeKey(
                likeDTO.getLikedBookNo(), likeDTO.getLikedMemberNo()
                )
        );
        likeRepository.save(like);
    }

}
