package com.ohgiraffers.section01.object;

import java.util.Objects;

public class Book {
    private int number;
    private String title;
    private String author;
    private int price;

    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        /* 주소 값이 같은 경우 동일 객체이므로 필드 값 비교 없이 바로 true 반환 */
        if (this == o) return true;
        /* 전달 객체가 null이거나 다른 타입이면 동등 객체일 수 없으므로 바로 false 반환 */
        if (o == null || getClass() != o.getClass()) return false;
        /* Book 타입이면서 동일 객체가 아니므로 동등 객체인지 비교 */
        Book book = (Book) o;
        /* 모든 필드 값이 동일할 경우 true 반환 */
        return number == book.number && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title, author, price);
    }
}
