package controller;

import java.util.List;
import org.apache.log4j.Logger;

import com.company.enitites.Books;
import com.company.services.BooksService;

public class MainController {
	
    public BooksService service = BooksService.getInstance();
	static Logger logger = Logger.getLogger(MainController.class); 
		
	public List<Books> doSeviceQuantityCall(String quantity, String supply){
		int quantityValue = Integer.parseInt(quantity);
		int supplyValue = Integer.parseInt(supply);
		if(supplyValue <=0 || quantityValue <0){
			logger.error("invalid supply");
			throw new IllegalArgumentException();
		}
		List<Books> books = service.getBooksWithNewSupply(quantityValue, supplyValue);
		return books;
	}
}
