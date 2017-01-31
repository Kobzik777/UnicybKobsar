package com.company.dao.jdbc.mysql;

import com.company.dao.GenresDao;
import com.company.enitites.Authors;
import com.company.enitites.Genres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii_Kobzar on 10/5/2016.
 */
public class MySqlGenresDao implements GenresDao {
    private static final String SELECT_ALL_AUTHORS = "select *\n" +
            "from genres";
    private static final String INSERT_BOOKS = "INSERT genres(id_genre,name) VALUES(?,?)";
    private static final String UPDATE_BOOKS = "UPDATE genres SET name = 'Sience' where id_genre = ?";
    private static final String DEELTE_BOOKS = "DELETE FROM genres WHERE id_genre = ?";
    private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM genres where id_genre=?";

    @Override
    public Genres find(int id) {
        Genres result = new Genres();
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (PreparedStatement query = connection.prepareStatement(SELECT_BOOKS_BY_ID)) {
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                result = getGoodsFromResultSet(rs);
            }
            return result;

        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Genres> findAll() {
        List<Genres> result = new ArrayList<>();
        Connection connection = MySqlJdbcDaoFactory.getConnection();
        try (Statement query = connection.createStatement()) {

            ResultSet rs = query.executeQuery(SELECT_ALL_AUTHORS);
            while (rs.next()) {
                result.add(getGoodsFromResultSet(rs));
            }
        } catch (Exception ex) {
            //log
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void update(Genres entity, int id) {
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
    private Genres getGoodsFromResultSet(ResultSet resultSet)
            throws SQLException {
        Genres goods = new Genres();
        goods.setId(resultSet.getInt("id_genre"));
        goods.setName(resultSet.getString("name"));
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
    public void insert(Genres entity) {
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
