package com.hubberspot.Test_Double_Stub;

import com.hubberspot.dummyTestDoubles.EmailSerivce;
import com.hubberspot.Test_Double_Stub.Book;
import java.util.*;

public class BookService
{
    private BookRepository bookRepository;
    private EmailSerivce emailSerivce;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount (int discountRate, int days)
    {
        List <Book> newbook = bookRepository.findNewBooks(days);

        for (Book book: newbook)
        {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price /100);
            book.setPrice(newPrice);
        }

        return  newbook;
    }

//    public void addBook(Book book)
//    {
//        bookRepository.save(book);
//    }
//
//    public int findNumberOfBooks()
//    {
//        return bookRepository.findAll().size();
//    }

    public int calculateTotalCost(List <String> bookIds)
    {
        int total = 0;
        for(String bookId: bookIds)
        {

            Book book = bookRepository.findByBookIds(bookId);
            total = total + book.getPrice();
        }
        return total;
    }

}
