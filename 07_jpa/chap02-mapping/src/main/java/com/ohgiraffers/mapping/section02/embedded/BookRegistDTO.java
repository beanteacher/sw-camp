package com.ohgiraffers.mapping.section02.embedded;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookRegistDTO {
    private String bookTitle;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    private int regularPrice;
    private double discountRate;
}
