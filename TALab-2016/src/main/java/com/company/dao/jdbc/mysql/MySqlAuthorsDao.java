package com.company.dao.jdbc.mysql;

import com.company.dao.AuthorsDao;
import com.company.enitites.Authors;
import com.company.enitites.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public class MySqlAuthorsDao implements AuthorsDao{
    private static final String SELECT_ALL_AUTHORS = "select *\n" +
            "from authors";
    private static final String INSERT_BOOKS = "INSERT authors(id_authors,Name) VALUES(?,?)";
    private static final String UPDATE_BOOKS = "UPDATE authors SET Name = 'Bulgakov' where id_authors = ?";
    private static final String DEELTE_BOOKS = "DELETE FROM authors WHERE id_authors = ?";
    private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM authors where id_authors=?";
  
    @Override
    public Authors find(int id) {
        Authors result = new Authors();
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
    public List<Authors> findAll() {
        List<Authors> result = new ArrayList<>();
        Connection connection =  MySqlJdbcDaoFactory.getConnection();
        try(Statement query = connection.createStatement()){

            ResultSet rs = query.executeQuery(SELECT_ALL_AUTHORS);
            while( rs.next() ){
                result.add(getGoodsFromResultSet(rs));
            }
        }catch(Exception ex){
            //log
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void update(Authors entity, int id) {
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(UPDATE_BOOKS)) {

            query.setInt(1, id);
            query.executeUpdate();


        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
    }

  /*  @Override
    public void update(Authors entity) {

    }
*/
    private Authors getGoodsFromResultSet(ResultSet resultSet)
            throws SQLException {
        Authors goods = new Authors();
        goods.setId(resultSet.getInt("id_authors"));
        goods.setName(resultSet.getString("Name"));
        return goods;
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
    public void insert(Authors entity) {
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(INSERT_BOOKS)) {

            query.setInt(1, entity.getId());
            query.setString(2, entity.getName());
            query.executeUpdate();


        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
    }

}
