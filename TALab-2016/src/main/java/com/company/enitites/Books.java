package com.company.enitites;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public class Books {
    private int id;
    private String title;
    private int quantity;

    public Books(int id, String title, int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }

    public Books() {

    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {


        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (quantity != books.quantity) return false;
        return title.equals(books.title);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + quantity;
        return result;
    }

}
