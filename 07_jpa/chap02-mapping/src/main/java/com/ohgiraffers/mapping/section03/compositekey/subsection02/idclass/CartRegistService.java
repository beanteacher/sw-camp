package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartRegistService {
    private final CartRepository cartRepository;

    @Transactional
    public void addItemToCart(CartDTO cartDTO) {
        Cart cart = new Cart(
                cartDTO.getCartOwnerMemberNo(),
                cartDTO.getAddedBookNo(),
                cartDTO.getQuantity()
        );

        cartRepository.save(cart);
    }
}
