package com.company.dao;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public abstract class DaoFactory {
    public abstract BooksDao createBooksDao();
    public abstract AuthorsDao createAuthorsDao();
    public abstract GenresDao createGenresDao();

    public static DaoFactory getInstance(){
        String factoryClassName = "com.company.dao.jdbc.mysql.MySqlJdbcDaoFactory";
        try {
            return (DaoFactory) Class.forName(factoryClassName)
                    .newInstance();
        } catch (Exception e) {
            //log
            throw new RuntimeException(e);
        }
    }
}
