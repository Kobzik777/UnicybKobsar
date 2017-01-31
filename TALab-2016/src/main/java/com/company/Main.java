package com.company;

import com.company.dao.AuthorsDao;
import com.company.dao.BooksDao;
import com.company.dao.DaoFactory;
import com.company.dao.GenresDao;
import com.company.enitites.Authors;
import com.company.enitites.Books;
import com.company.enitites.Genres;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        // write your code here

        DaoFactory factory = DaoFactory.getInstance();
        BooksDao dao = factory.createBooksDao();
        System.out.println(dao.findAll());
//        Books books = new Books();
//        books.setId(1);
//        System.out.println(dao.find(3));
//        books.setId(5);
//        books.setTitle("ololo");
//        books.setQuantity(4);
//        dao.insert(books);
//        dao.update(books,3);
//        dao.delete(5);
//        AuthorsDao dao2 = factory.createAuthorsDao();
//        Authors authors = new Authors();
//        System.out.println(dao2.find(1));
//        dao2.update(authors,3);
//        authors.setName("Kashik");
//        authors.setId(4);
        //dao2.insert(authors);
        //dao2.delete(4);
//        GenresDao dao3 = factory.createGenresDao();
//        System.out.println(dao3.findAll());
//        System.out.println(dao3.find(1));
//        Genres genres = new Genres();
//        genres.setId(3);
//        genres.setName("sience");
//        dao3.insert(genres);
//        dao3.update(genres,3);
//        dao3.delete(3);

    }
}
//select sum(Quantity) as sum_of_books
//from books