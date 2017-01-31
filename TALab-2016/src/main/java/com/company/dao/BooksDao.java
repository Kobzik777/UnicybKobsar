package com.company.dao;

import java.util.List;

import com.company.enitites.Books;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public interface BooksDao extends GenericDao<Books> {
	List<Books> findByQuantity (int quantity);
}
