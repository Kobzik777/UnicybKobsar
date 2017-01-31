package com.company.dao.jdbc.mysql;

import com.company.enitites.Books;
import com.company.dao.BooksDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlBooksDao implements BooksDao {

    private static final String SELECT_ALL_BOOKS = "select *\n" +
            "from books";
    private static final String INSERT_BOOKS = "INSERT books (id_books,Title,Quantity) VALUES(?,?,?)";
    private static final String UPDATE_BOOKS = "UPDATE books SET Title = 'C# для чайников' where id_books = ?";
    private static final String DEELTE_BOOKS = "DELETE FROM books WHERE id_books = ?";
    private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM books where id_books=?";
    private static final String SELECT_BOOKS_BY_QUANTITY = "SELECT * FROM books where Quantity = ?";

    @Override
    public Books find(int id) {
        // TODO Auto-generated method stub

        Books result = new Books();
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(SELECT_BOOKS_BY_ID)) {
            query.setInt(1,id);
            ResultSet rs = query.executeQuery();
            while (rs.next()){
                result = getGoodsFromResultSet(rs);
            }
            return result;

        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<Books> findAll() {
        List<Books> result = new ArrayList<>();
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (Statement query = connection.createStatement()) {

            ResultSet rs = query.executeQuery(SELECT_ALL_BOOKS);
            while (rs.next()) {
                result.add(getGoodsFromResultSet(rs));
            }
        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
        return result;
    }

    private Books getGoodsFromResultSet(ResultSet resultSet)
            throws SQLException {
        Books goods = new Books();
        goods.setId(resultSet.getInt("id_books"));
        goods.setTitle(resultSet.getString("Title"));
        goods.setQuantity(resultSet.getInt("Quantity"));
        return goods;
    }

    @Override
    public void update(Books entity, int id) {
        // TODO Auto-generated method stub
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(UPDATE_BOOKS)) {

            query.setInt(1, id);
            query.executeUpdate();


        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(DEELTE_BOOKS)) {

            query.setInt(1, id);
            query.executeUpdate();


        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void insert(Books entity) {
        // TODO Auto-generated method stub
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(INSERT_BOOKS)) {

            query.setInt(1, entity.getId());
            query.setString(2, entity.getTitle());
            query.setInt(3, entity.getQuantity());
            query.executeUpdate();


        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }


    }
    
    @Override
    public List<Books> findByQuantity(int quantity){
        List<Books> result = new ArrayList<>();
        Connection connection =  MySqlJdbcDaoFactory.getConnection();
        try(PreparedStatement query = connection
                .prepareStatement(SELECT_BOOKS_BY_QUANTITY)){
            query.setInt(1, quantity);
            ResultSet rs = query.executeQuery();
            while( rs.next() ){
                Books books = getGoodsFromResultSet(rs);
                result.add(books);
            }
        }catch(Exception ex){
            //log
            throw new RuntimeException(ex);
        }
        return result;
    }

}
