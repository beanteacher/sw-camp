package com.ohgiraffers.jpql.section03.projection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectionService {
    private final ProjectionRepository projectionRepository;

    @Transactional
    public List<Menu> singleEntityProjection() {
        List<Menu> menuList = projectionRepository.singleEntityProjection();
        menuList.get(0).setMenuName("세상에서 제일 맛있는 유니콘 고기");
        return menuList;
    }
}
