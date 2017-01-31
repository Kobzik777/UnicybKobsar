package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.company.dao.BooksDao;
import com.company.dao.DaoFactory;
import com.company.enitites.Books;
import com.company.services.BooksService;
import com.mysql.cj.mysqlx.MysqlxError;


/**
 * Servlet implementation class ControllerBooksFindAll
 */
@WebServlet("/sssss")
public class ControllerBooksFindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BooksService bs = BooksService.getInstance();
	 private static final Logger log = Logger.getLogger(ControllerBooksFindAll.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerBooksFindAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		// TODO Auto-generated method stub
		try{
	//	DaoFactory factory = DaoFactory.getInstance();
    //    BooksDao dao = factory.createBooksDao();
        PrintWriter pw = response.getWriter();
        MainController controller = new MainController();
      //  pw.print(dao.findAll().toString()); 
        String quantity =  request.getParameter("quantity");
		String supply = request.getParameter("supply");
		List<Books> books = controller.doSeviceQuantityCall(quantity, supply);
		int quantityValue = Integer.parseInt(quantity);
		int supplyValue = Integer.parseInt(supply);
		if(supplyValue <=0){
			log.error("invalid supply");
			throw new IllegalArgumentException();
		}
		//List<Books> books =  bs.getBooksWithNewSupply(quantityValue, supplyValue);
		pw.println(books.toString());		

        log.info("Supply was being added");  
        
		}
		
		catch (Exception ex){
			log.error("Shit happens");
			 
		}

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
