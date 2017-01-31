package com.company.controller;

import java.security.Provider.Service;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.company.enitites.Books;
import com.company.services.BooksService;

import controller.ControllerBooksFindAll;
import controller.MainController;





public class TestController {
	private MainController controller;
	private BooksService service; 
	//private static final Logger log = Logger.getLogger(TestController.class);
	
	@Before
	public void init(){
		service = mock( BooksService.class);
		controller = new MainController();
		controller.service=service;
	
	}


	@Test
	public void testController(){
		when(service.getBooksWithNewSupply(0, 10)).thenReturn(
				Arrays.asList(new Books()));
		controller.doSeviceQuantityCall("0", "10");
		verify(service).getBooksWithNewSupply(0, 10);
	}

	@Test(expected = RuntimeException.class)
	public void testControllerInvalidData(){
		controller.doSeviceQuantityCall("aaa", "10");
		verify(service).getBooksWithNewSupply(100, 10);
	}

	@Test
	public void testControllerInvalidDataExt(){
		try{
			controller.doSeviceQuantityCall("-1", "10");
		}catch(RuntimeException ex){
			
		}
		verify(service, never()).getBooksWithNewSupply(anyInt(),anyInt());	
				                                        
	}
	@Test
	public void testControllerInvalidDiscount(){
		try{
			controller.doSeviceQuantityCall("0", "-10");
		}catch(RuntimeException ex){
			
		}
		verify(service , never()).getBooksWithNewSupply(anyInt(),anyInt());
				                             
}
}

