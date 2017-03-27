package com.book.web.pojo.raw;

public class Book {
    private String id;

    private String bookName;

    private String bookType;

    private Integer bookPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }
}