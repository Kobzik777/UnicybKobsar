package com.company.sevices;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.company.dao.BooksDao;
import com.company.enitites.Books;
import com.company.services.BooksService;

public class BooksSeviceTest {
	
	@Test
	public void testBooksWithSuply(){
		BooksService booksService = new BooksService();
		BooksDao dao = mock(BooksDao.class);
		booksService.setDao(dao);
		when(dao.findByQuantity(0)).thenReturn(Arrays.asList(new Books(4,"Nothing here",0)));
		List<Books> actual = booksService.getBooksWithNewSupply(0, 10);
		assertTrue( Arrays.asList( new Books(4,"Nothing here",10)).equals(actual));
	}

}
