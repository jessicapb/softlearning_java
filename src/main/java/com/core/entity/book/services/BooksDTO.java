package com.core.entity.book.services;

public class BooksDTO {
    private final String description, author, title, cover, gender, editorial, ISBN;
    private final int code, page;
    private final double price, high, width, length,  weight, depth;
    private final boolean fragil;
    
    public BooksDTO(int code, double price, String description, String author, String title, String cover, int page, String gender, String editorial, 
    String iSBN, double high, double width, double length, double weight,boolean fragil, double depth) {

        this.code = code;
        this.price = price;
        this.description = description;
        this.author = author;
        this.title = title;
        this.cover = cover;
        this.page = page;
        this.gender = gender;
        this.editorial = editorial;
        this.ISBN = iSBN;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragil= fragil;
        this.depth = depth;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public int getPage() {
        return page;
    }

    public String getGender() {
        return gender;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getHigh() {
        return high;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getFragil() {
        return fragil;
    }

    public double getDepth() {
        return depth;
    }
}
