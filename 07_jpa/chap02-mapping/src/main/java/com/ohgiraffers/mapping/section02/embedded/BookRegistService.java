package com.ohgiraffers.mapping.section02.embedded;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookRegistService {
    private final BookRepository bookRepository;

    @Transactional
    public void registBook(BookRegistDTO dto) {
        Book book = new Book(
                dto.getBookTitle(),
                dto.getAuthor(),
                dto.getPublisher(),
                dto.getPublishedDate(),
                new Price(dto.getRegularPrice(),
                    dto.getDiscountRate())
        );
        bookRepository.save(book);
    }
}
