package com.ohgiraffers.associationmapping.section02.onetomany;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OneToManyService {

    private final OneToManyMenuRepository menuRepository;

    public Category findCategory(int categoryCode) {
        return menuRepository.find(categoryCode);

    }
}
