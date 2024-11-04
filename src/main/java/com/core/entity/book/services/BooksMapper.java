package com.core.entity.book.services;

import com.core.entity.book.model.Books;
import com.core.entity.exceptions.BuildException;

public class BooksMapper {
    public static Books bookFromDTO(BooksDTO bdto) throws BuildException{
        return Books.getInstanceBooks(
            bdto.getCode(), 
            bdto.getPrice(), 
            bdto.getDescription(), 
            bdto.getAuthor(), 
            bdto.getTitle(), 
            bdto.getCover(), 
            bdto.getPage(), 
            bdto.getGender(), 
            bdto.getEditorial(), 
            bdto.getISBN(), 
            bdto.getHigh(), 
            bdto.getWidth(), 
            bdto.getLength(), 
            bdto.getWeight(),
            bdto.getFragil(),
            bdto.getDepth()
        );
    }

    public static BooksDTO dtoFromBook(Books b){
        return new BooksDTO(
            b.getcode(),
            b.getprice(),
            b.getdescription(),
            b.getAuthor(),
            b.getTitle(),
            b.getCover(),
            b.getPage(),
            b.getGender(),
            b.getEditorial(),
            b.getISBN(),
            b.getHigh(),
            b.getWidth(),
            b.getLength(),
            b.getWeight(),
            b.getFragil(),
            b.getDepth()
        );
    }
}
