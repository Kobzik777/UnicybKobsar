package com.company.services;

import java.util.List;

import com.company.dao.BooksDao;
import com.company.dao.DaoFactory;
import com.company.enitites.Books;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public class BooksService {
    private static BooksService instance;

    private BooksDao dao = DaoFactory.getInstance().createBooksDao();


    public BooksService() {
        super();
    }

    public void setDao(BooksDao dao) {
        this.dao = dao;
    }

    public static BooksService getInstance(){
        if( instance == null ){
            instance = new BooksService();
        }
        return instance;
    }
    public List<Books> getBooksWithNewSupply(int quantity, int supplyNumber){
        List<Books> list = dao.findByQuantity(quantity);
        for(Books g : list ){
                g.setQuantity(g.getQuantity()+supplyNumber);
        }
        return list;
    }

}
